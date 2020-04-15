package com.missyou.logic;

import com.missyou.bo.SkuOrderBO;
import com.missyou.core.enumeration.CouponType;
import com.missyou.core.money.IMoneyDiscount;
import com.missyou.exception.http.ForbiddenException;
import com.missyou.exception.http.ParameterException;
import com.missyou.model.Category;
import com.missyou.model.Coupon;
import com.missyou.util.CommonUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CouponChecker {

    private final Coupon coupon;

    private final IMoneyDiscount iMoneyDiscount;

    public CouponChecker(Coupon coupon, IMoneyDiscount iMoneyDiscount) {
        this.coupon = coupon;
        this.iMoneyDiscount = iMoneyDiscount;
    }

    public void isOk() {
        Date now = new Date();
        Boolean isInTimeline = CommonUtil.isInTimeLine(now, this.coupon.getStartTime(), this.coupon.getEndTime());
        if (!isInTimeline) {
            throw new ForbiddenException(40007);
        }
    }

    public void finalTotalPriceIsOk(BigDecimal orderFinalTotalPrice,
                                    BigDecimal serverTotalPrice) {
        BigDecimal serverFinalTotalPrice;

        switch (CouponType.toType(this.coupon.getType())) {
            case FULL_MINUS:
            case NO_THRESHOLD_MINUS:
                serverFinalTotalPrice = serverTotalPrice.subtract(this.coupon.getMinus());
                if (serverFinalTotalPrice.compareTo(new BigDecimal("0")) <= 0) {
                    throw new ForbiddenException(50008);
                }
                break;
            case FULL_OFF:
                serverFinalTotalPrice = this.iMoneyDiscount.discount(serverTotalPrice, this.coupon.getRate());
                break;
            default:
                throw new ParameterException(40009);
        }
        int compare = serverFinalTotalPrice.compareTo(orderFinalTotalPrice);
        if (compare != 0) {
            throw new ForbiddenException(50008);
        }
    }

    public void canBeUsed(List<SkuOrderBO> skuOrderBOList, BigDecimal serverTotalPrice) {
        BigDecimal orderCategoryPrice;

        if (this.coupon.getWholeStore()) {
            orderCategoryPrice = serverTotalPrice;
        } else {
            List<Long> cidList = this.coupon.getCategoryList()
                    .stream()
                    .map(Category::getId)
                    .collect(Collectors.toList());
            orderCategoryPrice = this.getSumByCategoryList(skuOrderBOList, cidList);
        }
        this.couponCanBeUsed(orderCategoryPrice);
    }

    private void couponCanBeUsed(BigDecimal orderCategoryPrice) {
        switch (CouponType.toType(this.coupon.getType())) {
            case FULL_OFF:
            case FULL_MINUS:
                int compare = this.coupon.getFullMoney().compareTo(orderCategoryPrice);
                if (compare > 0) {
                    throw new ParameterException(40008);
                }
                break;
            case NO_THRESHOLD_MINUS:
                break;
            default:
                throw new ParameterException(40009);
        }
    }

    private BigDecimal getSumByCategoryList(List<SkuOrderBO> skuOrderBOList, List<Long> cidList) {
        return cidList.stream()
                .map(cid -> this.getSumByCategory(skuOrderBOList, cid))
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0"));
    }

    private BigDecimal getSumByCategory(List<SkuOrderBO> skuOrderBOList, Long cid) {
        return skuOrderBOList.stream()
                .filter(sku -> sku.getCategoryId().equals(cid))
                .map(SkuOrderBO::getTotalPrice)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0"));
    }
}


