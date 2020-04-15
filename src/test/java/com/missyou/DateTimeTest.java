package com.missyou;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.Calendar;

public class DateTimeTest {
    @Test
    public void TestDateTimeAddSeconds() {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = (Calendar) calendar.clone();
        System.out.println(calendar.getTime());
        calendar.add(Calendar.SECOND, 3600);
        System.out.println(calendar.getTime());
        System.out.println(calendar1.getTime());
    }
}
