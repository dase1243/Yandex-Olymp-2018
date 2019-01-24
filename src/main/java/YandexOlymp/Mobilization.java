package YandexOlymp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Mobilization {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nm = reader.readLine();
        int n = Integer.parseInt(nm);
        Map<Integer, Integer> diff = new HashMap<>();
        String[] dev;
        String[] man;
        dev = reader.readLine().split(" ");
        man = reader.readLine().split(" ");
        List<Integer> devInt = new ArrayList<>();
        List<Integer> manInt = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            devInt.add(Integer.parseInt(dev[i]));
            manInt.add(Integer.parseInt(man[i]));
            diff.put(i + 1, Integer.parseInt(man[i]) - Integer.parseInt(dev[i]));
        }

//                .sorted(Map.Entry.comparingByValue(Integer::compareTo))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
//                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        int m = Integer.parseInt(reader.readLine());
        int best = 0;
        for (int i = 0; i < m; i++) {
            String[] certificate = reader.readLine().split(" ");
            int index = Integer.parseInt(certificate[0]);
            if (certificate[1].equals("1")) {
                int res = diff.get(index) - Integer.parseInt(certificate[2]);
                devInt.set(index - 1, devInt.get(index - 1) + Integer.parseInt(certificate[2]));
                diff.remove(index);
                diff.put(index, res);
            }
            if (certificate[1].equals("2")) {
                int res = diff.get(index) + Integer.parseInt(certificate[2]);
                manInt.set(index - 1, manInt.get(index - 1) + Integer.parseInt(certificate[2]));
                diff.remove(index);
                diff.put(index, res);
            }
            diff = diff.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Integer::compareTo))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
            List<Integer> integers = new ArrayList<>();
            integers.addAll(diff.keySet());
            best = 0;
            for (int j = 0; j < integers.size() / 2; j++) {
                best += devInt.get(integers.get(j) - 1);
                best += manInt.get(integers.get(j + integers.size() / 2) - 1);
            }
            System.out.println(best);
        }
    }
}
