package package01.exception;

public class TransactionException extends Exception {
    private static final long serialVersionUID = -1050820986758443882L;

    public TransactionException(String message) {
        super(message);
    }
}
