import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

        Integer iNum1 = random.nextInt(100) - 50;
        System.out.println("Random number = " + iNum1);
        Predicate<Object> condition = p2 -> {
            return iNum1 / 2 * 2 == iNum1;
        };
        Function<Object, Integer> ifTrue = sT -> 2;
        Function<Object, Integer> ifFalse = sT -> 1;
        Function<Object, Integer> ff = ternaryOperator(condition, ifTrue, ifFalse);
        String s1;
        if (ff.apply(iNum1) == 2) {
            s1 = " четное число";
        } else {
            s1 = " нечетное число";
        }
        System.out.println(iNum1 + s1);
    }

    private static Function<Object, Integer> ternaryOperator(Predicate<Object> condition,
                                                             Function<Object, Integer> ifTrue,
                                                             Function<Object, Integer> ifFalse) {
        java.util.Random random2 = new java.util.Random();
        Integer iNum = random2.nextInt(100) - 50;
        String sf;
        if (condition.test(iNum)) {
            sf = "выпало четное число" + iNum;
            return ifTrue;
        } else {
            sf = "выпало нечетное число" + iNum;
            return ifFalse;
        }
    }
}



