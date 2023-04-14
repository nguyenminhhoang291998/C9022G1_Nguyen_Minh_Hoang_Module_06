package com.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestController_getListStudent {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListStudent_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/studentRest/list/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sachs rong, tim kiem .....
     * @throws Exception
     */
    @Test
    public void getListStudent_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/studentRest/list?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(7))
                .andExpect(jsonPath("totalElements").value(35))
                .andExpect(jsonPath("content[0].name").value("Nguyen Van Anh"))
                .andExpect(jsonPath("content[0].dateOfBirth").value("2022-08-16"))
                .andExpect(jsonPath("content[0].classStudent.id").value(3))
                .andExpect(jsonPath("content[4].name").value("Nhan"))
                .andExpect(jsonPath("content[4].dateOfBirth").value("2022-08-26"))
                .andExpect(jsonPath("content[4].classStudent.id").value(2));
    }

//    @Test
//    public void getListStudent_6() {
//        ResponseEntity<Page<Student>> responseEntity
//                = this.studentRestController.getListStudent(PageRequest.of(0, 2));
//
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals(3, responseEntity.getBody().getTotalPages());
//        Assertions.assertEquals(5, responseEntity.getBody().getTotalElements());
//        Assertions.assertEquals("Nguyễn Văn Bình",
//                responseEntity.getBody().getContent().get(1).getName());
//        Assertions.assertEquals("2001-10-05",
//                responseEntity.getBody().getContent().get(1).getDateOfBirth());
//    }
}
