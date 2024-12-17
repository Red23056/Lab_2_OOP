package org.example;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import com.opencsv.*;
import org.xml.sax.SAXException;

import java.io.IOException;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void read_data_xml(String file) throws ParserConfigurationException, IOException, SAXException {
        //List_of_towns List = new List_of_towns();
        File xmlFile = new File(file);
         // Create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file
        Document document = builder.parse(xmlFile);

        // Access elements by tag name
        NodeList nodeList = document.getElementsByTagName("root");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("Element Content: " + node.getTextContent());
        }
    }

    public static void read_data_csv(String file)
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
    //"/d:/address.xml
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        boolean working = true;
        Scanner scanner = new Scanner(System.in);
        while(working){
            System.out.printf("Введите путь до файла с расширением csv или введите |end| для выхода: ");
            String address = scanner.nextLine();
            if (Objects.equals(address, "end")){
                working = false;
            }
            else {
                read_data_xml(address);
            }
        }
    }
}