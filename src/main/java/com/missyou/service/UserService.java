package com.missyou.service;

import com.missyou.core.LocalUser;
import com.missyou.model.User;
import com.missyou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findFirstById(id);
    }























    public void updateUserWxInfo(Map<String, Object> wxUser) {
        User user =this.getUserById(LocalUser.getUser().getId());
        user.setNickname(wxUser.get("nickName").toString());
        user.setWxProfile(wxUser);
        userRepository.save(user);
    }

    public User createDevUser(Long uid) {
        User newUser = User.builder().unifyUid(uid).build();
        userRepository.save(newUser);
        return newUser;
    }

    public User getUserByUnifyUid(Long uuid) {
        return userRepository.findByUnifyUid(uuid);
    }
}

