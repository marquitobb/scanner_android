package com.example.scan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;

public class MainActivity extends AppCompatActivity {

    EditText etcodigo;
    Button btn_escaner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etcodigo = (EditText)findViewById(R.id.etcodigo);
        btn_escaner = (Button)findViewById(R.id.btn_escaner);

        btn_escaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escanear();
            }
        });
    }
    /*
    public void escaner(){
        IntentIntegrator intent = new IntentIntegrator(this);
        //intent.setDesiredBarcodeFormats(IntentIntegrator.PRODUCT_CODE_TYPES);
        intent.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);

        intent.setPrompt("escanear codigo");
        intent.setCameraId(0);
        intent.setOrientationLocked(false);
        intent.setBeepEnabled(false);
        intent.setCaptureActivity(CaptureActivity.class);
        intent.setBarcodeImageEnabled(false);
        intent.initiateScan();


    }*/
    public void escanear() {
        IntentIntegrator intent = new IntentIntegrator(this);
        intent.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intent.setPrompt("ESCANEAR CODIGO");
        intent.setCameraId(0);
        intent.setOrientationLocked(false);
        intent.setBeepEnabled(false);
        intent.setCaptureActivity(CaptureActivityPortrait.class);
        intent.setBarcodeImageEnabled(false);
        intent.initiateScan();
    }
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null){
            if (result.getContents() == null){
                Toast.makeText(this, "cancelaste", Toast.LENGTH_LONG);
            }else {
                Log.e(MainActivity.class.getSimpleName(),"error es nulo");
                etcodigo.setText(result.getContents().toString());
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(MainActivity.this, "Cancelaste el escaneo", Toast.LENGTH_SHORT).show();
            } else {
                etcodigo.setText(result.getContents().toString());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
