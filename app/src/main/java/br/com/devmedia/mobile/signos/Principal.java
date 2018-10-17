package br.com.devmedia.mobile.signos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Principal extends AppCompatActivity
{
    /* As variaveis abaixo servirão para armazenar o dia e o mês escolhidos o spinner(vetor) -
    OBS: variaveis do tipo private(privada), só poderam ser vistas dentro da classe na qual foram declaradas  */

    private Spinner spinnerDia = null;
    private Spinner spinnerMes = null;

    private void validarData()
    {
        int dia = spinnerDia.getSelectedItemPosition();
        int mes = spinnerMes.getSelectedItemPosition();
        dia++;
        mes++;
        if (dia > 29 && mes == 2)
        {
            spinnerDia.setSelection(28);
        }
        else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia > 30))
        {
            spinnerDia.setSelection(29);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        /* A classe R permite acessar os elementos do xml na classe Java, ela serve como um intermediador entre o Java e XML */
        spinnerDia = findViewById(R.id.spinnerDia);
        spinnerMes = findViewById(R.id.spinnerMes);

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

        // ----------------------------------------COMENTAR - AULA 22 ----------------------------------------
        spinnerDia.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener()
                {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                    {
                        validarData();
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent)
                    {

                    }
                }
        );
        // -----------------------------------------COMENTAR - AULA 22 ------------------------------------------




        Button enviar = (Button) findViewById(R.id.btnEnviar);//
        enviar.setOnClickListener(new View.OnClickListener()//
        {
            public void onClick(View view)
            {
                int posicaoDia = spinnerDia.getSelectedItemPosition(); //
                int posicaoMes = spinnerMes.getSelectedItemPosition();

                posicaoDia++;
                posicaoMes++;

                InterpretadorSigno Interpretador = new InterpretadorSigno();
                Signo signoResultado = Interpretador.interpretador(posicaoDia, posicaoMes);

                Bundle args = new Bundle();
                args.putSerializable("resultado", signoResultado);
                Intent intent = new Intent(Principal.this, Resultado.class);
                intent.putExtra("signo", args);
                startActivity(intent);

                /*Linha 45: instanciamos uma variável do tipo Button que fará referência ao elemento na parte visual (XML), possibilitando assim realizar a ação do clique com o método setOnClickListener;
                Linhas 46: definimos o método setOnClickListener, responsável por setar uma ação quando o botão for pressionado;
                Linhas 50: obtemos o índice selecionado nos spinners;
                Linhas 53 e 54: como os índices dos spinners começam a contar em 0, enquanto os dias e meses começam em 1, precisamos incrementar o valor obtido para que os índices sejam equivalentes;
                Linhas 56 e 57: instanciamos a classe InterpretadorSigno e invocamos o método interpretador, passando como argumento o dia e mês informados pelo usuário;
                Linhas 59 e 60: declaramos uma variável do tipo Bundle, utilizada para trafegar dados através das activities, e adicionamos nela o signo obtido;
                Linhas 61 e 62: instanciamos o objeto do tipo Intent, responsável por fazer a passagem de parâmetros entre activities, e adicionamos a ela o bundle criado anteriormente;
                Linha 63: iniciamos a activity de resultados passando o intent que contém o bundle com o signo.*/
            }
        });
    }
}
