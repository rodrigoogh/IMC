package appuss.com.br.imc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by morgan on 8/9/17.
 */

public class ResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView tvResultado = findViewById(R.id.tvResultado);
        TextView tvDescricao = findViewById(R.id.tvDescricao);
        ImageView ivImagem = findViewById(R.id.ivImagem);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        Bundle bundle = getIntent().getExtras();
        IMC imc = (IMC) bundle.getSerializable("imc");
        tvResultado.setText(imc.calcular());

        if(imc.getIndice() == 1){
            if(imc.isSexo()){
                ivImagem.setImageResource(R.drawable.m1);
            } else {
                ivImagem.setImageResource(R.drawable.f1);
            }

            tvDescricao.setText(R.string.i1);

        } else if(imc.getIndice() == 2){
            if(imc.isSexo()){
                ivImagem.setImageResource(R.drawable.m2);
            } else {
                ivImagem.setImageResource(R.drawable.f2);
            }

            tvDescricao.setText(R.string.i2);

        } else if(imc.getIndice() == 3){
            if(imc.isSexo()){
                ivImagem.setImageResource(R.drawable.m3);
            } else {
                ivImagem.setImageResource(R.drawable.f3);
            }

            tvDescricao.setText(R.string.i3);

        } else if(imc.getIndice() == 4){
            if(imc.isSexo()){
                ivImagem.setImageResource(R.drawable.m4);
            } else {
                ivImagem.setImageResource(R.drawable.f4);
            }

            tvDescricao.setText(R.string.i4);
        }else if(imc.getIndice() == 5){
            if(imc.isSexo()){
                ivImagem.setImageResource(R.drawable.m5);
            } else {
                ivImagem.setImageResource(R.drawable.f5);
            }

            tvDescricao.setText(R.string.i5);
        } else if(imc.getIndice() == 6){
            if(imc.isSexo()){
                ivImagem.setImageResource(R.drawable.m6);
            } else {
                ivImagem.setImageResource(R.drawable.f6);
            }

            tvDescricao.setText(R.string.i6);
        } else {
            if(imc.isSexo()){
                ivImagem.setImageResource(R.drawable.m7);
            } else {
                ivImagem.setImageResource(R.drawable.f7);
            }

            tvDescricao.setText(R.string.i7);
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
