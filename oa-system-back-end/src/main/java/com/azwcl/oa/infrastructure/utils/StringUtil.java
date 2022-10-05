package com.azwcl.oa.infrastructure.utils;

import com.azwcl.oa.infrastructure.common.enums.StringRandomModel;
import org.springframework.util.DigestUtils;

import java.util.Random;
import java.util.UUID;

/**
 * 字符串工具类
 *
 * @author az
 * @date 2022/09/08
 */
public class StringUtil {
    private final static Random RANDOM;

    static {
        RANDOM = new Random();
    }

    /**
     * md5 加密字符串
     * @param val 字符串
     * @return 加密的值
     */
    public static String md5(String val) {
        return DigestUtils.md5DigestAsHex(val.getBytes());
    }

    /**
     * 随机字符串
     *
     * @param number 需要随机的位数
     * @param model 字符串随机模式
     * @return 随机串
     */
    public static String random(int number, StringRandomModel model) {
        String str0 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String str1 = "0123456789";
        String str2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String str;

        switch (model) {
            case ALL: {
                str = str0;
                break;
            }
            case ONLY_NUMBER: {
                str = str1;
                break;
            }
            case ONLY_CHARACTER: {
                str = str2;
                break;
            }
            default: {
                str = str0;
            }
        }

        int len = str.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number; ++i) {
            sb.append(str.charAt(RANDOM.nextInt(len)));
        }

        return sb.toString();
    }

    /**
     * uuid 字符串
     *
     * @return uuid字符串
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }


    /**
     * 判断字符串是否是邮箱
     *
     * @param val 值
     * @return true-是,false-不是
     */
    public static boolean isEmail(String val) {
        String expr = "^([a-zA-Z0-9_\\-.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$";

        return val.matches(expr);
    }

    /**
     * 是否是空字符串
     *
     * @param val 字符串
     * @return 返回
     */
    public static boolean isEmpty(String val) {
        return val == null || "".equals(val.trim());
    }
}
