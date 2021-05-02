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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.applicovidp.R;

public class QcmActivity extends AppCompatActivity {
    private EditText Q1;
    private EditText Q2;
    private EditText Q3;
    private EditText Q4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qcm);

    }

    private void start_AproposActivity() {
        Intent apropos = new Intent(this, AproposActivity.class);
        startActivity(apropos);
    }

    private void start_ContactActivity() {
        Intent contact = new Intent(this, ContactActivity.class);
        startActivity(contact);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pages_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Apropos:
                start_AproposActivity();
                return true;
            case R.id.Contacts:
                start_ContactActivity();
                return true;
        }
        return false;
    }

    public void onRadioButtonClicked4(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        EditText Q1 = (EditText) findViewById(R.id.Q1);
        EditText Q2 = (EditText) findViewById(R.id.Q2);
        EditText Q3 = (EditText) findViewById(R.id.Q3);
        EditText Q4 = (EditText) findViewById(R.id.Q4);
        int i;
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.r11:
                if (checked)
                    Q1.setText("1"); // Pirates are the best
                break;
            case R.id.r12:
                if (checked) {
                    Q1.setText("-1");
                }
                break;
        }
    }

    public void onRadioButtonClicked3(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.r31:
                if (checked) {

                    Q3.setText("1");// Pirates are the best
                }
                break;
            case R.id.r32:
                if (checked) {
                    Q3.setText("-1");
                }// Ninjas rule
                break;
        }
    }

    public void onRadioButtonClicked2(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.r21:
                if (checked) {
                    Q2.setText("1");
                }
                // Pirates are the best
                break;
            case R.id.r22:
                if (checked) {
                    Q2.setText("-1");
                }// Ninjas rule
                break;
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.r41:
                if (checked) {
                    Q2.setText("1");
                }// Pirates are the best
                break;
            case R.id.r42:
                if (checked) {
                    Q2.setText("-1");
                } // Ninjas rule
                break;
        }
        Button bt3 = (Button) findViewById(R.id.vali);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int o = Integer.getInteger(String.valueOf(Q1)) + Integer.getInteger(String.valueOf(Q2)) +
                        Integer.getInteger(String.valueOf(Q3)) + Integer.getInteger(String.valueOf(Q4));
                Intent i = new Intent(QcmActivity.this, ResultatActivity.class);
                i.putExtra("Value", o);

            }
        });

    }
}