/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.services;

import echangeservices.entity.Message;
import echangeservices.entity.Utilisateur;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class EnvoiMessageService {

    @PersistenceContext
    EntityManager em;

    @Autowired
    private MessageService ms;
    @Autowired
    private UtilisateurService us;

    public void envoieMessage(long emeteurID, long recepteurID, String message, String titre, Date date) {
        Message m = new Message();
        Utilisateur u1 = us.findOne(emeteurID);
        Utilisateur u2 = us.findOne(recepteurID);
        m.setEmetteur(u1);
        m.setDestinataire(u2);
        m.setContenu(message);
        m.setTitre(titre);
        m.setDateCreation(date);
        m.setLu(false);
        u1.getMessageEnvoyé().add(m);
        u2.getMessageReçu().add(m);
        us.save(u1);
        us.save(u2);
        ms.save(m);

    }

    public void lectureMessage(long messageID) {
        Message m = ms.findOne(messageID);
        m.setLu(true);
        ms.save(m);

    }
}
