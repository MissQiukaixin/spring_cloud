


import cn.hutool.core.util.IdUtil;
import org.junit.Test;

public class test1 {
    @Test
    public void oo(){
        //使用hutool插件生成唯一的id
        System.out.println(IdUtil.simpleUUID());
    }
}
