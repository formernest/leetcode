public class FirstAppearingOnce {
    int[] count = new int[256];
    int index = 1;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(count[ch] == 0){  // 第一次出现的字符记录出现的位置
            count[ch] = index ++;
        }else{
            count[ch] = -1;  //非第一次出现的直接置为-1，不考虑
        }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int temp = Integer.MAX_VALUE;
        char ch = '#';
        for(int i=0; i<256; i++){
            if(count[i] != 0 && count[i] != -1 && temp>count[i]){
                temp = count[i];
                ch = (char) i;
            }
        }
        return ch;
    }
}