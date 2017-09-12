package appuss.com.br.imc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView etPeso = findViewById(R.id.etPeso);
        final TextView etAltura = findViewById(R.id.etAltura);
        final Button btnLimpar = findViewById(R.id.btnLimpar);
        final Button btnCalcular = findViewById(R.id.btnCalcular);
        final Spinner sSexo = findViewById(R.id.sSexo);
        final IMC imc = new IMC();

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.sexo,
                android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sSexo.setAdapter(arrayAdapter);

        etPeso.setText("0.0");
        etAltura.setText("0.0");

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etPeso.setText("0.0");
                etAltura.setText("0.0");
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean error = false;

                if(!TextUtils.isEmpty(etPeso.getText().toString()) && Float.valueOf(etPeso.getText().toString()) > 0){
                    imc.setPeso(Float.valueOf(etPeso.getText().toString()));
                } else {
                    error = true;
                    etPeso.setError("Preencha com seu peso em kg");
                }

                if(!TextUtils.isEmpty(etAltura.getText().toString()) && Float.valueOf(etAltura.getText().toString()) > 0){
                    imc.setAltura(Float.valueOf(etAltura.getText().toString()));
                } else {
                    error = true;
                    etAltura.setError("Preencha com sua altura em metros");
                }

                if(sSexo.getSelectedItemPosition() == 0){
                    imc.setSexo(true);
                } else {
                    imc.setSexo(false);
                }

                if(!error) {
                    Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
                    intent.putExtra("imc", imc);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
