/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.culture_news.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 *
 * @author Blekzet
 */

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "role_id")
    @GeneratedValue
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Transient
    @ManyToMany(mappedBy = "role")
    private Set<User> users;

    public Role(Long roleId) {
        this.roleId = roleId;
    }

    public Role(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Long getRole_id() {
        return roleId;
    }

    public void setRole_id(Long role_id) {
        this.roleId = role_id;
    }

    public String getRole_name() {
        return roleName;
    }

    public void setRole_name(String role_name) {
        this.roleName = role_name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getRole_name();
    }
    
    
}
