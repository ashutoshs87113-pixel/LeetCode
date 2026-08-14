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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        

        ListNode fast= list1;
        ListNode slow = list1;
        ListNode c = list2;

        for(int i = 1; i <= b+1; i++){
            fast = fast.next;
        }

        for(int i = 1; i < a; i++){
            slow = slow.next;
        }
         slow.next = c;
        while(c.next != null){
            c = c.next;
        }
        c.next = fast;

        return list1;
       
    }
}