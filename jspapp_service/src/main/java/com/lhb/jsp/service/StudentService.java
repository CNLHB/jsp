package com.lhb.jsp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhb.jsp.common.enums.ExceptioneEnum;
import com.lhb.jsp.common.exception.CommonAdviceException;
import com.lhb.jsp.common.vo.PageResult;
import com.lhb.jsp.mapper.StudentMapper;
import com.lhb.jsp.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public PageResult queryStuList(int page, int rows){
        PageHelper.startPage(page, rows);
        Example example = new Example(Student.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId",1);
        String orderByClause = "create_time" + " DESC" ;
        example.setOrderByClause(orderByClause);
        List<Student> students = studentMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(students)) {
            return new PageResult<>();
        }
        PageInfo<Student> info = new PageInfo<>(students);
        return new PageResult<>(info.getTotal(),info.getPageNum(), students);
    }

    public Student queryStuById(Long id) {
        Student student = new Student();
        student.setId(id);
        Student student1 = studentMapper.selectByPrimaryKey(student);
        if (student1==null){
            throw  new CommonAdviceException(ExceptioneEnum.QUERY_RESULT_EMPTY);
        }
        return student1;
    }

    public Student register(Student stu) {
        Student student = new Student();
        student.setAccount(stu.getAccount());
        int student1 = studentMapper.selectCount(student);
        if (student1!=0){
            throw new CommonAdviceException(ExceptioneEnum.USER_NUMBER_EXIST);
        }
        int insert = studentMapper.insert(stu);
        return stu;
    }

    public Student updateStu(Student stu) {
        int i = studentMapper.updateByPrimaryKeySelective(stu);
        if (i==0){
            throw new CommonAdviceException(ExceptioneEnum.UPDATA_ERROR);
        }
        return stu;
    }

    public Student login(Student stu) {
        Student student = studentMapper.selectOne(stu);
        if (student==null){
            throw  new CommonAdviceException(ExceptioneEnum.NUMBER_OR_PASSWORD_ERROR);
        }
        return student;
    }

    public void deleteStu(Long id) {
        Student student = new Student();
        student.setId(id);
        int i = studentMapper.deleteByPrimaryKey(student);
        if (i==0){
            throw new CommonAdviceException(ExceptioneEnum.DETELE_ERROR);
        }
    }

    public void updatePwdById(Long id, String oldPassword, String newPassword, String comPassword) {
        if (!StringUtils.isEmpty(oldPassword)&&!StringUtils.isEmpty(newPassword)&&!StringUtils.isEmpty(comPassword)){

            if (!newPassword.equals(comPassword)) {
                throw new CommonAdviceException(ExceptioneEnum.NUMBER_OR_PASSWORD_ERROR);
            }
            Student student = new Student();
            student.setId(id);
//        user.setPassword(md5Pass);
            Student student1 = studentMapper.selectByPrimaryKey(student);
            if (student1 != null) {
                if (!student1.getPassword().equals(oldPassword)) {
                    throw new CommonAdviceException(ExceptioneEnum.INVALID_PASSWORD_ERROR);
                }
                student1.setPassword(newPassword);

                int i = studentMapper.updateByPrimaryKeySelective(student1);
                if (i == 0) {
                    throw new CommonAdviceException(ExceptioneEnum.NUMBER_OR_PASSWORD_ERROR);
                }
            } else {
                throw new CommonAdviceException(ExceptioneEnum.NUMBER_OR_PASSWORD_ERROR);
            }
        }
    }
}
