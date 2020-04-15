package com.missyou.service.impl;

import com.missyou.model.Activity;
import com.missyou.repository.ActivityRepository;
import com.missyou.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity getByName(String name) {
        return activityRepository.findByName(name);
    }
}
