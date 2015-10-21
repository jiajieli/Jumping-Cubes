package db61b;
import static org.junit.Assert.*;
import org.junit.Test;
/**For UnitTesting
 * @author Jiajie Li*/



public class UnitTests {
    @Test
    public void testDatabase() {
        Database db = new Database();
        String[] colNames = {"ele1", "ele2"};
        Table t1 = new Table(colNames);
        db.put("table1", t1);
        assertEquals(db.get("table1") == t1, true);
    }
    @Test
    public void testColumn()  {
        Database db = new Database();
        String[] colNames = {"ele1", "ele2"};
        Table t1 = new Table(colNames);
        String[] data = {"a", "b"};
        Row row = new Row(data);
        t1.add(row);
        Column col1 = new Column("ele1", t1);
        assertEquals(col1.getName(), "ele1");
        assertEquals(col1.getFrom(row), "a");
    }


    @Test
    public void testCondition()  {
        Database db = new Database();
        String[] colNames = {"ele1", "ele2"};
        Table t1 = new Table(colNames);
        String[] data = {"a", "b"};
        Row row = new Row(data);
        t1.add(row);
        Column col1 = new Column("ele2", t1);
        Condition cond = new Condition(col1, "=", "b");
        assertEquals(cond.test(row), true);
    }
    @Test
    public void testRow()  {
        Database db = new Database();
        String[] colNames = {"ele1", "ele2"};
        Table t1 = new Table(colNames);
        String[] data = {"a", "b"};
        Row row = new Row(data);
        t1.add(row);
        Column col1 = new Column("ele2", t1);
        Condition cond = new Condition(col1, "=", "Beijing");
        assertEquals(row.equals(row), true);
        assertEquals(row.get(0), "a");
        assertEquals(row.size(), 2);
    }
    @Test
    public void testTable()  {
        Database db = new Database();
        String[] colNames = {"ele1", "ele2"};
        Table t1 = new Table(colNames);
        String[] data = {"a", "b"};
        Row row = new Row(data);
        t1.add(row);
        assertEquals(t1.findColumn("ele2"), 1);
        assertEquals(t1.getTitle(0).equals("ele1"), true);
    }
    /* Run the unit tests in this file. */
    public static void main(String... args) {
        System.exit(ucb.junit.textui.runClasses(UnitTests.class));
    }
}
