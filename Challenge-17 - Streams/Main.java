import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final Stream<String> iStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15).map(b -> "B" + b);
        final Stream<String> bStream = IntStream.rangeClosed(16, 30).mapToObj(i -> "I" + i);
        final Stream<String> nStream = Stream.iterate(31, n -> n + 1)
                .limit(15)
                .map(n -> "N" + n);
        final Iterator<Integer> gIterator = IntStream.rangeClosed(46, 60).iterator();
        final Stream<String> gStream = Stream.generate(gIterator::next)
                .limit(15)
                .map(n -> "G" + n);
        final Stream<String> oStream = Arrays.stream(new int[]{61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75}).mapToObj(o -> "O" + o);


        Stream.concat(
                iStream,
                Stream.concat(
                        Stream.concat(
                                Stream.concat(bStream, nStream), gStream
                        ), oStream)

        ).forEach(System.out::println);
    }
}