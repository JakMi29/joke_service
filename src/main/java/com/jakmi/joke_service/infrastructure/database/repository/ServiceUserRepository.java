package com.jakmi.joke_service.infrastructure.database.repository;

import com.jakmi.joke_service.business.dao.ServiceUserDAO;
import com.jakmi.joke_service.doamin.ServiceUser;
import com.jakmi.joke_service.infrastructure.database.entity.ServiceUserEntity;
import com.jakmi.joke_service.infrastructure.database.mapper.ServiceUserEntityMapper;
import com.jakmi.joke_service.infrastructure.database.repository.jpa.ServiceUserJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ServiceUserRepository implements ServiceUserDAO {

    private final ServiceUserJpaRepository repository;
    private final ServiceUserEntityMapper serviceUserEntityMapper;

    @Override
    public Optional<ServiceUser> findByEmail(String email) {
        return repository.findByEmail(email).map(serviceUserEntityMapper::map);
    }

    @Override
    public void deleteByEmail(String email) {
        repository.deleteByEmail(email);
    }

    @Override
    public Optional<ServiceUser> findByUserName(String username) {
        return repository.findByUsername(username).map(serviceUserEntityMapper::map);
    }

    @Override
    public void createUser(ServiceUser user) {
        repository.save(serviceUserEntityMapper.map(user));
    }


}
