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
        ListNode dummy= new ListNode(0);
        ListNode cur=dummy;
        ListNode h1=reverse(l1);
        ListNode h2=reverse(l2);
        int carry=0;
        while(h1!=null || h2!=null || carry>0){
            int value=carry;
            if(h1!=null){
                value+=h1.val;
                h1=h1.next;
            }
            if(h2!=null){
                value+=h2.val;
                h2=h2.next;
            }
            carry=value/10;
            cur.next=new ListNode(value%10);
            cur=cur.next;
        }
        return reverse(dummy.next);
    }
    private ListNode reverse(ListNode head){
        ListNode cur=head;
        ListNode prev=null;
        ListNode nxt;
        while(cur!=null){
            nxt=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
        }
        return prev;
    }
}