package dev.rozwalka.distributed.tracing.microservice2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

@RestController
@Slf4j
public class SampleController {

    private final RestTemplate restTemplate;

    public SampleController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String get() {
        log.info("Hi from second micro service");

        return restTemplate.exchange("http://localhost:8083/",
                GET, null, new ParameterizedTypeReference<String>() {
                }).getBody();
    }

}
