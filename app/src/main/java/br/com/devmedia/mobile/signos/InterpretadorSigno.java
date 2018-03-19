package br.com.devmedia.mobile.signos;
import java.util.ArrayList; //Classe ArrayList
/**
 * Created by Leandro on 18/03/2018.
 */

public class InterpretadorSigno /* Classe para interpretar qual é o signo do usuário com base nos valores definidos por ele */
{
    private ArrayList<Signo> signos = new ArrayList<Signo>() /* Criando(instanciando) um objeto da classe ArrrayList,
                                                                que inseri valor nos parametros do metodo construtor da classe Signo
                                                                O vetor 'signos' é criado com a chamada do metodo construtor e com seus valores passados
                                                                para seus parametros*/

    {{ //INICIO - DOUBLE BRACKET INITIALIZATION
        add(new Signo(20, 1, 18, 2, "Aquário", "@drawable/aquario"));
        add(new Signo(19, 2, 20, 3, "Peixes", "@drawable/aquario"));
        add(new Signo(21, 3, 19, 4, "Aries", "@drawable/aquario"));
        add(new Signo(20, 4, 20, 5, "Touro", "@drawable/aquario"));
        add(new Signo(21, 5, 20, 6, "Gemeos", "@drawable/aquario"));
        add(new Signo(21, 6, 22, 7, "Cancêr", "@drawable/aquario"));
        add(new Signo(23, 7, 22, 8, "Leão", "@drawable/aquario"));
        add(new Signo(23, 8, 22, 9, "Virgem", "@drawable/aquario"));
        add(new Signo(23, 9, 22, 10, "Libra", "@drawable/aquario"));
        add(new Signo(23, 10, 21, 11, "Escorpião", "@drawable/aquario"));
        add(new Signo(22, 11, 21, 12, "Sagitario", "@drawable/aquario"));
        add(new Signo(22, 12, 19, 1, "Capricornio", "@drawable/aquario"));
    }};//FIM - DOUBLE BRACKET INITIALIZATION

    public Signo interpretador(int dia, int mes)// Metodo do tipo Signo, que irá ser chamado para que o usuário passe o dia e mes de nascimento
    {
        Signo signo = null; // Variavel 'signo' do tipo Signo que guarda o resultado do signo, após passar pela estrutura da condição abaixo
        for (Signo s : signos) // FOREACH QUE PERCORRE O VETOR "signos", dentro do for é declarada a variavel 's' do tipo Signo -
                                // OBS: os dois pontos são usados quando se deseja fazer um for em um objeto do tipo vetor

        {
            if (s.getMesInicio() == mes && dia >= s.getDiaInicio())  /*     's' chama os metodos acessores de sua classe,
                                                                            e faz a comparação do que foi passado pelo usuario
                                                                            com os parametros já inseridos pelo metodo ArrayList signos  */
            {
                signo = s; // 's' passa deu valor para variavel signo, que a responsavel pelo aramazenament oda informação
                break;
            }
            else if(s.getMesFim() == mes && dia <= s.getDiaFim())
            {
                signo = s;
            }
        }
        return signo;
    }

}
