package com.babayan.homeworks.homework_15;

public class DataFactoryCreator extends DataFactory {

    DataFactoryCreator(String path) {
        super(path);
    }

    @Override
    public DataProvider createData() {
        return createData(new DataMapper());
    }

    @Override
    public DataProvider createData(Mapper mapper) {
        if (this.getPath().contains(".csv")) {
            return new CsvFileDataProvider(mapper);
        } else {
            return new SerializedOFDataProvider();
        }
    }
}
