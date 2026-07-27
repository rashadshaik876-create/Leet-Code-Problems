/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;

        // Traverse both lists. When one pointer hits the end, redirect it to the other list's head.
        // If the lists intersect, pA and pB will meet at the intersection node after at most A + B steps.
        // If they do not intersect, both will reach null at the same time.
        while (pA != pB) {
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        return pA;
    }
}
