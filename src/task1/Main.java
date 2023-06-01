package task1;

public class Main {

    public static void main(String[] args) {

         boolean checker = true;
         String res = "";
         Integer arraySize = 1;
         Integer current = 1;
         Integer n = Integer.valueOf(args[0]);
         Integer m = Integer.valueOf(args[1]);

        while(checker){
            // если элемент массива последний и текущая переменная = 1, то выход
            if(current == 1 && arraySize == m){
                checker = false;
            }
            // если текущий элемент массива первый, записываю текущую переменную в результат
            if(arraySize == 1){
                res += current;
            }
            // если понимаю, что дошел до конца массива, то снова ухожу в начало, при этом не меняя текущую переменную
            if(arraySize == m){
                arraySize = 1;
            } else {
                // если элементв массива - не последний, увеличиваю счетчик
                arraySize++;
                // если текущая переменная = максимальному числу, то делаю ее равной 1
                if(current == n){
                    current = 1;
                } else {
                    // иначе - увеличиваю
                    current++;
                }
            }
        }
        // если попало под условие - вывожу результат
        System.out.println(res);

    }

}
