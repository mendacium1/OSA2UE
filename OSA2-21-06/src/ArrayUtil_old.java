import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public final class ArrayUtil_old {


    public ArrayUtil_old() {}

    public static Comparable getMax(Optional<ArrayList<Comparable>> list) {
        if (list.orElseThrow().isEmpty()) {
            throw new IllegalArgumentException("Array can not be empty");
        }
        return Collections.max(list.get());
    }

}
