/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.entity;

import echangeservices.enumeration.TypeUtilisateur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author admin
 */
@Entity
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;
    private String mdp;
    private int solde;
    private TypeUtilisateur typeUtil;

    @OneToMany(mappedBy = "createurCommentaire")
    private List<Commentaire> commentairesPostés = new ArrayList<Commentaire>();

    @OneToMany(mappedBy = "createurAnnonce")
    private List<Annonce> annoncesPostees = new ArrayList<Annonce>();

    @ManyToOne
    @JoinColumn(name = "LIEU_ID")
    private Lieu lieuUtilisateur;

    @OneToMany(mappedBy = "destinataire")
    private List<Message> messageReçu = new ArrayList<Message>();

    @OneToMany(mappedBy = "emetteur")
    private List<Message> messageEnvoyé = new ArrayList<Message>();

    @OneToMany(mappedBy = "crediteur")
    private List<Paiement> paiementReçu = new ArrayList<Paiement>();

    @OneToMany(mappedBy = "debiteur")
    private List<Paiement> paiementEnvoyé = new ArrayList<Paiement>();

    public Utilisateur() {
    }

    
    
    public List<Commentaire> getCommentairesPostés() {
        return commentairesPostés;
    }

    public void setCommentairesPostés(List<Commentaire> CommentairesPostés) {
        this.commentairesPostés = CommentairesPostés;
    }

    public List<Annonce> getAnnoncesPostées() {
        return annoncesPostees;
    }

    public void setAnnoncesPostées(List<Annonce> AnnoncesPostées) {
        this.annoncesPostees = AnnoncesPostées;
    }

    public Lieu getLieuUtilisateur() {
        return lieuUtilisateur;
    }

    public void setLieuUtilisateur(Lieu LieuUtilisateur) {
        this.lieuUtilisateur = LieuUtilisateur;
    }

    public List<Message> getMessageReçu() {
        return messageReçu;
    }

    public void setMessageReçu(List<Message> messageReçu) {
        this.messageReçu = messageReçu;
    }

    public List<Message> getMessageEnvoyé() {
        return messageEnvoyé;
    }

    public void setMessageEnvoyé(List<Message> messageEnvoyé) {
        this.messageEnvoyé = messageEnvoyé;
    }

    public List<Paiement> getPaiementReçu() {
        return paiementReçu;
    }

    public void setPaiementReçu(List<Paiement> paiementReçu) {
        this.paiementReçu = paiementReçu;
    }

    public List<Paiement> getPaiementEnvoyé() {
        return paiementEnvoyé;
    }

    public void setPaiementEnvoyé(List<Paiement> paiementEnvoyé) {
        this.paiementEnvoyé = paiementEnvoyé;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public TypeUtilisateur getTypeUtil() {
        return typeUtil;
    }

    public void setTypeUtil(TypeUtilisateur TypeUtil) {
        this.typeUtil = TypeUtil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "echangeservices.entity.Utilisateur[ id=" + id + " ]";
    }

}
