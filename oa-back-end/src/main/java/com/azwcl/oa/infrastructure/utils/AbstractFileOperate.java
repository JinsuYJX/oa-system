package com.azwcl.oa.infrastructure.utils;

import com.azwcl.oa.infrastructure.common.model.FileInfo;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;

/**
 * 文件操作类
 *
 * @author az
 * @date 2022/09/12
 */

public abstract class AbstractFileOperate {
    /**
     * 文件 md5 加密
     *
     * @param fileInputStream 文件输入流
     * @return 加密后 hash 字符串
     * @throws IOException io 异常
     */
    public String md5(FileInputStream fileInputStream) throws IOException {
        return DigestUtils.md5DigestAsHex(fileInputStream);
    }

    /**
     * 文件 md5 加密
     *
     * @param file 文件
     * @return 加密后 hash 字符串
     * @throws IOException io 异常
     */
    public String md5(MultipartFile file) throws IOException {
        return DigestUtils.md5DigestAsHex(file.getInputStream());
    }

    /**
     * 保存文件
     *
     * @param path     存储路径
     * @param filename 存储文件名
     * @param file     存储文件
     */
    public abstract void save(String path, String filename, MultipartFile file);

    /**
     * 保存文件
     *
     * @param path     存储路径
     * @param filename 存储文件名
     * @param file     存储文件
     */
    public abstract void save(String path, String filename, File file);

    /**
     * 删除文件
     *
     * @param path     删除文件路径
     * @param filename 删除文件名
     */
    public abstract void delete(String path, String filename);

    /**
     * 判断文件是否存在
     *
     * @param path     文件路径
     * @param filename 文件名
     */
    public abstract void isExist(String path, String filename);

    /**
     * 搜索目录下内容
     *
     * @param path 路径
     * @return 目录下文件信息
     */
    public abstract List<FileInfo> findCatalogContent(String path);

    /**
     * 获取某文件输入流
     *
     * @param path     文件路径
     * @param filename 文件名
     * @return 文件流
     */
    public abstract InputStream getFile(String path, String filename);
}
