package controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.applicovidp.R;

import java.util.ArrayList;
import java.util.List;

import methode.PersonneBDD;
import methode.personne;

public class AproposActivity extends AppCompatActivity {
    private PersonneBDD PersonneBDD;
    private EditText g;
    private EditText k;
    private EditText o ;
    private EditText f;
    private EditText j;
    private ListView y;
    private Button s;
    private String nom, prenom, adresse, telephone, mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apropos);
        s=(Button) findViewById(R.id.val);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(AproposActivity.this, QcmActivity.class));
            }
        });
        y = (ListView) findViewById(R.id.list);
        g = (EditText) findViewById(R.id.nom);
        k = (EditText) findViewById(R.id.prenom);
        o = (EditText) findViewById(R.id.tel);
        f = (EditText) findViewById(R.id.adresse);
        j = (EditText) findViewById(R.id.mail);
        nom = getIntent().getExtras().getString("Value");
        g.setText(nom);

        prenom = getIntent().getExtras().getString("Value2");
        k.setText(prenom);

        telephone = getIntent().getExtras().getString("Value3");
        o.setText(telephone);

        adresse = getIntent().getExtras().getString("Value4");
        f.setText(adresse);
        mail = getIntent().getExtras().getString("Value5");
        j.setText(mail);
    }

    private void start_AproposActivity() {
        Intent apropos =new Intent(this, AproposActivity.class);
        startActivity(apropos);
    }
    private void start_ContactActivity() {
        Intent contact =new Intent(this, ContactActivity.class);
        startActivity(contact);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.pages_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.Apropos:
                start_AproposActivity();
                return  true;
            case R.id.Contacts:
                start_ContactActivity();
                return  true;
        }
        return false;
    }
}