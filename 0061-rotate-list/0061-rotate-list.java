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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        ListNode temp=head;
        int n=0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        
        k=k%n;
        if(k==0) return head;
        head=reverse(head,null);
        temp=head;
        for(int i=1;i<k;i++){
            temp=temp.next;
        }
        ListNode second= temp.next;
        temp.next=null;
        ListNode firstPart=reverse(head,null);
        ListNode secondPart=reverse(second,null);
        head.next=secondPart;
        return firstPart;
    }
    public ListNode reverse(ListNode head1 , ListNode head2){
        ListNode cur=head1;
        ListNode prev=null;
        ListNode nxt;
        while(cur!=head2){
            nxt=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
        }
        return prev;
    }
}