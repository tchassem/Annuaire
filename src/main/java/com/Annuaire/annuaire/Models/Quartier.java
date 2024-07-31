package com.Annuaire.annuaire.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quartier {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String QuatierName;
    @ManyToOne
    @JsonIgnoreProperties("ville")
    @JoinColumn(name ="ville_id")
    private Ville ville;


}
