/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://talelin.com
 * @免费专栏 $ http://course.talelin.com
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2020-03-30 13:42
 */
package com.missyou.vo;

import com.missyou.model.Order;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Getter
@Setter
public class OrderPureVO extends Order {
    private Long period;
    private Date createTime;

    public OrderPureVO(Order order, Long period) {
        BeanUtils.copyProperties(order, this);
        this.period = period;
    }
}

