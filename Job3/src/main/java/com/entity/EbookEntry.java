package com.entity;

import java.io.Serializable;
import java.util.Date;

public class EbookEntry implements Serializable {

    private int id;
    private int categoryId;
    private String title;
    private String summary;
    private String uploaduser;
    private Date cretedate;
    private String Datetime;

    @Override
    public String toString() {
        return "EbookEntry{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", uploaduser='" + uploaduser + '\'' +
                ", cretedate=" + cretedate +
                '}';
    }

    public String getDatetime() {
        return Datetime;
    }

    public void setDatetime(String datetime) {
        Datetime = datetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUploaduser() {
        return uploaduser;
    }

    public void setUploaduser(String uploaduser) {
        this.uploaduser = uploaduser;
    }

    public Date getCretedate() {
        return cretedate;
    }

    public void setCretedate(Date cretedate) {
        this.cretedate = cretedate;
    }

    public EbookEntry() {

    }

    public EbookEntry(int id, int categoryId, String title, String summary, String uploaduser, Date cretedate) {

        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
        this.summary = summary;
        this.uploaduser = uploaduser;
        this.cretedate = cretedate;
    }
}
