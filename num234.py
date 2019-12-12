# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if head == None or head.next == None:
            return True
        slow = head
        fast = head
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        last = slow.next
        pre = head
        while last.next != None:
            tmp = last.next
            last.next = tmp.next
            tmp.next = slow.next
            slow.next = tmp
        while slow.next != None:
            slow = slow.next
            if pre.val != slow.val:
                return False
            pre = pre.next
        return True
        
        

        