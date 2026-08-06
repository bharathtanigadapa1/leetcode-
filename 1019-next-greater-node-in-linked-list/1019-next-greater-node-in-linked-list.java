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
    public int[] nextLargerNodes(ListNode head) {
        int n=0;
        ListNode temp=head;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        temp=head;
        int res[]= new int[n];
        Deque<Integer> st= new ArrayDeque<>();
        for(int i=0;i<n;i++){
            res[i]=temp.val;
            temp=temp.next;
        }
        temp=head;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && res[i]>res[st.peek()]){
                res[st.pop()]=res[i];
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            res[st.pop()]=0;
        }
        return res;

    }
    
}