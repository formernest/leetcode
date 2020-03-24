class num125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0, end = s.length()-1;
        while(start < end){
            while(!Character.isAlphabetic(s.charAt(start)) && !Character.isDigit(s.charAt(start)) && start<end) start++;
            while(!Character.isAlphabetic(s.charAt(end)) && !Character.isDigit(s.charAt(end)) && end>start) end--;
            if(start == end) return true;
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = ",;";
        num125 solution = new num125();
        System.out.println(solution.isPalindrome(s));
    }
}