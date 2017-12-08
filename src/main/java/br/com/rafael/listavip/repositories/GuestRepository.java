package br.com.rafael.listavip.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.rafael.listavip.models.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long> {

}
