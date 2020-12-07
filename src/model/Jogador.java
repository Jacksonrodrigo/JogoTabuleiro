package model;

import java.util.Observable;

public class Jogador extends Observable {
    private String nome;
    private int posicaoAtual;

    public Jogador(String nome) {
        this.nome = nome;
        this.posicaoAtual = -1;
    }

    public String getNome() {
        return nome;
    }

    public int getPosicaoAtual() {
        return posicaoAtual;
    }
    public void avanca(int qtd) {
        this.posicaoAtual += qtd;
        this.setChanged();
        this.notifyObservers();
    }

    @Override
    public String toString() {

        return "Jogador: "+nome;
    }



}
