package com.azwcl.oa.infrastructure.utils;

import com.azwcl.oa.infrastructure.common.enums.StringRandomModel;
import org.springframework.util.DigestUtils;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

/**
 * 字符串工具类
 *
 * @author az
 * @date 2022/09/08
 */
public class StringUtil {
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

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number; ++i) {
            sb.append(str.charAt(random.nextInt(len)));
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
}
