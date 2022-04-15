package com.xbl.webservice.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2022-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("all_files")
@ApiModel(value="AllFiles对象", description="")
@AllArgsConstructor
@NoArgsConstructor
public class AllFiles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "fid", type = IdType.AUTO)
    private String  fid;

    @TableField("file_name")
    private String fileName;

    @TableField("file_size")
    private Integer fileSize;

    @TableField("file_type")
    private Integer fileType;

    @TableField("file_path")
    private String filePath;
    @TableLogic(value = "1",delval = "0")//归0就没了
    private Integer deleted;

}
