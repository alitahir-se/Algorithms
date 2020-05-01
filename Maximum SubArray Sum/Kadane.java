/*
 * Kadane's Algorithm for MaxSubArray sum
 * Time Complexity O(n)
 * Original Algo assumes given array has atleast one positive element.
 * Check for the case when all elements are negative is added. 
 */
package subarray;

/**
 *
 * @author Ali Tahir
 */
public class Kadane {
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
	Tuple result = MaxSubArray(arr);
        System.out.println("Left Index: " + Integer.toString(result.left) + "  Right Index: " + Integer.toString(result.right));
        System.out.println("Sum: " + Integer.toString(result.sum));
    }
    
    
    public static Tuple MaxSubArray(int arr[]){
        
        int max = Integer.MIN_VALUE;
        int allNegativemax = Integer.MIN_VALUE; // for the case when all elements are negative
        boolean isPositive = false; // flag to see if atleast one element is positive
        
        int sum = 0;
        
        int negIndex = 0; // index of greatest element if all elements are negative 
        int leftIndex = 0;
        int rightIndex = 0;
        int start = 0;
        
        for(int i=0;i<arr.length;i++){
            
            if(!isPositive && arr[i] > 0){
                isPositive = true;
            }
            
            if(!isPositive && allNegativemax < arr[i]){
                allNegativemax = arr[i];
                negIndex = i;
            }
            
            sum += arr[i];
            
            if(sum < 0){
                sum = 0;
                start = i+1;
            
            }else if(sum > max){
                max = sum;
                leftIndex = start;
                rightIndex = i;
            
            }
        
        }
    
        
        if(!isPositive){
            return new Tuple(negIndex,negIndex,allNegativemax);
        }
        
        
      return new Tuple(leftIndex,rightIndex,max);
    
    }
    
    
}
