import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bye world!");

        Predicate<Double> x = new Predicate<Double>() {
            @Override
            public boolean test(Double v) {
                return v >= 0.0;
            }
        };

    }

}