package com.example.repository;

import com.example.model.Coach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICoachRepository extends JpaRepository<Coach, Integer> {

    @Query(value = "select * from coach where is_delete = false ", nativeQuery = true)
    Page<Coach> findAll(Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO coach (`number_plate`, `company_name`, `departure_time`, " +
            "`destination_time`, `email`, `is_delete`, `phone_number`, `coach_type_id`, `departure_id`, " +
            "`destination_id`) VALUES (:id, :company_name, :departure_time, :destination_time, :email, false," +
            " :phone_number, :coach_type_id, :departure_id, :destination_id)", nativeQuery = true)
    void saveCoach(@Param("id") int id, @Param("company_name") String company_name, @Param("departure_time") String departure_time,
                   @Param("destination_time") String destination_time,
                   @Param("email") String email, @Param("phone_number") String phone_number,
                   @Param("coach_type_id") int coach_type_id,
                   @Param("departure_id") int departure_id,
                   @Param("destination_id") int destination_id);
    @Modifying
    @Query(value = "UPDATE coach SET `company_name` = :company_name, `departure_time` = :departure_time, " +
            "`destination_time` = :destination_time, `email` = :email, `phone_number` " +
            "= :phone_number, `coach_type_id` = :coach_type_id, `departure_id` = :departure_id, `destination_id` = :destination_id " +
            "WHERE (`number_plate` = :id)", nativeQuery = true)
    void updateCoach(@Param("id") int id, @Param("company_name") String company_name, @Param("departure_time") String departure_time,
                     @Param("destination_time") String destination_time,
                     @Param("email") String email, @Param("phone_number") String phone_number,
                     @Param("coach_type_id") int coach_type_id,
                     @Param("departure_id") int departure_id,
                     @Param("destination_id") int destination_id);
    @Modifying
    @Query(value = "update coach set is_delete = true where number_plate = :id", nativeQuery = true)
    void deleteCoach(@Param("id") int id);

    @Query(value = "select * from coach where number_plate = :id and is_delete = false",nativeQuery = true)
    Coach findCoachById(@Param("id") int id);
}
