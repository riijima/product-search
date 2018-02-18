package com.example.demo.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductService {

    public Path saveUploadedFileTemporary(MultipartFile imageFile) throws IOException {
        // 一時ファイルを作成して、アップロードされた画像を保存
        Path tempFilePath = Files.createTempFile("upload", "image");
        tempFilePath.toFile().deleteOnExit();
        FileCopyUtils.copy(imageFile.getInputStream(), Files.newOutputStream(tempFilePath));
        return tempFilePath;
    }

    public void saveProduct(ProductForm form) {
        // アップロードされ一時ファイルに保存されたファイルの存在チェック
        Path savedFile = Paths.get(form.getSavedImageFilePath());
        if (Files.notExists(savedFile)) {
            throw new RuntimeException("アップロードファイルが見つかりません");
        }
    }

}
