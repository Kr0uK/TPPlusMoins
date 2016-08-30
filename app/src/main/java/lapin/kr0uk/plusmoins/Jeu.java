package lapin.kr0uk.plusmoins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Jeu extends AppCompatActivity {
    Random rnd = new Random ();
    int nbGenere = rnd.nextInt(100)+1;
    int reponse;
    int nbErreurs = 0;

    TextView txtStatut ;
    TextView txtResultat;
    EditText txtInputReponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        Button btnValider = (Button) findViewById(R.id.btnValider);
        txtStatut  = (TextView) findViewById(R.id.txtStatut);
        txtResultat = (TextView) findViewById(R.id.txtResultat);
        txtInputReponse = (EditText) findViewById(R.id.txtInputReponse);


    }


    public void btn_click(View view) {

    }
}
