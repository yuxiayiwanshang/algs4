public class BinarySearch{
    public BinarySearch(){
    }
    
    public static int indexOf(int[] a, int key){
        int lo=0;
        int hi=a.length -1;
        while(lo<=hi){
            int mid = ( lo+ hi)/2;
            if(key > a[mid] ) lo = mid +1;
            else if(key < a[mid] ) hi = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    public static void main(String[] args){
        int[] a = {1,4,7,11,15,23};
        System.out.println(indexOf(a,7));
    }
}
