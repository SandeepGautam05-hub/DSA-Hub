/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
// class Solution {
//     public ListNode middleNode(ListNode head) {

//         int cnt = 0;
//         ListNode temp = head;

//         // Count the nodes
//         while (temp != null) {
//             cnt++;
//             temp = temp.next;
//         }

//         int middle = cnt / 2;

//         // Traverse to the middle node
//         temp = head;
//         int cnt2 = 0;

//         while (cnt2 < middle) {
//             temp = temp.next;
//             cnt2++;
//         }

//         return temp;
//     }
// }

class Solution {
    // Sandeep Gautam
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}