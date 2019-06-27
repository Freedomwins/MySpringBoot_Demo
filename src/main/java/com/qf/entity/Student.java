package com.qf.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private  int cid;

    @TableField(exist = false)
    private Classes classes;
}
