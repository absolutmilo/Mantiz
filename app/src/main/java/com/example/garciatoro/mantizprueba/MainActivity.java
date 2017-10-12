package com.example.garciatoro.mantizprueba;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Username = (EditText) findViewById(R.id.UserNameText);
        Password = (EditText) findViewById(R.id.PasswordText);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(),Password.getText().toString());

            }
        });



        NfcAdapter nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if(nfcAdapter != null){
            if(nfcAdapter.isEnabled()) {
                Toast.makeText(this, "NFC disponible", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(this,R.string.NFCInactivado , Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, R.string.NFCNoCompatible, Toast.LENGTH_SHORT).show();
        }


    }


    private void validate(String userName, String userPassword){

        if(Objects.equals(userName, getString(R.string.user)) && Objects.equals(userPassword,getString(R.string.password))){
            Log.i("intento con usuario",getString(R.string.user));
            Toast.makeText(this, "Ingresando", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,Mainboard.class);
            startActivity(intent);

        }
        else{
            if(counter != 0)
            {
                counter--;
                Toast.makeText(this, R.string.credencialesInvalidas, Toast.LENGTH_SHORT).show();
            }
            else{
                Info.setVisibility(View.VISIBLE);
                Info.setText(R.string.numeroExcedidoIntentos);
                Login.setEnabled(false);
            }
        }
    }
}
