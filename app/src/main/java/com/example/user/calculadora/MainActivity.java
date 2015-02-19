package com.example.user.calculadora;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends ActionBarActivity {

    float numero1 = (float)0.0;
    float resultado;
    int pant=0;
    int temp=0;
    int op=0;
    int enable;



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView tv = (TextView)findViewById(R.id.textView);
        outState.putFloat("resultado",Float.parseFloat(tv.getText().toString()));
     //   outState.putInt("pant",pant);
        outState.putInt("op",op);
        outState.putInt("enable",enable);



    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText("0");
        if( savedInstanceState != null ) {
            //Then the application is being reloaded
            tv.setText(""+savedInstanceState.getFloat("resultado"));
            pant=1;



            savedInstanceState.getInt("enable");
//            Toast.makeText(getApplicationContext(),"El valor de pant es "+pant+" , el valor de op es "+op,Toast.LENGTH_LONG).show();



        }



    }

    public void agreganumero(View view)
    {
        enable=0;
        Button boton = (Button)findViewById(view.getId());
        TextView tv = (TextView)findViewById(R.id.textView);
        if(pant==1)//para verificar que hay un resultado en pantalla y no añadir numero al lado sin presionar igual
        {

            tv.setText("");
            pant=0;
        }
        if(op==6) {
            tv.setText("");
            resultado=(float)0.0;
            op=0;

        }

        tv.setText(tv.getText().toString()+boton.getText().toString());
    }

    public void reset(View view)
    {
        TextView tv = (TextView)findViewById(R.id.textView);

        resultado= (float) 0.0;
        tv.setText("0.0");
        numero1= (float) 0.0;
        temp=0;
        pant=1;
        op=0;



    }

    public void restar(View view)
    {

        enable++;
        if(enable==1)
        {
            actualizarResultado();
            op=2;
            pant=1;
        }
        else
        {
            op=2;
            TextView tv = (TextView)findViewById(R.id.textView);
            resultado=Float.parseFloat(tv.getText().toString());
        }

    }
    public void dividir(View view)
    {
        enable++;
        if(enable==1)
        {
            actualizarResultado();
            op=4;
            pant=1;
        }
        else
        {
            TextView tv = (TextView)findViewById(R.id.textView);
            op=4;
            resultado=Float.parseFloat(tv.getText().toString());
        }
    }
    public void multiplicar(View view)
    {
        enable++;
        if(enable==1)
        {
            actualizarResultado();
            op=3;
            pant=1;
        }
        else
        {
            TextView tv = (TextView)findViewById(R.id.textView);
            op=3;
            resultado=Float.parseFloat(tv.getText().toString());
        }
    }

    public void suma(View view)
    {
        enable++;
        if (enable==1)
        {
            actualizarResultado();
            op=1;
            pant=1;
        }
        else
        {
            TextView tv = (TextView)findViewById(R.id.textView);

            resultado=Float.parseFloat(tv.getText().toString());
            op=1;
        }



    }
    public void igual(View view)
    {
        TextView tv = (TextView)findViewById(R.id.textView);
        if (enable!=0)
            resultado=Float.parseFloat(tv.getText().toString());
        else
        {
            actualizarResultado();

            pant=1;
        }
        op=6;//Ultimo cambio realizado
    }
    void actualizarResultado()
    {

        TextView tv = (TextView)findViewById(R.id.textView);

            numero1=Float.parseFloat(tv.getText().toString());



        if(op==1)
        {
            resultado=resultado+numero1;
        }
        if(op==2)
        {
            resultado=resultado-numero1;
        }
        if(op==3)
        {
            resultado=resultado*numero1;
        }
        if(op==4)
        {

            try{resultado = resultado / numero1;}catch(Exception e)
            {
                tv.setText("Syntax Error");
            }
        }


        if(op==0)
            resultado=Float.parseFloat(tv.getText().toString());
        tv.setText(""+resultado);


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
