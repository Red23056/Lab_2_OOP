package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

public class List_of_towns {
    HashSet<String> repeats_data;
    HashSet<String> repeats_town;
    HashMap<String, Integer> repeats;
    HashMap<String, Integer> homes_in_town;

    List_of_towns(){
        repeats_data = new HashSet<>();
        repeats_town = new HashSet<>();
        repeats = new HashMap<>();
        homes_in_town = new HashMap<>();
    }

    public void insert_new_town(String new_town, String new_street, String new_homes, String new_type_homes){
        //Integer new_homes_int = Integer.parseInt(new_homes);
        int new_homes_int;
        try {
            new_homes_int = Integer.parseInt(new_homes);
        }
        catch (NumberFormatException e) {
            new_homes_int = 0;
        }
        if (repeats_data.isEmpty()) {
            repeats_data.add(new_town+"|"+new_street+"|"+new_homes+"|"+new_type_homes);
        }
        else {
            if (repeats_data.contains(new_town+"|"+new_street+"|"+new_homes+"|"+new_type_homes)){
                repeats.put(new_town+"|"+new_street+"|"+new_homes+"|"+new_type_homes, repeats.getOrDefault(new_town+"|"+new_street+"|"+new_homes+"|"+new_type_homes, 0) + 1);
            }
            else{
                repeats_data.add(new_town+"|"+new_street+"|"+new_homes+"|"+new_type_homes);
            }
        }
        if(repeats_town.isEmpty()){
            repeats_town.add(new_town+"|"+new_type_homes);
            homes_in_town.put(new_town+"|"+new_type_homes, homes_in_town.getOrDefault(new_town+"|"+new_type_homes, 0) + new_homes_int);
        }
        else{
            if (repeats_town.contains(new_town+"|"+new_type_homes)){
                homes_in_town.put(new_town+"|"+new_type_homes, homes_in_town.getOrDefault(new_town+"|"+new_type_homes, 0) + new_homes_int);
            }
            else{
                repeats_town.add(new_town+"|"+new_type_homes);
                homes_in_town.put(new_town+"|"+new_type_homes, homes_in_town.getOrDefault(new_town+"|"+new_type_homes, 0) + new_homes_int);
            }
        }

    }

    public void print_all_reserve(){
        //System.out.println(repeats);
        for (Map.Entry<String, Integer> entry : repeats.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Полное повторение: " + key + ", Количество повторений: " + value + 1);
        }
        //System.out.println(homes_in_town);
        for (Map.Entry<String, Integer> entry : homes_in_town.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Город и тип дома: " + key + ", Количество домов: " + value);
        }
    }
}