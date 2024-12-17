package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

public class List_of_towns {
    data_address head;
    data_address tail;
    data_address buffer;
    int count_homes_on_street;
    HashSet<String> repeats_town;
    HashMap<String, Integer> repeats;
    class data_address {
        data_address(String new_town, String new_street, String new_homes, String new_type_homes){
            town = new_town;
            street = new_street;
            homes = new_homes;
            type_home = new_type_homes;
            counter = 0;
            next = null;
        }
        String town;
        String street;
        String homes;
        String type_home;
        data_address next;
        int counter;
    }

    List_of_towns(){
        head = null;
        tail = null;
        count_homes_on_street = 0;
        buffer = null;
        repeats_town = new HashSet<>();
        repeats = new HashMap<>();
    }

    public void insert_new_town(String new_town, String new_street, String new_homes, String new_type_homes){
        if (head == null) {
            head = new data_address(new_town, new_street, new_homes, new_type_homes);
            tail = head;
            repeats_town.add(new_town+new_street+new_homes+new_type_homes);
        } else {
            if (repeats_town.contains(new_town+new_street+new_homes+new_type_homes)){
                repeats.put(new_town+new_street+new_homes+new_type_homes, repeats.getOrDefault(new_town+new_street+new_homes+new_type_homes, 0) + 1);
            }
            else{
                repeats_town.add(new_town+new_street+new_homes+new_type_homes);
            }
            data_address these_town = tail;
            these_town.next = new data_address(new_town, new_street, new_homes, new_type_homes);
            tail = these_town.next;
        }
    }

    public void print_all_reserve(){
        System.out.println(repeats);
    }
}