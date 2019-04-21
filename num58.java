class num58 {
    public int lengthOfLastWord(String s) {
        String[] splits = s.split(" ");
        if(splits.length > 0){
            return splits[splits.length-1].length();
        }
        return 0;
    }
    public static void main(String[] args) {
        String str = "Hello World and me";
        num58 s = new num58();
        System.out.println(s.lengthOfLastWord(str));
    }
}