package ro.blogspot.quizsoccerapp.soccerquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score=0;
    String numeJucator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }


    public void submitOrder(View view) {
        int rezultatTotal= calculeazaScor();
        String rezultatTest = rezultatTestare(rezultatTotal);
        displayMessage(rezultatTest);
            if (score==100) {
            Toast toast = new Toast(this);
            ImageView imagine = new ImageView(this);
            imagine.setImageResource(R.drawable.fifa_world_cup);
            toast.setView(imagine);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
            toast.show();
        }
    }

    /**
     * This function increment the score
     */

    public void radioButoncheck (View view){
        boolean apasat = ((RadioButton) view).isChecked();
        RadioGroup intrebarea1 = (RadioGroup) findViewById(R.id.prima_intrebare);
        switch (intrebarea1.getCheckedRadioButtonId()) {
            case R.id.butonul_da:
                score = score + 20;
                break;
            case R.id.butonul_nu:
                score = score + 0;
                break;
        }
    }


    private int calculeazaScor () {

        String intrebarea4= "maradona";
        String intrebarea5= "inter";




        CheckBox intrebarea2 = (CheckBox) findViewById(R.id.brasilia_orientare);
        if (intrebarea2.isChecked()){
            score=score+20;
        }

        CheckBox intrebarea3 = (CheckBox) findViewById(R.id.ronaldo_orientare);
        if (intrebarea3.isChecked()){
            score=score+20;
        }

        EditText raspuns4= (EditText) findViewById(R.id.intrebarea_patru);
        String raspunsIntrebarea4 = raspuns4.getText().toString();
        if (raspunsIntrebarea4.equalsIgnoreCase(intrebarea4)){
            score=score+20;
        }

        EditText raspuns5= (EditText) findViewById(R.id.intrebarea_cinci);
        String raspunsIntrebarea5 = raspuns5.getText().toString();
        if (raspunsIntrebarea5.equalsIgnoreCase(intrebarea5)){
            score=score+20;
        }
        return score;

    }
    private String rezultatTestare (int score) {
        EditText nume = (EditText) findViewById(R.id.nume_jucator);
        String numeJucator = nume.getText().toString();
        String rezultatFinal= "Felicitari, " + numeJucator + "! ai obtinut " + score + " puncte!";
        return rezultatFinal;
    }

    private void displayMessage(String message) {
        TextView rezultat = (TextView) findViewById(R.id.final_test);
        rezultat.setText(message);
    }

}


