package offer;

public class GetNumberOfK {
   public int GetNumberOfK(int [] array , int k) {
      int count = 0;
      for(int i=0;i<array.length;i++){
         if(array[i]==k)count++;
      }
      return count;
   }
   /*二分查找 找到第一个K 和 最后一个K 二者位置相减*/
   //[1,2,3,3,3,3,4,5],3
   public int GetNumberOfK1(int [] array , int k) {
      if(array.length==0)
         return 0;
      int firstK = GetFirstIndex(array,k,0,array.length-1);
      int lastK = GetLastIndex(array,k,0,array.length-1);
      if(firstK==-1||lastK==-1)
         return 0;
      else
         return lastK-firstK+1;
   }
   private int GetLastIndex(int[] array, int k, int start, int end) {
      while(start<=end){
         int mid = (start+end)/2;
         if(array[mid]>k){
            end = mid-1;
         }else if(array[mid]<k){
            start = mid+1;
         }else {
            if ((mid + 1 < array.length && array[mid + 1] != k) || mid + 1 == array.length) {
               return mid;
            }else {
               start = mid+1;
            }
         }
      }
      return -1;
   }

   private int GetFirstIndex(int[] array, int k, int start, int end) {
      while(start<=end){
         int mid = (start+end)/2;
         if(array[mid]>k){
            end = mid-1;
         }else if(array[mid]<k){
            start = mid+1;
         }else {
            if ((mid >0 && array[mid - 1] != k) || mid ==0) {
               return mid;
            }else {
               end = mid-1;
            }
         }
      }
      return -1;
   }
}
