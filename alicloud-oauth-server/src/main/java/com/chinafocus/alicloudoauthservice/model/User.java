package com.chinafocus.alicloudoauthservice.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("user")
public class User extends Model<User> {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;


    private String password;


    private Date createTime;
}
