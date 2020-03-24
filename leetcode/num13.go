package main
import(
    "fmt"
    "strings"
)
type Dict struct{
	key string
	value int
}
func romanToInt(s string) int {
    var result int
    dict := []Dict{{"CM",900},{"M",1000},{"CD",400},{"D",500},{"XC",90},{"C",100},{"XL",40},{"L",50},{"IX",9},{"X",10},{"IV",4},{"V",5},{"I",1}}
    for _, v := range dict{
        for strings.Index(s, v.key)!=-1{
            result = result + v.value
            s = strings.Replace(s, v.key, "", 1)
        }        
        if s == ""{
            break
        }
    }
    return result
}
func main(){
    fmt.Println(romanToInt("MCMXCIV"))
}