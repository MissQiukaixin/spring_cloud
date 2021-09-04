package qiu.kai.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


//自定义Ribbon的负载均衡模式
public class MyRandomRule extends AbstractLoadBalancerRule {
    public MyRandomRule() {
    }

    private int total = 0;
    private int currentIndex = 0; //当前服务要大于等于活着的服务数不然会越界
    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();   //获得活着的服务
                List<Server> allList = lb.getAllServers();     //获得所有服务
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

//                int index = this.chooseRandomInt(serverCount);   // 生成区间随机数
//                server = (Server)upList.get(index);
//                if (server == null) {
//                    Thread.yield();
//                } else {
//                    if (server.isAlive()) {
//                        return server;
//                    }
//
//                    server = null;
//                    Thread.yield();
//                }
                //自定义
                if (total < 3){
                    server = upList.get(currentIndex);
                    total++;
                } else {
                    total = 0 ;
                    currentIndex++;
                    if (currentIndex > upList.size()-1){
                        currentIndex = 0;
                    }
                    server = upList.get(currentIndex);
                }
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
