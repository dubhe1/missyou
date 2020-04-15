package com.missyou.vo;

import com.missyou.model.Category;
import com.missyou.model.Coupon;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CouponCategoryVO extends CouponPureVO {
    private List<CategoryPureVO> categories = new ArrayList<>();

    public CouponCategoryVO(Coupon coupon) {
        super(coupon);
        List<Category> categories = coupon.getCategoryList();
        categories.forEach(category -> {
            CategoryPureVO vo = new CategoryPureVO(category);
            this.categories.add(vo);
        });
    }
}
