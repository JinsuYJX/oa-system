package com.azwcl.oa.infrastructure.common.model;

import lombok.Getter;

/**
 * 文件信息
 *
 * @author az
 * @date 2022/09/12
 */

@Getter
public class FileInfo {

    /**
     * 文件名
     */
    private final String name;

    /**
     * 文件大小 byte
     */
    private final Long size;

    /**
     * 创建日期
     */
    private final Integer createDate;

    /**
     * 创建时间
     */
    private final Integer createTime;

    /**
     * 是否是目录
     */
    private final Boolean isCatalog;

    /**
     * 初始化一个目录信息
     *
     * @param name       目录名
     * @param createDate 创建日期
     * @param createTime 创建时间
     */
    public FileInfo(String name, Integer createDate, Integer createTime) {
        this.name = name;
        this.size = 0L;
        this.createDate = createDate;
        this.createTime = createTime;
        this.isCatalog = false;
    }

    /**
     * 初始化一个文件信息
     *
     * @param name       文件名
     * @param size       文件大小
     * @param createDate 创建日期
     * @param createTime 创建时间
     */
    public FileInfo(String name, Long size, Integer createDate, Integer createTime) {
        this.name = name;
        this.size = size;
        this.createDate = createDate;
        this.createTime = createTime;
        this.isCatalog = true;
    }
}
