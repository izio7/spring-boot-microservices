package com.marcuseisele.springboot_microservices.counterservice.api;


import com.marcuseisele.springboot_microservices.counterservice.api.client.CountClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class CounterConsumerController {

    private final CountClient countClient;

    CounterConsumerController(CountClient countClient) {
        this.countClient = countClient;
    }

    @GetMapping(path = "/decoratedCount")
    public String getDecoratedCount() {
        return "decorated: " + countClient.getStores();
    }
}
