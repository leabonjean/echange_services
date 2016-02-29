/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.test;

import echangeservices.entity.Annonce;
import echangeservices.entity.Categorie;
import echangeservices.entity.Utilisateur;
import echangeservices.enumeration.TypeAnnonce;
import echangeservices.enumeration.TypeUtilisateur;
import echangeservices.exception.ExceptionSoldeInsuffisant;
import echangeservices.services.AnnonceService;
import echangeservices.services.CategorieService;
import echangeservices.services.CommentaireService;
import echangeservices.services.DataBaseService;
import echangeservices.services.EnvoiMessageService;
import echangeservices.services.LieuService;
import echangeservices.services.MessageService;
import echangeservices.services.PaiementService;
import echangeservices.services.TransfertService;
import echangeservices.services.UtilisateurService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import echangeservices.spring.SpringConfig;
import java.sql.Timestamp;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author ETY
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class SpringTest {

    @Autowired
    UtilisateurService us;

    @Autowired
    TransfertService ts;
    
    @Autowired
    EnvoiMessageService ems;
    
    @Autowired
    AnnonceService as;
    
    @Autowired
    CategorieService cs;
    
    @Autowired
    LieuService ls;
    
    @Autowired
    MessageService ms;
    
    @Autowired
    CommentaireService cos;
    
    @Autowired
    PaiementService ps;
    
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DataBaseService db;

    @Before
    public void delete() {
        db.deleteAll();

        Categorie c = new Categorie();
        c.setId(1L);
        c.setNom("Animaux");
        cs.save(c);
        
        Utilisateur u = new Utilisateur();
        u.setEmail("fffff");
        u.setId(1L);
        u.setMdp("fffffg");
        u.setTypeUtil(TypeUtilisateur.NORMAL);
        u.setSolde(500);
        

        Utilisateur u1 = new Utilisateur();
        u1.setEmail("btfht");
        u1.setId(2L);
        u1.setMdp("gergre");
        u1.setTypeUtil(TypeUtilisateur.NORMAL);
        u1.setSolde(0);
        
        
        Annonce a = new Annonce();
        a.setTypeAnnonce(TypeAnnonce.DEMANDE);
        a.setId(1L);
        a.setCreateurAnnonce(u1);
        u1.getAnnoncesPostées().add(a);
        a.setTitre("Chat");
        a.setContenu("Je vends la bete");
        a.setPrix(250);
        a.setCategorieAnnonce(c);
        c.getAnnoncesDeCategorie().add(a);
        as.save(a);
        
        
        Annonce a1 = new Annonce();
        a1.setTypeAnnonce(TypeAnnonce.DEMANDE);
        a1.setId(2L);
        a1.setCreateurAnnonce(u1);
        u1.getAnnoncesPostées().add(a1);
        a1.setTitre("Chien");
        a1.setContenu("Je vends la bete");
        a1.setPrix(250);
        a1.setCategorieAnnonce(c);
        c.getAnnoncesDeCategorie().add(a1);
        as.save(a1);
        
        Annonce a2 = new Annonce();
        a2.setTypeAnnonce(TypeAnnonce.DEMANDE);
        a2.setId(3L);
        a2.setCreateurAnnonce(u);
        u.getAnnoncesPostées().add(a2);
        a2.setTitre("Oiseau");
        a2.setContenu("Je vends la bete");
        a2.setPrix(250);
        a2.setCategorieAnnonce(c);
        c.getAnnoncesDeCategorie().add(a2);
        as.save(a2);
        
        cs.save(c);
        us.save(u);
        us.save(u1);
        
        
        

        ems.envoieMessage(1L, 2L, "ffezfezfe", "fezfze", new Date());
        
    }

    @Test
    public void doNadaOK() throws ExceptionSoldeInsuffisant {

        ts.transfert(1L, 2L, 100, "coucou");
        
    }
    
//    @Test
    public void testliste(){
        
        System.out.println(as.findBytypeAnnonceAndTitre(TypeAnnonce.DEMANDE, "Chat"));
                
    }

    
}

