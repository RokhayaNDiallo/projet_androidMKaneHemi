package controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.applicovidp.R;

import methode.personne;

public class FairetestActivity extends AppCompatActivity  {
    private personne personne;
    private Button b,e;
    private EditText r;
    private EditText s;
    private EditText h ;
    private EditText w;
    private EditText y;
    private String nom, prenom, adresse, telephone, mail;
     private String d="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fairetest);
        b = (Button) findViewById(R.id.buttonl);
        e = (Button) findViewById(R.id.button1);
        r = (EditText) findViewById(R.id.nom);
        s = (EditText) findViewById(R.id.prenom);
        h = (EditText) findViewById(R.id.tel);
        w = (EditText) findViewById(R.id.adresse);
        y = (EditText) findViewById(R.id.mail);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent apropos= new Intent(String.valueOf(FairetestActivity.class));
                nom=r.getText().toString();
                prenom=s.getText().toString();
                mail=y.getText().toString();
                adresse=w.getText().toString();
                telephone=h.getText().toString();

                apropos.putExtra("Value",nom);
                apropos.putExtra("Value2",prenom);
                apropos.putExtra("Value3",adresse);
                apropos.putExtra("Value4",telephone);
                apropos.putExtra("Value5",mail);

                start_AproposActivity();
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                startActivity(new Intent(FairetestActivity.this, AproposActivity.class));
                }
        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.pages_menu, menu);

        return true;
    }
    private void start_AproposActivity() {
        Intent apropos =new Intent(this, ContactActivity.class);
        startActivity(apropos);
    }
    private void start_ContactActivity() {
        Intent contact =new Intent(this, ContactActivity.class);
        startActivity(contact);
    }
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.Apropos:

                d+=nom+"\n";
                d+=prenom+"\n";
                d+=adresse+"\n";
                d+=telephone+"\n";
                d+=mail+"\n";

                Toast.makeText(FairetestActivity.this,"Personne: \n:"+d,Toast.LENGTH_LONG).show();

                return  true;
            case R.id.Contacts:
                start_ContactActivity();
                return  true;
        }
        return false;
    }
}