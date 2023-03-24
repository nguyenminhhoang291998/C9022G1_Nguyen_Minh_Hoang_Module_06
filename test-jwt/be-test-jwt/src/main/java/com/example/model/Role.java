package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Role {
    @Id
    private int id;

    @Column(columnDefinition = "varchar(45)")
    private String name;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private Set<AccountRole> accountRoleSet;

    public Role() {
    }

    public Role(int id, String name, Set<AccountRole> accountRoleSet) {
        this.id = id;
        this.name = name;
        this.accountRoleSet = accountRoleSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AccountRole> getAccountRoleSet() {
        return accountRoleSet;
    }

    public void setAccountRoleSet(Set<AccountRole> accountRoleSet) {
        this.accountRoleSet = accountRoleSet;
    }
}
