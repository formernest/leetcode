//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int xor = 0;
        for(int i=0; i<array.length; i++){
            xor ^= array[i];
        }
        int flag = 1;
        while((xor & flag) == 0) flag <<= 1;
        for(int i=0; i<array.length; i++){
            if((flag & array[i]) == 0) num1[0] ^= array[i];
            else num2[0] ^= array[i];
        }
    }

    public static void main(String[] args) {
        FindNumsAppearOnce solution = new FindNumsAppearOnce();
        int[] array = {0,0,1,1,2,2,3,4};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        solution.FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}