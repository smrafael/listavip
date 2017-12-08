package br.com.rafael.listavip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rafael.listavip.models.Guest;
import br.com.rafael.listavip.repositories.GuestRepository;

@Controller
public class GuestController {
	
	@Autowired
	private GuestRepository repository;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/list")
	public String listGuests(Model model) {
		
		Iterable<Guest> guests = repository.findAll();
		model.addAttribute("convidados", guests);
		
		return "listguests";
	}

}
