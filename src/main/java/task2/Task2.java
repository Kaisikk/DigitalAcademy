package task2;

import com.sun.deploy.xml.XMLParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Да, я знаю, что класс так лучше не называть. Я так не делаю, честно:)
 */
public class Task2 {

    public static void main(String[] args) throws IOException, URISyntaxException {

        List<Integer> res = new ArrayList<>();

        float circleX = 0;
        float circleY = 0;
        float radius = 0;
        String line;


        // получаю путь к директории где сейчас лежит jar файл
        String path = System.getProperty("user.dir");

        // получение данных о координатах и радиусе окружности
        BufferedReader circleReader = new BufferedReader(new FileReader(path + "\\" + args[0]));

        // получение данных о точках
        BufferedReader pointReader = new BufferedReader(new FileReader(path + "\\" + args[1]));

        // бегу по файлу построчно
        while((line = circleReader.readLine()) != null){
            // я не знаю в какой последовательности будут данные в файле, поэтому проверяю через regex
            if(Pattern.matches("\\d \\d", line)){
            String[] circlePoint = line.split(" ");
            circleX = Float.parseFloat(circlePoint[0]);
            circleY = Float.parseFloat(circlePoint[1]);
            // если понимаю, что в моей строке просто число, то записываю его как радиус окружности
            } else if(Pattern.matches("\\d", line)){
                radius = Float.parseFloat(line);
            }
        }


        while((line = pointReader.readLine()) != null){
            // получаю строку
        String[] data = line.split(" ");
        // получаю из нее координаты точек для использования в формуле для проверки где находится точка
        float x = Float.parseFloat(data[0]) - circleX;
        float y = Float.parseFloat(data[1]) - circleY;
        float distance = x * x + y * y;
        // проверка, что точка внутри
        if(distance < radius * radius){
            res.add(1);
            // проверка что точка снаружи
        } else if(distance > radius * radius){
            res.add(2);
            // если точка на окружности
        } else {
            res.add(0);
        }
    }
        System.out.println(res.stream().map(obj -> String.valueOf(obj)).collect(Collectors.joining(" ")));

    }

}

