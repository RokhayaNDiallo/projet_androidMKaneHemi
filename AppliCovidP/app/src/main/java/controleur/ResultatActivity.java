package controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applicovidp.R;

public class ResultatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
       EditText j = (EditText) findViewById(R.id.objet);
        String resultat = getIntent().getExtras().getString("Value");
        j.setText(resultat);
        String res=j.getText().toString();
        if (res== String.valueOf('4')) {
      Button  s=(Button) findViewById(R.id.res);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator u = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                u.vibrate(50);
           Toast.makeText(ResultatActivity.this,"Vous etes dans un état critique \n:",Toast.LENGTH_LONG).show();}
        });}
        if (res== String.valueOf('3')) {
            Button  s=(Button) findViewById(R.id.res);
            s.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Vibrator u = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    u.vibrate(50);
                    Toast.makeText(ResultatActivity.this,"Vous etes dans un état critique \n:",Toast.LENGTH_LONG).show();}
            });}

        if(res== String.valueOf('2')) {
            Button  s=(Button) findViewById(R.id.res);
            s.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(ResultatActivity.this,"Vous n'êtes pas contaminé \n:",Toast.LENGTH_LONG).show();}

            });}
        if(res== String.valueOf('1')) {
            Button  s=(Button) findViewById(R.id.res);
            s.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(ResultatActivity.this,"Vous n'êtes pas contaminé \n:",Toast.LENGTH_LONG).show();}

            });}
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