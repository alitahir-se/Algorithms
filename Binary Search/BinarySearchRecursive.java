/*
 * Time Complexity = O(log n)
 * Space Complexity Recursive = O(log n) // call stack is used for recursion
 * Recurence Relation: T(n/2) + c 
 */
package Search;

/**
 *
 * @author Ali Tahir
 */
public class BinarySearchRecursive {
    
    public static void main(String [] args){
        
        int arr[] = { 5,2 ,5,8,1,9,14,0,6,11,8,3,4,9,1 }; 
        int size = arr.length; 
        int key = 9; 
       
        java.util.Arrays.sort(arr);// binary search works on sorted data
      
        int result = binarySearchRecursive(arr,key,0, size - 1); 
      
        
       
        if (result == -1) 
            System.out.println("Key not Found"); 
        else
            System.out.println("Key found at index: " + result); 
     
    
    }
    
    // start = left and end = right
    public static int binarySearchRecursive(int [] arr,int key,int start,int end){
        
        if(start <= end){
            
            int mid = (start+end)/2;
            
            if(arr[mid] == key){
                return mid;
            }
        
            
            if(arr[mid] < key){
                return binarySearchRecursive(arr,key,mid+1,end);
            }else{
                return binarySearchRecursive(arr,key,start,mid-1);
            }
        
        }
        
        return -1; // not found
    
    
    }
    
}
