package com.ssm.service.Impl;

import com.ssm.domain.BaseResult;
import com.ssm.page.PageBean;
import com.ssm.domain.Student;
import com.ssm.mapper.StudentMapper;
import com.ssm.service.StudentService;
import com.sun.javafx.font.PGFont;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 18/1/26.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    /*声明service层中的对外接口对象*/
    @Resource
    private StudentMapper studentMapper;
    public List<Student> selectAll() {

        return studentMapper.selectAll();
    }

    /**
     * @param pageIndex 页码 从0开始
     * @param pageSize  每页显示的条数
     * @return 返回包含total和data的结果封装对象
     */
    public BaseResult<Student> pageSelect(int pageIndex, int pageSize,Student student) {
        BaseResult<Student> result=new BaseResult<Student>();
        PageBean<Student> pg=new PageBean<Student>(1,3,4);
        pg.setParameter(student);
        int total=studentMapper.getTotalRecord(pg);
        /*构建分页对象*/
        PageBean<Student> pageBean=new PageBean<Student>(pageIndex+1,pageSize,total);
        //更新分页查询中的参数
        pageBean.setParameter(student);
        List<Student> datas=studentMapper.pageSelect(pageBean);
        /*将总记录数与当前页data数据设置到BaseResult对象中*/
        result.setTotal(total);
        result.setData(datas);
        return result;
    }

//    public List<Student> pageSelectStudent(PageBean pageBean) {
//        return studentMapper.pageSelect(pageBean);
//    }


}
