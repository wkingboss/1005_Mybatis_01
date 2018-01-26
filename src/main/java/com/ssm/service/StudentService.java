package com.ssm.service;

import com.ssm.domain.BaseResult;
import com.ssm.page.PageBean;
import com.ssm.domain.Student;

import java.util.List;

/**
 * Created by dllo on 18/1/26.
 */
public interface StudentService {
    List<Student> selectAll();

//    List<Student> pageSelectStudent(PageBean pageBean);

    /**
     * @param pageIndex 页码 从0开始
     * @param pageSize 每页显示的条数
     * @return 返回包含total和data的结果封装对象
     */
    BaseResult<Student> pageSelect(int pageIndex,
                                   int pageSize,
                                   Student student);
}
