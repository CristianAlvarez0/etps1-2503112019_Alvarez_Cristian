package sv.edu.utec.educhat.BaseDatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

import sv.edu.utec.educhat.AdaptadorChat;

public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS=1;
    private static final String NOMBRE_BASE="BASEDUCHAT.db";

    public SQLiteOpenHelper(@Nullable Context context) {
        super(context, NOMBRE_BASE, null, VERSION_BASEDATOS);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

       db.execSQL("CREATE TABLE usuarios (Id_usuario INTEGER PRIMARY KEY," +
                " NombreUSU TEXT, correo TEXT,Pass TEXT, ConfirmPass TEXT)");


        db.execSQL("CREATE TABLE categoria_chat (Id_cat INTEGER PRIMARY KEY," +
                " NombreCAT TEXT)");

        db.execSQL("CREATE TABLE chat (Id_chat INTEGER," +
                " NombreCHAT TEXT, Descripcion TEXT,Id_usuario INTEGER,Id_cat INTEGER, Categoria INTEGER,"+
                "PRIMARY KEY (Id_chat,Id_usuario,Id_cat),"+
                "FOREIGN KEY (Id_usuario) REFERENCES usuarios(Id_usuario)," +
                "FOREIGN KEY (Id_cat) REFERENCES categoria_chat(Id_cat))"
        );

        db.execSQL("CREATE TABLE forotipo (Id_forotipo INTEGER PRIMARY KEY," +
                " NombreTIPOFORO TEXT)");

        db.execSQL("CREATE TABLE foro (Id_foro INTEGER," +
                " NombreFORO TEXT, Descripcion TEXT, Id_usuario INTEGER, Id_forotipo INTEGER,Categoria INTEGER," +
                "PRIMARY KEY (Id_foro,Id_usuario,Id_forotipo)," +
                "FOREIGN KEY (Id_usuario) REFERENCES usuarios(Id_usuario)," +
                "FOREIGN KEY (Id_forotipo) REFERENCES forotipo(Id_forotipo))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
