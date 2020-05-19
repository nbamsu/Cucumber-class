package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@techotrialdb.c2cuobkpe1em.us-east-2.rds.amazonaws.com:1521:xe", "hr", "hr");
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");
        resultSet.beforeFirst();
        resultSet.next();
        System.out.println(resultSet.getString("FIRST_NAME"));
        System.out.println(resultSet.getString("salary"));
        System.out.println(resultSet.getString("hire_date"));
        int count=0;
        while(resultSet.next()){
            System.out.println(resultSet.getString("first_name"));
            count++;
        }
        System.out.println("last person "+ count);
        resultSet.last();
        System.out.println(resultSet.getRow());

        //Working with DataBaseMetaData
        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println("User: "+ metaData.getUserName());
        System.out.println("DaTaBase data: "+metaData.getDatabaseProductName());
        System.out.println("connection  type: "+metaData.getConnection());

        ResultSetMetaData rsMetaData = resultSet.getMetaData();
        System.out.println("Columns number: "+rsMetaData.getColumnCount());

        System.out.println(rsMetaData.getColumnName(1));
        System.out.println(rsMetaData.getColumnTypeName(1));
        System.out.println(rsMetaData.getColumnDisplaySize(1));


        //resultSet --> storing all data (fields)
        // rsMetaData --> storing column numbers and names

        resultSet.first();
        for (int i=1;i<=rsMetaData.getColumnCount();i++){
            System.out.println(rsMetaData.getColumnName(i));
        }
        List<Map<String, Object>> data= new ArrayList<>();
        while (resultSet.next()){
            Map<String, Object> map=new HashMap<>();
            for (int i=1;i<=rsMetaData.getColumnCount();i++){
                map.put(rsMetaData.getColumnName(i),resultSet.getObject(rsMetaData.getColumnName(i)));
            }
            data.add(map);
        }
        System.out.println(data);
        System.out.println("+++++++++++++SALARIES+++++++++");

        for (int i=0;i<data.size();i++){
            System.out.println(data.get(i).get("SALARY"));
        }

    }


}
