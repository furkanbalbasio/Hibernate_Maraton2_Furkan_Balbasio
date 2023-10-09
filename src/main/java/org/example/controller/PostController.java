package org.example.controller;

import org.example.repository.entity.Post;
import org.example.service.PostService;
import org.example.utility.Constans;

import java.util.List;
import java.util.Optional;

public class PostController {
    PostService postService;
    public PostController(){
        this.postService = new PostService();
    }
    public void newPost(String comment,Long computerid,Long userid) {
        Post post= Post.builder()
                .baseEntity(Constans.getBaseEntity())
                .comment(comment)
                .likeCount(0)
                .computerid(computerid)
                .userid(userid)
                .build();
    }

    public void listPosts() {
        findAll().forEach(post->{
            System.out.println(post.toString());
        });
    }
    public List<Post> findAll(){
        return postService.findAll();
    }

    public void findPostsByUserId(Long userid) {
        findById(userid).stream().forEach(postByUserId->{
            System.out.println(postByUserId.toString());
        });
    }
    public Optional<Post> findById(Long id){
        return postService.findById(id);
    }

}
