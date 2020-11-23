package model;

import java.util.Random;

public class CasaSorte implements Casa{
    private int incremento;
    public CasaSorte() {
        Random rand = new Random();
        this.incremento = rand.nextInt(6) + 1;
    }

    public int getIncremento() {
        return incremento;
    }
    @Override
    public String toString(){
        return "Casa de Sorte: avance "+incremento+" posições";
    }
}
