package controller;

import exception.JogarExcep;
import java.util.LinkedList;
import java.util.List;

public class JogoController {

    private int tamanhoDado;
    private int numPecas;
    private Tabuleiro tabuleiro;
    private List<Integer> jogadores;

    /**
     * Construtor JogoLudo
     *
     * @param tamanhoDado representa o tamanho máximo que o dado pode ter.
     * @param numPecas representa a quantidade de jogadores que tem no jogo,
     * no mínimo 1 jogador.
     */
    public JogoController(int tamanhoDado, int numPecas) {
        this.tamanhoDado = tamanhoDado;
        this.numPecas = numPecas;
        tabuleiro = new Tabuleiro();
        jogadores = new LinkedList<Integer>();
    }

    /**
     * Método para iniciar o jogo, tem que ter no minimo um jogador.
     *
     */
    public void iniciarJogo() {
        for (int i = 1; i <= numPecas; i++) {
            jogadores.add(i);
        }
    }

    /**
     * Método para sair do Jogo
     *
     */
    public void sairJogo() {
    }

      public void jogar(int jogador, int dado) throws JogarExcep {
    }

    /**
     * getStatusJogo
     *
     * @return o estado atual do jogo.
     */
    public String getStatusJogo() {
        String retorno = "";
        for (int i = 0; i < numPecas; i++) {
            if (i == 0) {
                retorno += "J" + jogadores.get(i) + ":"
                        + tabuleiro.getCasas().iterator().next().getId();
            } else {
                retorno += "/J" + jogadores.get(i) + ":"
                        + tabuleiro.getCasas().iterator().next().getId();
            }

        }
        return retorno;
    }

    /**
     * getNumPecas()
     *
     * @return quantidade de peças(jogadores) que tem no jogo.
     */
    public int getNumPecas() {
        return numPecas;
    }

    /**
     * getTamanhoDado()
     *
     * @return tamanho do dado.
     */
    public int getTamanhoDado() {
        return tamanhoDado;
    }

    /**
     * getTabuleiro()
     *
     * @return a instancia do tabuleiro
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
