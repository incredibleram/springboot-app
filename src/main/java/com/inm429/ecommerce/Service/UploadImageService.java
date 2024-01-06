package com.inm429.ecommerce.Service;

import com.google.cloud.storage.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadImageService {

    private final Storage storage;

    public UploadImageService() {
        storage = StorageOptions.newBuilder().setProjectId("inm420-cloud-ecommerce").build().getService();
    }

    public void uploadFile(MultipartFile file) throws IOException {
        BlobId blobId = BlobId.of("inm429-bucket", file.getOriginalFilename());
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        storage.create(blobInfo, file.getBytes());
    }

    public Resource downloadFile(String fileName) throws MalformedURLException {
        Blob blob = storage.get(BlobId.of("inm429-bucket", fileName));
        if (blob != null) {
            Path path = Paths.get(fileName);
            UrlResource resource = new UrlResource(path.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } else {
            throw new RuntimeException("File not found!");
        }
    }
}
