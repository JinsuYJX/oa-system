package com.azwcl.oa.infrastructure.client;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.azwcl.oa.infrastructure.common.file.FileOperate;
import com.azwcl.oa.infrastructure.config.AliyunConfig;
import com.azwcl.oa.infrastructure.config.AliyunOssConfig;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 阿里云 oss 的 client
 *
 * @author az
 * @date 2022/09/17
 */
@Component
public class AliyunOssClient implements FileOperate {

    private final AliyunOssConfig aliyunOssConfig;

    private final OSS ossClient;

    public AliyunOssClient(AliyunConfig aliyunConfig, AliyunOssConfig aliyunOssConfig) {
        this.aliyunOssConfig = aliyunOssConfig;
        this.ossClient = new OSSClientBuilder().build(this.aliyunOssConfig.getEndPoint(), aliyunConfig.getAccessKeyId(), aliyunConfig.getAccessKeySecret());
    }

    @Override
    public void save(String path, String filename, MultipartFile file) throws IOException {
        this.save(path, filename, file.getInputStream());
    }

    @Override
    public void save(String path, String filename, InputStream stream) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(aliyunOssConfig.getBucketName(), aliyunOssConfig.getDataPath() + path + filename, stream);
        ossClient.putObject(putObjectRequest);
    }

    @Override
    public void delete(String path, String filename) {
        ossClient.deleteObject(aliyunOssConfig.getBucketName(), aliyunOssConfig.getDataPath() + path + filename);
    }

    @Override
    public Boolean isExist(String path, String filename) {
        return ossClient.doesObjectExist(aliyunOssConfig.getBucketName(), aliyunOssConfig.getDataPath() + path + filename);
    }
}
