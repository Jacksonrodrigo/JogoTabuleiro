package view;

import model.Tabuleiro;
import  model.CasaSorte;
import model.CasaAzar;

public class TabuleiroView {
    public static void showSituacaoAtual(Tabuleiro tab){
        for (int i = 0; i < tab.getQtdCasas(); i++) {
            //if (tab.getCasaOcupada(i) != null) {
            //    System.out.println("casa "+i+": "+tab.getCasaOcupada(i)+" ->"+tab.getJogadoresCasa(i));
            //}
            CasaView.desenhaCasa(tab.getCasa(i), tab.getJogadoresCasa(i));
        }
        System.out.println("============");
        JogoView.continuar();
    }
}
