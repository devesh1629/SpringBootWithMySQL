package com.example.crudUsingMySQL.service.impl;

import com.example.crudUsingMySQL.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    @Qualifier("restTemplate10")
    private RestTemplate restTemplate;

    @Value("${posts.api-key}")
    private String postsApiKey;

    @Value("${posts.urlToGetAllPosts}")
    private String getAllPostsApi;

    @Value("${posts.urlToGetPostById}")
    private String getPostByIdApi;

    @Override
    public ResponseEntity<?> getAllPosts() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(getAllPostsApi, HttpMethod.GET, entity, String.class);
        return response;
    }

    @Override
    public ResponseEntity<?> getPostById(Integer postId) {
        URI uri = UriComponentsBuilder.fromUriString(getPostByIdApi)
                .buildAndExpand(postId)
                .toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        return response;
    }

}
