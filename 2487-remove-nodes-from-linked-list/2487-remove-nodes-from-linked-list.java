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
    public ListNode removeNodes(ListNode head) {
        head=reverse(head);
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            if(temp.val>temp.next.val){
                temp.next=temp.next.next;
            }
            else    temp=temp.next;
        }
        return reverse(head);
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