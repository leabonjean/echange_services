/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.services;

import echangeservices.entity.Annonce;
import echangeservices.entity.Catégorie;
import echangeservices.enumeration.TypeAnnonce;
import echangeservices.enumeration.TypeUtilisateur;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author admin
 */
public interface AnnonceService extends CrudRepository<Annonce, Long>{
    
        public List<Annonce> findByCatégorieId(Catégorie categorie);
        public List<Annonce> findByTitre(String s);
        public List<Annonce> findByTitreAndContenu(String s ,String p);
        public List<Annonce> findBytypeAnnonce(TypeAnnonce Type);
        public List<Annonce> findByUtilisateurId(long id);
        public List<Annonce> findBydateCreationOrderByAsc(Timestamp date);
        public List<Annonce> findBytypeAnnonceAndCatégorieId(TypeAnnonce type,Catégorie cat);
        public List<Annonce> findBytypeAnnonceAndTitre(TypeAnnonce type , String s);
        
}
