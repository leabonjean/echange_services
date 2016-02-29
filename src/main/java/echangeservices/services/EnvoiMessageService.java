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

/**
 *
 * @author admin
 */
public class EnvoiMessageService {

    @PersistenceContext
    EntityManager em;

    private MessageService ms;
    private UtilisateurService us;

    public void envoieMessage(long emeteurID, long recepteurID, String message, String titre, Timestamp date) {
        Message m = new Message();
        m.setEmetteur(us.findOne(emeteurID));
        m.setDestinataire(us.findOne(recepteurID));
        m.setContenu(message);
        m.setTitre(titre);
        m.setDateCreation(date);
        m.setLu(false);
        

    }
    
    public void lectureMessage(Message m){
        m.setLu(true);
    }
}
