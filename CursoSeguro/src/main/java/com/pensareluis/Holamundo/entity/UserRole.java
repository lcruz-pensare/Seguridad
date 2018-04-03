package com.pensareluis.Holamundo.entity;

import javax.persistence.*;

/**
 * @author Jorge Álvarez
 * @version 1.0 - 2018/03/27
 */
@Entity
@Table(name = "user_roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"role", "username"})})
public class UserRole {
    @Id
    @Column(name="user_rol_id",nullable = false,unique = true)
    private Integer userRoleId;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="username",nullable=false)
    private Account user;
    @Column(name="role", nullable = false, length = 45)
    private String role;

    public UserRole(Account user, String role) {
        this.user = user;
        this.role = role;
    }

    public UserRole() {
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Account getUser() {
        return user;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
