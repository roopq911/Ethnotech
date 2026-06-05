class Post {
    String data;
    boolean sponsored;
    Post prev, next;
    
    Post(String data, boolean sponsored) {
        this.data = data;
        this.sponsored = sponsored;
    }
}

public class Feed {
    Post head, curr;

    void add(String data, boolean sponsored) {
        Post p = new Post(data, sponsored);
        if (head == null) head = curr = p;
        else {
            Post t = head;
            while (t.next!= null) t = t.next;
            t.next = p;
            p.prev = t;
        }
    }

    void next() {
        if (curr!= null && curr.next!= null) curr = curr.next;
        show();
    }

    void prev() {
        if (curr!= null && curr.prev!= null) curr = curr.prev;
        show();
    }

    void delete() {
        if (curr == null) return;
        if (curr.prev!= null) curr.prev.next = curr.next;
        else head = curr.next;
        if (curr.next!= null) curr.next.prev = curr.prev;
        curr = curr.next!= null? curr.next : curr.prev;
    }

    void show() {
        if (curr == null) System.out.println("Empty");
        else System.out.println(curr.data + (curr.sponsored? " [Ad]" : ""));
    }

    public static void main(String[] args) {
        Feed f = new Feed();
        f.add("Post 1", false);
        f.add("Sponsored Post", true);
        f.add("Post 3", false);
        
        f.show(); 
        f.next();
        f.next(); 
        f.prev(); 
        f.delete(); 
        f.show();     }
}