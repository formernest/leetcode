import java.util.Scanner;
class Q2{
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int num = scanner.nextInt();
        // int []array = new int[num];
        // for (int i=0; i<num; i++){
        //     array[i] = scanner.nextInt();
        // }
        // for (int i=0; i<num; i++){
        //     System.out.println(Q2.encode(array[i]));
        // }
        String s = "55555";
        Q2 q2 = new Q2();
        // String[] result = q2.splits(s, 3);
        // for(String str:result){
        //     System.out.println(str);
        // }
        System.out.println(q2.encode(s));
    }
    public static String encode(String num){
        String result="";
        int length = num.length();
        int size;
        size = (length%3==0)? length/3:length/3+1;
        String[] array1 = splits(num,3);
        int i=0;
        String[] array2 = new String[size];
        char c;
        String[] init = new String[size];
        for(int k=0;k<size;k++){
            array2[i] = Integer.toBinaryString(Integer.valueOf(array1[i]));
            if(array2[i].length()!=10){
                while(array2[i].length()<10){
                    array2[i] = "0" + array2[i];
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
    public static String[] splits(String s, int span){
        int size = (s.length()%span==0)? s.length()/span:s.length()/span+1;
        String[] result = new String[size];
        int i,j;
        j=0;
        while(s.length()!=0){
            if(s.length()-span>=0){
                result[j] = s.substring(s.length()-span,s.length());
                s = s.substring(0,s.length()-span);
            }
            else{
                result[j] = s;
                s="";
            }   
            j++;    
        }
        return result;
    }
}