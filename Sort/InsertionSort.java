/*
 * Time Complexity = O(n^2)
 * Space Complexity = O(1) // thus it is in-place sorting 
 */
package Sort;

/**
 *
 * @author Ali Tahir
 */
public class InsertionSort {
    
    public static void main(String [] args){
        
        int [] arr = {10,9,8,7,6,5,4,3,2,1};
        insertionSort(arr);
        
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        
        System.out.println();
    
    }
    
    
    public static void insertionSort(int [] arr){
        
        int key,j;
        for(int i=1;i<arr.length;i++){
            
            key = arr[i];
            j = i-1;
            while(j>= 0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            
            arr[j+1] = key;
        
        
        }
    
    }
    
}
