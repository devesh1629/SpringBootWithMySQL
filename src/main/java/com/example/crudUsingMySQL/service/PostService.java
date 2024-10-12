package com.example.crudUsingMySQL.service;

import org.springframework.http.ResponseEntity;

public interface PostService {

    public ResponseEntity<?> getAllPosts();

    public ResponseEntity<?> getPostById(Integer id);

}
