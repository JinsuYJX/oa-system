package com.azwcl.oa.infrastructure.utils;

import com.azwcl.oa.infrastructure.common.file.FileOperate;

import java.io.*;
import java.nio.file.Files;

/**
 * 本地文件读取工具类
 *
 * @author ZERO
 * @date 2022/9/18
 */
public class FileOperateUtil implements FileOperate {

    @Override
    public Boolean isExist(String path, String filename) {
        return new File(path, filename).exists();
    }

    @Override
    public InputStream getFile(String path, String filename) throws IOException {

        File file = new File(path, filename);

        if (!file.exists()) {
            throw new IOException();
        }

        return Files.newInputStream(file.toPath());
    }

    @Override
    public void save(String path, String filename, InputStream stream) throws IOException {
        File file = new File(path, filename);

        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            throw new IOException();
        }

        OutputStream out = Files.newOutputStream(file.toPath());

        int len;
        byte[] buffer = new byte[1024];
        while ((len = stream.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }

        out.close();
    }

    @Override
    public void delete(String path, String filename) throws IOException {
        File file = new File(path, filename);

        if (!file.exists() || !file.delete()) {
            throw new IOException();
        }
    }
}