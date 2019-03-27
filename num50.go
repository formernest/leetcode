package main
import(
	"math"
	"fmt"
)
func myPow(x float64, n int) float64 {
	y := math.Pow(x, float64(n))
	return y
}
func main(){
	fmt.Println(myPow(2.00000, -2))
}