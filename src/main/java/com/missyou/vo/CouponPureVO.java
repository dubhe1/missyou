/**
 * @作者 7七月
 * @微信公号 林间有风
 * @开源项目 $ http://7yue.pro
 * @免费专栏 $ http://course.7yue.pro
 * @我的课程 $ http://imooc.com/t/4294850
 * @创建时间 2019-08-10 21:01
 */
package com.missyou.vo;

import com.missyou.model.Coupon;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CouponPureVO {
    private Long id;
    private String title;
    private Date startTime;
    private Date endTime;
    private String description;
    private BigDecimal fullMoney;
    private BigDecimal minus;
    private BigDecimal rate;
    private Integer type;
    private String remark;
    private Boolean wholeStore;

    public CouponPureVO(Object[] objects){
        Coupon coupon = (Coupon) objects[0];
        BeanUtils.copyProperties(coupon, this);
    }

    public CouponPureVO(Coupon coupon){
        BeanUtils.copyProperties(coupon, this);
    }

    public static List<CouponPureVO> getList(List<Coupon> couponList) {
        return couponList.stream()
                .map(CouponPureVO::new)
                .collect(Collectors.toList());
    }
}
