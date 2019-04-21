class num44 {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()||p=='*') return s.isEmpty();
        boolean first_match = (!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='?'));
        if(p.length()>=2 && p.charAt(1)=='*'){
            return (isMatch(s, p.substring(2))||(first_match&&isMatch(s.substring(1), p)));
        }else{
            return (first_match&&isMatch(s.substring(1), p.substring(1)));
        }
    }
    public static void main(String[] args) {
        num44 s = new num44();
        String text = "aa";
        String p = "*";
        System.out.println(s.isMatch(text, p));
    }
}