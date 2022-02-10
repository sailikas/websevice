package com.xbl.webservice.pojo;

import lombok.Builder;
import lombok.Data;

import java.io.File;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class FolderBean {
    private List<File> fileList;        //文件夹内的所有文件
    private String name;                //文件夹名
    private int capacity;               //该文件夹所占空间大小
    private Date createTime;            //文件夹创建时间
    private Date updateTime;            //文件夹修改时间

}
