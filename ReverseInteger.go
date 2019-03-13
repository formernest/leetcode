package main
import (
	"fmt"
)
func reverse(x int) int {
	result := 0
	current := 0
    for x!=0 {
		current = x%10
		result = result * 10 + current
		x = x/10
	}
	return result
}
func main(){
	fmt.Println(reverse(123))
}