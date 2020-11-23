package model;

import  exception.TabuleiroExcep;
import model.InterfaceCasa;
public class Casa {
    private String id;
    private String tipoCasa;
    private String param;
    protected InterfaceCasa comportamento;

    /**
     * Construtor vazio da classe Casa
     */
    public Casa() {
    }

    /**
     * Construtor da Classe Casa
     *
     * @param id identificador da classe
     * @param nomeCasa nome da casa
     * @param parametro parametro que a casa executa
     */
    public Casa(String id, String tipoCasa, String param) {
        this.tipoCasa = tipoCasa;
        this.id = id;
        this.param = param;
    }

    /**
     * getComportamento()
     *
     * @return o comportamento da casa
     */
    public String getComportamento() throws TabuleiroExcep {
        return comportamento.getComportamento();
    }

    /**
     * setComportamento
     *
     * @param comportamento Interface que tem a estratégia da casa
     */
    public void setComportamento( InterfaceCasa comportamento) {
        this.comportamento = comportamento;
    }

    /**
     * getId()
     *
     * @return id da casa
     */
    public String getId() {
        return id;
    }

    /**
     * getParam()
     *
     * @return o parametro que a casa vai executar
     */
    public String getParam() {
        return param;
    }

    /**
     * getTipoCasa
     *
     * @return tipo da casa
     */
    public String getTipoCasa() {
        return tipoCasa;
    }
}