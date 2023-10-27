package com.jakmi.joke_service.business;

import com.jakmi.joke_service.business.dao.JokeDAO;
import com.jakmi.joke_service.doamin.Category;
import com.jakmi.joke_service.infrastructure.database.entity.JokeEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JokePaginationService {
    private final JokeDAO jokeDAO;

    public Page<JokeEntity> paginate(int pageNumber, int pageSize){
        Sort sort= Sort.by("name");
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        return jokeDAO.findAll(pageable);
    }

    public Page<JokeEntity> paginateByCategory(String categoryName, int pageNumber, int pageSize){
        Sort sort= Sort.by("name");
        Pageable pageable= PageRequest.of(pageNumber,pageSize,sort);
        Category category=Category.valueOf(categoryName.toUpperCase());
        return jokeDAO.findByCategory(category,pageable);
    }


}
