package com.main.superhero.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.main.superhero.domain.SuperHero;
import com.main.superhero.service.SuperHeroService;

@RestController
public class SuperHeroController {
	@Autowired
	private SuperHeroService superHeroService;

	@Autowired
	private ValidateData validateData;

	@PostMapping("/getAllSuperHerosDetails")
	public List<SuperHero> getAllSuperHerosDetails() {
		return superHeroService.getAllSuperHerosDetails();
	}

	@PostMapping("/getSuperHeroDetails/{id}")
	public SuperHero getSuperHeroDetails(@PathVariable("id") Long id) {
		if (validateData.validateId(id)) {
			return superHeroService.getSuperHeroDetails(id);
		} else {
			return new SuperHero("Either Data is not found in database or ID is not valid.");
		}
	}
	
	@PostMapping("/addSuperHeroDetails")
	public SuperHero addSuperHeroDetails(@RequestBody SuperHero s) {
		String st = validateData.validateData(s);

		if (st.isEmpty())
			return superHeroService.addSuperHeroDetails(s);

		else {
			return new SuperHero(st);
		}
	}

	@PostMapping("/updateSuperHeroDetails")
	public SuperHero updateSuperHeroDetails(@RequestBody SuperHero s) {
		String st = validateData.validateData(s);

		if (st.isEmpty())
			return superHeroService.updateSuperHeroDetails(s);

		else
			return new SuperHero(st);

	}

	@PostMapping("/deleteSuperHeroDetails/{id}")
	public SuperHero deleteSuperHeroDetails(@PathVariable("id") Long id) {
		if (validateData.validateId(id))
			return superHeroService.deleteSuperHeroDetails(id);

		else
			return new SuperHero("ID entered is not valid, please insert valid ID.");
	}
}
