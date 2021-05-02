package controleur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.applicovidp.R;

public class ChoixActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);

        Button  bt1 = (Button) findViewById(R.id.test);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChoixActivity.this,FairetestActivity.class));

            }
        });

        Button  bt2 = (Button) findViewById(R.id.res);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChoixActivity.this,ReshebdoActivity.class));

            }
        });


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
        super.onCreateOptionsMenu(menu);
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