package main
import(
	"strconv"
	"fmt"
)
func letterCombinations(digits string) []string {
	var result []string
	if digits == ""{
		return result
	}
	dict := map[int]string{2:"abc",3:"def",4:"ghi",5:"jkl",6:"mno",7:"pqrs",8:"tuv",9:"wxyz"}
	length := len(digits)
	i := 0
	for i<length {
		current,_ := strconv.Atoi(string(digits[i]))
		if len(result)==0{
			for _, v:= range dict[current]{
				result = append(result, string(v))
			}
		}else{
			currlen := len(result)
			for j:=0; j < currlen; j++{
				for _, char := range dict[current]{
					result = append(result,result[j]+string(char))
				}
			}
			result = result[currlen:len(result)]
		}
		i++
	}
	return result
}
func main(){
	fmt.Println(letterCombinations("2345"))
}