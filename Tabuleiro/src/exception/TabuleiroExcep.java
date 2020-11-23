package exception;

public class TabuleiroExcep extends Exception {

    /**
     * Construtor que recebe uma Exception como parâmetro 
     *
     * @param cause Exception
     */
    public TabuleiroExcep(Throwable cause) {
        super(cause);
    }

    /**
     * Construtor que recebe como parâmetro uma Exception e uma mensagem 
     *
     * @param message mensagem da exceção
     * @param cause Exception
     */
    public TabuleiroExcep(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construtor que recebe como parametro uma mensagem
     *
     * @param message mensagem da exceção
     */
    public TabuleiroExcep(String message) {
        super(message);
    }
}
