import java.util.*;

public class BinarySearch{
    public static void main(String[] args){
        int[] array = new int[]{1,2,3,5,6,8};
        int v = 0;
        int leresult = lowerBound(array,0,array.length, v);
        System.out.println("pos:" + leresult);
        int gtresult = upperBound(array,0,array.length, v);
        System.out.println("pos:" + gtresult);
        
        int abs = Arrays.binarySearch(array,v);
        int pos = abs < 0 ? ~abs : abs;
        if(abs >= 0){
            System.out.println("exists position:" + pos);
        }else{
             System.out.println("not exists insertion position:" + pos);
        }
    }
    
    //Find position of target value.
    //If match value doesn't exists return nearest position contains lesser value
    public static int lowerBound(int[] a, int l, int r, int v){
        if(l > r || l < 0 || r > a.length)throw new IllegalArgumentException();
        int low = l - 1 , high = r;
        while(high - low > 1){
            int mid = high + low>>>1;
            if(a[mid] >= v){
                high = mid;
            }else{
                low = mid;
            }
        }
        return low;
    }
    
    //Find position of target value.
    //If match value doesn't exists return nearest position contains greater value
    public static int upperBound(int[] a, int l, int r, int v){
        if(l > r || l < 0 || r > a.length)throw new IllegalArgumentException();
        int low = l - 1 , high = r;
        while(high - low > 1){
            int mid = high + low>>>1;
            if(a[mid] <= v){
                low = mid;
            }else{
                high = mid;
            }
        }
        return high;
    }
    
}