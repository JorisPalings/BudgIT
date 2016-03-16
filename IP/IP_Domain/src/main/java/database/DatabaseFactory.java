package database;

/**
 * @author Joris
 */
public class DatabaseFactory {
    
    public Database createDatabase(String databaseType) {
        Database db = null;
        switch(databaseType) {
            case("Fake"):
                    db = new FakeDatabase();
                    break;
            case("Relational"):
                    db = new RelationalDatabase();
                    break;
            default:
                    break;
        }
        if(db == null) {
            throw new DatabaseException("Invalid database type");
        }
        return db;
    }

}
