package exception;

public class JogarExcep extends Exception {

    /**
     * Construtor que recebe uma Exception como parâmetro
     *
     * @param cause Exception
     */
    public JogarExcep(Throwable cause) {
        super(cause);
    }

    /**
     * Construtor que recebe como parâmetro uma Exception e uma mensagem
     *
     * @param message mensagem da exceção
     * @param cause   Exception
     */
    public JogarExcep(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Construtor que recebe como parametro uma mensagem
     *
     * @param message mensagem da exceção
     */
    public JogarExcep(String message) {
        super(message);
    }
}