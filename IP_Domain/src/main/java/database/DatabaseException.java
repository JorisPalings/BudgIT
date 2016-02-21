package database;

/**
 * @author Joris
 */
public class DatabaseException extends RuntimeException {
    
    public DatabaseException() {
        super();
    }
    
    public DatabaseException(String message) {
        super(message);
    }
    
    public DatabaseException(Throwable throwable) {
        super(throwable);
    }
    
    public DatabaseException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
