package com.lhb.jsp.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "t_student")
public class Student {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long roleId;
    private String username;
    private String account;
    private String password;
    private String adress;

    private Date createTime;
}
