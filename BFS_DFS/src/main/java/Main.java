import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        List<Integer> test = new ArrayList<>();
        test.add(2);
        test.add(3);
        test.add(5);
        test.add(7);

        Consumer<Integer> print = System.out::println;



        test.forEach(print);
       }

    }


