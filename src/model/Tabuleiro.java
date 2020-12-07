package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tabuleiro  {
    private Casa[] casas;
    private List<Jogador> jogadores;
    //                     10            20             30
    public Tabuleiro(int qtdCasas, int percSorte, int percAzar) {
        this.jogadores = new ArrayList<>();
        this.casas = new Casa[qtdCasas];
        int qtdSorte = qtdCasas * percSorte / 100;
        int qtdAzar = qtdCasas * percAzar / 100;
        int i = 0;
        for ( ; i < (qtdCasas - qtdSorte - qtdAzar);  i++) {
            casas[i] = new CasaNeutra();

        }
        for (int x = 0; x < qtdSorte; x++) {
            casas[i] = new CasaSorte();
            i++;
        }
        for (int x = 0; x < qtdAzar; x++) {
            casas[i] = new CasaAzar();
            i++;
        }
        embaralhaCasas();

    }
    private void embaralhaCasas() {
        Random rand = new Random();
        for (int x = 0; x < this.casas.length; x++) {
            int pos1 = rand.nextInt(this.casas.length);
            int pos2 = rand.nextInt(this.casas.length);
            Casa temp = this.casas[pos1];
            this.casas[pos1] = this.casas[pos2];
            this.casas[pos2] = temp;
        }
        for (int x = 0; x < casas.length; x++) {
            this.casas[x].posicao = x + 1;
        }
    }
    public Casa getCasa(int pos) {
        return this.casas[pos];
    }
    public Casa getCasaOcupada(int pos) {
        Casa retorno = null;
        for(Jogador jog : jogadores) {
            if (jog.getPosicaoAtual() == pos) {
                retorno = this.casas[pos];
            }
        }
        return retorno;
    }
    public String getJogadoresCasa(int pos) {
        String retorno = "";
        for(Jogador jog : jogadores) {
            if (jog.getPosicaoAtual() == pos) {
                retorno += jog.getNome()+", ";
            }
        }
        return retorno;
    }
    public List<Jogador> getJogadores() {
        return jogadores;
    }
    public void addJogador(Jogador jog) throws MuitosJogadoresException {
        if (this.jogadores.size() == 6) {
            throw new MuitosJogadoresException();
        } else {
            this.jogadores.add(jog);
        }
    }
    public int getQtdCasas() {
        return this.casas.length;
    }
}
