package com.sofka.demo.repo;

import com.sofka.demo.controller.PersonController;
import com.sofka.demo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepoIpm implements IPersonRepo{
    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Override
    public Flux<Person> list() {
        List<Person> listperson = new ArrayList<>();
        listperson.add(new Person(1,"Yefer"));
        listperson.add(new Person(2,"Alejo"));
        listperson.add(new Person(3,"Valencia"));
        listperson.add(new Person(0,"Garzon"));

        return Flux.fromIterable(listperson);
    }

    @Override
    public Mono<Person> listForId(Integer id) {
        return Mono.just(new Person(1,"Yefer"));
    }

    @Override
    public Mono<Person> register(Person person) {
        log.info(person.toString());
        return Mono.just(person);
    }

    @Override
    public Mono<Person> modify(Person person) {
        log.info(person.toString());
        return Mono.just(person);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return Mono.empty();
    }
}
