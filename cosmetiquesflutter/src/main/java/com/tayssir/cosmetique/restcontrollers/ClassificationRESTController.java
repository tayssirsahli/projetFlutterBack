package com.tayssir.cosmetique.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tayssir.cosmetique.entities.Classification;
import com.tayssir.cosmetique.entities.Cosmetique;
import com.tayssir.cosmetique.repos.ClassificationRepository;
import com.tayssir.cosmetique.service.ClassificationService;

@RestController
@RequestMapping("/api/clas")
@CrossOrigin(origins = "*")
public class ClassificationRESTController {

	
	@Autowired
	ClassificationRepository classificationRepository;
	
	@Autowired
	ClassificationService classificationService;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Classification> getAllCategories()
	{
		return classificationRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Classification getClassificationById(@PathVariable("id") Long id) {
		
		return classificationRepository.findById(id).get();
	}
	
	 @RequestMapping(path = "/add", method = RequestMethod.POST)
	    public Classification createClassification(@RequestBody Classification classification) {
	        return classificationService.saveClassification(classification);
	    }
	 
	 @RequestMapping(path = "/update", method = RequestMethod.PUT)
	    public Classification updateClassification(@RequestBody Classification classification) {
	        // Vérifier si l'entité existe avant de la mettre à jour
	        if (classificationRepository.existsById(classification.getIdClas())) {
	            return classificationService.saveClassification(classification);  // Utilisez le service pour gérer la logique de sauvegarde
	        } else {
	            throw new RuntimeException("Classification not found for ID: " + classification.getIdClas());
	        }
	    }
	 
	 @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	    public void deleteClassification(@PathVariable("id") Long id) {
	        // Check if the classification exists
	        if (classificationRepository.existsById(id)) {
	            classificationRepository.deleteById(id);
	        } else {
	            throw new RuntimeException("Classification not found for ID: " + id);
	        }
	    }
}
