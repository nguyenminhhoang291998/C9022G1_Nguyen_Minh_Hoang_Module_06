package com.example.model;

import javax.persistence.*;

@Entity(name = "account_role")
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @ManyToOne
    @JoinColumn(name = "account_employee_email")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public AccountRole() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public AccountRole(Account account, Role role) {
        this.account = account;
        this.role = role;
    }
}
