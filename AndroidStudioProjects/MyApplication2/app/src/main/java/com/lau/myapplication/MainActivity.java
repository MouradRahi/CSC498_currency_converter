package com.lau.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView usd_input;
    public TextView lbp_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usd_input=findViewById(R.id.usdInput);
        lbp_input=findViewById(R.id.lbpInput);
    }

    public void convert(View v){
        Toast toast;
        String usd_amount=usd_input.getText().toString();
        String lbp_amount=lbp_input.getText().toString();

        if(usd_amount.length()>0 && lbp_amount.length()==0) {
            try{
            double usd = Double.parseDouble(usd_amount);
            lbp_input.setText(usd * 22000 + " LBP");
            }catch(NumberFormatException e){
                usd_input.setText("");
                toast=Toast.makeText(getApplicationContext(),"Enter a number in only one of the fields",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        else if(usd_amount.length()==0 && lbp_amount.length()>0){
            try{
                double lbp = Double.parseDouble(lbp_amount);
                usd_input.setText(lbp / 22000 + " USD");
            }catch(NumberFormatException e){
                lbp_input.setText("");
                toast=Toast.makeText(getApplicationContext(),"Enter a number in only one of the fields",Toast.LENGTH_SHORT);
                toast.show();
            }

        }
        else if(usd_amount.length()==0 && lbp_amount.length()==0){
            toast=Toast.makeText(getApplicationContext(),"Enter a value in one of the fields",Toast.LENGTH_SHORT);
            toast.show();
        }
        else if(usd_amount.length()>0 && lbp_amount.length()>0){
            toast=Toast.makeText(getApplicationContext(),"Enter a value in only one of the fields",Toast.LENGTH_SHORT);
            toast.show();
        }

    }
    public void emptyLbp (View v){

        lbp_input.setText("");
    }
    public void emptyUsd(View v){

        usd_input.setText("");
    }
}