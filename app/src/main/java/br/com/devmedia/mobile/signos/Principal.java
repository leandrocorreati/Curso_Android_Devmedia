package br.com.devmedia.mobile.signos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Principal extends AppCompatActivity
{
    /* As variaveis abaixo servirão para armazenar o dia e o mês escolhidos o spinner(vetor) -
    OBS: variaveis do tipo private(privada), só poderam ser vistas dentro da classe na qual foram declaradas  */

    private Spinner spinnerDia = null;
    private Spinner spinnerMes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        /* A classe R permite acessar os elementos do xml na classe Java, ela serve como um intermediador entre o Java e XML */
        spinnerDia = (Spinner) findViewById(R.id.spinnerDia);
        spinnerMes = (Spinner) findViewById(R.id.spinnerMes);

        /* O "ArrayAdapter" serve para pegar os dados de um vetor(array), o ArrayAdapter irá pegar os dados dos vetores xml: dias e meses.
            note que a classe R está fazendo o intermedio entre o Java e o XML */
        ArrayAdapter<CharSequence>adapter_dia = ArrayAdapter.createFromResource
                (this,R.array.dias,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence>adapter_mes = ArrayAdapter.createFromResource
                (this,R.array.meses,android.R.layout.simple_spinner_item);

        /* Especifica o tipo de dropdown que irá ser usado ( o tipo de spinner ) */
        adapter_dia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_mes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        /* Aqui as variaveis spinnerDia e spinnerMes recebem os valores escolhidos, através do
         método "setAdapter" que recebe como parametro o valor pego no leitor de vetores que é o ArrayAdapter lá em cima */
        spinnerDia.setAdapter(adapter_dia);
        spinnerMes.setAdapter(adapter_mes);
    }
}
