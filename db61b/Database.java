package db61b;

import java.util.HashMap;
import static db61b.Utils.*;

/** A collection of Tables, indexed by name.
 *  @author Jiajie Li*/
class Database {
    /** An empty database. */
    public Database() {
        _tableMaps.clear();
    }

    /** Return the Table whose name is NAME stored in this database, or null
     *  if there is no such table. */
    public Table get(String name) {
        if (!_tableMaps.containsKey(name)) {
            throw error("invalid name for table");
        } else {
            return _tableMaps.get(name);
        }
    }

    /** Set or replace the table named NAME in THIS to TABLE.  TABLE and
     *  NAME must not be null, and NAME must be a valid name for a table. */
    public void put(String name, Table table) {
        if (name == null || table == null) {
            throw new IllegalArgumentException("null argument");
        }
        _tableMaps.put(name, table);
    }

    /** Private field for hashmap. */
    private HashMap<String, Table> _tableMaps = new HashMap<>();
}
