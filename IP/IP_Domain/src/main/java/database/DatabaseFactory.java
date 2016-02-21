package database;

import database.Database;
import database.StubDatabase;

/**
 * @author Joris
 */
public class DatabaseFactory {
    
    public Database createDatabase(String databaseType) {
        if(databaseType == null || databaseType.trim().equals("")) {
            throw new DatabaseException("DatabaseType is null or an empty String");
        }
        Database database = null;
        switch(databaseType) {
            case("Stub"):
                    database = new StubDatabase();
                    break;
            case("Relational"):
                    database = new RelationalDatabase();
                    break;
            default:
                    break;
        }
        return database;
    }

}
