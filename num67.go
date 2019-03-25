package main
import(
	"fmt"
)
func addBinary(a string, b string) string {
	var sum int
	i:=len(a)	
	j:=len(b)
	if(i < j){
		i, j = j, i
		a, b = b, a
	}
	result := make([]byte, i+1)
	var carry int
	var curr int
    for j>0 {
		j--
		i--
		sum = int(a[i]-'0')+int(b[j]-'0') + carry
		curr = sum % 2
		carry = sum / 2
		result[i+1] = byte(curr + '0')
	}
	for i > 0{
		i--
		curr := (int(a[i]-'0') + carry) % 2
		carry = (int(a[i]-'0') + carry) / 2
		result[i+1] = byte(curr+'0')
	}
	result[0] = byte(carry+'0')
	i = 0
	for i<len(result)-1{
		if result[i] == '0'{
			i++
			continue
		}else{
			break
		}
	}
	return string(result[i:])
}
func main(){
	a := "1010"
	b := "1011"
	fmt.Println(addBinary(a,b))
}