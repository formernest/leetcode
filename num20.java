import java.util.Stack;

class num20{
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        try {
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                if(c == '('||c == '{' || c == '['){
                    stack.push(c);
                }else{
                    Character peek = stack.peek();
                    if(c==')'){
                        if(peek!='(') return false;
                        else stack.pop();
                    }
                    if(c=='}'){
                        if(peek!='{') return false;
                        else stack.pop();
                    }
                    if(c==']'){
                        if(peek!='[') return false;
                        else stack.pop();
                    }
                }
            } 
        } catch (Exception EmptyStackException) {
            return false;
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        num20 s = new num20();
        System.out.println(s.isValid("{"));
    }
}