package dev.rozwalka.distributed.tracing.microservice3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class SampleController {

    private final RestTemplate restTemplate;

    public SampleController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String get() {
        log.info("Hi from third micro service");

        return "Hello";

//        return restTemplate.exchange("http://localhost:8080/",
//                GET, null, new ParameterizedTypeReference<String>() {
//                }).getBody();    }
    }

}
