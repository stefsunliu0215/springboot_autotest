package com.liu.bean;

/**
 * @ClassName: Resource
 * @Description: 附件信息
 * @Author: 52945
 * @Date: 2020/1/8 14:07
 * @Version: 1.0
 */
public class Resource {

    private String resName;

    private String uploadTime;

    private String resSize;

    public Resource() {
    }

    public Resource(String resName, String uploadTime, String resSize) {
        this.resName = resName;
        this.uploadTime = uploadTime;
        this.resSize = resSize;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getResSize() {
        return resSize;
    }

    public void setResSize(String resSize) {
        this.resSize = resSize;
    }

}
