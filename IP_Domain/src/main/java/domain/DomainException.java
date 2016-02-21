package domain;

/**
 * @author Joris
 */
public class DomainException extends RuntimeException {
    
    public DomainException() {
        super();
    }
    
    public DomainException(String message) {
        super(message);
    }
    
    public DomainException(Throwable throwable) {
        super(throwable);
    }
    
    public DomainException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
