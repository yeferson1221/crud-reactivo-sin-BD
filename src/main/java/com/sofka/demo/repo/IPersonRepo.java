package com.sofka.demo.repo;

import com.sofka.demo.model.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonRepo {
    Flux<Person> list();
    Mono<Person> listForId(Integer id);
    Mono<Person> register(Person person);
    Mono<Person> modify(Person person);
    Mono<Void> delete(Integer id);

}
