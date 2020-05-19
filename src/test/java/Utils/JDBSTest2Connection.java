package Utils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBSTest2Connection {
    public static void main(String[] args) throws SQLException {
        DBUtils.establishConnection();
        List<Map<String ,Object>> queryResult=DBUtils.runQuery("Select first_name, last_name, salary from employees");
        System.out.println(queryResult.get(0).get("LAST_NAME"));

        DBUtils.closeConnection();
        DBUtils.establishConnection();
        List<Map<String ,Object>> queryResult2=DBUtils.runQuery("Select first_name, last_name, salary from employees");
        System.out.println(DBUtils.getRowsNumber("select first_name from employees"));
    }
}
