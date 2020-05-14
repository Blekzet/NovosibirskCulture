package com.culture_news.repositories;

import com.culture_news.entity.User;
import com.culture_news.entity.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRolesRepository extends JpaRepository<UsersRoles, Long> {
    public UsersRoles findByUserIdAndRoleId(Long userId, Long roleId);
}

