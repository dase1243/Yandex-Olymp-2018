package YandexOlymp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Long> books_current_day = new ArrayList<>();
        String[] mass = reader.readLine().split(" ");
        for (int i = 0; i < mass.length; i++) {
            books_current_day.add((long) Integer.parseInt(mass[i]));
        }
        long day = 0;
        long passion = 1;
        while (books_current_day.get(1) >= 0) {
            if (books_current_day.get(2) != 6 && books_current_day.get(2) != 7) {
                books_current_day.set(1, books_current_day.get(1) + books_current_day.get(0));
            }
            long new_current = books_current_day.get(1) - passion;
            if(new_current < 0){
                break;
            }
            books_current_day.set(1, new_current);
            books_current_day.set(2, books_current_day.get(2) + 1);
            passion++;
            day++;

            if(books_current_day.get(2) == 8){
                books_current_day.set(2, 1L);
            }
        }
        System.out.println(day);
    }
}
