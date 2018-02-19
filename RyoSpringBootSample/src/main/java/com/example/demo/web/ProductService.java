package com.example.demo.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductService {
    private Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ObjectMapper objectMapper;

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
        // JSON復元
        try {
            ProductForm object = objectMapper.readValue(form.getCondition(), ProductForm.class);
            logger.debug(object.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<Integer, String> createTagMap() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "タグ1");
        map.put(2, "タグ2");
        map.put(3, "タグ3");
        map.put(4, "タグ4");
        map.put(5, "タグ5");
        return map;
    }

    public void completeTagNames(ProductForm form) {
        List<String> tagNames = form.getTagNames();
        if (tagNames == null) {
            tagNames = new ArrayList<>();
            form.setTagNames(tagNames);
        }
        tagNames.clear();
        Map<Integer, String> tagMap = createTagMap();
        for (Integer id : form.getTagIds()) {
            tagNames.add(tagMap.get(id));
        }
    }
}
