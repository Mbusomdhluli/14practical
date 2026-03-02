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
     public boolean isInTable(String key) {
        return lookup(key) != null;
    }

    public void insert(String key, String value) {
        int i = hash(key);
        Node current = table[i];

        if (current == null) {
            table[i] = new Node(key, value);
            return;
        }

        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }

        prev.next = new Node(key, value);
    }
     public String lookup(String key) {
        int i = hash(key);
        Node current = table[i];

        while (current != null) {
            if (current.key.equals(key))
                return current.value;
            current = current.next;
        }
        return null;
    }
    //commit


