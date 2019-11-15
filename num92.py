# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

# Input: 1->2->3->4->5->NULL, m = 2, n = 4
# Output: 1->4->3->2->5->NULL

class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        Mleft, Nright = None, None
        index = 1
        pre = head
        current = head
        while current:
            next = current.next
            if index >= m and index <= n:
                current.next = pre
            if index == m-1:
                Mleft = current
            if index == m:
                M = current
            if index == n:
                N = current
            if index == n+1:
                Nright = current
                break
            pre = current
            current = next
            index += 1
        if Mleft is not None:  # 不是从1开始进行反转
            Mleft.next = N
        if M is not None:
            M.next = Nright
        if Mleft is None:  # 从1开始反转
            return N
        else:
            return head
