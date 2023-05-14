package com.example.repository;

import com.example.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface IAccountRepository extends JpaRepository<Account,Long> {

    @Query(value = "select a.* from account a join person p on a.person_id = p.id where p.email = ?1",nativeQuery = true)
    Account findAccountByEmployeeEmail(String username);

    @Modifying
    @Query(value = "update account set password =?1 where id =?2 ",nativeQuery = true)
    void saveNewPassword(String newPassword, Long id);
}
