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
        private int hash(String key) {
        int h = Math.abs(key.hashCode());
        return (h % m) + 1;
    }

    public boolean isFull() {
        return size >= m;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isInTable(String key) {
        return lookup(key) != null;
    }
    public void insert(String key, String value) {
        if (isFull()) return;

        int i = hash(key);
        int start = i;

        while (table[i] != null && !table[i].deleted) {
            if (table[i].key.equals(key)) {
                table[i].value = value;
                return;
            }
            i = (i % m) + 1;  
            if (i == start) return;
        }

        table[i] = new Entry(key, value);
        size++;
    }
    //progress

