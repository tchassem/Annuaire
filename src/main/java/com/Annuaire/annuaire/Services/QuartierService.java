package com.Annuaire.annuaire.Services;

import com.Annuaire.annuaire.Exceptions.NotFoundException;
import com.Annuaire.annuaire.Models.Quartier;
import com.Annuaire.annuaire.Repos.QuartierRepos;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuartierService {

    private final QuartierRepos quartierRepos;

    public Quartier newQuartier(Quartier quartier){
        return quartierRepos.save(quartier);
    }

    public Quartier updateQuartier(Long id, Quartier quartier){
       Quartier quartierToUpdate = quartierRepos.findById(id).orElseThrow(()-> new NotFoundException("ce quartier n'existe pas "));
       quartierToUpdate.setQuatierName(quartier.getQuatierName());
       quartierToUpdate.setVille(quartier.getVille());
       return quartierRepos.save(quartierToUpdate);
    }

    public Quartier searchQuatier(Long id_quartier){
        return quartierRepos.findById(id_quartier).orElseThrow(()->new NotFoundException("ce quartier n'existe pas!"));
    }

    public List<Quartier> allQuartier(){
        return quartierRepos.findAll();
    }

    public void deleteQuartier(Long id_quartier){
        quartierRepos.deleteById(id_quartier);
    }
}
