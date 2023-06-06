package task4;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task4 {

    public static void main(String[] args) throws IOException, URISyntaxException {

        String path = System.getProperty("user.dir");
        BufferedReader reader = new BufferedReader(new FileReader(path + "\\" + args[0]));
        List<Integer> intList = new ArrayList<>();
        Integer mediana = 0;
        Integer count = 0;

        String str = "";
        while((str = reader.readLine()) != null){
            Integer it = Integer.valueOf(str);
            intList.add(it);
        }
        // сортировка в порядке возрастания чисел
        Collections.sort(intList);

        // если количество чисел нечетное
        if(!(intList.size() %2 == 0)){
            // получаю число к которому надо приводить
            mediana = intList.get((intList.size() - 1) / 2);
        } else {
            Integer index = intList.size() / 2;
            mediana = (intList.get(index) + intList.get(index - 1)) / 2;
        }


        for (int i = 0; i < intList.size(); i++) {

            int checker = intList.get(i);
            while(checker != mediana){
                if (checker > mediana){
                     checker--;
                     count++;
                } else {
                    checker++;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
