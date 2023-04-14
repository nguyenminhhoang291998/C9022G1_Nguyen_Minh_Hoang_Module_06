package com.example.controller;

import com.example.dto.CenterDTO;
import com.example.dto.ICenterDTO;
import com.example.model.Center;
import com.example.model.MessageResponse;
import com.example.service.ICenterService;
import com.example.service.IEmployeeService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CenterRestController {

    @Autowired
    private ICenterService centerService;

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/center/list")
    public ResponseEntity<?> getAllCenter(@RequestParam(required = false, defaultValue = "0") int page,
                                          @RequestParam(required = false, defaultValue = "") String nameCenter,
                                          @RequestParam(required = false, defaultValue = "") String nameAdmin) {
        Page<ICenterDTO> centerDTOPage;
        Pageable pageable = PageRequest.of(page, 2);
        centerDTOPage = centerService.findAllCenter(nameCenter, nameAdmin, pageable);
        if (centerDTOPage.isEmpty()) {
            return new ResponseEntity<>("Không tìm thấy dữ liệu!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(centerDTOPage, HttpStatus.OK);
    }


    @DeleteMapping("/center/delete/{id}")
    public ResponseEntity<?> softDeleteEmployeeById(@PathVariable("id") Long id) {
        if (centerService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/center/create/{id}")
    public ResponseEntity<?> createEmployee(@Validated @RequestBody CenterDTO centerDTO,
                                            BindingResult bindingResult, @PathVariable("id") Long id) {

        Center center = new Center();
        BeanUtils.copyProperties(centerDTO, center);
        if (centerService.existCenter(center.getName())) {
            bindingResult.rejectValue("name", "name", "Tên cơ sở đã bị trùng");
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.BAD_REQUEST);
        }
        if (centerService.addCenter(center)) {
            Center centerNew = centerService.findCenterByName(center.getName());
            if (employeeService.setCenterId(centerNew.getId(), id)) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
