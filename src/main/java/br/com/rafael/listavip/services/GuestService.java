package br.com.rafael.listavip.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smrafael.emailsender.services.EmailSender;

import br.com.rafael.listavip.models.Guest;
import br.com.rafael.listavip.repositories.GuestRepository;

@Service
public class GuestService {
	
	@Autowired
    private GuestRepository repository;
	
	private EmailSender emailSender = new EmailSender();

    public Iterable<Guest> findAll(){
        Iterable<Guest> convidados = repository.findAll();
        return convidados;
    }

    public void save(Guest guest){
        repository.save(guest);
        emailSender.send(guest.getName(), guest.getEmail());
    }

}
