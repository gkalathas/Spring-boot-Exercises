package com.example.server.service.implementation;

import com.example.server.model.Server;
import com.example.server.repository.ServerRepository;
import com.example.server.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImplementation implements ServerService {

    ServerRepository serverRepository;


    @Override
    public Server create(Server server) {
        log.info("Server with name {} created", server.getName() );
        return null;
    }

    @Override
    public Server ping(String ipAddress) {
        return null;
    }

    @Override
    public Collection<Server> serverList(int limit) {
        return null;
    }

    @Override
    public Server get(Long id) {
        return null;
    }

    @Override
    public Server update(Server server) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
