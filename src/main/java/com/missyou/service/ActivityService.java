/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2019-08-03 19:56
 */
package com.missyou.service;

import com.missyou.model.Activity;
import com.missyou.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public Activity getByName(String name) {
        return activityRepository.findByName(name);
    }

//    public List<Activity> getByCategoryId(Long categoryId){
//        Date date = new Date();
//        List<Activity> activities = activityRepository
//                .findByStartTimeLessThanAndEndTimeGreaterThanAndCategoryListId(
//                        date, date, categoryId);
//        return activities;
//    }
}
