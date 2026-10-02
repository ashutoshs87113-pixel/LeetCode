/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node deepCopy(Node head){
        Node dummy = new Node(-1);
        Node temp1 = head;
        Node temp2 = dummy;

        while(temp1 != null){
            Node t = new Node(temp1.val);

            temp2.next = t;
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        
        Node head2 = deepCopy(head);
        Node temp = head;
        Node temp2 = head2;

        HashMap<Node, Node> map = new HashMap<>();

        while(temp != null){
            map.put(temp,temp2);
            temp = temp.next;
            temp2 = temp2.next;
        }
        temp = head;
        while(temp != null){
            temp2 = map.get(temp);
            temp2.random = map.get(temp.random);
            temp = temp.next;
        }
        return head2;
    }
}