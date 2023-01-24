import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        System.out.println("*******  ДЗ 10 задача 1  *******");
        java.util.Random random = new java.util.Random();
        int iNum = random.nextInt(100) - 50; // генерируем целое число от -50 до 50
        Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer v) {
                return v >= 0;
            }
        };
        String s;
        if (p.test(iNum)) s = " положительное";
        else s = " отрицательное";
        System.out.println("Число " + iNum + s);

        Predicate<Integer> pp = v -> v >= 0;
        System.out.println("--- реализация через лямбду: ---");
        iNum = random.nextInt(100) - 50; // генерируем целое число от -50 до 50
        if (pp.test(iNum)) s = " положительное";
        else s = " отрицательное";
        System.out.println("Число " + iNum + s);

        System.out.println("\n*******  ДЗ 10 задача 2  *******");
        String name = "Nick";
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("My name is " + s + ", i'm programmer");
            }
        };
        consumer.accept(name);
        System.out.println("--- реализация через лямбду: ---");
        name = "Alex";
        Consumer<String> consumer1 = s1 -> System.out.println("My name is " + s1 + ", i'm driver");
        consumer1.accept(name);

        System.out.println("\n*******  ДЗ 10 задача 3  *******");


    }

}