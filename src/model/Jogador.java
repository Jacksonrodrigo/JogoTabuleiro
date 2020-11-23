package model;

public class Jogador {
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
    }

    @Override
    public String toString() {
        return "Jogador: "+nome;
    }


}