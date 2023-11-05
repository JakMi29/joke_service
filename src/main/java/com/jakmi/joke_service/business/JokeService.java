package com.jakmi.joke_service.business;

import com.jakmi.joke_service.api.rest.request.AddJokeRequest;
import com.jakmi.joke_service.api.rest.request.EditJokeRequest;
import com.jakmi.joke_service.business.dao.JokeDAO;
import com.jakmi.joke_service.doamin.Category;
import com.jakmi.joke_service.doamin.Joke;
import com.jakmi.joke_service.doamin.ServiceUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class JokeService {
    private final JokeDAO jokeDAO;
    private final ServiceUserService serviceUserService;
    private final JokePaginationService jokePaginationService;


    public List<Joke> findAll(int pageNumber, int pageSize) {
        return this.jokePaginationService.paginateAll(pageNumber, pageSize);
    }


    public List<Joke> findByCategory(String category, int pageNumber, int pageSize) {
        return this.jokePaginationService.paginateByCategory(category, pageNumber, pageSize);
    }

    @Transactional
    public Joke createJoke(AddJokeRequest request, String userEmail) {
        ServiceUser user = serviceUserService.findByEmail(userEmail);
        Joke joke = Joke.builder()
                .name(request.getName())
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

    @Transactional
    public List<Joke> findByUserName(String userName, Integer pageNumber, Integer pageSize) {
        ServiceUser serviceUser = serviceUserService.findByUsername(userName);
        return this.jokePaginationService.paginateByUser(serviceUser, pageNumber, pageSize);
    }

    @Transactional
    public void editJoke(EditJokeRequest editJokeRequest) {
        Joke joke = jokeDAO.findByName(editJokeRequest.getOldName())
                .withName(editJokeRequest.getNewName())
                .withContents(editJokeRequest.getContents())
                .withCategory(Category.valueOf(editJokeRequest.getCategory().toUpperCase()));
        jokeDAO.createJoke(joke);

    }
}
