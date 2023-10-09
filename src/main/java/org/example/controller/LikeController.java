package org.example.controller;

import org.example.repository.entity.Like;
import org.example.repository.entity.Post;
import org.example.service.LikeService;
import org.example.service.PostService;

import java.util.List;

public class LikeController {
    LikeService likeService;
    public LikeController(){
        this.likeService = new LikeService();
    }
    public void likePost(Long postid,Long userid) {
        Like like=Like.builder()
                .postid(postid)
                .userid(userid)
                .build();
    }

    public void listLikePosts() {
        findAll().forEach(likePost -> {
            System.out.println(likePost.toString());
        });
    }
    public List<Like> findAll(){
        return likeService.findAll();
    }

}
