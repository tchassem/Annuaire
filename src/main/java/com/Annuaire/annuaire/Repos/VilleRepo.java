package com.Annuaire.annuaire.Repos;

import com.Annuaire.annuaire.Models.Ville;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRepo extends JpaRepository<Ville, Long> {

}
