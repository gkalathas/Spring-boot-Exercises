package com.example.server.service.implementation;

import com.example.server.enumerattion.Status;
import com.example.server.model.Server;
import com.example.server.repository.ServerRepository;
import com.example.server.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import static com.example.server.enumerattion.Status.SERVER_DOWN;
import static com.example.server.enumerattion.Status.SERVER_UP;
import static java.util.List.of;


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImplementation implements ServerService {

    ServerRepository serverRepository;


    @Override
    public Server create(Server server) {
        log.info("Server with name {} created", server.getName() );
//        server.setImageUrl(setServerImageUrl());
        return serverRepository.save(server);
    }



    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP: {}", ipAddress);
        Server server = serverRepository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000)? SERVER_UP : SERVER_DOWN);
        serverRepository.save(server);
        return server;
    }

    @Override
    public Collection<Server> serverList(int limit) {
        log.info("Fetching all servers");
        return serverRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Fetching server by id: {}", id);
        return serverRepository.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating server: {}", server.getName());
        return serverRepository.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting server with i: {}", id);
        serverRepository.deleteById(id);
        return Boolean.TRUE;
    }

//    private String setServerImageUrl() {
//        String[] imageNames = {"server1", "server2", "server3", "server4"};
//        return ServletUriComponentsBuilder.fromCurrentContextPath().
//                path("C:\\Users\\kalat\\Desktop\\server\\images" +
//                        imageNames[new Random().nextInt(4)]).toUriString();
//    }
}
