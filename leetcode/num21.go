package main
type ListNode struct {
	Val int
	Next *ListNode
}
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	var head, curr *ListNode
	if(l1 == nil){return l2}
	if(l2 == nil){return l1}
	if(l1.Val<l2.Val){
		curr = l1
		l1 = l1.Next
	}else{
		curr = l2
		l2 = l2.Next
	}
	head = curr
	for ; l1!=nil; l1=l1.Next{
		for ; l2!=nil && l2.Val<l1.Val; l2=l2.Next{
			curr.Next = l2
			curr = curr.Next
		}
		curr.Next = l1
		curr = curr.Next
	}
	if l2!=nil{
		curr.Next = l2
	}else{
		curr.Next = nil
	}
	return head
}
func main(){

}