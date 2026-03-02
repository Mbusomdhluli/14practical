//start
public class openHash {

    private static class Entry {
        String key;
        String value;
        boolean deleted;

        Entry(String k, String v) {
            key = k;
            value = v;
            deleted = false;
        }
    }
    private Entry[] table;
    private int m;
    private int size;

    public openHash(int m) {
        this.m = m;
        table = new Entry[m + 1];
        size = 0;
    }
  //progress
