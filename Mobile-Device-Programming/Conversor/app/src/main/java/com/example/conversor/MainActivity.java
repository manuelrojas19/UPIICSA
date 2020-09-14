package com.example.conversor;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.view.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
EditText txtOrg, txtDest;
RadioGroup radioGroup1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtOrg = (EditText)findViewById(R.id.txtOrg);
        txtDest = (EditText)findViewById(R.id.txtDest);
        radioGroup1 = (RadioGroup)findViewById(R.id.radioGroup1);
    }

    public void btnConvertir_click(View sender){
        String ent = txtOrg.getText().toString();
        if(this.radioGroup1.getCheckedRadioButtonId() == R.id.optBin){
            txtDest.setText(dec2bin(Integer.parseInt(ent)));
        }
        else if(this.radioGroup1.getCheckedRadioButtonId() == R.id.optDec){
            txtDest.setText(bin2dec(ent));
        }
        else if(this.radioGroup1.getCheckedRadioButtonId() == R.id.optDec2Oct){
            txtDest.setText(dec2oct(Integer.parseInt(ent)));
        }
        else if(this.radioGroup1.getCheckedRadioButtonId() == R.id.optOct2Dec){
            txtDest.setText(oct2dec((ent)));
        }
        else if(this.radioGroup1.getCheckedRadioButtonId() == R.id.optTrece){
            txtDest.setText(rotar(ent, 13));
        }
    }

    private String dec2oct(int decimal){
        String octal = Integer.toOctalString(decimal);
        return  octal;
    }

    private String oct2dec (String octal){
        int decimal = Integer.parseInt(octal, 8);
        String decimal1 = decimal+"";
        return decimal1;
    }

    private String dec2bin(int n)
    {
        String res = "";
        while(n != 0)
        {
            res = (n%2==0 ? "0" : "1") + res;
            n/=2;
        }
        return res;
    }

  /*  private int bin2dec(int b)
    {
        int c = 1, d =0, p = 0;
        while (b>0)
        {
            p = 0;
            p = c*(b%10);
            d+=p;
            c*=2;
            b/=10;
        }
        return d;
    }*/

    /*private String trece(String s){
        String res;  //arbol ---> neoby
        String p1 = " abcdefghijklm";
        String p2 = " nopqrstuvwxyz";

        for (int i= 0,j = 0; i<=13; i++){

            if (p1[i] == s[j]){
                res += p2[i];
                j++;
                i=0;
            }
            if (p2[i] == s[j]){
                res += p1[i];
                j++;
                i=0;
            }
            ;

        }
        return res;
    }*/

   private int bin2dec(String s)
    {
        int res=0, i=s.length()-1;
        for(char c : s.toCharArray())
        {
            res = (int) (res + Math.pow(2, i)*(c=='0' ? 0 : 1));
            i--;
        }
        return res;
    }

    public String rotar(String cadenaOriginal, int rotaciones) {
        // En ASCII, la a es 97, b 98, A 65, B 66, etcétera
        final int LONGITUD_ALFABETO = 26, INICIO_MINUSCULAS = 97, INICIO_MAYUSCULAS = 65;
        String cadenaRotada = ""; // La cadena nueva, la que estará rotada
        for (int x = 0; x < cadenaOriginal.length(); x++) {
            char caracterActual = cadenaOriginal.charAt(x);
            // Si no es una letra del alfabeto entonces ponemos el char tal y como está
            // y pasamos a la siguiente iteración
            if (!Character.isLetter(caracterActual)) {
                cadenaRotada += caracterActual;
                continue;
            }

            int codigoAsciiDeCaracterActual = (int) caracterActual;
            boolean esMayuscula = Character.isUpperCase(caracterActual);

            // La posición (1 a 26) que ocupará la letra después de ser rotada
            // El % LONGITUD_ALFABETO se utiliza por si se pasa de 26. Por ejemplo,
            // la "z", al ser rotada una vez da el valor de 27, pero en realidad debería
            // regresar a la letra "a", y con mod hacemos eso ya que 27 % 26 == 1,
            // 28 % 26 == 2, etcétera ;)
            int nuevaPosicionEnAlfabeto = ((codigoAsciiDeCaracterActual
                    - (esMayuscula ? INICIO_MAYUSCULAS : INICIO_MINUSCULAS)) + rotaciones) % LONGITUD_ALFABETO;
            // Arreglar rotaciones negativas
            if (nuevaPosicionEnAlfabeto < 0)
                nuevaPosicionEnAlfabeto += LONGITUD_ALFABETO;
            int nuevaPosicionAscii = (esMayuscula ? INICIO_MAYUSCULAS : INICIO_MINUSCULAS) + nuevaPosicionEnAlfabeto;
            // Convertir el código ASCII numérico a su representación como símbolo o letra y
            // concatenar
            cadenaRotada += Character.toString((char) nuevaPosicionAscii);
        }
        return cadenaRotada;
    }



}

