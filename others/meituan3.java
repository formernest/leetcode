import java.util.Scanner;
public class meituan3 {
    int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int[] count = new int[k];
        int ans = 0;
        int now = 0;
        
        void dfs(int[] times, int target, int pos) {
            if (target < 0) {  // 剪枝
                return;
            }
            if (pos == k) {
                return;
            }else if(pos==k-1){
                ans = Math.max(ans,now+Collections.min(count)*q);
            } else ans = Math.max(ans,now);
            count[pos]++;
            now+=p;
            dfs(nums, target - nums[pos], pos);
            now-=p;
            count[pos]--;
            // 不选当前选下一个
            dfs(nums, target, pos + 1);
        }
        
        vector<vector<int>> combinationSum(vector<int>& nums, int target) {
            dfs(nums, target, 0);
            return ans;
        }
    }
    public void dfs(int[] times, int target, int pos, int k) {
        if (target < 0) {  // 剪枝
            return;
        }
        if (pos == k) {
            return;
        }else if(pos==k-1){
            ans = Math.max(ans,now+Collections.min(count)*q);
        } else ans = Math.max(ans,now);
        count[pos]++;
        now+=p;
        dfs(nums, target - nums[pos], pos);
        now-=p;
        count[pos]--;
        // 不选当前选下一个
        dfs(nums, target, pos + 1);
    }
}
        