package com.babayan.lectures.lecture_10;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;


public class DataProvider {
    private final DataMapper dataMapper;
    public DataProvider(){
        dataMapper=new DataMapper();
    }
    public void provide(String file) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(file), ',', '"');
        for(String[] a:reader.readAll()){
            dataMapper.add(a[0],a[1],Integer.valueOf(a[2]),Integer.valueOf(a[3]),Integer.valueOf(a[4]),a[5]);
        }
    }

    public DataMapper getDataMapper() {
        return dataMapper;
    }
    //    DataProvider считывает данные из файла,
//    внутри иммеет объект типа DataMapper,
//    метод provide возврщает коллекцию Person'ов




public static void main(String[] args) throws Exception {
    String dir = "D:\\Java\\hillel\\src\\main\\resources\\lecture_10\\";
//    Scanner scanner = new Scanner(Path.of(dir+"data.txt"), StandardCharsets.UTF_8);
//    String a = scanner.next();
//    System.out.println(a);
//    System.out.println(scanner.nextLine());
    CSVReader reader = new CSVReader(new FileReader(dir+"data.csv"), ',', '"');
    for(String[] a:reader.readAll()){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

//    for(String a:reader.readNext()){
//        System.out.println(a);
//    }
}

}
