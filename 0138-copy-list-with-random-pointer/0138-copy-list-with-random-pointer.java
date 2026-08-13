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

    public Node copy( Node head){
        Node temp = head;
        Node dummy = new Node(-1);
        Node t1 = dummy;

        while(temp != null){
            Node t2 = new Node(temp.val);
            t1.next = t2;
            t1 = t1.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    public void merge(Node head1, Node head2){
        Node dummy = new Node(-1);

        Node temp = dummy;
        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1 != null && temp2 != null){
            temp.next = temp1;
            temp = temp.next;
            temp1 = temp1.next;

            temp.next = temp2;
            temp = temp.next;
            temp2 = temp2.next;
        }

    }

    public void randomcopy(Node head1, Node head2){
        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1 != null && temp2 !=null){
            if(temp1.random == null) temp2.random = null;

            else
                temp2.random = temp1.random.next;

                temp1 = temp1.next.next;
              if(temp2.next != null)  temp2= temp2.next.next;
        }
    }

    public void split(Node head){
        Node dummy = new Node(-1);
        Node dummy1 = new Node (-1);
        
        Node temp = head;
        Node temp1 = dummy;
        Node temp2 = dummy1;

        while(temp != null){
            temp1.next = temp;
            temp = temp.next;
            temp1 = temp1.next;
            
            temp2.next = temp;
            temp = temp.next;
            temp2 = temp2.next;

        }
        temp1.next = null;

    }
    public Node copyRandomList(Node head) {
        
        Node head2 = copy(head);

        merge(head, head2);

        randomcopy(head, head2);
        
        split(head);
         
         return head2;
    }
}