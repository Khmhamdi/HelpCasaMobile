package com.example.helpcasamobile.ManipData;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.helpcasamobile.DBHandler.DataBaseHandler;
import com.example.helpcasamobile.Factory.LogementFactory;
import com.example.helpcasamobile.Model.Logement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class LogementDataExchange {

    private static SQLiteDatabase mDB;
    private static DataBaseHandler cnx;

    public LogementDataExchange(Context context) {
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
    public static Logement searchLogement(int id){
        Cursor c = openLecture().query(LogementFactory.TABLE_NAME,
                null,
                LogementFactory.COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);
        if (c.getCount() == 0) {
            return null;
        }else {
            Logement resLgm = new Logement();

            resLgm.setIdLogement(c.getInt(0));
            resLgm.setTypeLogement(c.getString(1));
            resLgm.setTypeAnnonce(c.getString(2));
            resLgm.setGouvernorat(c.getString(3));
            resLgm.setVille(c.getString(4));
            resLgm.setAdresse(c.getString(5));
            resLgm.setSuperficie(c.getInt(6));
            resLgm.setNbrChambre(c.getInt(7));
            resLgm.setDescription(c.getString(8));
            resLgm.setPrix(c.getFloat(9));
            resLgm.setDtAnnonce(c.getString(10));
            resLgm.setValidite(c.getInt(11));
            resLgm.setIdProp(c.getInt(12));
            resLgm.setIdAchet(c.getInt(13));
            resLgm.setMeuble(c.getString(14));
            resLgm.setImage(c.getString(15));
            resLgm.setEtat(c.getString(16));
            resLgm.setDtReserv(c.getString(17));
            resLgm.setDtValidation(c.getString(18));
            resLgm.setIdUser(c.getInt(19));
            resLgm.setCommProp(c.getFloat(20));
            resLgm.setCommAchet(c.getFloat(21));
            c.close();
            fermer();
            return resLgm;
        }
    }

    //Méthode pour la requête SELECT ALL
    public static ArrayList<Logement> getAllLogements() {
        Cursor c = openLecture().query(LogementFactory.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                LogementFactory.COLUMN_DATE_ANNONCE);

            ArrayList<Logement> ListLgm= new ArrayList<Logement>(c.getCount());
        if (c.moveToFirst()) {
            do {
                Logement resLgm = new Logement();

                resLgm.setIdLogement(c.getInt(0));
                resLgm.setTypeLogement(c.getString(1));
                resLgm.setTypeAnnonce(c.getString(2));
                resLgm.setGouvernorat(c.getString(3));
                resLgm.setVille(c.getString(4));
                resLgm.setAdresse(c.getString(5));
                resLgm.setSuperficie(c.getInt(6));
                resLgm.setNbrChambre(c.getInt(7));
                resLgm.setDescription(c.getString(8));
                resLgm.setPrix(c.getFloat(9));
                resLgm.setDtAnnonce(c.getString(10));
                resLgm.setValidite(c.getInt(11));
                resLgm.setIdProp(c.getInt(12));
                resLgm.setIdAchet(c.getInt(13));
                resLgm.setMeuble(c.getString(14));
                resLgm.setImage(c.getString(15));
                resLgm.setEtat(c.getString(16));
                resLgm.setDtReserv(c.getString(17));
                resLgm.setDtValidation(c.getString(18));
                resLgm.setIdUser(c.getInt(19));
                resLgm.setCommProp(c.getFloat(20));
                resLgm.setCommAchet(c.getFloat(21));

                ListLgm.add(resLgm);
            } while (c.moveToNext());
        }
            c.close();
            fermer();
            return ListLgm;
    }

    public static ArrayList<Logement> getAllReservedLogements() {
        Cursor c = openLecture().query(LogementFactory.TABLE_NAME,
                null,
                LogementFactory.COLUMN_ETAT + " = ?",
                new String[]{"Réservé(e)"},
                null,
                null,
                LogementFactory.COLUMN_DATE_ANNONCE);

        ArrayList<Logement> ListLgm= new ArrayList<Logement>(c.getCount());
        if (c.moveToFirst()) {
            do {
                Logement resLgm = new Logement();

                resLgm.setIdLogement(c.getInt(0));
                resLgm.setTypeLogement(c.getString(1));
                resLgm.setTypeAnnonce(c.getString(2));
                resLgm.setGouvernorat(c.getString(3));
                resLgm.setVille(c.getString(4));
                resLgm.setAdresse(c.getString(5));
                resLgm.setSuperficie(c.getInt(6));
                resLgm.setNbrChambre(c.getInt(7));
                resLgm.setDescription(c.getString(8));
                resLgm.setPrix(c.getFloat(9));
                resLgm.setDtAnnonce(c.getString(10));
                resLgm.setValidite(c.getInt(11));
                resLgm.setIdProp(c.getInt(12));
                resLgm.setIdAchet(c.getInt(13));
                resLgm.setMeuble(c.getString(14));
                resLgm.setImage(c.getString(15));
                resLgm.setEtat(c.getString(16));
                resLgm.setDtReserv(c.getString(17));
                resLgm.setDtValidation(c.getString(18));
                resLgm.setIdUser(c.getInt(19));
                resLgm.setCommProp(c.getFloat(20));
                resLgm.setCommAchet(c.getFloat(21));

                ListLgm.add(resLgm);
            } while (c.moveToNext());
        }
        c.close();
        fermer();
        return ListLgm;
    }

    //Méthode pour la requete INSERT
    public static long addLogement(Logement lgm){

        ContentValues valeurs = new ContentValues();

        valeurs.put(LogementFactory.COLUMN_TYPE_LOGEMENT, lgm.getTypeLogement());
        valeurs.put(LogementFactory.COLUMN_TYPE_ANNONCE, lgm.getTypeAnnonce());
        valeurs.put(LogementFactory.COLUMN_GOUVERNORAT, lgm.getGouvernorat());
        valeurs.put(LogementFactory.COLUMN_VILLE, lgm.getVille());
        valeurs.put(LogementFactory.COLUMN_ADRESSE, lgm.getAdresse());
        valeurs.put(LogementFactory.COLUMN_SUPERFICIE, lgm.getSuperficie());
        valeurs.put(LogementFactory.COLUMN_NBR_CHAMBRE, lgm.getNbrChambre());
        valeurs.put(LogementFactory.COLUMN_DESCRIPTION, lgm.getDescription());
        valeurs.put(LogementFactory.COLUMN_PRIX, lgm.getPrix());
        valeurs.put(LogementFactory.COLUMN_DATE_ANNONCE, lgm.getDtAnnonce());
        valeurs.put(LogementFactory.COLUMN_DATE_VALIDITE, lgm.getValidite());
        valeurs.put(LogementFactory.COLUMN_ID_PROP, lgm.getIdProp());
        valeurs.put(LogementFactory.COLUMN_ID_ACHET, lgm.getIdAchet());
        valeurs.put(LogementFactory.COLUMN_MEUBLE, lgm.getMeuble());
        valeurs.put(LogementFactory.COLUMN_IMAGE, lgm.getImage());
        valeurs.put(LogementFactory.COLUMN_ETAT, lgm.getEtat());
        valeurs.put(LogementFactory.COLUMN_DT_RESERV, lgm.getDtReserv());
        valeurs.put(LogementFactory.COLUMN_DT_VALIDATION, lgm.getDtValidation());
        valeurs.put(LogementFactory.COLUMN_ID_USER, lgm.getIdUser());
        valeurs.put(LogementFactory.COLUMN_COMM_PROPRIETAIRE, lgm.getCommProp());
        valeurs.put(LogementFactory.COLUMN_COMM_ACHETEUR, lgm.getCommAchet());

        long res = openEcriture().insert(LogementFactory.TABLE_NAME, null, valeurs);
        fermer();
        return res;
    }

    //Méthode pour la requete UPDATE
    public static int updateLogement(int id, Logement lgm){

        ContentValues valeurs = new ContentValues();

        valeurs.put(LogementFactory.COLUMN_TYPE_LOGEMENT, lgm.getTypeLogement());
        valeurs.put(LogementFactory.COLUMN_TYPE_ANNONCE, lgm.getTypeAnnonce());
        valeurs.put(LogementFactory.COLUMN_GOUVERNORAT, lgm.getGouvernorat());
        valeurs.put(LogementFactory.COLUMN_VILLE, lgm.getVille());
        valeurs.put(LogementFactory.COLUMN_ADRESSE, lgm.getAdresse());
        valeurs.put(LogementFactory.COLUMN_SUPERFICIE, lgm.getSuperficie());
        valeurs.put(LogementFactory.COLUMN_NBR_CHAMBRE, lgm.getNbrChambre());
        valeurs.put(LogementFactory.COLUMN_DESCRIPTION, lgm.getDescription());
        valeurs.put(LogementFactory.COLUMN_PRIX, lgm.getPrix());
        valeurs.put(LogementFactory.COLUMN_DATE_ANNONCE, lgm.getDtAnnonce());
        valeurs.put(LogementFactory.COLUMN_DATE_VALIDITE, lgm.getValidite());
        valeurs.put(LogementFactory.COLUMN_ID_PROP, lgm.getIdProp());
        valeurs.put(LogementFactory.COLUMN_ID_ACHET, lgm.getIdAchet());
        valeurs.put(LogementFactory.COLUMN_MEUBLE, lgm.getMeuble());
        valeurs.put(LogementFactory.COLUMN_IMAGE, lgm.getImage());
        valeurs.put(LogementFactory.COLUMN_ETAT, lgm.getEtat());
        valeurs.put(LogementFactory.COLUMN_DT_RESERV, lgm.getDtReserv());
        valeurs.put(LogementFactory.COLUMN_DT_VALIDATION, lgm.getDtValidation());
        valeurs.put(LogementFactory.COLUMN_ID_USER, lgm.getIdUser());
        valeurs.put(LogementFactory.COLUMN_COMM_PROPRIETAIRE, lgm.getCommProp());
        valeurs.put(LogementFactory.COLUMN_COMM_ACHETEUR, lgm.getCommAchet());

        int LignesMAJ = openEcriture().update(LogementFactory.TABLE_NAME, valeurs, LogementFactory.COLUMN_ID + " = " + id,
                null);
        fermer();
        return LignesMAJ;
    }


    public static int updateEtatLogement(int id, String etat){

        ContentValues valeurs = new ContentValues();
        valeurs.put(LogementFactory.COLUMN_ETAT, etat);
        int LignesMAJ = openEcriture().update(LogementFactory.TABLE_NAME, valeurs, LogementFactory.COLUMN_ID + " = " + id,
                null);
        fermer();
        return LignesMAJ;
    }

    public static int reserverAnnonce(int idLogement, int idAchet, String dtReserv, String etat){

        ContentValues valeurs = new ContentValues();
        valeurs.put(LogementFactory.COLUMN_ID_ACHET, idAchet);
        valeurs.put(LogementFactory.COLUMN_DT_RESERV, dtReserv);
        valeurs.put(LogementFactory.COLUMN_ETAT, etat);
        int LignesMAJ = openEcriture().update(LogementFactory.TABLE_NAME, valeurs, LogementFactory.COLUMN_ID + " = " + idLogement,
                null);
        fermer();
        return LignesMAJ;
    }

    public static int validerOperation(int idLogement, int idUser, String dtValidation, float commProp, float commAchet, String etat){

        ContentValues valeurs = new ContentValues();
        valeurs.put(LogementFactory.COLUMN_ID_USER, idUser);
        valeurs.put(LogementFactory.COLUMN_DT_VALIDATION, dtValidation);
        valeurs.put(LogementFactory.COLUMN_COMM_PROPRIETAIRE, commProp);
        valeurs.put(LogementFactory.COLUMN_COMM_ACHETEUR, commAchet);
        valeurs.put(LogementFactory.COLUMN_ETAT, etat);
        int LignesMAJ = openEcriture().update(LogementFactory.TABLE_NAME, valeurs, LogementFactory.COLUMN_ID + " = " + idLogement,
                null);
        fermer();
        return LignesMAJ;
    }

    //Méthode pour la requete DELETE
    public static int deleteLogement(int id){
        int LignesSupp = openEcriture().delete(LogementFactory.TABLE_NAME, LogementFactory.COLUMN_ID + " = ?",
                new String[] { String.valueOf(id) });
        return LignesSupp;
    }

    // Méthode pour filtrer les biens immobiliers en fonction des critères spécifiés
    public static ArrayList<Logement> filtrerImmo(ArrayList<Logement> biens, String typeLogement, String typeAnnonce, String gouvernorat, String ville, int superficieMin, int superficieMax, int nbrChambreMin, float prixMin, float prixMax/*, String meuble, String image*/) {
        ArrayList<Logement> FiltreResult = new ArrayList<>();
        if (biens != null) {
            Iterator<Logement> iterator = biens.iterator();
            while (iterator.hasNext()) {
                Logement bien = iterator.next();
                if ((typeLogement == null || bien.getTypeLogement().equals(typeLogement)) &&
                        (typeAnnonce == null || bien.getTypeAnnonce().equals(typeAnnonce)) &&
                        (gouvernorat == null || bien.getGouvernorat().equals(gouvernorat)) &&
                        (ville == null || bien.getVille().equals(ville)) &&
                        (nbrChambreMin <= bien.getNbrChambre()) &&
                        (superficieMin <= bien.getSuperficie() && bien.getSuperficie() <= superficieMax) &&
                        (prixMin <= bien.getPrix() && bien.getPrix() <= prixMax) /*&&
                        (meuble == null || (bien.getMeuble() != null && bien.getMeuble().equals(meuble))) &&
                        (image == null || (bien.getImage() != null && bien.getImage().equals(image)))*/) {
                    FiltreResult.add(bien);
                }
            }
        }
        return FiltreResult;
    }


    public static ArrayList<String> SelectDistinctVilles() {
        ArrayList<String> villes = new ArrayList<>();

        // Utilisation de try-with-resources pour s'assurer que le curseur est fermé automatiquement
        try (Cursor curseur = openLecture().rawQuery("SELECT DISTINCT " + LogementFactory.COLUMN_VILLE + " FROM " + LogementFactory.TABLE_NAME, null)) {
            if (curseur != null && curseur.moveToFirst()) {
                do {
                    String ville = curseur.getString(0);
                    villes.add(ville);
                } while (curseur.moveToNext());
                Collections.sort(villes);
            }else{
                villes.add("Aucun éléments");
            }
        } catch (SQLException e) {
            // Gérer les erreurs de base de données
            e.printStackTrace(); // Ou enregistrer l'erreur dans les logs
        }

        return villes;
    }

}
