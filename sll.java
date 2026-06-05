import java.util.Scanner;

class Node {
    String url;
    Node next;

    Node(String url) {
        this.url = url;
        this.next = null;
    }
}

class BrowserHistory {
    private Node head;
    private Node current;

    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        current = head;
    }

    // Visit a new page
    public void visit(String url) {
        Node newNode = new Node(url);

        // Clear forward history
        current.next = null;

        current.next = newNode;
        current = newNode;

        System.out.println("Visited: " + url);
    }

    // Back operation
    public String back(int steps) {
        while (steps > 0 && current != head) {
            Node temp = head;

            while (temp.next != current) {
                temp = temp.next;
            }

            current = temp;
            steps--;
        }

        return current.url;
    }

    // Show current page
    public String getCurrentPage() {
        return current.url;
    }
}

public class sll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Homepage URL: ");
        String homepage = sc.nextLine();

        BrowserHistory browser = new BrowserHistory(homepage);

        while (true) {
            System.out.println("\n--- Browser History Menu ---");
            System.out.println("1. Visit Page");
            System.out.println("2. Back");
            System.out.println("3. Current Page");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter URL: ");
                    String url = sc.nextLine();
                    browser.visit(url);
                    break;

                case 2:
                    System.out.print("Enter Steps: ");
                    int steps = sc.nextInt();
                    System.out.println("Current Page: " + browser.back(steps));
                    break;

                case 3:
                    System.out.println("Current Page: " + browser.getCurrentPage());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}