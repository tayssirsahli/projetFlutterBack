package com.tayssir.cosmetique.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cosmetique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCosmetique;
    private String nomCosmetique;
    private Double prixCosmetique;
    private Date dateCreation;
   
    @ManyToOne
    @JoinColumn(name = "classification_id_clas")
    private Classification classification;

    public Cosmetique() {
        super();
    }

    public Cosmetique(String nomCosmetique, Double prixCosmetique, Date dateCreation) {
        super();
        this.nomCosmetique = nomCosmetique;
        this.prixCosmetique = prixCosmetique;
        this.dateCreation = dateCreation;
    }

    public Long getIdCosmetique() {
        return idCosmetique;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public void setIdCosmetique(Long idCosmetique) {
        this.idCosmetique = idCosmetique;
    }

    public String getNomCosmetique() {
        return nomCosmetique;
    }

    public void setNomCosmetique(String nomCosmetique) {
        this.nomCosmetique = nomCosmetique;
    }

    public Double getPrixCosmetique() {
        return prixCosmetique;
    }

    public void setPrixCosmetique(Double prixCosmetique) {
        this.prixCosmetique = prixCosmetique;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Cosmetique [idCosmetique=" + idCosmetique + ", nomCosmetique=" + nomCosmetique + ", prixCosmetique=" + prixCosmetique
                + ", dateCreation=" + dateCreation + "]";
    }
}
