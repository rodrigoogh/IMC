package appuss.com.br.imc;

import android.content.Context;
import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by morgan on 8/8/17.
 */

public class IMC implements Serializable {

    public float peso;
    public float altura;
    public int indice;
    public boolean sexo;

    public IMC() {
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getIndice() { return indice; }

    public void setIndice(int indice) { this.indice = indice; }

    public boolean isSexo() { return sexo; }

    public void setSexo(boolean sexo) { this.sexo = sexo; }

    public String calcular(){
        float imc = (float) (peso/Math.pow(altura, 2));

        if(sexo) {
            if (imc < 17) {
                this.setIndice(1);
                return "muito abaixo do peso";
            } else if (imc < 18.49) {
                this.setIndice(2);
                return "abaixo do peso";
            } else if (imc < 24.99) {
                this.setIndice(3);
                return "em seu peso normal";
            } else if (imc < 29.99) {
                this.setIndice(4);
                return "acima do peso";
            } else if (imc < 34.99) {
                this.setIndice(5);
                return "obeso";
            } else if (imc < 39.99) {
                this.setIndice(6);
                return "severamente obeso";
            } else {
                this.setIndice(7);
                return "morbidamente obeso";
            }

        } else {
            if (imc < 16) {
                this.setIndice(1);
                return "muito abaixo do peso";
            } else if (imc < 17.49) {
                this.setIndice(2);
                return "abaixo do peso";
            } else if (imc < 23.99) {
                this.setIndice(3);
                return "em seu peso normal";
            } else if (imc < 28.99) {
                this.setIndice(4);
                return "acima do peso";
            } else if (imc < 33.99) {
                this.setIndice(5);
                return "obeso";
            } else if (imc < 38.99) {
                this.setIndice(6);
                return "severamente obeso";
            } else {
                this.setIndice(7);
                return "morbidamente obeso";
            }
        }
    }
}
