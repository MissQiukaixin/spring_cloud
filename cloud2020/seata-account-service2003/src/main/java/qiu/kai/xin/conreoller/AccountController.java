package qiu.kai.xin.conreoller;


import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qiu.kai.xin.domain.CommonResult;
import qiu.kai.xin.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class AccountController {

//    @Autowired
    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money){
        System.out.println("准备开始进入account的service------>");
        accountService.decrease(userId,money);
        return new CommonResult(200,"扣减账户余额成功！");
    }

    @GetMapping("hello")  //测试连通性
    public String hello(){
        return "我是account的hello,我们可以进行通信";
    }
}
