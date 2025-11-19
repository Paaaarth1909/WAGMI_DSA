package GFG.Easy;

/* You are given the head of a singly linked list and an integer x. Delete the xth node (1-based indexing) from the singly linked list.

Examples:

Input: x = 1,
    
Output: 2 -> 3 -> 1 -> 7
Explanation: After deleting the node at the 1st position (1-base indexing), the linked list is as
    
Input: x = 5,
    
Output: 2 -> 3 -> 4 -> 5
Explanation: After deleting the node at 5th position (1-based indexing), the linked list is as
    
Constraints:
1 ≤ size of linked list ≤ 105
1 ≤ x ≤ size of linked list

*/

class Node
{
    int data;
    Node next;

    Node(int d)
    {
        this.data = d;
        this.next = null;
    }
}

class Solution {
    Node deleteNode(Node head, int x) {
        if (head == null) return null;
        
        // If x == 1, delete the head node
        if (x == 1) {
            return head.next;
        }
        
        Node curr = head;
        for (int i = 1; i < x - 1 && curr != null; i++) {
            curr = curr.next;
        }
        
        // curr is now (x-1)th node
        if (curr != null && curr.next != null) {
            curr.next = curr.next.next;
        }
        
        return head;
    }
}