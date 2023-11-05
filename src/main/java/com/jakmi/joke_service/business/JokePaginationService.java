package com.jakmi.joke_service.business;

import com.jakmi.joke_service.business.dao.JokeDAO;
import com.jakmi.joke_service.doamin.Category;
import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.doamin.ServiceUser;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class JokePaginationService {
    private final JokeDAO jokeDAO;

    @Transactional
    public List<Joke> paginateAll(int pageNumber, int pageSize) {
        Sort sort = Sort.by("name");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return jokeDAO.findAll(pageable);
    }

    @Transactional
    public List<Joke> paginateByCategory(String categoryName, int pageNumber, int pageSize) {
        Sort sort = Sort.by("name");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Category category = Category.valueOf(categoryName.toUpperCase());
        return jokeDAO.findByCategory(category, pageable);
    }

    @Transactional
    public List<Joke> paginateByUser(ServiceUser serviceUser, Integer pageNumber, Integer pageSize) {
        Sort sort = Sort.by("name");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return jokeDAO.findByUser(serviceUser, pageable);
    }
}
