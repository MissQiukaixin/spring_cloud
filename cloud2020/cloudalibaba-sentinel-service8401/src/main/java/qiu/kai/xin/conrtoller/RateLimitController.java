package qiu.kai.xin.conrtoller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import qiu.kai.xin.entities.CommonResult;
import qiu.kai.xin.entities.Payment;
import qiu.kai.xin.myhandler.CustomerBlockHandler;

@RestController
public class RateLimitController {
    //含有兜底的方法
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource" , blockHandler = "handlerException")
    public CommonResult get(){
        return new CommonResult(200,"按照资源名称限流测试ok",new Payment(2020L,"serial001"));
    }

    public CommonResult handlerException(BlockException blockException)
    {
        return new CommonResult(444,blockException.getClass().getCanonicalName()+"\t服务不可以用");
    }
    //不含有兜底的方法  用的是name属性来指定的
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public CommonResult byUrl(){
        return new CommonResult(200,"按Url限流测试Ok",new Payment(2020L,"serial001"));
    }
}
