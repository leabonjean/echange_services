/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.services;

import echangeservices.entity.Message;
import java.sql.Timestamp;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
//@Service
public class EnvoiMessageService {

//    @PersistenceContext
//    EntityManager em;
//
//    @Autowired
//    private MessageService ms;
//    @Autowired
//    private UtilisateurService us;
//
//    public void envoieMessage(long emeteurID, long recepteurID, String message, String titre, Timestamp date) {
//        Message m = new Message();
//        m.setEmetteur(us.findOne(emeteurID));
//        m.setDestinataire(us.findOne(recepteurID));
//        m.setContenu(message);
//        m.setTitre(titre);
//        m.setDateCreation(date);
//        m.setLu(false);
//        ms.save(m);
//        
//
//    }
//    
//    public void lectureMessage(Message m){
//        m.setLu(true);
//        ms.save(m);
//    }
}
