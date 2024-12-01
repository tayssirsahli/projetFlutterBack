package com.tayssir.cosmetique.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tayssir.cosmetique.entities.Cosmetique;
import com.tayssir.cosmetique.entities.Classification;

@RepositoryRestResource(path = "rest")
public interface CosmetiqueRepository extends JpaRepository<Cosmetique, Long> {

    List<Cosmetique> findByNomCosmetique(String nomCosmetique);

    List<Cosmetique> findByNomCosmetiqueContains(String nomCosmetique);

    @Query("select c from Cosmetique c where c.classification = ?1")
    List<Cosmetique> findByClassification(Classification classification);

    List<Cosmetique> findByClassification_IdClas(long idClas);

    List<Cosmetique> findByOrderByNomCosmetiqueAsc();

    @Query("select c from Cosmetique c order by c.nomCosmetique ASC, c.prixCosmetique DESC")
    List<Cosmetique> trierCosmetiquesNomsPrix();
}
