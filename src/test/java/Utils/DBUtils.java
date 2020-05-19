package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {
    //establishConnection();
    //runQuery(String query) --> it will return list of Maps
    //getRowNumber(String query); --> it will return int as a number of rows
    //closedDB(); --> it will close all connections made with database
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void establishConnection() throws SQLException {
        connection = DriverManager.getConnection(ConfigReader.getProperty("DBURL"),
                ConfigReader.getProperty("DBUsername"),
                ConfigReader.getProperty("DBPassword"));
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }

    public static List<Map<String, Object>> runQuery(String query) throws SQLException {

        resultSet = statement.executeQuery(query);
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        List<Map<String, Object>> data = new ArrayList<>();
        while (resultSet.next()){
            Map<String, Object> map= new HashMap<>();
            for (int i=1;i<=resultSetMetaData.getColumnCount();i++){
                map.put(resultSetMetaData.getColumnName(i),resultSet.getObject(resultSetMetaData.getColumnName(i)));
            }
            data.add(map);
        }
        return data;
    }

    public static int getRowsNumber(String query) throws SQLException {
        resultSet=statement.executeQuery(query);
        resultSet.last();
        return resultSet.getRow();
    }

    public static void closeConnection() throws SQLException {
        if (connection!=null){
            connection.close();
        }
        if (statement!=null){
            statement.close();
        }
        if (resultSet!=null){
            resultSet.close();
        }
    }

}
