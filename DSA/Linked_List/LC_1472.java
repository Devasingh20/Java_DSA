
package DSA.Linked_List;

public class LC_1472 {

    static class BrowserHistory {

        static class Node {
            String url;
            Node next;
            Node pre;

            Node(String url) {
                this.url = url;
            }
        }

        Node curr;

        // Constructor
        public BrowserHistory(String homepage) {
            curr = new Node(homepage);
        }

        // Visit a new webpage
        public void visit(String url) {
            Node node = new Node(url);

            curr.next = node;
            node.pre = curr;

            curr = node;
        }

        // Move backward
        public String back(int steps) {
            while (steps > 0 && curr.pre != null) {
                curr = curr.pre;
                steps--;
            }

            return curr.url;
        }

        // Move forward
        public String forward(int steps) {
            while (steps > 0 && curr.next != null) {
                curr = curr.next;
                steps--;
            }

            return curr.url;
        }
    }

    public static void main(String[] args) {

        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");

        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));

        browserHistory.visit("linkedin.com");

        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }
}
