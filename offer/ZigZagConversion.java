class ZigZagConversion {
    public String convert(String s, int numRows) {
        String temp = "";
        int length = s.length();
        int column = length;
        Character [][]array = new Character[numRows][column];
        int i=0,j=0;
        j = 0;
        int row = 0;
        if(numRows == 1){
            temp = s;
        }else{
            for(i=0;i<length;i++){
            
                array[row][j] = s.charAt(i);
                if(row==(numRows-1) || j%(numRows-1) != 0){
                    row--;
                    j++;
                }else if(row == 0 || j%(numRows-1) == 0){
                    row++;
                }
            }
            for(i=0; i<numRows; i++){
                for(j=0; j< column; j++){
                    if(array[i][j]!=null)
                    temp += array[i][j];
                }
            }
        }     
        return temp;
    }
    public static void main(String[] args) {
        ZigZagConversion conv = new ZigZagConversion();
        System.out.println(conv.convert("AB", 1));
    }
}