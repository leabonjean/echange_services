/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.entity;

import echangeservices.enumeration.TypeAnnonce;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Annonce implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titre;
    private String contenu;
    private int prix;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    private TypeAnnonce typeAnnonce;
    
    @ManyToOne
    @JoinColumn(name = "UTIL_ID")
    private Utilisateur createurAnnonce;
    
    @ManyToOne
    @JoinColumn(name = "CATEGORIE_ID")
    private Categorie categorieAnnonce;
    
    @OneToMany(mappedBy = "commentaireAnnonce")
    private List<Commentaire> commentairesAnnonce = new ArrayList<Commentaire>();

    public Annonce() {
    }

    public Utilisateur getCreateurAnnonce() {
        return createurAnnonce;
    }

    public void setCreateurAnnonce(Utilisateur CreateurAnnonce) {
        this.createurAnnonce = CreateurAnnonce;
    }

    public Categorie getCategorieAnnonce() {
        return categorieAnnonce;
    }

    public void setCategorieAnnonce(Categorie CategorieAnnonce) {
        this.categorieAnnonce = CategorieAnnonce;
    }

    public List<Commentaire> getCommentairesAnnonce() {
        return commentairesAnnonce;
    }

    public void setCommentairesAnnonce(List<Commentaire> CommentairesAnnonce) {
        this.commentairesAnnonce = CommentairesAnnonce;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public TypeAnnonce getTypeAnnonce() {
        return typeAnnonce;
    }

    public void setTypeAnnonce(TypeAnnonce typeAnnonce) {
        this.typeAnnonce = typeAnnonce;
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
        if (!(object instanceof Annonce)) {
            return false;
        }
        Annonce other = (Annonce) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "echangeservices.entity.Annonce[ id=" + id + " ]";
    }
    
}
