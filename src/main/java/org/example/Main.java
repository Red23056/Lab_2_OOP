package org.example;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import com.opencsv.*;
import java.io.IOException;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void read_data(String file)
    {
        List_of_towns List = new List_of_towns();
        try {
            FileReader filereader = new FileReader(file);
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .withCSVParser(parser)
                    .build();
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                List.insert_new_town(row[0], row[1], row[2], row[3]);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        List.print_all_reserve();
    }
    //"/d:/address.csv
    public static void main(String[] args) {
        boolean working = true;
        Scanner scanner = new Scanner(System.in);
        while(working){
            System.out.printf("Введите путь до файла с расширением csv или введите |end| для выхода: ");
            String address = scanner.nextLine();
            if (Objects.equals(address, "end")){
                working = false;
            }
            else {
                read_data(address);
            }
        }
    }
}