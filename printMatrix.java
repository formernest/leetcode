import java.util.ArrayList;
public class printMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {  
       ArrayList<Integer> result = new ArrayList<>();
       if(matrix == null || matrix[0].length == 0) return result;
       int startRow = 0, startCol = 0, endRow = matrix.length-1, endCol = matrix[0].length-1;
       help(result, matrix, startRow, startCol, endRow, endCol);
       return result;
    }
    public void help(ArrayList<Integer> result, int [][]matrix, int startRow, int startCol, int endRow, int endCol){
        if(startCol < endCol && startRow < endRow){
            for(int i=startCol; i<=endCol; i++) result.add(matrix[startRow][i]);
            for(int i=startRow+1; i<=endRow-1; i++) result.add(matrix[i][endCol]);
            for(int i=endCol; i>=startCol; i--) result.add(matrix[endRow][i]);
            for(int i=endRow-1; i>startRow; i--) result.add(matrix[i][startCol]);
            help(result, matrix, startRow+1, startCol+1, endRow-1, endCol-1);
        }else if(startRow == endRow && startCol < endCol){
            for(int i=startCol; i<=endCol; i++) result.add(matrix[startRow][i]);
        }else if(startCol == endCol && startRow < endRow){
            for(int i=startRow; i<=endRow; i++) result.add(matrix[i][startCol]);
        }else if(startRow == endRow && startCol == endCol){
            result.add(matrix[startRow][startCol]);
        }else{
            return;
        }  
    }
    public static void main(String[] args) {
        printMatrix solution = new printMatrix();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> result = solution.printMatrix(matrix);
        for(int item: result){
            System.out.println(item);
        }

    }
}