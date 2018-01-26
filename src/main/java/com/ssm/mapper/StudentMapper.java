package com.ssm.mapper;

/**
 * Created by dllo on 18/1/26.
 */

import com.ssm.page.PageBean;
import com.ssm.domain.Student;

import java.util.List;

/**
 * Student操作的对外接口声明
 * 具体实现见Student.xml
 */
public interface StudentMapper {
    /**
     * 查询所有学生列表
     * 1.方法名对应Student.xml中的id
     * 2.方法参数随影Student.xml中的parameterType属性
     * 3.方法返回值对应Student.xml中的resultType属性
     * @return
     */
    List<Student> selectAll();

    /**
     *
     *@param pageBean 中包含分页信息
     * @return
     */
    List<Student> pageSelect
            (PageBean<Student> pageBean);

    /**
     * 获取学生表总条数
     * @return
     */
    Integer getTotalRecord(PageBean<Student> pageBean);


}
