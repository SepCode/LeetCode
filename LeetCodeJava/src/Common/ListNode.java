package Common;
import java.util.List;

// Definition for singly-linked list.
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(final int x) {
        val = x;
        next = null;
    }

    public ListNode(List<Integer> array) {
        if (array.size() <= 0) {
            return;
        }
        val = array.get(0);
        ListNode tmp = null;
        for (int i = 1; i < array.size(); i++) {
            if (tmp == null) {
                tmp = new ListNode(array.get(i));
                next = tmp;
            } else {
                ListNode node = new ListNode(array.get(i));
                tmp.next = node;
                tmp = node;
            }

        }
    }

    public void printListNode() {
        System.out.println();
        ListNode tmp = this;
        while (tmp != null) {
            System.out.print(tmp.val + ((tmp.next != null) ? "," : "\n"));
            tmp = tmp.next;
        }
        System.out.println();
    }
    
}