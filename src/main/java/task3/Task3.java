package task3;

import com.google.gson.Gson;

import java.io.*;
import java.util.*;

/**
 * Да, я знаю, что класс так лучше не называть. Я так не делаю, честно:)
 */
public class Task3 {

    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();

        // Map чтобы сопоставлять объекты по id(мне просто кажется, что так удобнее)
        Map<Integer, Value> valueMap = new HashMap<>();

        String path = System.getProperty("user.dir");
        // получение объектов из json

        Tests test = gson.fromJson(new FileReader(path + "\\" + args[0]), Tests.class);

        Tests value = gson.fromJson(new FileReader(path + "\\" + args[1]), Tests.class);

        // кидаю объекты со значениями в мапу
        value.getValues().forEach( vl -> {
            valueMap.put(vl.getId(), vl);
        });

        Value item = valueMap.getOrDefault(test.getId(), null);
        if(item != null){
            if(item.getTitle() != null){
                test.setTitle(item.getTitle());
            }
            if(item.getValue() != null){
                test.setValue(item.getValue());
            }
        }
        test.getValues().forEach( it -> {
            Value checker = valueMap.getOrDefault(it.getId(), null);
            if(checker != null){
                if(checker.getValue() != null){
                    it.setValue(checker.getValue());
                }
                if(checker.getTitle() != null){
                    it.setTitle(checker.getTitle());
                }
            }
        });

        String res = gson.toJson(test);
        File file = new File(path + "\\" + "report.json");
        file.createNewFile();
        PrintWriter pw = new PrintWriter(file);
        pw.print(res);
        pw.close();

    }

}
