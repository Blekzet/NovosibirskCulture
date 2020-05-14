package com.culture_news.service;


import com.culture_news.entity.Place;
import com.culture_news.entity.Role;
import com.culture_news.entity.User;
import com.culture_news.entity.UsersRoles;
import com.culture_news.repositories.UserRepository;
import com.culture_news.repositories.UsersRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UsersRolesRepository usersRolesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public User findUserById(Long userId) {
        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }

    @Transactional
    public boolean changeUser(User user, User oldUser) {
        em.createQuery("UPDATE User SET firstName = :newFirstName WHERE firstName = :oldFirstName")
                .setParameter("newFirstName" , user.getFirstName())
                .setParameter("oldFirstName" , oldUser.getFirstName())
                .executeUpdate();
        em.createQuery("UPDATE User SET lastName= :newLastName WHERE lastName = :oldLastName")
                .setParameter("newLastName",user.getLastName())
                .setParameter("oldLastName",oldUser.getLastName())
                .executeUpdate();
        em.createQuery("UPDATE User SET email= :newEmail WHERE email = :oldEmail")
                .setParameter("newEmail",user.getEmail())
                .setParameter("oldEmail",oldUser.getEmail())
                .executeUpdate();
        return true;
    }
    @Transactional
    public boolean changeUserName(User user, User oldUser) {
        em.createQuery("UPDATE User SET userName = :newUserName WHERE userName = :oldUserName")
                .setParameter("newUserName" , user.getUserName())
                .setParameter("oldUserName" , oldUser.getUserName())
                .executeUpdate();
        return true;
    }
    @Transactional
    public boolean changeUserAvatar(User user, User oldUser) {
        em.createQuery("UPDATE User SET avatar = :newAvatar WHERE avatar = :oldAvatar and userId = :id")
                .setParameter("newAvatar" , user.getAvatar())
                .setParameter("oldAvatar" , oldUser.getAvatar())
                .setParameter("id" , oldUser.getUserId())
                .executeUpdate();
        return true;
    }
    @Transactional
    public boolean changeUserPassword(User user, User oldUser) {
        String newPassword = passwordEncoder.encode(user.getPassword());
        String confirmNewPassord = passwordEncoder.encode(user.getPasswordConfirm());
        em.createQuery("UPDATE User SET password = :newPassword, passwordConfirm = :confirmNewPassword WHERE password = :oldPassword and passwordConfirm = :oldConfirmPassword and userId = :id")
                .setParameter("newPassword" , newPassword)
                .setParameter("confirmNewPassword" , confirmNewPassord)
                .setParameter("oldPassword" , oldUser.getPassword())
                .setParameter("oldConfirmPassword" , oldUser.getPasswordConfirm())
                .setParameter("id" , oldUser.getUserId())
                .executeUpdate();
        return true;
    }

    @Transactional
    public boolean saveUser(User user) {
        if (userRepository.findByUserName(user.getUsername()) != null) {
            return false;
        }

        user.setAvatar("../img/emptyAvatar.jpg");
        user.setFirstName("Не указано");
        user.setLastName("Не указана");
        user.setEmail("Не указан");
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPasswordConfirm(passwordEncoder.encode(user.getPasswordConfirm()));
        userRepository.save(user);

        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean addRoleUser(Long userId) {
        if (usersRolesRepository.findByUserIdAndRoleId(userId, 2L) != null) {
            return false;
        }
        userRepository.getOne(userId).getRoles().add(new Role(2L, "ROLE_EDITOR"));
        return true;
    }
    @Transactional
    public boolean deleteRoleUser(Long userId) {
        if (usersRolesRepository.findByUserIdAndRoleId(userId, 2L) != null) {
            em.createQuery("DELETE FROM UsersRoles WHERE userId = :id AND roleId = 2").setParameter("id", userId).executeUpdate();
            return true;
        }
        return false;
    }

}
