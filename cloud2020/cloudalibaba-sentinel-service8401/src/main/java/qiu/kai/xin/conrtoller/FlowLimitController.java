package qiu.kai.xin.conrtoller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

//流控controller


@RestController
@Slf4j
public class FlowLimitController {
    /**
     * testA 关联 testB
     * 当 B 的资源达到阈值时，A的服务就会关闭  别人捣乱我买单
     *
     * 排队等待是一个个的进来
     */
    @GetMapping("/testA")
    public String testA(){
//        try {
//            //睡X秒
//            TimeUnit.MILLISECONDS.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "-----testB";
    }


    @GetMapping("/testD")
    public String testD(){
        try {
            //停止1秒
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "-----testD";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("testE 测试RT");
        //异常比例
        int age = 10 / 0;
        return "-----testE";
    }

    @GetMapping("/testF")
    public String testF(){
        log.info("testE 测试RT");
        //异常数
        int age = 10 / 0;
        log.info(Thread.currentThread().getName()+"testF测试：");
        return "-----testE";
    }

    @GetMapping("/testHotkey")
    //资源热点的名称是 value
    // blockHandler 这个兜底的方法只处理web上的访问配置错误   java得源代码错误不行
    @SentinelResource(value = "testHotKey",blockHandler = "del_testHotKey")
    public String testHotkey(
            @RequestParam(value = "p1",required = false) String p1,
            @RequestParam(value = "p2",required = false) String p2
    ){
        int a = 10/0;
        return "------testHotKey";
    }

    //兜底的方法  这个兜底的方法只处理web上的访问配置错误   java得源代码错误不行
    public String del_testHotKey(String p1, String p2, BlockException exception){
        return "------del_testHotKey,我是兜底方法😭";
    }

}
