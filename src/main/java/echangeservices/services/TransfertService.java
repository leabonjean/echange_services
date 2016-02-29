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

/**
 *
 * @author admin
 */
public class TransfertService {
    
    private UtilisateurService us;
    
    @PersistenceContext
    private EntityManager em;
  
    public void transfert(long crediteurID, long debiteurID, Integer montant, String message){
        Paiement p = new Paiement();
        
        p.setCrediteur(us.findOne(crediteurID));
        p.setDebiteur(us.findOne(debiteurID));
        p.setMontant(montant);
        p.setCommentaire(message);
        Integer solde1 = us.findOne(crediteurID).getSolde();
        Integer solde2 = us.findOne(debiteurID).getSolde();
        if(solde2 - 200 < montant){
            System.out.print("Solde insuffisant");
            return;
        }
        us.findOne(crediteurID).setSolde(solde1 + montant);
        us.findOne(debiteurID).setSolde(solde2 - montant);

    }
}
