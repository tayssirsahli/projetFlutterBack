package com.tayssir.cosmetique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayssir.cosmetique.entities.Cosmetique;
import com.tayssir.cosmetique.entities.Classification;
import com.tayssir.cosmetique.repos.CosmetiqueRepository;

@Service
public class CosmetiqueServiceImp implements CosmetiqueService {

    @Autowired
    CosmetiqueRepository cosmetiqueRepository;

    @Override
    public Cosmetique saveCosmetique(Cosmetique cosmetique) {
        return cosmetiqueRepository.save(cosmetique);
    }

    @Override
    public Cosmetique updateCosmetique(Cosmetique cosmetique) {
        return cosmetiqueRepository.save(cosmetique);
    }

    @Override
    public void deleteCosmetique(Cosmetique cosmetique) {
        cosmetiqueRepository.delete(cosmetique);
    }

    @Override
    public void deleteCosmetiqueById(Long id) {
        cosmetiqueRepository.deleteById(id);
    }

    @Override
    public Cosmetique getCosmetique(Long id) {
        return cosmetiqueRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cosmetique> getAllCosmetique() {
        return cosmetiqueRepository.findAll();
    }

    @Override
    public List<Cosmetique> findByNomCosmetique(String nomCosmetique) {
        return cosmetiqueRepository.findByNomCosmetiqueContains(nomCosmetique);
    }

    @Override
    public List<Cosmetique> findByNomCosmetiqueContains(String nomCosmetique) {
        return cosmetiqueRepository.findByNomCosmetiqueContains(nomCosmetique);
    }

    @Override
    public List<Cosmetique> findByClassification(Classification classification) {
        return cosmetiqueRepository.findByClassification(classification);
    }

    @Override
    public List<Cosmetique> findByClassification_IdClas(long idClas) {
        return cosmetiqueRepository.findByClassification_IdClas(idClas);
    }

    @Override
    public List<Cosmetique> findByOrderByNomCosmetiqueAsc() {
        return cosmetiqueRepository.findByOrderByNomCosmetiqueAsc();
    }

    @Override
    public List<Cosmetique> trierCosmetiquesNomsPrix() {
        return cosmetiqueRepository.trierCosmetiquesNomsPrix();
    }
}
