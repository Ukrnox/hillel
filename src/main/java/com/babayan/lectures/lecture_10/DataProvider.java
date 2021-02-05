package com.babayan.lectures.lecture_10;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;


public class DataProvider {
    private final DataMapper dataMapper;
<<<<<<< HEAD

    public DataProvider() {
        dataMapper = new DataMapper();
    }

    public void provide(String file) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(file), ',', '"');
        for (String[] a : reader.readAll()) {
            dataMapper.add(a[0], a[1], Integer.valueOf(a[2]), Integer.valueOf(a[3]), Integer.valueOf(a[4]), a[5]);
=======
    public DataProvider(){
        dataMapper=new DataMapper();
    }
    public void provide(String file) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(file), ',', '"');
        for(String[] a:reader.readAll()){
            dataMapper.add(a[0],a[1],Integer.valueOf(a[2]),Integer.valueOf(a[3]),Integer.valueOf(a[4]),a[5]);
>>>>>>> origin/master
        }
    }

    public DataMapper getDataMapper() {
        return dataMapper;
    }
    //    DataProvider считывает данные из файла,
//    внутри иммеет объект типа DataMapper,
//    метод provide возврщает коллекцию Person'ов


<<<<<<< HEAD
    public static void main(String[] args) throws Exception {
        String dir = "D:\\Java\\hillel\\src\\main\\resources\\lecture_10\\";
=======


public static void main(String[] args) throws Exception {
    String dir = "D:\\Java\\hillel\\src\\main\\resources\\lecture_10\\";
>>>>>>> origin/master
//    Scanner scanner = new Scanner(Path.of(dir+"data.txt"), StandardCharsets.UTF_8);
//    String a = scanner.next();
//    System.out.println(a);
//    System.out.println(scanner.nextLine());
<<<<<<< HEAD
        CSVReader reader = new CSVReader(new FileReader(dir + "data.csv"), ',', '"');
        for (String[] a : reader.readAll()) {
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        }
=======
    CSVReader reader = new CSVReader(new FileReader(dir+"data.csv"), ',', '"');
    for(String[] a:reader.readAll()){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
>>>>>>> origin/master

//    for(String a:reader.readNext()){
//        System.out.println(a);
//    }
<<<<<<< HEAD
    }
=======
}
>>>>>>> origin/master

}
