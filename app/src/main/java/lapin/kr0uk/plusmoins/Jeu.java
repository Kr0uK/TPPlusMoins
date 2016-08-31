package lapin.kr0uk.plusmoins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Jeu extends AppCompatActivity {

    // On déclare les variables
    Random rnd = new Random();
    int nbGenere = rnd.nextInt(100) + 1;
    int reponse;
    int nbErreurs = 0;

    String debug = Integer.toString(nbGenere);

    TextView txtStatut; // texte pour vérifier la victoire/défaite
    TextView txtResultat; // texte qui indique plus/moins
    EditText txtInputReponse; // réponse de l'user


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        // on lie le XML à Java
        Button btnValider = (Button) findViewById(R.id.btnValider);
        txtStatut = (TextView) findViewById(R.id.txtStatut);
        txtResultat = (TextView) findViewById(R.id.txtResultat);
        txtInputReponse = (EditText) findViewById(R.id.txtInputReponse);


        // Listener sur le bouton
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                /*
                    on met la bonne valeur en debug
                    Log.w("TAG",debug);
                    Log.d("TAG",debug);
                    Log.e("TAG",debug);
                    */

                    reponse = Integer.parseInt(txtInputReponse.getText().toString());
                    if (reponse < 1 || reponse > 100) { // on vérifie que le résulat soit bien dans les bonnes valeurs

                        Toast.makeText(Jeu.this, "Resaisissez un chiffre entre 1 et 100", Toast.LENGTH_LONG).show();
                    } else {

                        verif(reponse);
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Saisissez un nombre entre 1 et 100.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void verif(int reponse) { // On vérifie que ce soit juste ou non
        String strReponse = "";

        try {

            nbErreurs++;
            if (nbErreurs < 5) {


                if (reponse == nbGenere) { // on vérifie si la réponse est juste
                    strReponse = "Félicitations !";
                } else if (reponse < nbGenere) {  // On gère les deux cas possibles
                    strReponse = "Le bon numéro est PLUS GRAND que celui que vous avez tapé.";
                } else {
                    strReponse = "Le bon numéro est PLUS PETIT que celui que vous avez tapé.";
                }

            } else {
                strReponse = "Vous avez perdu, le bon numéro était " + nbGenere;
            }
        } finally {

            String sEssais = "Vous êtes à " + nbErreurs + " Essai(s)";
            txtStatut.setText(sEssais);
            txtResultat.setText(strReponse);
        }

    }
}



