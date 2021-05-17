package com.sm.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoInfo {
    private Long id;//序列号

    private String vid;//视频id

    private String title;//视频标题

    private String directors;//导演

    private String actors;//演员

    private String tags;//标签

    private String area;//地区

    private String language;//语言

    public VideoInfo(ResultSet rs) throws SQLException {
        this.id = rs.getLong("id");
        this.vid = rs.getString("vid");
        this.title = rs.getString("title");
        this.directors = rs.getString("directors");
        this.actors = rs.getString("actors");
        this.tags = rs.getString("tags");
        this.area = rs.getString("area");
        this.language = rs.getString("language");
    }

    public VideoInfo() {
    }

    private String descinfo;//描述

    private Byte attr;//视频类型 1单片2剧集

    private Integer epcnt;//剧集数量

    private Integer eptotal;//全集数

    private Integer length;//时长（秒）

    private String fdncode;//播放码

    private Integer cid;//二级类别

    private Integer isRecommand;//是否推荐 1推荐0不推荐

    private String pubdate;//发行年份

    private Integer isclose;//0未完结1已经完结

    private String img1;

    private String img2;

    private String img3;

    private String img4;

    @Override
    public String toString() {
        return "VideoInfo{" +
                "id=" + id +
                ", vid='" + vid + '\'' +
                ", title='" + title + '\'' +
                ", directors='" + directors + '\'' +
                ", actors='" + actors + '\'' +
                ", tags='" + tags + '\'' +
                ", area='" + area + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid == null ? null : vid.trim();
    }

    public Byte getAttr() {
        return attr;
    }

    public void setAttr(Byte attr) {
        this.attr = attr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescinfo() {
        return descinfo;
    }

    public void setDescinfo(String descinfo) {
        this.descinfo = descinfo == null ? null : descinfo.trim();
    }

    public Integer getEpcnt() {
        return epcnt;
    }

    public void setEpcnt(Integer epcnt) {
        this.epcnt = epcnt;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1 == null ? null : img1.trim();
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2 == null ? null : img2.trim();
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3 == null ? null : img3.trim();
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4 == null ? null : img4.trim();
    }

    public String getFdncode() {
        return fdncode;
    }

    public void setFdncode(String fdncode) {
        this.fdncode = fdncode == null ? null : fdncode.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getIsRecommand() {
        return isRecommand;
    }

    public void setIsRecommand(Integer isRecommand) {
        this.isRecommand = isRecommand;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getEptotal() {
        return eptotal;
    }

    public void setEptotal(Integer eptotal) {
        this.eptotal = eptotal;
    }

    public Integer getIsclose() {
        return isclose;
    }

    public void setIsclose(Integer isclose) {
        this.isclose = isclose;
    }


}