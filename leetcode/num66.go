package main
import(
	"fmt"
)
func plusOne(digits []int) []int {
	carry := 1
    for i:=len(digits)-1;i>=0;i--{
		curr := (digits[i] + carry)%10
		carry = (digits[i] + carry)/10
		digits[i] = curr
	}
	if carry > 0{
		digits = append([]int{carry},digits...)
	}
	return digits
}
func main(){
	digits := []int{9,9,9,9}
	fmt.Println(plusOne(digits))
}