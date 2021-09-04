package qiu.kai.xin.service;

import feign.hystrix.FallbackFactory;
import qiu.kai.xin.pojo.Dept;

import java.util.List;

public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryBtId(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("id=>"+id+"不存在该用户")
                        .setDb_source("没有数据");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}