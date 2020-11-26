package rocks.zipcode;


public class DashaMapTwo implements HashMapX {

    class Node {
        String key;
        String value;
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }

    private Node[] hasharray;

    public DashaMapTwo() {
        this.hasharray = new Node[26];
        int i = 0;
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            hasharray[i] = new Node(String.valueOf(alphabet), "-1");
            i++;
        }
    }

    private String HashFunctionOne(String input) {
        if (input.length() > 0) {
            return String.valueOf(input.charAt(0)).toLowerCase();
        }
        if (input.length() > 1) {
            return String.valueOf(input.charAt(1)).toLowerCase();
        }
        return null;
    }

    private Integer findHead(String kh) {
        int i = 0;
        for (Node n : hasharray) {
            if (n.key.equals(kh)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private void appendTo(String kh, Node n) {
        Integer bucket = findHead(kh);
        if (bucket != -1) {
            n.next =  hasharray[bucket].next;
            hasharray[bucket].next = n;
        }
    }

    private Node findIn(String keyword) {
        String keyhash =  HashFunctionOne(keyword);
        Integer bucket = findHead(keyhash);
        Node n = hasharray[bucket].next;
        while (n != null && !n.key.equals(keyword)) {
            n = n.next;
        }
        return n;
    }

    @Override
    public void set(String key, String value) {
        String keyhash =  HashFunctionOne(key);
        Node newval = new Node(key, value);
        appendTo(keyhash, newval);
    }

    @Override
    public String delete(String key) {
        String keyhash =  HashFunctionOne(key);
        Integer bucket = findHead(keyhash);
        Node n = hasharray[bucket].next;
        if(n==null)
        {
            return "item not found";
        }

        while (n != null){
            Node temp =n;
            if(!n.key.equals(key))
            {
                n=n.next.getNext();
            }
            else
            {
                temp.next=n.next;
                n=temp;
                return n.getKey();
            }
        }

        return "not found , not deleted";
    }

    @Override
    public String get(String key) {
        String keyhash =  HashFunctionOne(key);
        Node newnode = findIn(key);
        if (newnode != null) {
            return newnode.value;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < hasharray.length; i++) {
            if (hasharray[i].next != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public long size() {
        long s = 0;
        for (Node n : hasharray) {
            Integer l = bucketSize(n.key);
            s += l;
        }
        return s;
    }

    @Override
    public Integer bucketSize(String key) {
        Integer foundhead = findHead(key);
        if (foundhead != -1) {
            Node p = hasharray[foundhead].next;
            int n = 0;
            while (p != null) {
                p = p.next;
                n++;
            }
            return n;
        }

        return 0;
    }
}
