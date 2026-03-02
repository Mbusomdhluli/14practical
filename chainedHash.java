//start
public class chainedHash {

    private static class Node {
        String key;
        String value;
        Node next;

        Node(String k, String v) {
            key = k;
            value = v;
            next = null;
        }
    }
  private Node[] table;
    private int m;

    public chainedHash(int m) {
        this.m = m;
        table = new Node[m + 1];
    }

    private int hash(String key) {
        int h = Math.abs(key.hashCode());
        return (h % m) + 1;
    }

    public boolean isEmpty() {
        for (int i = 1; i <= m; i++)
            if (table[i] != null)
                return false;
        return true;
    }
//progress
