package com.example.repository;

import com.example.dto.ICenterDTO;
import com.example.model.Center;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ICenterRepository extends JpaRepository<Center,Long> {
    @Query(value = "select c.id as id, c.name as nameCenter, c.opening_date as openingDate, c.address as address, e.name as nameAdmin, e.id as idAdmin " +
            " from center c join employee e on c.id = e.center_id  where c.name like  concat ('%',:nameCenter,'%') and e.name like  concat ('%',:nameAdmin,'%') and c.is_delete = false and e.role_id = 1",nativeQuery = true)
    Page<ICenterDTO> findAllCenter(@Param("nameCenter") String nameCenter,@Param("nameAdmin") String nameAdmin, Pageable pageable);



    @Modifying
    @Transactional
    @Query(value = "update `center` set is_delete = true where id = :id", nativeQuery = true)
    void deleteCenterById(Long id);


    Center findByName(String name);

    boolean existsByName(String name);

}
