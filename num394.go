package main
import(
	"regexp"
	"fmt"
	"strings"
)
func decodeString(s string) string {
	var tmp string
	reg := regexp.MustCompile(`[\d]*\[[a-z]+\]`)
	for len(reg.FindAllString(s,-1))!=0{
		result := reg.FindAllString(s, -1)
		for _, v := range result{
			tmp = ""
			num := int(v[0])
			str := s[2:len(v)-1]
			for num > 0{
				tmp = tmp + str
				num--
			}
			s = strings.Replace(s, v, tmp, 0)
		}
	}
	return s
}
func main(){
	text := "2[abc]3[cd]ef"
	fmt.Println(decodeString(text))
}