package controller;

import java.util.ArrayList;
import java.util.List;
import  exception.JogarExcep;
import exception.TabuleiroExcep;
import model.Casa;

public class Tabuleiro {

    private List<Casa> casas;

    /**
     * Construtor tabuleiro inicializando a lista de casas.
     */
    public Tabuleiro() {
        casas = new ArrayList<Casa>();
    }

    /**
     * Método responsável por adicionar as casas no tabuleiro.
     *
     * @param casa Casa
     * @throws JogarExcep Lança um exceção caso a casa não esteja 
     * atendendo as regras compostas na especificação.
     */
    public void adicionaCasa(Casa casa) throws JogarExcep {
        // Se o id igual a null ou vazio lança Exceção
        if (casa.getId() == null || casa.getId().equals("")) {
            throw new JogarExcep ("ID Invalido: '" + casa.getId() + "'");
        }
        // Se existe id duplicado lança Ecxeção
        if (isDuplicate(casa.getId())) {
            throw new JogarExcep("Ja existe uma casa com ID '"
                    + casa.getId() + "'");
        }
        // Se tipo de Casa igual a null ou vazio lança Exceção
        if (casa.getTipoCasa() == null || casa.getTipoCasa().equals("")) {
            throw new JogarExcep("Tipo de casa invalido: '"
                    + casa.getTipoCasa() + "'");
        }
        // Se tipo de casa não for um dos oito tipos válidos lança Exceção
        if (casaInvalida(casa.getTipoCasa())) {
            throw new JogarExcep("Tipo de casa invalido: '"
                    + casa.getTipoCasa() + "'");
        }
        /* Se o tipo da casa igual a VOLTA, verifica se
        o parametro passado é um inteiro válido.*/
        if (casa.getTipoCasa().equals("VOLTA")) {
            verificaInteiroVolta(casa.getParam());
        }
        /* Se o tipo da casa igual a AVANCA, verifica se
        o parametro passado é um inteiro válido.*/
        if (casa.getTipoCasa().equals("AVANCA")) {
            verificaInteiroAvanca(casa.getParam());
        }
        /*Se o parametro da casa IR_PARA igual a null ou vazio lança Exceção, se
         * o parametro da casa não corresponder a um id válido no jogo, tambem
         * lança uma Exceção */
        if (casa.getTipoCasa().equals("IR_PARA")) {
            idCasaValido(casa.getParam());
            if (!idExiste(casa.getParam())) {
                throw new JogarExcep("Nao existe casa com id '"
                        + casa.getParam() + "'");
            }
        }

        // Adiciona a casa
        casas.add(casa);
    }

    /**
     * getTamanhoTabuleiro retorna o tamanho do tabuleiro.
     * @return quantidade de casas que o tabuleiro tem.
     */
    public int getTamanhoTabuleiro() {
        return casas.size();
    }

    /**
     * Método para verificar se existe id duplicado.
     *
     * @param id identificador da casa
     * @return verdadeiro se ja existir casa com aquele id e falso se não.
     */
    public boolean isDuplicate(String id) {
        boolean retorno = false;
        for (Casa casa : casas) {
            if (casa.getId().equals(id)) {
                retorno = true;
            }
        }
        return retorno;
    }

    /**
     * Método para verificar se o inteiro da casa VOLTA é válido.
     *
     * @param param parametro da casa, onde tem que ser um inteiro válido de 
     * casas para avançar.
     * @throws TabuleiroException lança exceção se o parametro não for um número 
     */
    public void verificaInteiroVolta(String param) throws TabuleiroExcep {
        try {
            Integer.parseInt(param);
        } catch (NumberFormatException ex) {
            throw new TabuleiroExcep("Numero de casas para voltar invalido: "
                    + "'" + param + "'", ex);
        }
    }

    /**
     * Método para verificar se o inteiro da casa AVANCA é válido.
     *
     * @param param parametro da casa, onde tem que ser um inteiro válido de 
     * casas para avançar.
     * @throws TabuleiroException lança exceção se o parametro não for um número 
     */
    public void verificaInteiroAvanca(String param) throws TabuleiroExcep {
        try {
            Integer.parseInt(param);
        } catch (NumberFormatException ex) {
            throw new TabuleiroExcep("Numero de casas para avancar invalido:"
                    + " '" + param + "'", ex);
        }
    }

    /**
     * Método para verificar se o parametro da casa IR_PARA é um id de casa
     * válido no jogo.
     *
     * @param id identificador da casa.
     * @throws TabuleiroException lança exceção se o id igual a null ou vazio.
     */
    public void idCasaValido(String id) throws TabuleiroExcep {
        if (id == null || id.equals("")) {
            throw new TabuleiroExcep("ID de casa invalido: '" + id + "'");
        }
    }

    /**
     * Método que verifica se o identificador passado é válido entre as casas.
     *
     * @param id identificador da casa.
     * @return verdadeiro se o id é válido e falso se não for válido.
     */
    public boolean idExiste(String id) {
        boolean retorno = false;
        for (Casa casa : casas) {
            if (id.equals(casa.getId())) {
                retorno = true;
            }
        }
        return retorno;
    }

    /**
     * Método que verifica os tipos de casas invalido
     *
     * @param tipoCasa tipo da casa.
     * @return verdadeiro se a casa é inválida e falso se a casa é válida,
     * ou seja, não é um dos tipos abaixo.
     * @throws TabuleiroException lança exceção se não for nenhum dos tipos
     * de casa abaixo.
     */
    public boolean casaInvalida(String tipoCasa) throws TabuleiroExcep {
        boolean retorno = false;
        if (!tipoCasa.equals("INICIO")
                && !tipoCasa.equals("REPETE")
                && !tipoCasa.equals("NADA")
                && !tipoCasa.equals("PARA")
                && !tipoCasa.equals("VOLTA")
                && !tipoCasa.equals("AVANCA")
                && !tipoCasa.equals("IR_PARA")
                && !tipoCasa.equals("FIM")) {
            retorno = true;
            throw new TabuleiroExcep("Tipo de casa invalido: '" + tipoCasa
                    + "'");
        }
        return retorno;
    }

    /**
     * Método de acesso a lista de casas
     *
     * @return lista de casas adicionadas.
     */
    public List<Casa> getCasas() {
        return casas;
    }
}

