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
         
        List<String> list = Arrays.asList(keys);
        Collections.shuffle(list);
        list.toArray(keys);

        for (int i = 0; i < N; i++)
            values[i] = String.valueOf(i + 1);

        double[] loadFactors = {0.75, 0.80, 0.85, 0.90, 0.95};

        System.out.println("Average Search Time (seconds)");
        System.out.println("--------------------------------------------------");
        System.out.println("Alpha\tN\tOpenHash\tChainedHash");

        for (double alpha : loadFactors) {

            int n = (int)(alpha * 1_000_000);
            int m = (int)(n / alpha);

            double openTime = 0;
            double chainedTime = 0;

            for (int r = 0; r < REPETITIONS; r++) {

                openHash open = new openHash(m);
                chainedHash chained = new chainedHash(m);

//progress
             for (int i = 0; i < n; i++) {
                    open.insert(keys[i], values[i]);
                    chained.insert(keys[i], values[i]);
                }

                
                long start = System.currentTimeMillis();
                for (int i = 0; i < n; i++)
                    open.lookup(keys[i]);
                long end = System.currentTimeMillis();
                openTime += (end - start) / 1000.0;

                start = System.currentTimeMillis();
                for (int i = 0; i < n; i++)
                    chained.lookup(keys[i]);
                end = System.currentTimeMillis();
                chainedTime += (end - start) / 1000.0;
            }

            openTime /= REPETITIONS;
            chainedTime /= REPETITIONS;

            System.out.printf("%.2f\t%d\t%.4f\t\t%.4f\n",
                    alpha, n, openTime, chainedTime);
        }
    }
}
//commit

