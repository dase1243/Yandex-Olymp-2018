package YandexOlymp;

import javafx.scene.input.DataFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(sumMat(5));
    }

    public static int sumMat(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            return n + sumMat(n - 1);
        }
    }
}
