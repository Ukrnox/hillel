package com.babayan.lectures.lecture_10.covid_data;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;


public class DataProvider {
    private final DataMapper dataMapper;

    public DataProvider() {
        dataMapper = new DataMapper();
    }

    public void provide(String userName,String password, String connectionUrl) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
            while (resultSet.next()) {

                int id = resultSet.getInt("Id");
                String name = resultSet.getString("ProductName");
                int price = resultSet.getInt("Price");

                System.out.printf("%d. %s - %d \n", id, name, price);
            }
        }
    }

    public DataMapper getDataMapper() {
        return dataMapper;
    }
    //    DataProvider считывает данные из файла,
//    внутри иммеет объект типа DataMapper,
//    метод provide возврщает коллекцию Person'ов


    public static void main(String[] args) throws Exception {
        String dir = "src\\main\\resources\\lecture_10\\";
//    Scanner scanner = new Scanner(Path.of(dir+"data.txt"), StandardCharsets.UTF_8);
//    String a = scanner.next();
//    System.out.println(a);
//    System.out.println(scanner.nextLine());
        CSVReader reader = new CSVReader(new FileReader(dir + "data.csv"), ',', '"');
        for (String[] a : reader.readAll()) {
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        }

//    for(String a:reader.readNext()){
//        System.out.println(a);
//    }
    }

}
