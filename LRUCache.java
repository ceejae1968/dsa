package programs;

import java.util.HashMap;
import java.util.Map;

class LRUCache{

    private Node head = new Node();
    private Node tail = new Node();
    private int size = 50;
    private Map<Integer, Node> hashMap = new HashMap<>();

    public LRUCache(){
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        Node node = hashMap.get(key);
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        Node prev = head.next;
        node.next = prev;
        node.prev = head;
        head.next = node;
        prev.prev = node;

        return node.value;
    }

    public void put(int key, int value){
        Node node = null;
        if(hashMap.containsKey(key)){
            node = hashMap.get(key);
            node.value = value;
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        } else {
            if(hashMap.size() >= size) {
                deleteLRUNode((hashMap.size() - size) + 1);
            }
            node = new Node();
            node.key = key;
            node.value = value;
        }
        Node prev = head.next;
        node.next = prev;
        node.prev = head;
        head.next = node;
        hashMap.put(key, node);

    }

    private void deleteLRUNode(int noOfNodesToDelete) {
        while(noOfNodesToDelete > 0){
            Node nodeToDelete = tail.prev;
            Node nodePriorToDelete = nodeToDelete.prev;
            nodePriorToDelete.next = tail;
            tail.prev = nodePriorToDelete;
            noOfNodesToDelete--;
            hashMap.remove(nodeToDelete.key);
        }
    }

    public static class Node{
        public int key;
        public int value;
        public Node next;
        public Node prev;
    }
}
