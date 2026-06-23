package com.rohit.controller;

import com.rohit.entity.Post;
import com.rohit.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "Post Deleted Successfully";
    }

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.savePost(post);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id,
                           @RequestBody Post updatedPost) {

        Post post = postService.getPostById(id);

        if(post != null){
            post.setTitle(updatedPost.getTitle());
            post.setContent(updatedPost.getContent());
            post.setAuthor(updatedPost.getAuthor());

            return postService.savePost(post);
        }

        return null;
    }
}