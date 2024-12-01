package com.tayssir.cosmetique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.tayssir.cosmetique.entities.Cosmetique;
import com.tayssir.cosmetique.entities.Classification;
import com.tayssir.cosmetique.entities.User;
import com.tayssir.cosmetique.repos.CosmetiqueRepository;
import com.tayssir.cosmetique.repos.ClassificationRepository;
import com.tayssir.cosmetique.repos.UserRepository;

@SpringBootApplication
public class CosmetiquesApplication implements CommandLineRunner {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    @Autowired
    private CosmetiqueRepository cosmetiqueRepository;  // Inject repository for Cosmetique
    @Autowired
    private ClassificationRepository classificationRepository;  // Inject repository for Classification
    @Autowired
    private UserRepository userRepository;  // Inject repository for User

    public static void main(String[] args) {
        SpringApplication.run(CosmetiquesApplication.class, args);
    }

    /**
     *
     */
    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Cosmetique.class);

        // Add sample classifications
        Classification classification1 = new Classification("Skincare", "Products for skin care");
        Classification classification2 = new Classification("Makeup", "Products for makeup");
        classificationRepository.save(classification1);
        classificationRepository.save(classification2);

      
		/*
		 * User user1 = new User("user@gmail.com", "123"); userRepository.save(user1);
		 */
        
       
         

        // Add sample cosmetic products
        Cosmetique cosmetique1 = new Cosmetique("Moisturizer", 15.99, new java.util.Date());
        cosmetique1.setClassification(classification1);
        Cosmetique cosmetique2 = new Cosmetique("Foundation", 25.50, new java.util.Date());
        cosmetique2.setClassification(classification2);

        cosmetiqueRepository.save(cosmetique1);
        cosmetiqueRepository.save(cosmetique2);

        System.out.println("Sample data has been added!");
    }

}
