package com.culture_news.entity;

import javax.persistence.*;

@Entity
@Table(name = "users_roles")
public class UsersRoles {
    @Id
    @Column(name = "user_user_id")
    private Long userId;

    @Column(name = "roles_role_id")
    private Long roleId;

    public UsersRoles(){
    }
    public UsersRoles(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
