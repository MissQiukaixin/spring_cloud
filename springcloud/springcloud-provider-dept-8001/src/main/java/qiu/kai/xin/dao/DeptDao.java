package qiu.kai.xin.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import qiu.kai.xin.pojo.Dept;

import java.util.List;


@Repository
@Mapper
public interface DeptDao {
    public boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
