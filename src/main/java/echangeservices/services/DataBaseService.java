/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.services;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
public class DataBaseService {
    
    @Autowired
    private AnnonceService as;
    @Autowired
    private CategorieService cs;
    @Autowired
    private CommentaireService coms;
    @Autowired
    private LieuService ls;
    @Autowired
    private MessageService ms;
    @Autowired
    private PaiementService ps;
    @Autowired
    private UtilisateurService us;
    
    public void deleteAll(){
            ls.deleteAll();
            cs.deleteAll();
            coms.deleteAll();
            as.deleteAll();
            ps.deleteAll();
            ms.deleteAll();
            us.deleteAll();
    
    }
    
}
