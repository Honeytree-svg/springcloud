package springcloud.controller;

import com.sz.springcloud.entity.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderNacosController {

    @Value("${server-url.nacos-user-service}")
    private String server;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){

        ResponseEntity<String> entity = restTemplate.getForEntity(server+"/payment/nacos/" + id,String.class);
        return entity.getBody();
    }

}
