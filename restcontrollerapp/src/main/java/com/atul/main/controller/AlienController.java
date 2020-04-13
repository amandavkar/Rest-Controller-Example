package com.atul.main.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.atul.main.entity.Alien;
import com.atul.main.service.AlienDAO;

@RestController
public class AlienController {
	
	
	@Autowired
	AlienDAO adao;
	
	@PostMapping(path="/alien", consumes= {"application/json"})
	public Alien addAlien(@RequestBody Alien alien) {
		adao.save(alien);
		return alien;
	}

	@PutMapping(path="/alien", consumes= {"application/json"})
	public Alien updateAlien(@RequestBody Alien alien) {
		adao.save(alien);
		return alien;
	}
	
	@GetMapping(path="/aliens", produces={"application/json"})
	public List<Alien> getAlliens() {		
		return adao.findAll();		
	}
	
	@GetMapping(path="/alien/{aid}",produces={"application/json"})
	public Optional<Alien> getAllien(@PathVariable("aid") int aid) {
		return adao.findById(aid);	
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAllien(@PathVariable("aid") int aid) {
		adao.deleteById(aid);	
		return "deleted";
	}
	
}
