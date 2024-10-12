package com.example.crudUsingMySQL.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import com.example.crudUsingMySQL.dto.RestTemplateConstants;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    @Qualifier(RestTemplateConstants.REST_TEMPLATE_10_S)
    @Bean
    public RestTemplate restTemplate5() {
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        factory.setReadTimeout(5000);
//        factory.setConnectTimeout(5000);
//        return new RestTemplate(factory);
        return new RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(10000))
            .setReadTimeout(Duration.ofMillis(10000))
            .build();
    }

    @Qualifier(RestTemplateConstants.REST_TEMPLATE_60_S)
    @Bean
    public RestTemplate restTemplate60() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(60000))
                .setReadTimeout(Duration.ofMillis(60000))
                .build();
    }

    @Qualifier(RestTemplateConstants.REST_TEMPLATE_20_S)
    @Bean
    public RestTemplate restTemplate20() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(20000))
                .setReadTimeout(Duration.ofMillis(20000))
                .build();
    }

    @Qualifier(RestTemplateConstants.REST_TEMPLATE_30_S)
    @Bean
    public RestTemplate restTemplate30() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(30000))
                .setReadTimeout(Duration.ofMillis(30000))
                .build();
    }

}