package com.missyou.vo;

import com.missyou.model.Activity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class ActivityPureVO {
    private Long id;
    private String title;
    private String entranceImg;
    private Boolean online;
    private String remark;
    private String startTime;
    private String endTime;

    public ActivityPureVO(Activity activity) {
        BeanUtils.copyProperties(activity,this);
    }

    public ActivityPureVO(Object object){
        BeanUtils.copyProperties(object, this);
    }

}
