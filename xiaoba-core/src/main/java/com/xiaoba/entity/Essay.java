package com.xiaoba.entity;


import java.sql.Date;
import java.util.List;

/**
 * @author zhouning
 */
public class Essay {
    private Integer essayId;
    private String essayTitle;
    private String essayAbstract;
    private String essayAuthor;
    private Date essayPublishTime;
    private String savePath;
    private Integer commentNum;
    private String category;
    private List<Tag> tagList;

    public Integer getEssayId() {
        return essayId;
    }

    public void setEssayId(Integer essayId) {
        this.essayId = essayId;
    }

    public String getEssayTitle() {
        return essayTitle;
    }

    public void setEssayTitle(String essayTitle) {
        this.essayTitle = essayTitle;
    }

    public String getEssayAbstract() {
        return essayAbstract;
    }

    public void setEssayAbstract(String essayAbstract) {
        this.essayAbstract = essayAbstract;
    }

    public String getEssayAuthor() {
        return essayAuthor;
    }

    public void setEssayAuthor(String essayAuthor) {
        this.essayAuthor = essayAuthor;
    }

    public Date getEssayPublishTime() {
        return essayPublishTime;
    }

    public void setEssayPublishTime(Date essayPublishTime) {
        this.essayPublishTime = essayPublishTime;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    @Override
    public String toString() {
        return "Essay{" +
                "essayId=" + essayId +
                ", essayTitle='" + essayTitle + '\'' +
                ", essayAbstract='" + essayAbstract + '\'' +
                ", essayAuthor='" + essayAuthor + '\'' +
                ", essayPublishTime=" + essayPublishTime +
                ", savePath='" + savePath + '\'' +
                ", commentNum=" + commentNum +
                ", category='" + category + '\'' +
                ", tagList=" + tagList +
                '}';
    }
}
