import java.util.Scanner;
class Q2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int []array = new int[num];
        for (int i=0; i<num; i++){
            array[i] = scanner.nextInt();
        }
        for (int i=0; i<num; i++){
            System.out.println(Q2.encode(array[i]));
        }
    }
    public static String encode(int num){
        String result = "";
        String numToString = Integer.toString(num);
        int length = numToString.length();
        int size;
        size = (length%3==0)? length/3:length/3+1;
        int[] array1 = new int[size];
        int i=0;
        String[] array2 = new String[size];
        char c;
        while(num!=0){
            array1[i] = num%1000;
            array2[i] = Integer.toBinaryString(array1[i]);
            if(array2[i].length()!=10){
                while(array2[i].length()<10){
                    array2[i] = "0"+array2[i];
                } 
            }
            int temp = Integer.parseInt(array2[i].substring(5,10),2);
            if(temp>9){
                c = (char)(temp-10+'A');
            }else{
                c = (char)(temp+'0');
            }
            result = c+result;
            temp = Integer.parseInt(array2[i].substring(0,5),2);
            if(temp>9){
                c = (char)(temp-10+'A');
            }else{
                c = (char)(temp+'0');
            }
            result = c+result;
            num = num/1000;
            i++;
        }
        for(i=0; i<result.length();i++){
            if(result.charAt(i)!='0') break;
            else{
                result = result.substring(i+1, result.length());
            }
        }
        return result;
    }
}