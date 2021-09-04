package qiu.kai.xin.service;

import org.springframework.stereotype.Service;
import qiu.kai.xin.pojo.Dept;

import java.util.List;


public interface DeptService {
    public boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
