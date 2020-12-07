package view;

import model.Tabuleiro;

import java.util.Observable;
import java.util.Observer;

public class TabuleiroView implements Observer {
    private Tabuleiro tabuleiro;
    public TabuleiroView(Tabuleiro tab) {
        this.tabuleiro = tab;
    }
    public void showSituacaoAtual(Tabuleiro tab){
        for (int i = 0; i < tab.getQtdCasas(); i++) {
            //if (tab.getCasaOcupada(i) != null) {
            //    System.out.println("casa "+i+": "+tab.getCasaOcupada(i)+" ->"+tab.getJogadoresCasa(i));
            //}
            if (tab.getCasaOcupada(i) != null) {
                CasaView.desenhaCasa(tab.getCasa(i), tab.getJogadoresCasa(i));
            }
        }
        System.out.println("============");

    }


    @Override
    public void update(Observable o, Object arg) {
        this.showSituacaoAtual(this.tabuleiro);
    }
}