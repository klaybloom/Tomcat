package com.sm.dao;

import com.sm.entity.VideoInfo;
import com.sm.mysql.Until;

import javax.management.Query;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class VideoSelectList {

    public  List<VideoInfo> query(Integer num,Integer size){
        String sql="SELECT * FROM zr_video_info LIMIT ?,?;";
        List<VideoInfo> videoInfoList = null;
        try {
            videoInfoList = Until.query(sql, VideoInfo.class, num,size);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return videoInfoList;
    }
}
