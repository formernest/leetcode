package daily_problem;


public class num574 {
    // public boolean isSubtree(TreeNode s, TreeNode t) {
    //     if(s==null && t!=null) return false;
    //     if(s!=null && t==null) return false;
    //     if(s==null && t==null) return true;
    //     if(s.val == t.val){
    //         return (isSubtree(s.left, t.left) && isSubtree(s.right, t.right)) ;
    //     }else{
    //         return false;
    //     }
    //     if(flag) return true;
    //     flag = flag || isSubtree(s.left, t) || isSubtree(s.right, t);
    //     return flag;  
    // }
    public static void main(String[] args) {
        String date = "20200506";
        Long d = Long.parseLong(date);
        System.out.println(d);
    }
}