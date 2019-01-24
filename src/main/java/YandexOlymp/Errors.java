package YandexOlymp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Errors {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = reader.readLine();
        List<Double> mapIServer_IProb = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(n); i++) {
            String[] mass = reader.readLine().split(" ");
            mapIServer_IProb.add(Double.parseDouble(mass[0]) / 100);
            mapIServer_IProb.add(Double.parseDouble(mass[1]) / 100);
        }
        Double fullProbability = 0.0;
        for (int i = 0; i < mapIServer_IProb.size(); i += 2) {
            fullProbability += mapIServer_IProb.get(i) * mapIServer_IProb.get(i + 1);
        }
        for (int i = 0; i < mapIServer_IProb.size(); i += 2) {
            System.out.println((mapIServer_IProb.get(i) * mapIServer_IProb.get(i + 1)) / fullProbability);
        }
    }
}
