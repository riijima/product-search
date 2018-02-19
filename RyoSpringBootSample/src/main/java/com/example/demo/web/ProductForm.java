package com.example.demo.web;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {

	private Integer productId;
	
	private String productName;
	
	private String productNameKana;
	
	private List<Integer> tagIds;
	
    private List<String> tagNames;

    private MultipartFile imageFile;
	
	private String imageFileName;

	private String savedImageFilePath;
	
	private String condition;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameKana() {
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	public List<Integer> getTagIds() {
		return tagIds;
	}

	public void setTagIds(List<Integer> tagIds) {
		this.tagIds = tagIds;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

    /**
     * @return the savedImageFilePath
     */
    public String getSavedImageFilePath() {
        return savedImageFilePath;
    }

    /**
     * @param savedImageFilePath the savedImageFilePath to set
     */
    public void setSavedImageFilePath(String savedImageFilePath) {
        this.savedImageFilePath = savedImageFilePath;
    }

    /**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ProductForm [productId=" + productId + ", productName=" + productName + ", productNameKana="
                + productNameKana + ", tagIds=" + tagIds + ", imageFile=" + imageFile + ", imageFileName="
                + imageFileName + ", savedImageFilePath=" + savedImageFilePath + "]";
    }

    /**
     * @return the tagNames
     */
    public List<String> getTagNames() {
        return tagNames;
    }

    /**
     * @param tagNames the tagNames to set
     */
    public void setTagNames(List<String> tagNames) {
        this.tagNames = tagNames;
    }
}
