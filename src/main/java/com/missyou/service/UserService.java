package com.missyou.service;

import com.missyou.model.User;

import java.util.Map;

public interface UserService {

    public User getUserById(Long id);

    public void updateUserWxInfo(Map<String, Object> wxUser);

    public User createDevUser(Long uid);

    public User getUserByUnifyUid(Long uuid);
}

