package main
import(
	"fmt"
)
type Dict struct{
	key string
	value int
}
func intToRoman(num int) string {
	var result string
	dict := []Dict{{"M",1000},{"CM",900},{"D",500},{"CD",400},{"C",100},{"XC",90},{"L",50},{"XL",40},{"X",10},{"IX",9},{"V",5},{"IV",4},{"I",1}}
	for _, v:= range dict{
		temp := num - v.value
		for temp >= 0 && num > 0{
			num = num - v.value
			result = result + v.key
			temp = num - v.value
		}
		if num == 0{
			break
		}
	}
	return result
}
func main(){
	fmt.Println(intToRoman(1994))
}