package com.Annuaire.annuaire.Services;

import com.Annuaire.annuaire.Exceptions.NotFoundException;
import com.Annuaire.annuaire.Models.Quartier;
import com.Annuaire.annuaire.Models.Ville;
import com.Annuaire.annuaire.Repos.QuartierRepos;
import com.Annuaire.annuaire.Repos.VilleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VilleService {

    private final VilleRepo villeRepo;
    private final QuartierRepos quartierRepos;
    public Ville newville(Ville ville){
        return villeRepo.save(ville);
    }
    public Ville updateVille(Long id,Ville ville){

        Ville villeToUpdate = villeRepo.findById(id).orElseThrow(()->new NotFoundException("la ville n'exsite pas"));
        villeToUpdate.setVilleName(ville.getVilleName());
        villeToUpdate.setQuartiers(ville.getQuartiers());
        return villeRepo.save(villeToUpdate);

    }

    public Ville findVille(Long id_ville){
        return villeRepo.findById(id_ville).orElseThrow(()-> new NotFoundException("this ville has not found !"));
    }

    public List<Ville> AllVille(){
        return villeRepo.findAll();
    }

    public void deleteville(Long id){
        villeRepo.deleteById(id);
    }

    public Ville quartierToVille(Long id_ville, Quartier quartier){
      Ville villeToUpdate = villeRepo.findById(id_ville).get();
      villeToUpdate.AddQuartier(quartier);
      quartierRepos.save(quartier);
      return villeRepo.save(villeToUpdate);

    }

}
