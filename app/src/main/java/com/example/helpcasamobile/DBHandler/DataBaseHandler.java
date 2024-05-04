package com.example.helpcasamobile.DBHandler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.helpcasamobile.Factory.ClientFactory;
import com.example.helpcasamobile.Factory.LogementFactory;
import com.example.helpcasamobile.Factory.UserFactory;

public class DataBaseHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "helpcasamobile.db";

    public DataBaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserFactory.reqUsers);
        db.execSQL(ClientFactory.reqClient);
        db.execSQL(LogementFactory.reqLogement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UserFactory.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ClientFactory.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + LogementFactory.TABLE_NAME);
        onCreate(db);
    }
}
