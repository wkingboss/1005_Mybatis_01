package com.ssm.controller;

import com.ssm.domain.BaseResult;
import com.ssm.page.PageBean;
import com.ssm.domain.Student;
import com.ssm.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 18/1/25.
 */
@Controller
public class StudentController {
    @Resource
    private StudentService studentService;
    private PageBean pageBean;

    @RequestMapping(value = {"", "/"})
    public String index() {
        return "index";
    }

    //获取学生列表数据,用于前端表格显示
    @RequestMapping(value = "searchStudent")
    @ResponseBody
    public BaseResult<Student> searchStudent() {
        List<Student> students = studentService.selectAll();
        //将寻找到的结果集进行封装
        BaseResult<Student> result = new BaseResult<Student>();
        result.setTotal(100);
        result.setData(students);
        return result;
    }

    /*分页查询
    * pageIndex和pageSize
    * student接受前端页码传递过来的参数*/
    @RequestMapping(value = "findStudent")
    @ResponseBody
    public BaseResult<Student> findStudent(int pageIndex, int pageSize,Student student) {
        /*分页查询业务*/
        BaseResult<Student> result  = studentService.pageSelect(pageIndex,pageSize,student);
        return result;

    }
}

