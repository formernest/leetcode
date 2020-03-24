import java.util.LinkedList;

public class GetMedian {
    LinkedList<Integer> items = new LinkedList<Integer>();

    public void Insert(Integer num) {
        if(items.size() == 0 || num < items.getFirst()) items.addFirst(num);
        else{
            boolean flag = false;
            for(Integer e:items){
                if(num < e){
                    int index = items.indexOf(e);
                    items.add(index, num);
                    flag = true;
                    break;
                }
            }
            if(!flag) items.addLast(num);
        }
    }

    public Double GetMedian() {
        if(items.size() == 0) return null;
        int index = items.size() / 2;
        if(items.size() % 2 == 0){
            return (Double.valueOf(items.get(index-1)) + Double.valueOf(items.get(index))) / 2;
        }
        return Double.valueOf(items.get(index));
    }

    public static void main(String[] args) {
        GetMedian solution = new GetMedian();
        solution.Insert(0);
        Double item = solution.GetMedian();
        System.out.println(Double.valueOf(item));
        solution.Insert(1);
        solution.Insert(2);
        solution.Insert(3);
        item = solution.GetMedian();
        System.out.println(Double.valueOf(item));
    }
}