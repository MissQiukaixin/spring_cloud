package qiu.kai.xin.myhandler;


import com.alibaba.csp.sentinel.slots.block.BlockException;
import qiu.kai.xin.entities.CommonResult;
import qiu.kai.xin.entities.Payment;

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444,"按照用户自定义,global,handlerException---1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,"按照用户自定义,global,handlerException---2");
    }

}
