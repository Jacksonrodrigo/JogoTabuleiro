package view;

import model.Jogador;

public class Teste {
    public static void main(String[] args) {
        /*
        Jogador[] a = {new Jogador("Jean"), new Jogador("fulano"), null};
        for(int i = -2; i <= 4; i++) {
            try {
                System.out.println(a[i].getNome());
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("ocorreu uma exceção! indice do array inexistente "+ex.getMessage());
            } catch (NullPointerException ex1) {
                System.out.println("o elemento "+i+" é nulo.");
            }
        }
        */
        JogoController.iniciarJogo();
    }
}
