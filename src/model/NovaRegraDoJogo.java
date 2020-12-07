package model;

public class NovaRegraDoJogo extends RegraDoJogo{

    @Override
    public boolean alguemGanhou(Tabuleiro tab) {
        boolean retorno = super.alguemGanhou(tab);
        if (!retorno) {
            for (Jogador jog : tab.getJogadores()) {

                // troquei pelo super()
                //if (jog.getPosicaoAtual() >= tab.getQtdCasas()) {
                //    retorno = true;
                //    ganhador  =jog;
                //}
                //if (jog.getPosicaoAtual() % 3 == 0) {
                if (jog.getPosicaoAtual()  == 8) {
                    retorno = true;
                    ganhador = jog;
                }
            }
        }
        return retorno;
    }
}
