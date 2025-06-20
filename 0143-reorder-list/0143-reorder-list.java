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
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode sec=slow.next;
        slow.next=null;
        ListNode node=null;
        while(sec!=null)
        {
            ListNode temp=sec.next;
            sec.next=node;
            node=sec;
            sec=temp;
        }
        ListNode first=head;
        sec=node;
        while(sec!=null)
        {
            ListNode t1=first.next,t2=sec.next;
            first.next=sec;
            sec.next=t1;
            first=t1;
            sec=t2;
        }
    }
}