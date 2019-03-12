package main
import(
	"sort"
	"fmt"
)
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	nums1 = append(nums1, nums2...)
	sort.Ints(nums1)
	length := len(nums1)
	var result float64
	if length % 2 == 0{
		result =(float64) (nums1[length/2-1]+nums1[length/2])/2
	}else{
		result = (float64)(nums1[length/2])
	}
	return result
}
func main(){
	nums1 := []int{1,3}
	nums2 := []int{2}
	result := findMedianSortedArrays(nums1, nums2)
	fmt.Println(result)	
}