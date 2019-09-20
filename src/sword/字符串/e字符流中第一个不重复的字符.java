package sword.字符串;

/**
 * @author yuyang
 * @create 2019-08-11 10:15
 */
public class e字符流中第一个不重复的字符 {
    private int index;
    private int[] occurence;
    public e字符流中第一个不重复的字符(){
        index=0;
        occurence = new int[256];
        for(int i=0;i<256;i++) {
            occurence[i]=-1;
        }
    }
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(occurence[(int)ch]==-1) {
            occurence[(int)ch]=index;   //第一次出现
        }else if(occurence[(int)ch]>=0) {
            occurence[(int)ch]=-2;   //已经出现过了
        }
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int minIndex=Integer.MAX_VALUE;  //最大的integer
        char ch='#';
        for(int i=0;i<256;i++) {
            if(occurence[i]>=0 && occurence[i]<minIndex) {
                ch = (char) i;
                minIndex=occurence[i];
            }
        }
        return ch;
    }

    public static void main(String[] args) {

    }
}
