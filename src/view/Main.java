package view;

import model.*;
import view.JogoController;
import view.TabuleiroView;

public class Main {
    public static void main(String[] args) {
        JogoController.iniciarJogo();
        /*
        Dado dado = new Dado();


        Tabuleiro tab = new Tabuleiro(50, 20, 20);

        //int pos = -1;
        Jogador jog1 = new Jogador("Jogador número 1");
        Jogador jog2 = new Jogador("Jogador número 2");
        try {
            tab.addJogador(jog1);
            tab.addJogador(jog2);

        } catch (MuitosJogadoresException e) {
            e.printStackTrace();
        }
        jog1.avanca(dado.jogar());
        jog2.avanca(dado.jogar());

        TabuleiroView.showSituacaoAtual(tab);
/*        for(int i = 0; i < 50; i ++) {
            System.out.println(tab.getCasa(i));
        }

        int pos = -1;
        Jogador jog1 = new Jogador("Jogador número 1");
        Jogador jog2 = new Jogador("Jogador número 2");
        //tab.addJogador(jog1);
        //tab.addJogador(jog2);
        for(int i = 0; i < 10; i++) {
            jog1.avanca(dado.jogar());
            TabuleiroView.showSituacaoAtual(tab);
            jog2.avanca(dado.jogar());
            TabuleiroView.showSituacaoAtual(tab);
        }
        for (int i = 0; i < 10; i++) {
            pos += dado.jogar();
            if (tab.getCasa(pos) instanceof CasaAzar) {
                System.out.println("deu ruim !");
            }
            if (tab.getCasa(pos) instanceof CasaSorte) {
                System.out.println("deu bom !");
            }
            System.out.println(tab.getCasa(pos).getIncremento()+ " posições");
            pos += tab.getCasa(pos).getIncremento();

            System.out.println(tab.getCasa(pos));
        }
*/

    }
}