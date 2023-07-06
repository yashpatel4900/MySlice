package  com.university.MySlice.utils;
import java.util.UUID;

public class RandomIDGenerator{

    public static long generateRandomId(){
        long max = 4*(2147483647L);
        UUID guid = UUID.randomUUID();
        return max+guid.hashCode();
    }

}

