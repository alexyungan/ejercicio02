package com.example.aes.aplicacion001;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private  EditText text_valor1;
    private  EditText text_valor2;

    public TextView textViewResultado;
    private  RadioButton radioButtonSumar;
    private RadioButton radioButtonResta;
    private  Button btnCalcular;
    private int opcion=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

           text_valor2= (EditText)findViewById(R.id.editTextvalor2);
          text_valor1= (EditText)findViewById(R.id.editTextvalor1);

          textViewResultado=(TextView)findViewById(R.id.textViewRespuesta) ;
           radioButtonSumar=(RadioButton)findViewById(R.id.radioButtonSumar);
          radioButtonResta=(RadioButton)findViewById(R.id.radioButtonRestar);
           btnCalcular=(Button)findViewById(R.id.buttonCalcular);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                operar(Integer.parseInt(text_valor1.getText().toString()),Integer.parseInt(text_valor2.getText().toString()));


            }
        });


        radioButtonResta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

               if( opcion==0){
                   radioButtonSumar.setChecked(false);

                   opcion=1;
               }


            }
        });


        radioButtonSumar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if( opcion==1){
                    radioButtonResta.setChecked(false);
                    opcion=0;

                }


            }
        });
    }


    public void operar(int a, int b){
        int res=0;
        if(radioButtonSumar.isChecked()==true){
            Log.d("a:",Integer.toString(a));
            Log.d("a:",Integer.toString(b));
            res=a+b;
            Log.d("la suma es :",Integer.toString(res));
            textViewResultado.setText("La suma  es: "+Integer.toString(res));
        }
        if(radioButtonResta.isChecked()==true){
            res=a-b;
            Log.d("la resta :",Integer.toString(res));
            textViewResultado.setText("La resta  es: "+Integer.toString(res));
        }

       // textViewResultado.setText("La respuesta es: "+Integer.toString(res));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
