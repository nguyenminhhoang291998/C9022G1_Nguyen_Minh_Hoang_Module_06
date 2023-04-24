package com.example.repository;

import com.example.dto.IProductDTO;
import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product,Long> {


    @Query(value = "SELECT p.id as id, p.name as name, p.price as price, p.description as description, p.release_date as releaseDate, p.product_quantity as productQuantity,\n" +
            "       pt.id as productTypeId, pt.name as productTypeName,\n" +
            "       b.id as brandsId, b.name as brandsName,\n" +
            "       i.url as url\n" +
            "FROM product p\n" +
            "JOIN image i ON p.id = i.product_id\n" +
            "JOIN product_type pt ON p.product_type_id = pt.id\n" +
            "JOIN brands b ON p.brands_id = b.id where p.name like %:nameSearch% and p.product_quantity > 0 " +
            "GROUP BY p.id",nativeQuery = true)
    Page<IProductDTO> getAllByName(Pageable pageable,String nameSearch);


    @Query(value = "SELECT p.id as id, p.name as name, p.price as price, p.description as description, p.release_date as releaseDate, p.product_quantity as productQuantity,\n" +
            "       pt.id as productTypeId, pt.name as productTypeName,\n" +
            "       b.id as brandsId, b.name as brandsName,\n" +
            "       i.url as url\n" +
            "FROM product p\n" +
            "JOIN image i ON p.id = i.product_id\n" +
            "JOIN product_type pt ON p.product_type_id = pt.id\n" +
            "JOIN brands b ON p.brands_id = b.id where p.name like %:nameSearch% and p.product_type_id = :productTypeId and p.product_quantity > 0 " +
            "GROUP BY p.id",nativeQuery = true)
    Page<IProductDTO> getAllByNameAndProductType (Pageable pageable, String nameSearch, Long productTypeId);


    @Query(value = "SELECT p.id as id, p.name as name, p.price as price, p.description as description, p.release_date as releaseDate, p.product_quantity as productQuantity,\n" +
            "       pt.id as productTypeId, pt.name as productTypeName,\n" +
            "       b.id as brandsId, b.name as brandsName,\n" +
            "       i.url as url\n" +
            "FROM product p\n" +
            "JOIN image i ON p.id = i.product_id\n" +
            "JOIN product_type pt ON p.product_type_id = pt.id\n" +
            "JOIN brands b ON p.brands_id = b.id where p.name like %:nameSearch% and p.brands_id = :brandsId  and p.product_quantity > 0 \n" +
            "GROUP BY p.id",nativeQuery = true)
    Page<IProductDTO> getAllByNameAndBrands(Pageable pageable, String nameSearch, Long brandsId);

    @Query(value = "SELECT p.id as id, p.name as name, p.price as price, p.description as description, p.release_date as releaseDate, p.product_quantity as productQuantity,\n" +
            "       pt.id as productTypeId, pt.name as productTypeName,\n" +
            "       b.id as brandsId, b.name as brandsName,\n" +
            "       i.url as url\n" +
            "FROM product p\n" +
            "JOIN image i ON p.id = i.product_id\n" +
            "JOIN product_type pt ON p.product_type_id = pt.id\n" +
            "JOIN brands b ON p.brands_id = b.id where p.name like %:nameSearch% and p.product_type_id = :productTypeId and p.brands_id = :brandsId  and p.product_quantity > 0 \n" +
            "GROUP BY p.id",nativeQuery = true)
    Page<IProductDTO> getAllByNameAndProductTypeAndBrands(Pageable pageable, String nameSearch, Long productTypeId,Long brandsId);

    @Query(value = "SELECT * from product where id = ?1",nativeQuery = true)
    Product findProductById(Long productId);

}
