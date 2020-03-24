public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            int sum = 0;
            for(int j=i; j<array.length; j++){
                sum += array[j];
                max = sum > max? sum:max;
            }        
        }
        return max;
    }
    public static void main(String[] args) {
        FindGreatestSumOfSubArray solution = new FindGreatestSumOfSubArray();
        int[] array = {6,-3,-2,7,-15,1,2,2};
        int result = solution.FindGreatestSumOfSubArray(array);
        System.out.println(result);
    }
}