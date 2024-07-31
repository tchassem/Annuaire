package com.Annuaire.annuaire.Controllers;

import com.Annuaire.annuaire.Models.Quartier;
import com.Annuaire.annuaire.Models.Ville;
import com.Annuaire.annuaire.Services.QuartierService;
import com.Annuaire.annuaire.Services.VilleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/quartiers")
public class QuartierController {
    private final QuartierService quartierService;

    @GetMapping
    public ResponseEntity<List<Quartier>> getAllQuartier(){
        List<Quartier> quartiers = quartierService.allQuartier();
        return ResponseEntity.ok(quartiers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quartier> getQuartier(@PathVariable Long id){
        Quartier quartierFound = quartierService.searchQuatier(id);
        return new ResponseEntity<Quartier>(quartierFound, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Quartier> createQuartier(@RequestBody Quartier quartier){
        Quartier CreatedQuartier = quartierService.newQuartier(quartier);
        return new ResponseEntity<>(CreatedQuartier, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Quartier> updateQuartier(@PathVariable Long id ,@RequestBody Quartier quartier){
        Quartier updatedQuartier = quartierService.updateQuartier(id, quartier);
        return new ResponseEntity<>(updatedQuartier, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuartier(@PathVariable Long id){
        quartierService.deleteQuartier(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
