package com.Annuaire.annuaire.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String villeName;
    @JsonIgnoreProperties("ville")
    @OneToMany(mappedBy = "ville")
    private List<Quartier> quartiers = new ArrayList<>();

    public void AddQuartier(Quartier quartier){
        quartiers.add(quartier);
        quartier.setVille(this);
    }

    public void removeQuartier(Quartier quartier){
        quartiers.remove(quartier);
        quartier.setVille(null);
    }
}
