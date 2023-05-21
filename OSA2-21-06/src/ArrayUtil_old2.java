import java.util.Optional;

public class ArrayUtil_old2<T> {

    public static <E extends Comparable<E>> E getMax(Optional<E[]> list) {
        if (list.orElseThrow().length == 0) {
            throw new IllegalArgumentException("Array can not be empty");
        }

        E comp1 = list.get()[0];

        for (E e : list.get()) {
            if (comp1.compareTo(e) < 0) {
                comp1 = e;
            }
        }

        return comp1;
    }
    
}
