/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.services;

import echangeservices.entity.Annonce;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface AnnonceService extends CrudRepository<Annonce, Long>{
    
}
