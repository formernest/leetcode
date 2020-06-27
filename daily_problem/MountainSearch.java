package daily_problem;

interface MountainArray {
    public int get(int index);
    public int length();
}
public class MountainSearch {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0;
        int r = mountainArr.length()-1;
        while(l < r){
            int mid = (l+r)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        int peek = l;
        int index = binarySearch(target, mountainArr, 0, peek);
        if(index != -1) return index;
        return binarySearch(target, mountainArr, peek+1, mountainArr.length()-1);
    }
    public int binarySearch(int target, MountainArray mountainArr, int left, int right){
        while(left <= right){
            int mid = (left+right)/2;
            if(mountainArr.get(mid) == target) return mid;
            if(mountainArr.get(mid) > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}