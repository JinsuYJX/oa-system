package com.azwcl.oa.infrastructure.utils;

import java.util.Calendar;

/**
 * 时间工具类
 *
 * @author az
 * @date 2022/10/05
 */

public class TimeUtil {

    /**
     * 获取今天的日期
     *
     * @return 返回今天日期
     */
    public static Integer getTodayDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) * 10000 + (calendar.get(Calendar.MONTH) + 1) * 100 + calendar.get(Calendar.DATE);
    }

    /**
     * 获取当前时间
     *
     * @return 返回当前时间
     */
    public static Integer getNowTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR) * 10000 + calendar.get(Calendar.MINUTE) * 100 + calendar.get(Calendar.SECOND);
    }
}
