/*
 * Time Complexity = O(log n)
 * Space Complexity Iterative = O(1)
 */
package Search;

/**
 *
 * @author Ali Tahir
 */
public class BinarySearchIterative {
    
    public static void main(String [] args){
        
        int arr[] = { 5,2 ,5,8,1,9,14,0,6,11,8,3,4,9,1 }; 
         
        int key = 9; 
       
        java.util.Arrays.sort(arr);// binary search works on sorted data
      
        int result = binarySearchIterative(arr,key); 
      
               
        if (result == -1) 
            System.out.println("Key not Found"); 
        else
            System.out.println("Key found at index: " + result); 
     
    
    }
    
    
    // start = left and end = right
    public static int binarySearchIterative(int [] arr,int key){
    
        int start = 0;
        int end = arr.length-1;
        int mid;
        
        while(start <= end){
        
            mid = (start+end)/2;
            
            if(arr[mid] == key){
                return mid;
            }
            
            if(arr[mid] < key){
                start = mid+1;
            }else{
                end = mid-1;
            }
                
        }
        
        return -1; // not found    
    }
    
}
