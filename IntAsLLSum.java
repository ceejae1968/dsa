package algos;

public class IntAsLLSum {
    public static void main(String args[]){
        ListNode l11 = new ListNode(3);
        ListNode l12 = new ListNode(4, l11);
        ListNode l1 = new ListNode(2, l12);

        ListNode l21 = new ListNode(4);
        ListNode l22 = new ListNode(6, l21);
        ListNode l2 = new ListNode(5, l22);

        addTwoNumbers(l1, l2);

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryForward = 0;
        ListNode firstNode = null;
        ListNode listNode = new ListNode();
        while(l1 != null || l2 != null){
            int i1 = l1 != null ? l1.val : 0;
            int i2 = l2 != null ? l2.val : 0;
            int sum = i1 + i2 + carryForward;
            if(sum > 9){
                carryForward = 1;
                listNode.val = sum%10;
            } else {
                carryForward = 0;
                listNode.val = sum;
            }
            l1 = l1 != null && l1.next != null ? l1.next : null;
            l2 = l2 != null && l2.next != null ? l2.next : null;
            if(l1 == null && l2 == null){
                if(sum > 9){
                    listNode.val = sum%10;
                    listNode.next = new ListNode(1);
                } else {
                    listNode.val = sum;
                }
                if(firstNode == null){
                    firstNode = listNode;
                }
                continue;
            }
            if(firstNode == null){
                firstNode = listNode;
            }
            listNode.next = new ListNode();
            listNode = listNode.next;
        }
        return firstNode;
    }
}