package com.example.helpcasamobile.Factory;

public class UserFactory {
    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "idUser";
    public static final String COLUMN_MATRICULE = "matricule";
    public static final String COLUMN_NOM = "nom";
    public static final String COLUMN_PRENOM = "prenom";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_TYPE_COMPTE = "type_compte";
    public static final String reqUsers = "CREATE TABLE " + TABLE_NAME + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_MATRICULE + " INTEGER, " +
            COLUMN_NOM + " TEXT, " +
            COLUMN_PRENOM + " TEXT, " +
            COLUMN_EMAIL + " TEXT, " +
            COLUMN_PASSWORD + " TEXT, " +
            COLUMN_TYPE_COMPTE + " TEXT);";

}
