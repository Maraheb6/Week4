package com.example.springhw19.Service;

import com.example.springhw19.Model.Director;
import com.example.springhw19.Repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DirectorService {
    public final DirectorRepository directorRepository;

    public List<Director> getDirector(){
        return directorRepository.findAll();
    }

    public void addDirector(Director director){
        directorRepository.save(director);
    }

    public boolean updateDirector(Integer id,Director director){
        Director oldDirector=directorRepository.findDirectorById(id);
        if(oldDirector==null){
            return false;
        }

        oldDirector.setName(director.getName());
        directorRepository.save(oldDirector);
        return true;
    }

    public boolean deleteDirector(Integer id){
        Director director=directorRepository.findDirectorById(id);
        if(director==null){
            return false;
        }
        directorRepository.delete(director);
        return true;
    }
}
