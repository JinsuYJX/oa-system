package com.azwcl.oa.infrastructure.client;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.azwcl.oa.infrastructure.common.file.FileOperate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 阿里云 oss 的 client
 *
 * @author az
 * @date 2022/09/17
 */

public class AliyunOssClient implements FileOperate {
    private final OSS ossClient;

    private final String bucketName;

    private final String dataPath;

    public AliyunOssClient(String endpoint, String bucketName, String accessKeyId, String accessKeySecret, String dataPath) {
        this.bucketName = bucketName;
        this.dataPath = dataPath;
        this.ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    @Override
    public void save(String path, String filename, MultipartFile file) throws IOException {
        this.save(path, filename, file.getInputStream());
    }

    @Override
    public void save(String path, String filename, InputStream stream) throws IOException {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, dataPath + path + filename, stream);
        ossClient.putObject(putObjectRequest);
    }

    @Override
    public void delete(String path, String filename) throws IOException {
        ossClient.deleteObject(bucketName, dataPath + path + filename);
    }

    @Override
    public Boolean isExist(String path, String filename) {
        return ossClient.doesObjectExist(bucketName, dataPath + path + filename);
    }
}
