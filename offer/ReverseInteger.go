package main
import (
	"fmt"
)
func reverse(x int) int {
	max := int(^uint32(0) >> 1)
	min := ^max
	result := 0
	current := 0
    for x!=0 {
		current = x%10
		result = result * 10 + current
		x = x/10
	}
	if(result > max || result < min){
		return 0
	}
	return result
}
func main(){
	fmt.Println(reverse(123))
}