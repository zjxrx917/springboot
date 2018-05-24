package com.csdn.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTest {
    /**
     * Calendar做日期的转换
     * @throws ParseException
     */
    @Test
    public void testCalendar() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTime().toLocaleString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(calendar.getTime());
        Date parse = sdf.parse("2018-04-15");
        System.out.println(format);
        System.out.println(parse.toLocaleString());
    }

    @Test
    public void testTimeUnit() {
        //两天得到的小时总数
        long hours = TimeUnit.DAYS.toHours(2);
        System.out.println(hours);

        long minutes = TimeUnit.HOURS.toMinutes(2);
        System.out.println(minutes);
    }
}
