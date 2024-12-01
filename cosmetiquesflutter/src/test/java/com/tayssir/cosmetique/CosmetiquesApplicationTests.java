package com.tayssir.cosmetique;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tayssir.cosmetique.entities.Cosmetique;
import com.tayssir.cosmetique.entities.Classification;
import com.tayssir.cosmetique.repos.CosmetiqueRepository;

@SpringBootTest
class CosmetiquesApplicationTests {

    @Autowired
    private CosmetiqueRepository cosmetiqueRepository;

    @Test
    public void testCreateCosmetique() {
        Cosmetique cosmetique = new Cosmetique("SVR sebiaclear gel moussant 200 ml", 30.5, new Date());
        cosmetiqueRepository.save(cosmetique);
    }

    @Test
    public void testFindCosmetique() {
        Cosmetique cosmetique = cosmetiqueRepository.findById(1L).orElse(null);
        System.out.println(cosmetique);
    }

    @Test
    public void testUpdateCosmetique() {
        Cosmetique cosmetique = cosmetiqueRepository.findById(1L).orElse(null);
        if (cosmetique != null) {
            cosmetique.setPrixCosmetique(2000.0);
            cosmetiqueRepository.save(cosmetique);
            System.out.println(cosmetique);
        }
    }

    @Test
    public void testDeleteCosmetique() {
        cosmetiqueRepository.deleteById(1L);
    }

    @Test
    public void testListerTousCosmetique() {
        List<Cosmetique> cosmetiques = cosmetiqueRepository.findAll();
        for (Cosmetique cosmetique : cosmetiques) {
            System.out.println(cosmetique);
        }
    }

    @Test
    public void testFindCosmetiqueByNom() {
        List<Cosmetique> cosmetiques = cosmetiqueRepository.findByNomCosmetique("UN SECURE Blur SPF50");
        for (Cosmetique cosmetique : cosmetiques) {
            System.out.println(cosmetique);
        }
    }

    @Test
    public void testFindCosmetiqueByNomContains() {
        List<Cosmetique> cosmetiques = cosmetiqueRepository.findByNomCosmetiqueContains("SVR");
        for (Cosmetique cosmetique : cosmetiques) {
            System.out.println(cosmetique);
        }
    }

    @Test
    public void testFindByClassification() {
        Classification classification = new Classification();
        classification.setIdClas(10L);
        List<Cosmetique> cosmetiques = cosmetiqueRepository.findByClassification(classification);
        for (Cosmetique cosmetique : cosmetiques) {
            System.out.println(cosmetique);
        }
    }

    @Test
    public void testFindByClassificationIdClas() {
        List<Cosmetique> cosmetiques = cosmetiqueRepository.findByClassification_IdClas(10L);
        for (Cosmetique cosmetique : cosmetiques) {
            System.out.println(cosmetique);
        }
    }

    @Test
    public void testFindByOrderByNomCosmetiqueAsc() {
        List<Cosmetique> cosmetiques = cosmetiqueRepository.findByOrderByNomCosmetiqueAsc();
        for (Cosmetique cosmetique : cosmetiques) {
            System.out.println(cosmetique);
        }
    }

    @Test
    public void testTrierCosmetiquesNomsPrix() {
        List<Cosmetique> cosmetiques = cosmetiqueRepository.trierCosmetiquesNomsPrix();
        for (Cosmetique cosmetique : cosmetiques) {
            System.out.println(cosmetique);
        }
    }
}
