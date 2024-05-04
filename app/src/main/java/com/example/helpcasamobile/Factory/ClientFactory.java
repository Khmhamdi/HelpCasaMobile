package com.example.helpcasamobile.Factory;

public class ClientFactory {
    public static final String TABLE_NAME = "client";
    public static final String COLUMN_ID_CLIENT = "idClient";
    public static final String COLUMN_NOM = "nom";
    public static final String COLUMN_PRENOM = "prenom";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_CIVILITE = "civilite";
    public static final String COLUMN_RAISON_SOCIALE = "raison_sociale";
    public static final String COLUMN_ADRESSE = "adresse";
    public static final String COLUMN_VILLE = "ville";
    public static final String COLUMN_CODE_POSTAL = "cp";
    public static final String COLUMN_TEL_MOBILE = "telMobile";
    public static final String COLUMN_TEL_FIX = "telFix";
    public static final String reqClient = "create table " + TABLE_NAME + "(" +
            COLUMN_ID_CLIENT + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_EMAIL + " TEXT UNIQUE, " +
            COLUMN_PASSWORD + " TEXT, " +
            COLUMN_CIVILITE + " TEXT, " +
            COLUMN_NOM + " TEXT, " +
            COLUMN_PRENOM + " TEXT, " +
            COLUMN_RAISON_SOCIALE + " TEXT, " +
            COLUMN_ADRESSE + " TEXT, " +
            COLUMN_VILLE + " TEXT, " +
            COLUMN_CODE_POSTAL + " TEXT, " +
            COLUMN_TEL_MOBILE + " TEXT, " +
            COLUMN_TEL_FIX + " TEXT);";

}
