package controleur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.applicovidp.R;

public class ContactActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState) ;
setContentView(R.layout.activity_contact);
        Button btnEnvoie = (Button) findViewById(R.id.envoyer);
 btnEnvoie.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

//On récupère les deux EditText correspondant aux champs pour entrer le numéro et le message
            final EditText numero = (EditText) findViewById(R.id.numero);
            final EditText message = (EditText) findViewById(R.id.message);
//On affecte un écouteur d'évènement au bouton

            //On récupère ce qui a été entré dans les EditText
            String num = numero.getText().toString();
            String msg = message.getText().toString();
            //Si le numéro est supérieur à 4 caractères et que le message n'est pas vide on lance la procédure d'envoi
            if (num.length() >= 4 && msg.length() > 0) {
                //Grâce à l'objet de gestion de SMS (SmsManager) que l'on récupère via la méthode static getDefault()
                //On envoie le SMS à l'aide de la méthode sendTextMessage
                SmsManager.getDefault().sendTextMessage(num, null, msg, null, null);
                //On efface les deux EditText
                numero.setText("");
                message.setText("");
            } else {
                //On affiche un petit message d'erreur dans un Toast
                Toast.makeText(ContactActivity.this, "Enter le numero et/ou le message", Toast.LENGTH_SHORT).show();
            }

        }});
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