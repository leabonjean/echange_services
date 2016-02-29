/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.services;

import echangeservices.entity.Paiement;
import echangeservices.entity.Utilisateur;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */  
@Service
public class TransfertService {

    @Autowired
    private UtilisateurService us;
    @Autowired
    private PaiementService ps;

    @PersistenceContext
    private EntityManager em;

    public void transfert(long crediteurID, long debiteurID, Integer montant, String message) {
        Paiement p = new Paiement();
        Utilisateur u1 = us.findOne(crediteurID);
        Utilisateur u2 = us.findOne(debiteurID);
        
        p.setCrediteur(us.findOne(crediteurID));
        p.setDebiteur(us.findOne(debiteurID));
        p.setMontant(montant);
        p.setCommentaire(message);
        Integer solde1 = us.findOne(crediteurID).getSolde();
        Integer solde2 = us.findOne(debiteurID).getSolde();
//        if (solde2 - 200 < montant) {
//            System.out.print("Solde insuffisant");
//            return;
//        }
        u1.setSolde(solde1+montant);
        u2.setSolde(solde2 - montant);

        us.save(u1);
        us.save(u2);
        ps.save(p);

    }
}
