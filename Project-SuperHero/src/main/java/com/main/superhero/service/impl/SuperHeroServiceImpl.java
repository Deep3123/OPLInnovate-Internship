package com.main.superhero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.superhero.domain.SuperHero;
import com.main.superhero.repository.SuperHeroRepo;
import com.main.superhero.service.SuperHeroService;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {
	@Autowired
	private SuperHeroRepo superHeroRepo;

	@Override
	public List<SuperHero> getAllSuperHerosDetails() {
		// TODO Auto-generated method stub
		return superHeroRepo.findAll();
	}

	@Override
	public SuperHero getSuperHeroDetails(Long id) {
		// TODO Auto-generated method stub
		if (superHeroRepo.findById(id).isPresent())
			return superHeroRepo.findById(id).get();

		else
			return new SuperHero("ID is not available in database.");
	}

	@Override
	public SuperHero addSuperHeroDetails(SuperHero s) {
		// TODO Auto-generated method stub
		superHeroRepo.save(s);
		return new SuperHero("Details of SuperHero has been successfully saved.", "Success");
	}

	@Override
	public SuperHero updateSuperHeroDetails(SuperHero s) {
		// TODO Auto-generated method stub
		if (superHeroRepo.findById(s.getId()).isPresent()) {
			SuperHero superHero = superHeroRepo.findById(s.getId()).get();

			if (superHero != null) {
				superHero.setId(s.getId());
				superHero.setAddress(s.getAddress());
				superHero.setEmailId(s.getEmailId());
				superHero.setMovie(s.getMovie());
				superHero.setGender(s.getGender());
				superHero.setName(s.getName());
				superHero.setUsername(s.getUsername());
				superHero.setPinCode(s.getPinCode());
				superHero.setMobileNo(s.getMobileNo());

				superHeroRepo.save(superHero);
				return new SuperHero("Details of SuperHero has been updated successfully.", "Success");
			} else {
				return new SuperHero("SuperHero not found");
			}
		} else {
			return new SuperHero("ID is not available in database.");
		}
	}

	@Override
	public SuperHero deleteSuperHeroDetails(Long id) {
		// TODO Auto-generated method stub
		if (superHeroRepo.findById(id).isPresent()) {
			superHeroRepo.deleteById(id);
			return new SuperHero("Details of SuperHero has been deleted successfully.", "Success");
		} else {
			return new SuperHero("ID is not available in database.");
		}
	}
}
