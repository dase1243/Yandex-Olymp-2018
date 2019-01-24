package YandexOlymp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

public class Meetings {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String n = reader.readLine();
//        Map<String, Map<String, Map<String, ArrayList<String>>>> index_day_1timeDurration_list1 = new HashMap<>();
        Map<Integer, List<String>> index_day_timeDurration_k_list = new HashMap<>();
        Integer index = 0;
        for (int i = 0; i < Integer.parseInt(n); i++) {
            String[] mass = reader.readLine().split(" ");
            List<String> request = Arrays.asList(mass);
            boolean failed = false;
            if (request.get(0).equals("APPOINT")) {
                for (Map.Entry<Integer, List<String>> entry : index_day_timeDurration_k_list.entrySet()) {
                    if (entry.getValue().get(0).equals(request.get(1))) {
                        String[] mass_time_req = request.get(2).split(":");
                        int time_request = Integer.parseInt(mass_time_req[0]) * 60 + Integer.parseInt(mass_time_req[1]);
                        int duration_req = Integer.parseInt(request.get(3)) + time_request;

                        String[] mass_time1 = entry.getValue().get(1).split(":");
                        int time_1 = Integer.parseInt(mass_time1[0]) * 60 + Integer.parseInt(mass_time1[1]);
                        int duration_1 = Integer.parseInt(entry.getValue().get(2)) + time_1;
                        if ((time_request >= time_1 && time_request < duration_1 || duration_req <= duration_1 && duration_req > time_1) ||
                                (time_request <= time_1 && duration_req >= duration_1)) {
                            System.out.println("FAIL");

                            List<String> retur = request.subList(5, request.size());
                            StringBuilder s = new StringBuilder();
                            for (String s1 : retur) {
                                if (entry.getValue().contains(s1)) {
                                    s.append(s1).append(" ");
                                }
                            }
                            System.out.println(s.substring(0, s.length() - 1));

                            failed = true;
                            break;
                        }
                    }
                }
                if (!failed) {
                    index_day_timeDurration_k_list.put(index, request.subList(1, request.size()));
                    index++;
                    System.out.println("OK");
                }

            } else if (request.get(0).equals("PRINT")) {
                Map<Integer, String> events = new HashMap<>();
                Map<Integer, String> events1 = new HashMap<>();
                for (Map.Entry<Integer, List<String>> entry : index_day_timeDurration_k_list.entrySet()) {
                    if (entry.getValue().get(0).equals(request.get(1))) {
                        if (entry.getValue().contains(request.get(2))) {
                            List<String> retur = entry.getValue();
                            String s = "";
                            List<String> returning = retur.subList(1, retur.size());
                            for (String s1 : retur.subList(1, retur.size())) {
                                s = s + s1 + " ";
                            }
                            String[] massTime = returning.get(0).split(":");
                            int time = Integer.parseInt(massTime[0]) * 60 + Integer.parseInt(massTime[1]);
                            events.put(time, s);
                            events = events.entrySet().stream().sorted(comparingByKey()).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2));
                        }
                    }
                }
                for (Map.Entry<Integer, String> entry : events.entrySet()) {
                    ArrayList<String> massSplit = new ArrayList<>(Arrays.asList(entry.getValue().split(" ")));
                    massSplit.remove(2);
                    String s = "";
                    for (String s1 : massSplit) {
                        if (entry.getValue().contains(s1)) {
                            s = s + s1 + " ";
                        }
                    }
                    events1.put(entry.getKey(), s);
                }
                for (Map.Entry<Integer, String> entry : events1.entrySet()) {
                    if(entry.getValue().equals(""))
                        break;
                    System.out.println(entry.getValue());
                }
            }
        }
    }
}
