package model;

import java.util.Random;

public class Dado {
    private int lados = 6;

    public Dado() {
    }

    public Dado(int lados) {
        this.lados = lados;
    }

    public int jogar() {
        Random rand = new Random();
        return rand.nextInt(this.lados) + 1;
    }

}