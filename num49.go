package main
import(
	"fmt"
	"strings"
)
func groupAnagrams(strs []string) [][]string {
	var result [][]string
	if len(strs) == 0{
		return result
	}
	var tmp []string
    for i:=1; i<len(strs); i++{
		
	}
	return result
}
func main(){
	strs := []string{"eat", "tea", "tan", "ate", "nat", "bat"}
	fmt.Println(groupAnagrams(strs))
}