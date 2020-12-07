package model;

import java.util.Random;

public class CasaAzar extends Casa {
    private int incremento;

    public CasaAzar() {

        Random rand = new Random();
        this.incremento = rand.nextInt(6) + 1;

    }
    public String getDescricao() {
        String retorno  = "pouco AZAR";
        if (incremento > 4) {
            retorno = "Muito AZAR";
        } else {
            if (incremento > 2) {
                retorno = "AZAR";
            }
        }
        return retorno;
    }
    public int getIncremento() {
        return incremento * -1;
    }
    @Override
    public String toString(){
        return "Casa de Azar: retorne "+incremento+" posições";
    }

}
