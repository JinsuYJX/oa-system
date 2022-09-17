package com.azwcl.oa.infrastructure.common.file;

import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 文件操作类
 *
 * @author az
 * @date 2022/09/12
 */

public interface FileOperate {
    /**
     * 文件 md5 加密
     *
     * @param inputStream 文件输入流
     * @return 加密后 hash 字符串
     * @throws IOException io 异常
     */
    default String md5(InputStream inputStream) throws IOException {
        return DigestUtils.md5DigestAsHex(inputStream);
    }

    /**
     * 文件 md5 加密
     *
     * @param file 文件
     * @return 加密后 hash 字符串
     * @throws IOException io 异常
     */
    default String md5(MultipartFile file) throws IOException {
        return this.md5(file.getInputStream());
    }

    /**
     * 保存文件
     *
     * @param path     存储路径
     * @param filename 存储文件名
     * @param file     存储文件
     * @throws IOException io 异常
     */
    default void save(String path, String filename, MultipartFile file) throws IOException {
        this.save(path, filename, file.getInputStream());
    }

    /**
     * 保存文件
     *
     * @param path     存储路径
     * @param filename 存储文件名
     * @param stream   文件输入流
     * @throws IOException io异常
     */
    default void save(String path, String filename, InputStream stream) throws IOException {
        throw new IOException();
    }

    /**
     * 删除文件
     *
     * @param path     删除文件路径
     * @param filename 删除文件名
     * @throws IOException io 异常
     */
    default void delete(String path, String filename) throws IOException {
        throw new IOException();
    }

    /**
     * 判断文件是否存在
     *
     * @param path     文件路径
     * @param filename 文件名
     * @return 文件存在与否 true-存在，false-不存在
     */
    default Boolean isExist(String path, String filename) {
        return false;
    }

    /**
     * 获取某文件输入流
     *
     * @param path     文件路径
     * @param filename 文件名
     * @return 文件流
     * @throws IOException io 异常
     */
    default InputStream getFile(String path, String filename) throws IOException {
        throw new IOException();
    }
}
