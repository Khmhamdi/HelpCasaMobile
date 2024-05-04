package com.example.helpcasamobile.ManipData;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

import com.example.helpcasamobile.DBHandler.DataBaseHandler;
import com.example.helpcasamobile.Factory.UserFactory;
import com.example.helpcasamobile.Model.User;

import java.util.ArrayList;

public class UsersDataExchange {

    private SQLiteDatabase mDB;
    private final DataBaseHandler cnx;

    public UsersDataExchange(Context context) {
        cnx= new DataBaseHandler(context,
                DataBaseHandler.DATABASE_NAME, null, DataBaseHandler.DATABASE_VERSION);
    }
    public SQLiteDatabase openEcriture(){
        mDB = cnx.getWritableDatabase();
        return mDB;
    }

    public SQLiteDatabase openLecture(){
        mDB = cnx.getReadableDatabase();
        return mDB;
    }

    public void fermer(){
        mDB.close();
    }


    //Méthode pour la requete SELECT One
    public User searchUser(int id){
        Cursor c = this.openEcriture().query(UserFactory.TABLE_NAME,
                null,
                UserFactory.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (c.getCount() == 0) {
            return null;
        }else {
            User resUser = new User();

            resUser.setIdUser(c.getInt(0));
            resUser.setMatricule(c.getInt(1));
            resUser.setNom(c.getString(2));
            resUser.setPrenom(c.getString(3));
            resUser.setEmail(c.getString(4));
            resUser.setPassword(c.getString(5));
            resUser.setTypeCompte(c.getString(6));

            c.close();
            this.fermer();
            return resUser;
        }
    }

    //Méthode pour la requête SELECT ALL
    public ArrayList<User> getAllUsers() {
        Cursor c = this.openLecture().query(UserFactory.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);
        if (c.getCount() == 0){
            return null;
        }else{
            ArrayList<User> ListUsers= new ArrayList<User>(c.getCount());
            c.moveToFirst();
            do {
                User resUser = new User();
                resUser.setIdUser(c.getInt(0));
                resUser.setMatricule(c.getInt(1));
                resUser.setNom(c.getString(2));
                resUser.setPrenom(c.getString(3));
                resUser.setEmail(c.getString(4));
                resUser.setPassword(c.getString(5));
                resUser.setTypeCompte(c.getString(6));

                ListUsers.add(resUser);
            } while (c.moveToNext());
            c.close();
            this.fermer();
            return ListUsers;
        }
    }

    //Méthode pour la requete INSERT
    public long addUser(User usr){
        ContentValues valeurs = new ContentValues();

        valeurs.put(UserFactory.COLUMN_MATRICULE, usr.getMatricule());
        valeurs.put(UserFactory.COLUMN_NOM, usr.getNom());
        valeurs.put(UserFactory.COLUMN_PRENOM, usr.getPrenom());
        valeurs.put(UserFactory.COLUMN_EMAIL, usr.getEmail());
        valeurs.put(UserFactory.COLUMN_PASSWORD, usr.getPassword());
        valeurs.put(UserFactory.COLUMN_TYPE_COMPTE, usr.getTypeCompte());

        long res = this.openEcriture().insert(UserFactory.TABLE_NAME, null, valeurs);
        this.fermer();
        return res;
    }

    //Méthode pour la requete UPDATE
    public int updateUser(User usr){
        ContentValues valeurs = new ContentValues();

        valeurs.put(UserFactory.COLUMN_MATRICULE, usr.getMatricule());
        valeurs.put(UserFactory.COLUMN_NOM, usr.getNom());
        valeurs.put(UserFactory.COLUMN_PRENOM, usr.getPrenom());
        valeurs.put(UserFactory.COLUMN_EMAIL, usr.getEmail());
        valeurs.put(UserFactory.COLUMN_PASSWORD, usr.getPassword());
        valeurs.put(UserFactory.COLUMN_TYPE_COMPTE, usr.getTypeCompte());

        int LignesMAJ = this.openEcriture().update(UserFactory.TABLE_NAME, valeurs, UserFactory.COLUMN_ID + " = ?",
                new String[] { String.valueOf(usr.getIdUser())});
        this.fermer();
        return LignesMAJ;
    }

    //Méthode pour la requete DELETE
    public void deleteUser(User usr){
        this.openEcriture().delete(UserFactory.TABLE_NAME, UserFactory.COLUMN_ID + " = ?",
                new String[] { String.valueOf(usr.getIdUser()) });
        this.fermer();
    }

}
