package com.example.springhw19.Controller;

import com.example.springhw19.ApiException.ApiException;
import com.example.springhw19.Model.Director;
import com.example.springhw19.Service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectoryConteoller {
    private  final DirectorService directorService;

    @GetMapping("/get")
    public ResponseEntity getDirector(){
        List<Director> directors=directorService.getDirector();
        return ResponseEntity.status(200).body(directors);
    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid @RequestBody Director director){

        directorService.addDirector(director);
        return ResponseEntity.status(200).body("Director Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector(@PathVariable Integer id,@Valid@RequestBody Director director){
        boolean isUpdate= directorService.updateDirector(id, director);
        if(isUpdate) {
            return ResponseEntity.status(200).body("Director Updated");
        }
        throw new ApiException("Wrong Id");
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity deleteDirector(@PathVariable Integer id){
        boolean isDelete= directorService.deleteDirector(id);
        if(isDelete) {
            return ResponseEntity.status(200).body("Director Deleted");
        }
        throw new ApiException("wrong Id");
    }
}
