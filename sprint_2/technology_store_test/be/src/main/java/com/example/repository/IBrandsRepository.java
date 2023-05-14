package com.example.repository;

import com.example.model.Brands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandsRepository extends JpaRepository<Brands, Long> {
}
