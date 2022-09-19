package com.azwcl.oa.infrastructure.utils;

import com.azwcl.oa.infrastructure.common.file.FileOperate;

import java.io.*;

/**
 * 本地文件读取工具类
 *
 * @author ZERO
 * @date 2022/9/18
 */
public class FileOperateUtil implements FileOperate {

    private Boolean isPathExist(String path) {
        File filePath = new File(path);
        return filePath.exists() && filePath.isDirectory();
    }

    @Override
    public Boolean isExist(String path, String filename) {
        return isPathExist(path) && (new File(path, filename)).exists();
    }

    @Override
    public InputStream getFile(String path, String filename) throws IOException {

        if (Boolean.TRUE.equals(isExist(path, filename))) {
            return new FileInputStream(new File(path, filename));
        }

        if (!(new File(path).isDirectory())) {
            throw new IOException("This is not the correct directory format");
        }

        //判断目录是否存在，若不存在则先创建目录
        File filePath = new File(path);
        if (!filePath.exists()) {
            boolean mkdir = filePath.mkdir();
            if (!mkdir) {
                throw new IOException("File path creation failure...");
            }
        }
        File file = new File(filePath, filename);
        boolean newFile = file.createNewFile();
        if (newFile) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File path creation failure...");
        }
    }

    @Override
    public void save(String path, String filename, InputStream stream) throws IOException {
        if (Boolean.FALSE.equals(isPathExist(path))) {
            File filePath = new File(path);
            boolean mkdir = filePath.mkdir();
            if (!mkdir) {
                throw new IOException("File path creation failure...");
            }
        }
        try (OutputStream out = new FileOutputStream(new File(path, filename))) {
            int len;
            byte[] buffer = new byte[1024];
            while ((len = stream.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            throw new IOException(e);
        }
    }

    @Override
    public void delete(String path, String filename) throws IOException {
        if (Boolean.FALSE.equals(isExist(path, filename))) {
            return;
        }

        File file = new File(path, filename);
        if (!file.delete()) {
            throw new IOException("File deletion failure...");
        }
    }
}

