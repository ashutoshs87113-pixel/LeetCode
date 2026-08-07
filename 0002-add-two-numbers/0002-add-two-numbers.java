/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode t1 = l1;
        ListNode t2 = l2;

        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;

        int carry = 0;

        while(t1 != null || t2 != null || carry != 0){
            int x = 0;
            int y = 0;

            if(t1 != null){
                x = t1.val;
            }
            if(t2 != null){
                y = t2.val;
            }

            int sum = x + y + carry;
            carry = sum /10;
            sum = sum % 10;

            t.next = new ListNode(sum);
            t = t.next;
            if( t1 != null){
                t1 = t1.next;
            }
            if( t2 != null){
                t2 = t2.next;
            }
        }
        return dummy.next;
    }
}