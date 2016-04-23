package database;

/**
 * @author Joris
 */
public class DatabaseFactory {
    
    public Database createDatabase(String databaseType) {
        Database db = null;
        switch(databaseType) {
            case("Memory"):
                db = new MemoryDatabase();
                break;
            case("Relational"):
                db = new RelationalDatabase("CategoryPU");
                break;
            default:
                break;
        }
        if(db == null) {
            throw new DatabaseException("Invalid database type '" + databaseType + "'");
        }
        return db;
    }

}
