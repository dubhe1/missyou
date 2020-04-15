package com.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Where(clause = "delete_time is null and online = 1")
public class ActivityCover extends BaseEntity {
    @Id
    private Long id;
    private String coverImg;
    private String internalTopImg;
    private String name;
    private String title;
    private String description;
    private Boolean online;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="activityCoverId")
    private  List<Activity> activityList;
}
