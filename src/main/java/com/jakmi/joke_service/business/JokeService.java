package com.jakmi.joke_service.business;

import com.jakmi.joke_service.api.rest.request.AddJokeRequest;
import com.jakmi.joke_service.business.dao.JokeDAO;
import com.jakmi.joke_service.business.dao.JokeServiceUserDAO;
import com.jakmi.joke_service.doamin.Category;
import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.doamin.JokeServiceUser;
import com.jakmi.joke_service.infrastructure.database.entity.JokeEntity;
import com.jakmi.joke_service.infrastructure.database.entity.JokeServiceUserEntity;
import com.jakmi.joke_service.infrastructure.database.mapper.JokeEntityMapper;
import com.jakmi.joke_service.infrastructure.database.mapper.JokeServiceUserEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JokeService {
    private final JokeDAO jokeDAO;
    private final JokeServiceUserService jokeServiceUserService;
    private final JokePaginationService jokePaginationService;
    private final JokeEntityMapper jokeEntityMapper;
    private final JokeServiceUserEntityMapper jokeServiceUserEntityMapper;

    @Transactional
    public List<Joke> findAll(int pageNumber, int pageSize) {
        return this.jokePaginationService.paginate(pageNumber, pageSize).stream()
                .map(jokeEntityMapper::map)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Joke> findByCategory(String category, int pageNumber, int pageSize) {
        return this.jokePaginationService.paginateByCategory(category, pageNumber, pageSize).stream()
                .map(jokeEntityMapper::map)
                .collect(Collectors.toList());
    }

    @Transactional
    public Joke createJoke(AddJokeRequest request, String userEmail) {
        JokeServiceUser user = jokeServiceUserService.findByEmail(userEmail);
        JokeEntity joke = JokeEntity.builder()
                .name(request.getDescription())
                .contents(request.getContents())
                .category(Category.valueOf(request.getCategory().toUpperCase()))
                .owner(jokeServiceUserEntityMapper.map(user))
                .build();
        return jokeDAO.createJoke(joke);
    }

    @Transactional
    public void deleteJoke(String jokeName) {
        jokeDAO.deleteJoke(jokeName);
    }

    @Transactional
    public List<Joke> findByUserName(String userName, Integer pageNumber, Integer pageSize) {
        JokeServiceUser jokeServiceUser = jokeServiceUserService.findByUsername(userName);
        return this.jokePaginationService.paginateByUser(jokeServiceUser, pageNumber, pageSize).stream()
                .map(jokeEntityMapper::map)
                .collect(Collectors.toList());
    }
}
