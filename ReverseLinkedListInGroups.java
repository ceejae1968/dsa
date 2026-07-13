package algos;

public class ReverseLinkedListInGroups {
    public static void main(String args[]){
        Node n8 = new Node("8", null);
        Node n7 = new Node("7", n8);
        Node n6 = new Node("6", n7);
        Node n5 = new Node("5", n6);
        Node n4 = new Node("4", n5);
        Node n3 = new Node("3", n4);
        Node n2 = new Node("2", n3);
        Node head = new Node("1", n2);
        reverseLinkedList(head);
    }

    public static void reverseLinkedList(Node head){
        Node prev = null;
        Node curr = head;

        int groupSize = 3;

        Node newHead = null;
        Node tail = null;
        while(head != null){
            Node groupHead = curr;

            int count = 0;
            while(head != null && count < groupSize) {
                head = curr.next;
                curr.next = prev;
                prev = curr;
                curr = head;
                count++;
            }

            if(newHead == null){
                newHead = prev;
            }

            if(tail != null){
                tail.next = prev;
            }
            tail = groupHead;
        }

        head = newHead;
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}

class Node {
    String value;
    Node next;
    public Node(String value, Node next){
        this.value = value;
        this.next = next;
    }
}
