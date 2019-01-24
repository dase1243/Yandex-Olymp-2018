package YandexOlymp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AutoDop {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = reader.readLine();
        List<ArrayList<String>> words = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < Integer.parseInt(n); i++) {
            words.add(new ArrayList<>(Arrays.asList(reader.readLine().split(" "))));
            if(i == 0){
                sum += words.get(0).size();
            }
            for (int j = 0; j < words.get(i).size(); j++) {
                for (ArrayList<String> entry: words) {

                }
            }
        }


        System.out.println(sum);
    }
}
