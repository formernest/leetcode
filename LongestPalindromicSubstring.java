class longestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return s;
        }
        String maxs = "";
        String temp = ""+s.charAt(0);
        int maxlength= 0;
        for(int i=0;i<s.length()-maxlength;i++){
            for(int j=i+1; j<s.length();j++){
                if (s.charAt(j)==temp.charAt(0)){
                    temp = temp+s.charAt(j);
                    if(temp.length()>maxlength){
                        maxlength = temp.length();
                        maxs = temp;
                    }
                    temp = ""+temp.charAt(1);
                    break;
                }else{
                    temp = temp+s.charAt(j);
                }
            }
        }
        return maxs;
    }
    public static void main(String[] args) {
        longestPalindromeSubstring s = new longestPalindromeSubstring();
        System.out.println(s.longestPalindrome("cbbd"));
    }
}