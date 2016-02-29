/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.test;

import echangeservices.entity.Utilisateur;
import echangeservices.enumeration.TypeUtilisateur;
import echangeservices.services.DataBaseService;
import echangeservices.services.EnvoiMessageService;
import echangeservices.services.MessageService;
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
    
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DataBaseService db;

    @Before
    public void delete() {
        db.deleteAll();

        Utilisateur u = new Utilisateur();
        u.setEmail("fffff");
        u.setId(1L);
        u.setMdp("fffffg");
        u.setTypeUtil(TypeUtilisateur.NORMAL);
        u.setSolde(500);
        us.save(u);

        Utilisateur u1 = new Utilisateur();
        u1.setEmail("btfht");
        u1.setId(2L);
        u1.setMdp("gergre");
        u1.setTypeUtil(TypeUtilisateur.NORMAL);
        u1.setSolde(0);
        us.save(u1);

        ems.envoieMessage(1L, 2L, "ffezfezfe", "fezfze", new Date());
        
    }

    @Test
    public void doNadaOK() {

        ts.transfert(1L, 2L, 300, "coucou");
        
    }
    
//    @Test
    public void envoieMessage1(){
        
        ems.lectureMessage(1L);
    }

    
}
