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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode cur=slow;
        ListNode prev=null;
        ListNode nxt;
        while(cur!=null){
            nxt=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
        }
        ListNode head2=prev;
        int maxSum=0;
        while(head2!=null){
            maxSum=Math.max(maxSum,head.val+head2.val);
            head=head.next;
            head2=head2.next;
        }
        return maxSum;
    }
}