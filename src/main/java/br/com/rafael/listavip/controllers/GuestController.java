package br.com.rafael.listavip.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.rafael.listavip.models.Guest;
import br.com.rafael.listavip.services.GuestService;

@Controller
public class GuestController {
	
	@Autowired
	private GuestService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/list")
	public String listGuests(Model model) {
		Iterable<Guest> guests = service.findAll();
		model.addAttribute("convidados", guests);
		model.addAttribute("newGuest", new Guest());
		
		return "listguests";
	}
	
	@PostMapping("/salvar")
	public String save(@ModelAttribute Guest guest) {
		service.save(guest);
		return "redirect:/list";
	}
}
