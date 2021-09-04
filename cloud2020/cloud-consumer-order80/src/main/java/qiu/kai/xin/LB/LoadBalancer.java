package qiu.kai.xin.LB;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
   public ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
