package YandexOlymp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class BigSum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<List<Integer>> numbers = new ArrayList<>();
        Arrays.stream(reader.readLine().split(" ")).forEach(s ->
                numbers.add(Arrays.stream(s.split("")).map(Integer::parseInt).collect(Collectors.toList()))
        );
        numbers.forEach(Collections::reverse);
        numbers.sort(Comparator.comparingInt(List::size));
        List<Integer> biggest = numbers.get(numbers.size() - 1);
        for (int i = 0; i < numbers.size() - 1; i++) {
            List<Integer> number = numbers.get(i);
            for (int j = 0; j < number.size(); j++) {
                int sum = biggest.get(j) + number.get(j);
                if (sum > 9) {
                    biggest.set(j, sum % 10);
                    if (biggest.get(j + 1) == null) {
                        biggest.add(0);
                    }
                    biggest.set(j + 1, sum / 10);
                } else {
                    biggest.set(j, sum);
                }
            }
        }
        Collections.reverse(biggest);
        biggest.forEach(System.out::print);
    }
}
