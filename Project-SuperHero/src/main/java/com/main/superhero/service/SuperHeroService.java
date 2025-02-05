package com.main.superhero.service;

import java.util.List;
import com.main.superhero.domain.SuperHero;

public interface SuperHeroService {
	public List<SuperHero> getAllSuperHerosDetails();

	public SuperHero getSuperHeroDetails(Long id);

	public SuperHero addSuperHeroDetails(SuperHero s);

	public SuperHero updateSuperHeroDetails(SuperHero s);

	public SuperHero deleteSuperHeroDetails(Long id);
}
