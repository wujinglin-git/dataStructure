import java.util.ArrayList;
import java.util.List;

class Solution {


    List list = new ArrayList();
    public List arr(){
        int x = 0;
        for (int i = 3; i <=1000 ; i++) {
            for (int j = 2; j <= i; j++) {
                if(i%j==0){
                    x++;
                }
            }
            if (x==0){
                list.add(i);
                x=0;
            }
        }
        return list;
    }
    int test(int n){
        List list = arr();
        for (int i = 0; i < list.size(); i++) {
            if ((int)list.get(i)>=n){
                return i-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        int max = solution.test(n);
        List list = solution.arr();
        int val = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j <= max; j++) {

                if (n == i+j){
                    val++;
                }
            }
        }
        System.out.println(list.size());
    }
}