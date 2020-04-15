package com.missyou.core.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HalfUpRound implements IMoneyDiscount {
    @Override
    public BigDecimal discount(BigDecimal original, BigDecimal discount) {
        BigDecimal actualMoney = original.multiply(discount);
        BigDecimal finalMoney = actualMoney.setScale(2, RoundingMode.HALF_UP);
        return finalMoney;
    }
}
