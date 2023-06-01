package sv.edu.utec.educhat;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class AdaptadorChat extends ArrayAdapter<String> {
    Activity contexto;
    String [] chatnft;
    Integer [] ImgChat;
    ImageView imgChat;
    TextView tvPersonaChat;

    public AdaptadorChat (Activity contexto,String [] chatnft, Integer[] ImgChat ){
        super(contexto,R.layout.chats,chatnft);
        this.contexto=contexto;
        this.chatnft=chatnft;
        this.ImgChat=ImgChat;



    }
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater inflater = contexto.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.chats,null, true);

        tvPersonaChat=rowView.findViewById(R.id.tvPersonaChat);//nombre
        imgChat=rowView.findViewById(R.id.imgvPerfil); //ftperfil
        tvPersonaChat.setText(chatnft[position]);
        imgChat.setImageResource(ImgChat[position]);
        return rowView;

    }



}
