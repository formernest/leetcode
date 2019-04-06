package main
import(
	"fmt"
)
func isMatch(s string, p string) bool {
    if p == "" {
		if s=="" {
			return true
		}
	}
	first_match := (len(s)!=0 && (p[0] == s[0] || p[0] == '.'));
        if (len(p) >= 2 && p[1] == '*'){
            return (isMatch(s, p[0:2])||(first_match && isMatch(s[0:1], p)));
        } else{
            return first_match && isMatch(s[0:1], p[0:1]);
        }
}
func main(){
	fmt.Println(isMatch("aa","a*"))
}