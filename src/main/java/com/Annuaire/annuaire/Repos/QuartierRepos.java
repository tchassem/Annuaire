package com.Annuaire.annuaire.Repos;

import com.Annuaire.annuaire.Models.Quartier;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartierRepos extends JpaRepository<Quartier, Long> {
}
