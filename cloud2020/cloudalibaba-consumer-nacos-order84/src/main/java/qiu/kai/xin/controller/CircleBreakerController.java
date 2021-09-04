package qiu.kai.xin.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import qiu.kai.xin.entities.CommonResult;
import qiu.kai.xin.entities.Payment;
import qiu.kai.xin.service.PaymentService;


/**
 * 这节讲的就是 sentinel的报错
 */
import javax.annotation.Resource;
@RestController
public class CircleBreakerController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback",fallback = "handlerFallback" )   //fallback只负责java的报错
    @SentinelResource(value = "fallback" , blockHandler = "blockHandler_",
                        //IllegalArgumentException 配了这个异常，就不走兜底的方法直接报错
                        exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL+"/paymentSQL/"+id,CommonResult.class,id);

        if (id == 5){
            throw new IllegalArgumentException("IllegalAccessException,非法参数异常");
        }else if (result.getData() == null){
            throw new NullPointerException("NullPointerException，该id没有对应记录，空指针异常");
        }
        return  result;
    }

    //兜底方法  处理java业余代码错误的关系
    public CommonResult handlerFallback(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"兜底异常handlerFallback,专门为java代码出错而准备：:"+e.getMessage(),payment);
    }

    //兜底方法  blockHandler 解决sentinel的关系
    public CommonResult blockHandler_(@PathVariable Long id, BlockException blockException){
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"blockHandler-sentinel限流,专门处理sentinel的：:"+blockException.getMessage(),payment);
    }

    //===============openfeign
    @Resource
    private PaymentService paymentService;

    @GetMapping("/OpenFeignPaymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }

}
