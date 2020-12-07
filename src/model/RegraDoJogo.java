package model;

public class RegraDoJogo {
    protected Jogador ganhador;

    public boolean alguemGanhou(Tabuleiro tab) {
        boolean retorno = false;
        for(Jogador jog : tab.getJogadores()) {
            if (jog.getPosicaoAtual() >= tab.getQtdCasas()) {
                retorno = true;
                ganhador  =jog;
            }
        }
        return retorno;
    }
    public Jogador quemGanhou() {

        return ganhador;
    }
}