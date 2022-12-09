package com.example.springTutorial.service;


import java.util.List;
import java.util.Optional;

//<T> = <ENTITY_TYPE>
public interface CrudService<ENTITY_TYPE> {

    ENTITY_TYPE create(ENTITY_TYPE entity);

    Optional<ENTITY_TYPE> read(Long id);

    List<ENTITY_TYPE> read();

    void delete(Long id);

    ENTITY_TYPE Update(ENTITY_TYPE entity, Long id);

}
