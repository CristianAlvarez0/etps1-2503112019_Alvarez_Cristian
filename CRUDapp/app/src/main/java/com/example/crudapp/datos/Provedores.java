package com.example.crudapp.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Provedores extends baseHelper{
    Context context;

    public Provedores(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    /*CODPROV INTEGER primary key AUTOINCREMENT,"+
                "NOMPROV TEXT NOT NULL ,"+
                "TELPROV TEXT NOT NULL,"+
                "CORRPROV TEXT NOT NULL"*/

    public long insertProvedor(String NOMPROV,String TELPROV,String CORRPROV){

        long codigo=0;
        try {

            baseHelper baseHelp = new baseHelper(context);
            SQLiteDatabase bd = baseHelp.getWritableDatabase();

            ContentValues valoresProve = new ContentValues();
            valoresProve.put("NOMPROV", NOMPROV);
            valoresProve.put("TELPROV", TELPROV);
            valoresProve.put("CORRPROV", CORRPROV);

           codigo= bd.insert(NOMBRE_TABLApv, null, valoresProve);
            return codigo;

        }
        catch (Exception ex){
            ex.toString();
            return codigo=0;
        }

    }
}
