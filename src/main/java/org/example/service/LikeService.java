package org.example.service;

import org.example.repository.LikeRepository;
import org.example.repository.entity.Like;

import java.util.List;
import java.util.Optional;

public class LikeService {
    LikeRepository likeRepository;

    public LikeService(){
        this.likeRepository = new LikeRepository();
    }

    public Like save(Like like){
        return likeRepository.save(like);
    }


    public List<Like> findAll(){
        return likeRepository.findAll();
    }

    public Optional<Like> findById(Long id){
        return likeRepository.findById(id);
    }

    public List<Like> saveAll(List<Like> likeList){
        return (List<Like>) likeRepository.saveAll(likeList);
    }

    public void delete(Like like){
        likeRepository.delete(like);
    }

    public void deleteById(Long id){
        likeRepository.deleteById(id);
    }

    public boolean existById(Long id){
        return likeRepository.existById(id);
    }

    public List<Like> findByEntity(Like like){
        return likeRepository.findByEntity(like);
    }

    public List<Like> findByColumnNameAndValue(String columnName, String columnValue){
        return likeRepository.findByColumnNameAndValue(columnName, columnValue);
    }
}
