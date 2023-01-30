import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args)    {

        System.out.println("*******  ДЗ 11 задача 1  *******");
        List<Integer> intList = new ArrayList<>();
        int nums = 10; // количество чисел, которое хотим нагенерировать в массив
        System.out.println("Генерируем массив из "+nums+" чисел:");
        for (int i=0;i<nums;i++) {
            java.util.Random random = new java.util.Random();
            int j = random.nextInt(50);
            intList.add(j); // генерируем целое число от 0 до 50, добавляем в массив
            System.out.print(j+" ");
        }
        System.out.println("\nнаходим в этом массиве минимальное и максимальное значение:");
        Stream<Integer> intStream = intList.stream();
        findMinMax(intStream,Integer::compareTo,(min,max) -> System.out.println("минимум = "+min+" , максимум = "+max));
// -----------------------------------------------------------
        System.out.println("\n*******  ДЗ 11 задача 2 *******");
        evenCounter(intList);
    }
public static void evenCounter(List<Integer> intList){
    System.out.println("В нашем массиве: "+intList.stream().filter(i -> i/2*2 == i).count()+" четных чисел");
    System.out.println("Чётные числа нашего массива: ");
    System.out.println(intList.stream().filter(i -> i/2*2 == i).collect(Collectors.toList()));
}
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer)
    {
        List<T> arrayList;
        T min = null;
        T max = null;
        arrayList = stream.sorted(order).collect(Collectors.toList());
        if (arrayList.size() > 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
        }
minMaxConsumer.accept(min,max);
    }
// =================================================================================
    /*    System.out.println("*******  ДЗ 10 задача 1  *******");
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
        Double d = iNum * 1.23;
        Function<Double, Long> doubleToLong = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println("Double число " + d + " округлили до " + doubleToLong.apply(d) + " (Long)");
        System.out.println("--- реализация через лямбду: ---");
        Function<Double, Long> doubleToLongF = aDouble -> Math.round(aDouble);
        d = iNum * 3.21;
        System.out.println("Double число " + d + " округлили до " + doubleToLong.apply(d) + " (Long)");

        System.out.println("\n*******  ДЗ 10 задача 4  *******");
        Supplier<Integer> integerSupplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                java.util.Random random = new java.util.Random();
                return random.nextInt(100);
            }
        };
        System.out.println("Supplier сгенерировал число " + integerSupplier.get());
        System.out.println("--- реализация через лямбду: ---");
        Supplier<Integer> integerS = () -> {
            java.util.Random random1 = new java.util.Random();
            return random1.nextInt(100);
        };
        System.out.println("lambda-Supplier сгенерировал число " + integerS.get());

        System.out.println("\n*******  ДЗ 10 задача 5  *******");

        Integer iNum1 = random.nextInt(100);
        System.out.println("Random number = " + iNum1);
        Predicate<Integer> condition = p2 -> iNum1 / 2 * 2 == iNum1;

        Function<Integer, String> ifTrue = sT -> "четное число";
        Function<Integer, String> ifFalse = sT -> "нечетное число";
        Function<Integer, String> ff = ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(iNum1 + " = " + ff.apply(iNum1));
*/

    private static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        {
            return t -> {
                U result = condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
                return result;
            };
        }
    }

}



