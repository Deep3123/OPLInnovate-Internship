package com.main.superhero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.main.superhero.domain.SuperHero;

public interface SuperHeroRepo extends JpaRepository<SuperHero, Long> {

}
