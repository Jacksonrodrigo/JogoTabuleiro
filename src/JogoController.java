import model.*;
import view.JogoView;
import view.TabuleiroView;

import java.util.Observable;
import java.util.Observer;

public class JogoController implements Observer{

    private static JogoController instancia;

    private int qtdJogadores;
    private Tabuleiro tabuleiro;
    private int jogadorAtual = 0;
    private boolean finalizado = false;
    private TabuleiroView tbv;
    private JogoView jgv;
    private RegraDoJogo regra;


    private JogoController() {
        //regra =  new RegraDoJogo();
        regra =  new NovaRegraDoJogo();
    }
    public static JogoController getInstance() {
        if (instancia == null) {
            instancia = new JogoController();
        }
        return instancia;
    }
    public void iniciarJogo() {
        tabuleiro = new Tabuleiro(10,20,20);
        tbv = new TabuleiroView(tabuleiro);
        jgv = new JogoView();
        qtdJogadores = JogoView.intQtdJogadores(2, 6);
        registrarJogadores();

        while(! finalizado) {
            iniciarJogada();
            JogoView.continuar();
            proximoJogador();
            //tbv.showSituacaoAtual(tabuleiro);
        }

    }
    private void proximoJogador() {
        jogadorAtual++;
        if(jogadorAtual == qtdJogadores) {
            jogadorAtual = 0;
        }
    }
    public void registrarJogadores() {
        for (int i = 1; i <= qtdJogadores; i++) {
            String n = JogoView.InformeJogador(i);
            try {
                Jogador j = new Jogador(n);
                tabuleiro.addJogador(j);
                j.addObserver(tbv);
                j.addObserver(jgv);
                j.addObserver(JogoController.getInstance());


            } catch (MuitosJogadoresException e) {
                e.printStackTrace();
            }
        }
    }
    private void iniciarJogada() {
        JogoView.mostraJogadorAtual(tabuleiro.getJogadores().get(jogadorAtual));
        Dado d = new Dado();
        tabuleiro.getJogadores().get(jogadorAtual).avanca(d.jogar());

    }

    public void iniciarJogoOld() {
        Tabuleiro tab = new Tabuleiro(10,20,20);
        try {

            tab.addJogador(new Jogador("Jackson1"));
            tab.addJogador(new Jogador("Jackson2"));
            Jogador a = null;
            try {
                a.getNome();
            } catch (NullPointerException e) {
                System.out.println("ops, tu tentou usar um null como jogador");
            }

            tab.addJogador(new Jogador("Jackson3"));
            tab.addJogador(new Jogador("Jackson4"));
            tab.addJogador(new Jogador("Jackson5"));

            tab.addJogador(new Jogador("Jackson6"));
            tab.addJogador(new Jogador("Jackson7"));
        } catch (MuitosJogadoresException e) {
            System.out.println(e.getMessage());
        }
        catch (NullPointerException e) {
            System.out.println("ops, tu tentou usar um null como jogador");
        }
        finally {
            System.out.println("depois de tudo");
        }
        for(int i = 0; i < tab.getJogadores().size(); i++) {
            System.out.println(tab.getJogadores().get(i));
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        if (regra.alguemGanhou(tabuleiro)) {
            finalizado = true;
            System.out.println(regra.quemGanhou().getNome()+" ganhou!!!");
        }
    }
}