package domain;

/**
 * @author Joris
 */
public enum Priority {
    
    LOW     ("Low"),
    MEDIUM  ("Medium"),
    HIGH    ("High"),
    TOP     ("Top");
    
    private String priorityName;
    
    Priority(String priorityName) {
        this.priorityName = priorityName;
    }
    
    public String getPriorityName() {
        return priorityName;
    }
    
}
