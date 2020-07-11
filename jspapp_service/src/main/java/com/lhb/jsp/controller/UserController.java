package com.lhb.jsp.controller;



import com.lhb.jsp.common.enums.SucessEnum;
import com.lhb.jsp.common.result.SucessHandler;
import com.lhb.jsp.common.vo.PageResult;
import com.lhb.jsp.pojo.Student;
import com.lhb.jsp.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("user")
public class UserController {
    @Autowired
    private StudentService studentService;
    @GetMapping("list")
    public ResponseEntity<PageResult> queryStuListByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "10") Integer rows
    ){
        PageResult pageResult = studentService.queryStuList(page, rows);
        return ResponseEntity.ok(pageResult);
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> queryStuById(
            @PathVariable(value = "id") Long id
    ){
        Student student=  studentService.queryStuById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("login")
    public ResponseEntity<Student> login(@RequestBody Student stu){
        Student student =   studentService.login(stu);
        return ResponseEntity.ok(student);
    }
    @PostMapping("register")
    public ResponseEntity<Student> register(@RequestBody Student stu){
        Student student =   studentService.register(stu);
        return ResponseEntity.ok(student);
    }
    @PutMapping
    public ResponseEntity<SucessHandler> updateStu(@RequestBody Student stu){
        Student student =   studentService.updateStu(stu);
        return ResponseEntity.ok(new SucessHandler(SucessEnum.RESULT_POST_OR_PUT_SUCESS));
    }
    @PutMapping("{id}")
    public ResponseEntity<SucessHandler> updatePwdById(
            @PathVariable(value = "id")Long id,
            @RequestParam(value = "oldPassword") String oldPassword,
            @RequestParam(value = "newPassword") String newPassword,
            @RequestParam(value = "comPassword") String comPassword

            ) {
        studentService.updatePwdById(id,oldPassword,newPassword,comPassword);
        return ResponseEntity.ok(new SucessHandler(SucessEnum.RESULT_POST_OR_PUT_SUCESS));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<SucessHandler> deleteStu(@PathVariable(value = "id") Long id){
        studentService.deleteStu(id);
        return ResponseEntity.ok(new SucessHandler(SucessEnum.RESULT_DELETE_SUCESS));
    }
}
