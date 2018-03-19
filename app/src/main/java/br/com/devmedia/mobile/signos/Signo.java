package br.com.devmedia.mobile.signos;
import java.io.Serializable; /* Classe responsavel pela transferencia(trafego) de objetos entre telas  */

/**
 * Created by Leandro on 18/03/2018.
 */

public class Signo implements Serializable /* Classe Signo herda caracteristicas da interface Serializable */
{
    //Atributos da classe
    private int diaInicio;
    private int diaFim;

    private int mesInicio;
    private int mesFim;

    private String nome;
    private String imagem;

    public Signo() // Ao usar a interface Serializable é necessario criar um metodo construtor vazio = REGRA
    {

    }

    public Signo(int diaInicio, int mesInicio, int diaFim, int mesFim, String nome, String imagem) /* Metodo Construtor: com seus respectivos parametros*/
    {
        /* Auto referencia  aos atributos declarados da classe que receberam o valor inseridos aao chamar o metodo */
        this.diaInicio = diaInicio;
        this.diaFim = diaFim;

        this.mesInicio = mesInicio;
        this.mesFim = mesFim;

        this.nome = nome;
        this.imagem = imagem;
    }


    public int getDiaInicio() {
        return diaInicio;
    }

    public int getDiaFim() {
        return diaFim;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public int getMesFim() {
        return mesFim;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }
}
