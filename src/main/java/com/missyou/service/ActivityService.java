package com.missyou.service;

import com.missyou.model.Activity;

public interface ActivityService {
    public Activity getByName(String name);


//    public List<Activity> getByCategoryId(Long categoryId){
//        Date date = new Date();
//        List<Activity> activities = activityRepository
//                .findByStartTimeLessThanAndEndTimeGreaterThanAndCategoryListId(
//                        date, date, categoryId);
//        return activities;
//    }
}
