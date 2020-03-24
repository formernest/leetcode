package main
import(
	"sort"
	"fmt"
)
func largestSumAfterKNegations(A []int, K int) int {
	if(len(A) == 0){
		return 0;
	}
    for K > 0{
		sort.Ints(A)
		A[0] = -A[0]
		K--
	}
	var sum int
	for _, v := range A{
		sum += v
	}
	return sum
}
func main(){
	A := []int{2,-3,-1,5,-4}
	fmt.Println(largestSumAfterKNegations(A, 2))
}