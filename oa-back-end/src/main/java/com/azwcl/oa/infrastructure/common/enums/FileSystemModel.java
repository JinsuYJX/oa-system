package com.azwcl.oa.infrastructure.common.enums;

import lombok.Getter;

import java.util.Objects;

/**
 * 文件系统模式
 *
 * @author az
 * @date 2022/09/17
 */
@Getter
public enum FileSystemModel {

    /**
     * 未知
     */
    NONE(-1),

    /**
     * 本地文件存储
     */
    LOCAL(0),

    /**
     * 阿里云 OSS 文件存储
     */
    ALIYUN_OSS(1);

    private final int model;

    FileSystemModel(int model) {
        this.model = model;
    }

    /**
     * 枚举 of 方法
     *
     * @param model 需要判断的 model
     * @return 返回匹配枚举
     */
    public static FileSystemModel of(int model) {
        FileSystemModel[] values = values();

        for (FileSystemModel value : values) {
            if (Objects.equals(value.getModel(), model)) {
                return value;
            }
        }
        return NONE;
    }
}
