package com.example.helpcasamobile.Model;

public class Client {
    private int idClient;
    private String email;
    private String password;
    private String civilite;
    private String nom;
    private String prenom;
    private String RaisonSociale;
    private String adresse;
    private String ville;
    private String cp, telMobile, telFix;

    public Client() {
    }

    public Client(String email, String password, String civilite, String nom, String prenom, String raisonSociale, String adresse, String ville, String cp, String telMobile, String telFix) {
        this.email = email;
        this.password = password;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.RaisonSociale = raisonSociale;
        this.adresse = adresse;
        this.ville = ville;
        this.cp = cp;
        this.telMobile = telMobile;
        this.telFix = telFix;
    }

    public Client(int idClient, String email, String password, String civilite, String nom, String prenom, String raisonSociale, String adresse, String ville, String cp, String telMobile, String telFix) {
        this.idClient = idClient;
        this.email = email;
        this.password = password;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.RaisonSociale = raisonSociale;
        this.adresse = adresse;
        this.ville = ville;
        this.cp = cp;
        this.telMobile = telMobile;
        this.telFix = telFix;
    }

    public Client(String civilite, String nom, String prenom, String raisonSociale, String adresse, String ville, String cp, String telMobile, String telFix) {
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        RaisonSociale = raisonSociale;
        this.adresse = adresse;
        this.ville = ville;
        this.cp = cp;
        this.telMobile = telMobile;
        this.telFix = telFix;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRaisonSociale() {
        return RaisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.RaisonSociale = raisonSociale;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    public String getTelFix() {
        return telFix;
    }

    public void setTelFix(String telFix) {
        this.telFix = telFix;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", civilite='" + civilite + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", RaisonSociale='" + RaisonSociale + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", cp=" + cp +
                ", telMobile=" + telMobile +
                ", telFix=" + telFix +
                '}';
    }
}
