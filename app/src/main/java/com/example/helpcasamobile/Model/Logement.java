package com.example.helpcasamobile.Model;

import java.util.Date;

public class Logement {
    private int idLogement;
    private String typeLogement, typeAnnonce, gouvernorat, ville, adresse;
    private int superficie;
    private int nbrChambre;
    private String description;
    private float prix;
    private String dtAnnonce;
    private int validite, idProp, idAchet;
    private String meuble, image, etat;
    String dtReserv, dtValidation;
    int idUser;
    float commProp, commAchet;

    public Logement() {
    }

    public Logement(int idLogement, String typeLogement, String typeAnnonce, String gouvernorat, String ville, String adresse, int superficie, int nbrChambre, String description, float prix, String dtAnnonce, int validite, int idProp, int idAchet, String meuble, String image, String etat, String dtReserv, String dtValidation, int idUser, float commProp, float commAchet) {
        this.idLogement = idLogement;
        this.typeLogement = typeLogement;
        this.typeAnnonce = typeAnnonce;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbrChambre = nbrChambre;
        this.description = description;
        this.prix = prix;
        this.dtAnnonce = dtAnnonce;
        this.validite = validite;
        this.idProp = idProp;
        this.idAchet = idAchet;
        this.meuble = meuble;
        this.image = image;
        this.etat = etat;
        this.dtReserv = dtReserv;
        this.dtValidation = dtValidation;
        this.idUser = idUser;
        this.commProp = commProp;
        this.commAchet = commAchet;
    }

    public Logement(String typeLogement, String typeAnnonce, String gouvernorat, String ville, String adresse, int superficie, int nbrChambre, String description, float prix, String dtAnnonce, int validite, int idProp, int idAchet, String meuble, String image, String etat, String dtReserv, String dtValidation, int idUser, float commProp, float commAchet) {
        this.typeLogement = typeLogement;
        this.typeAnnonce = typeAnnonce;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbrChambre = nbrChambre;
        this.description = description;
        this.prix = prix;
        this.dtAnnonce = dtAnnonce;
        this.validite = validite;
        this.idProp = idProp;
        this.idAchet = idAchet;
        this.meuble = meuble;
        this.image = image;
        this.etat = etat;
        this.dtReserv = dtReserv;
        this.dtValidation = dtValidation;
        this.idUser = idUser;
        this.commProp = commProp;
        this.commAchet = commAchet;
    }

    public Logement(String typeLogement, String typeAnnonce, String gouvernorat, String ville, String adresse, int superficie, int nbrChambre, String description, float prix, String dtAnnonce, int validite, int idProp, int idAchet, String meuble, String image, String etat, int idUser) {
        this.typeLogement = typeLogement;
        this.typeAnnonce = typeAnnonce;
        this.gouvernorat = gouvernorat;
        this.ville = ville;
        this.adresse = adresse;
        this.superficie = superficie;
        this.nbrChambre = nbrChambre;
        this.description = description;
        this.prix = prix;
        this.dtAnnonce = dtAnnonce;
        this.validite = validite;
        this.idProp = idProp;
        this.idAchet = idAchet;
        this.meuble = meuble;
        this.image = image;
        this.etat = etat;
        this.idUser = idUser;
    }

    public int getIdLogement() {
        return idLogement;
    }

    public void setIdLogement(int idLogement) {
        this.idLogement = idLogement;
    }

    public String getTypeLogement() {
        return typeLogement;
    }

    public void setTypeLogement(String typeLogement) {
        this.typeLogement = typeLogement;
    }

    public String getTypeAnnonce() {
        return typeAnnonce;
    }

    public void setTypeAnnonce(String typeAnnonce) {
        this.typeAnnonce = typeAnnonce;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public int getNbrChambre() {
        return nbrChambre;
    }

    public void setNbrChambre(int nbrChambre) {
        this.nbrChambre = nbrChambre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDtAnnonce() {
        return dtAnnonce;
    }

    public void setDtAnnonce(String dtAnnonce) {
        this.dtAnnonce = dtAnnonce;
    }

    public int getValidite() {
        return validite;
    }

    public void setValidite(int validite) {
        this.validite = validite;
    }

    public int getIdProp() {
        return idProp;
    }

    public void setIdProp(int idProp) {
        this.idProp = idProp;
    }

    public int getIdAchet() {
        return idAchet;
    }

    public void setIdAchet(int idAchet) {
        this.idAchet = idAchet;
    }

    public String getMeuble() {
        return meuble;
    }

    public void setMeuble(String meuble) {
        this.meuble = meuble;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDtReserv() {
        return dtReserv;
    }

    public void setDtReserv(String dtReserv) {
        this.dtReserv = dtReserv;
    }

    public String getDtValidation() {
        return dtValidation;
    }

    public void setDtValidation(String dtValidation) {
        this.dtValidation = dtValidation;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public float getCommProp() {
        return commProp;
    }

    public void setCommProp(float commProp) {
        this.commProp = commProp;
    }

    public float getCommAchet() {
        return commAchet;
    }

    public void setCommAchet(float commAchet) {
        this.commAchet = commAchet;
    }

    @Override
    public String toString() {
        return "Logement{" +
                "idLogement=" + idLogement +
                ", typeLogement='" + typeLogement + '\'' +
                ", typeAnnonce='" + typeAnnonce + '\'' +
                ", gouvernorat='" + gouvernorat + '\'' +
                ", ville='" + ville + '\'' +
                ", adresse='" + adresse + '\'' +
                ", superficie=" + superficie +
                ", nbrChambre=" + nbrChambre +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", dtAnnonce='" + dtAnnonce + '\'' +
                ", validite=" + validite +
                ", idProp=" + idProp +
                ", idAchet=" + idAchet +
                ", meuble='" + meuble + '\'' +
                ", image='" + image + '\'' +
                ", etat='" + etat + '\'' +
                ", dtReserv='" + dtReserv + '\'' +
                ", dtValidation='" + dtValidation + '\'' +
                ", idUser=" + idUser +
                ", commProp=" + commProp +
                ", commAchet=" + commAchet +
                '}';
    }
}
