//start
import java.util.*;

public class Practical14 {

    static final int N = 1 << 20; 
    static final int REPETITIONS = 30;

    public static void main(String[] args) {

        String[] keys = new String[N];
        String[] values = new String[N];

        for (int i = 0; i < N; i++)
            keys[i] = String.valueOf(i + 1);
      //shaffle keys
