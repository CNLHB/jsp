package com.lhb.jsp.mapper;

import com.lhb.jsp.pojo.Student;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface StudentMapper  extends Mapper<Student>, IdListMapper<Student,Long>, InsertListMapper<Student> {
}
