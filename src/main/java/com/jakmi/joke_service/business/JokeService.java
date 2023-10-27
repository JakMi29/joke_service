package com.jakmi.joke_service.business;

import com.jakmi.joke_service.api.rest.request.AddJokeRequest;
import com.jakmi.joke_service.business.dao.JokeDAO;
import com.jakmi.joke_service.doamin.Category;
import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.doamin.JokeServiceUser;
import com.jakmi.joke_service.infrastructure.database.mapper.JokeEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JokeService {
    private final JokeDAO jokeDAO;
    private final JokeServiceUserService jokeServiceUserService;
    private final JokePaginationService jokePaginationService;
    private final JokeEntityMapper jokeEntityMapper;

    @Transactional
    public List<Joke> findAll(int pageNumber, int pageSize) {
        return this.jokePaginationService.paginate(pageNumber,pageSize).stream()
                .map(jokeEntityMapper::map)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Joke> findByCategory(String category, int pageNumber, int pageSize) {
        return this.jokePaginationService.paginateByCategory(category,pageNumber,pageSize).stream()
                .map(jokeEntityMapper::map)
                .collect(Collectors.toList());
    }

    @Transactional
    public Joke createJoke(AddJokeRequest request, String userEmail) {
        JokeServiceUser user = jokeServiceUserService.findByEmail(userEmail);
        Joke joke = Joke.builder()
                .name(request.getDescription())
                .contents(request.getContents())
                .category(Category.valueOf(request.getCategory().toUpperCase()))
                .owner(user)
                .build();
        return jokeDAO.createJoke(joke);
    }
    @Transactional
    public void deleteJoke(String jokeName) {
        jokeDAO.deleteJoke(jokeName);
    }
}
