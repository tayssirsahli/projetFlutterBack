package com.tayssir.cosmetique.service;

import java.util.List;

import com.tayssir.cosmetique.entities.Cosmetique;
import com.tayssir.cosmetique.entities.Classification;

public interface CosmetiqueService {

    Cosmetique saveCosmetique(Cosmetique cosmetique);
    Cosmetique updateCosmetique(Cosmetique cosmetique);
    void deleteCosmetique(Cosmetique cosmetique);
    void deleteCosmetiqueById(Long id);
    Cosmetique getCosmetique(Long id);
    List<Cosmetique> getAllCosmetique();
    List<Cosmetique> findByNomCosmetique(String nomCosmetique);
    List<Cosmetique> findByNomCosmetiqueContains(String nomCosmetique);
    List<Cosmetique> findByClassification(Classification classification);
    List<Cosmetique> findByClassification_IdClas(long idClas);
    List<Cosmetique> findByOrderByNomCosmetiqueAsc();
    List<Cosmetique> trierCosmetiquesNomsPrix();
}
