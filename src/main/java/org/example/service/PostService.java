package org.example.service;

import org.example.repository.PostRepository;
import org.example.repository.entity.Post;

import java.util.List;
import java.util.Optional;

public class PostService {
    PostRepository postRepository;

    public PostService(){
        this.postRepository = new PostRepository();
    }

    public Post save(Post post){
        return postRepository.save(post);
    }


    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Optional<Post> findById(Long id){
        return postRepository.findById(id);
    }

        public List<Post> saveAll(List<Post> postList){
        return (List<Post>) postRepository.saveAll(postList);
    }

    public void delete(Post post){
        postRepository.delete(post);
    }

    public void deleteById(Long id){
        postRepository.deleteById(id);
    }

    public boolean existById(Long id){
        return postRepository.existById(id);
    }

    public List<Post> findByEntity(Post post){
        return postRepository.findByEntity(post);
    }

    public List<Post> findByColumnNameAndValue(String columnName, String columnValue){
        return postRepository.findByColumnNameAndValue(columnName, columnValue);
    }
}
