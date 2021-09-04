package qiu.kai.xin.controller;


import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import qiu.kai.xin.domain.CommonResult;
import qiu.kai.xin.domain.Order;
import qiu.kai.xin.service.OrderService;

import javax.annotation.Resource;

@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    private CommonResult create(Order order){
        orderService.create(order);

        System.out.println("创建一次订单。。。。");
        return new CommonResult(200,"订单创建成功");
    }
}
