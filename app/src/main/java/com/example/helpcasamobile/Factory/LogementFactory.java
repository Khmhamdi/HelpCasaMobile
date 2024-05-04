package com.example.helpcasamobile.Factory;

import static com.example.helpcasamobile.Factory.ClientFactory.COLUMN_ID_CLIENT;

public class LogementFactory {
    public static final String TABLE_NAME = "logement";
    public static final String TABLE_CLIENT = "client";
    public static final String TABLE_USER = "user";
    public static final String COLUMN_ID = "idLogement";
    public static final String COLUMN_TYPE_LOGEMENT = "typeLogement";
    public static final String COLUMN_TYPE_ANNONCE = "typeAnnonce";
    public static final String COLUMN_GOUVERNORAT = "gouvernorat";
    public static final String COLUMN_VILLE = "ville";
    public static final String COLUMN_ADRESSE = "adresse";
    public static final String COLUMN_SUPERFICIE = "superficie";
    public static final String COLUMN_NBR_CHAMBRE = "nbrChambre";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_PRIX = "prix";
    public static final String COLUMN_DATE_ANNONCE = "dtAnnonce";
    public static final String COLUMN_DATE_VALIDITE = "validite";
    public static final String COLUMN_ID_PROP = "idProp";
    public static final String COLUMN_ID_ACHET = "idAchet";
    public static final String COLUMN_MEUBLE = "meuble";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_ETAT = "etat";
    public static final String COLUMN_DT_RESERV = "dtReservation";
    public static final String COLUMN_DT_VALIDATION = "dtValidation";
    public static final String COLUMN_ID_USER = "idUser";
    public static final String COLUMN_COMM_PROPRIETAIRE = "commProp";
    public static final String COLUMN_COMM_ACHETEUR = "commAchet";
    public static final String reqLogement = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_TYPE_LOGEMENT + " TEXT, " +
            COLUMN_TYPE_ANNONCE + " TEXT, " +
            COLUMN_GOUVERNORAT + " TEXT UNIQUE, " +
            COLUMN_VILLE + " TEXT, " +
            COLUMN_ADRESSE + " TEXT, " +
            COLUMN_SUPERFICIE + " INTEGER, " +
            COLUMN_NBR_CHAMBRE + " TEXT, " +
            COLUMN_DESCRIPTION + " TEXT, " +
            COLUMN_PRIX + " REAL, " +
            COLUMN_DATE_ANNONCE + " DATE, " +
            COLUMN_DATE_VALIDITE + " INTEGER, " +
            COLUMN_ID_PROP + " INTEGER, " +
            COLUMN_ID_ACHET + " INTEGER, " +
            COLUMN_MEUBLE + " TEXT, " +
            COLUMN_IMAGE + " TEXT, " +
            COLUMN_ETAT + " TEXT, " +
            COLUMN_DT_RESERV + " DATE, " +
            COLUMN_DT_VALIDATION + " DATE, " +
            COLUMN_ID_USER + " INTEGER, " +
            COLUMN_COMM_PROPRIETAIRE + " REAL, " +
            COLUMN_COMM_ACHETEUR + " REAL, " +
            "FOREIGN KEY (" + COLUMN_ID_PROP + ") REFERENCES " + TABLE_CLIENT + "(" + COLUMN_ID_CLIENT + ")" +
            "FOREIGN KEY (" + COLUMN_ID_ACHET + ") REFERENCES " + TABLE_CLIENT + "(" + COLUMN_ID_CLIENT + ")" +
            "FOREIGN KEY (" + COLUMN_ID_USER + ") REFERENCES " + TABLE_USER + "(" + COLUMN_ID + "));";

}
