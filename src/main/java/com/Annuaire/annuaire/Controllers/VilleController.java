package com.Annuaire.annuaire.Controllers;

import com.Annuaire.annuaire.Models.Quartier;
import com.Annuaire.annuaire.Models.Ville;
import com.Annuaire.annuaire.Services.VilleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/villes")
public class VilleController {

    private final VilleService villeService;

    @GetMapping
    public ResponseEntity<List<Ville>> getAllVille(){
        List<Ville> villes = villeService.AllVille();
        return ResponseEntity.ok(villes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ville> getVille(@PathVariable Long id){
        Ville villeFound = villeService.findVille(id);
        return new ResponseEntity<Ville>(villeFound,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Ville> createVille(@RequestBody Ville ville){
        Ville CreatedVille = villeService.newville(ville);
        return new ResponseEntity<>(CreatedVille, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Ville> updateVille(@PathVariable Long id ,@RequestBody Ville ville){
        Ville updatedVille = villeService.updateVille(id, ville);
        return new ResponseEntity<>(updatedVille, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVille(@PathVariable Long id){
        villeService.deleteville(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/quartier/{id}")
    public ResponseEntity<?> addQuartier(@PathVariable Long id, @RequestBody Quartier quartier){
        villeService.quartierToVille(id, quartier);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}




