package com.example.repository;

import com.example.model.Oder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOderRepository extends JpaRepository<Oder,Long> {

    @Query(value = "select * from oder o where lower(c.name) like lower(%?1%) and o.oderDate <= COALESCE(NULLIF(?2,''))" +
            " join customer c on o.customer_id = c.id",nativeQuery = true)
    Page<Oder> getAll(String name,String oderDate,Pageable pageable);
}
