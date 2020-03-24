package main
import(
	"sort"
	"fmt"
)
type Interval struct {
	Start int
	End   int
}
type list []Interval
func (I list) Len() int{
	return len(I)
}
func (I list) Less(i, j int) bool{
	return I[i].Start < I[j].Start
}
func (I list) Swap(i, j int){
	I[i], I[j] = I[j], I[i]
}
func merge(intervals []Interval) []Interval {
	sort.Sort(list(intervals))
	var result []Interval
	for _, v := range intervals{
		if(len(result)==0 || result[len(result)-1].End<v.Start){
			result = append(result, v)
		}else{
			if result[len(result)-1].End < v.End{
				result[len(result)-1].End = v.End
			}
		}
	}
	return result
}
func main(){
	var intervals []Interval
	intervals = append(intervals, Interval{1,4}, Interval{0,2}, Interval{3, 5})
	result := merge(intervals)
	fmt.Println(result)
}