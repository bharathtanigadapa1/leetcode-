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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head.next;//because when there is only two nodes starting fast from results in losing the first node 
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second= slow.next;
        slow.next=null;
        ListNode left= sortList(head);
        ListNode right= sortList(second);
        return merge(left,right);
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy= new ListNode(0,null);
        ListNode cur=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }
            else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if(l1!=null) cur.next=l1;
        if(l2!=null) cur.next=l2;
        return dummy.next;
    }
}