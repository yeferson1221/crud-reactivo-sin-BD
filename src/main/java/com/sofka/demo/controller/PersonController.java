package com.sofka.demo.controller;

import com.sofka.demo.model.Person;
import com.sofka.demo.repo.IPersonRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private IPersonRepo repo;

    @GetMapping
    public Flux<Person> list(){
        return repo.list();
    }
    @GetMapping("/{id}")
    public Mono<Person>listForId(@PathVariable("id") Integer id){
        return repo.listForId(id);
    }

    @PostMapping
    public Mono<Person> register(@RequestBody Person person){
        return repo.register(person);
    }

    @PutMapping
    public Mono<Person> modify(@RequestBody Person person){
        return repo.modify(person);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){
        return  repo.listForId(id)
                .flatMap(person -> repo.delete(person.getId()));
    }
}
