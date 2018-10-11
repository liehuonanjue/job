package com.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class ReplyDetail implements Serializable {

    private int id; // 编号
    private int invaid;// 帖子编号
    @NotNull(message = "回复内容")
    @Size(min = 4, max = 6, message = "用户名大于四个字节小于6个")
    private String content;// 回复内容
    private String autohor;//回复人名称
    private Date createdate;//发布时间
    private String datetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvaid() {
        return invaid;
    }

    public void setInvaid(int invaid) {
        this.invaid = invaid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAutohor() {
        return autohor;
    }

    public void setAutohor(String autohor) {
        this.autohor = autohor;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "ReplyDetail{" +
                "id=" + id +
                ", invaid=" + invaid +
                ", content='" + content + '\'' +
                ", autohor='" + autohor + '\'' +
                ", createdate=" + createdate +
                ", datetime='" + datetime + '\'' +
                '}';
    }

    public ReplyDetail() {
    }

    public ReplyDetail(int id, int invaid, String content, String autohor, Date createdate, String datetime) {

        this.id = id;
        this.invaid = invaid;
        this.content = content;
        this.autohor = autohor;
        this.createdate = createdate;
        this.datetime = datetime;
    }
}
