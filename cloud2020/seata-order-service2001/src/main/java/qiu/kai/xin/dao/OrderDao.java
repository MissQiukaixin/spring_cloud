package qiu.kai.xin.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import qiu.kai.xin.domain.Order;

@Mapper
public interface OrderDao {

    //1 新建订单
    public void create(Order order);

    public void update(@Param("userId") Long userId,@Param("status")Integer status);

}
