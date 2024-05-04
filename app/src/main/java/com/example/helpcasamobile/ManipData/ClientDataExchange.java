package com.example.helpcasamobile.ManipData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.helpcasamobile.Model.Client;
import com.example.helpcasamobile.DBHandler.DataBaseHandler;
import com.example.helpcasamobile.Factory.ClientFactory;

import java.util.ArrayList;

public class ClientDataExchange {

    private static SQLiteDatabase mDB;
    private static DataBaseHandler cnx;

    public ClientDataExchange(Context context) {
        cnx= new DataBaseHandler(context,
                DataBaseHandler.DATABASE_NAME, null, DataBaseHandler.DATABASE_VERSION);
    }
    public static SQLiteDatabase openEcriture(){
        mDB = cnx.getWritableDatabase();
        return mDB;
    }

    public static SQLiteDatabase openLecture(){
        mDB = cnx.getReadableDatabase();
        return mDB;
    }

    public static void fermer(){
        mDB.close();
    }


    //Méthode pour la requete SELECT One
    public static Client searchClient(int id){
        Cursor c = openLecture().query(ClientFactory.TABLE_NAME,
                null,
                ClientFactory.COLUMN_ID_CLIENT + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (c.moveToFirst()) {
            Client resClt = new Client();
            resClt.setIdClient(c.getInt(0));
            resClt.setEmail(c.getString(1));
            resClt.setPassword(c.getString(2));
            resClt.setCivilite(c.getString(3));
            resClt.setNom(c.getString(4));
            resClt.setPrenom(c.getString(5));
            resClt.setRaisonSociale(c.getString(6));
            resClt.setAdresse(c.getString(7));
            resClt.setVille(c.getString(8));
            resClt.setCp(c.getString(9));
            resClt.setTelMobile(c.getString(10));
            resClt.setTelFix(c.getString(11));

            c.close();
            fermer();
            return resClt;
        } else {
            c.close();
            fermer();
            return null;
        }
    }

    //Méthode pour la requete SELECT One par email

    public static Client searchClientEmail(String email) {
        Cursor c = openLecture().query(ClientFactory.TABLE_NAME,
                null,
                ClientFactory.COLUMN_EMAIL + " = ?",
                new String[]{email},
                null,
                null,
                null);
        if (c.moveToFirst()) {
            Client resClt = new Client();
            resClt.setIdClient(c.getInt(0));
            resClt.setEmail(c.getString(1));
            resClt.setPassword(c.getString(2));
            resClt.setCivilite(c.getString(3));
            resClt.setNom(c.getString(4));
            resClt.setPrenom(c.getString(5));
            resClt.setRaisonSociale(c.getString(6));
            resClt.setAdresse(c.getString(7));
            resClt.setVille(c.getString(8));
            resClt.setCp(c.getString(9));
            resClt.setTelMobile(c.getString(10));
            resClt.setTelFix(c.getString(11));

            c.close();
            fermer();
            return resClt;
        } else {
            c.close();
            fermer();
            return null;
        }
    }

    //Méthode pour la requête SELECT ALL
    public static ArrayList<Client> getAllClients() {
        Cursor c = openLecture().query(ClientFactory.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                ClientFactory.COLUMN_NOM);

        ArrayList<Client> listClients = new ArrayList<>();

        // Vérifiez si le curseur contient des données
        if (c.moveToFirst()) {
            do {
                Client resClt = new Client();
                resClt.setIdClient(c.getInt(0));
                resClt.setEmail(c.getString(1));
                resClt.setPassword(c.getString(2));
                resClt.setCivilite(c.getString(3));
                resClt.setNom(c.getString(4));
                resClt.setPrenom(c.getString(5));
                resClt.setRaisonSociale(c.getString(6));
                resClt.setAdresse(c.getString(7));
                resClt.setVille(c.getString(8));
                resClt.setCp(c.getString(9));
                resClt.setTelMobile(c.getString(10));
                resClt.setTelFix(c.getString(11));

                listClients.add(resClt);
            } while (c.moveToNext());
        }

        c.close();
        fermer();
        return listClients;
    }



    //Méthode pour la requete INSERT
    public static long addClient(Client clt){

        ContentValues valeurs = new ContentValues();

        valeurs.put(ClientFactory.COLUMN_EMAIL, clt.getEmail());
        valeurs.put(ClientFactory.COLUMN_PASSWORD, clt.getPassword());
        valeurs.put(ClientFactory.COLUMN_CIVILITE, clt.getCivilite());
        valeurs.put(ClientFactory.COLUMN_NOM, clt.getNom());
        valeurs.put(ClientFactory.COLUMN_PRENOM, clt.getPrenom());
        valeurs.put(ClientFactory.COLUMN_RAISON_SOCIALE, clt.getRaisonSociale());
        valeurs.put(ClientFactory.COLUMN_ADRESSE, clt.getAdresse());
        valeurs.put(ClientFactory.COLUMN_VILLE, clt.getVille());
        valeurs.put(ClientFactory.COLUMN_CODE_POSTAL, clt.getCp());
        valeurs.put(ClientFactory.COLUMN_TEL_MOBILE, clt.getTelMobile());
        valeurs.put(ClientFactory.COLUMN_TEL_FIX, clt.getTelFix());

        long res = openEcriture().insert(ClientFactory.TABLE_NAME, null, valeurs);

        return res;
    }

    public static boolean emailExists(String email) {
        Cursor c = openLecture().query(
                ClientFactory.TABLE_NAME,
                new String[]{ClientFactory.COLUMN_EMAIL},
                ClientFactory.COLUMN_EMAIL + " = ?",
                new String[]{email},
                null,
                null,
                null
        );

        boolean exists = c.getCount() > 0;
        c.close();
        return exists;
    }


    //Méthode pour la requete UPDATE
    public static int updateClient(int id, Client clt){

        ContentValues valeurs = new ContentValues();

        valeurs.put(ClientFactory.COLUMN_CIVILITE, clt.getCivilite());
        valeurs.put(ClientFactory.COLUMN_NOM, clt.getNom());
        valeurs.put(ClientFactory.COLUMN_PRENOM, clt.getPrenom());
        valeurs.put(ClientFactory.COLUMN_RAISON_SOCIALE, clt.getRaisonSociale());
        valeurs.put(ClientFactory.COLUMN_ADRESSE, clt.getAdresse());
        valeurs.put(ClientFactory.COLUMN_VILLE, clt.getVille());
        valeurs.put(ClientFactory.COLUMN_CODE_POSTAL, clt.getCp());
        valeurs.put(ClientFactory.COLUMN_TEL_MOBILE, clt.getTelMobile());
        valeurs.put(ClientFactory.COLUMN_TEL_FIX, clt.getTelFix());

        int LignesMAJ = openEcriture().update(ClientFactory.TABLE_NAME, valeurs, ClientFactory.COLUMN_ID_CLIENT + " = " + id,
                null);
        return LignesMAJ;
    }

    //Méthode pour la requete DELETE
    public static int deleteClient(int id){
        int LignesSupp = openEcriture().delete(ClientFactory.TABLE_NAME, ClientFactory.COLUMN_ID_CLIENT + " = ?",
            new String[] {String.valueOf(id)});
        return LignesSupp;
    }
}
