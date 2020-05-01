/*
 * Divide and Conquer Algorithm for MaxSubArray sum
 * Time Complexity O(nlogn) 
 */
package subarray;

/**
 *
 * @author Ali Tahir
 */
public class DivideAndConquer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
	Tuple result = MaxSubArray(arr,0,arr.length-1);
        System.out.println("Left Index: " + Integer.toString(result.left) + "  Right Index: " + Integer.toString(result.right));
        System.out.println("Sum: " + Integer.toString(result.sum));
    }
    
    public static Tuple MaxSubArray(int arr[],int s,int e){
        
        if(s == e){
            return new Tuple(s,e,arr[s]);
        }
        
        int mid = (s+e)/2;
        Tuple left = MaxSubArray(arr,s,mid);
        Tuple right =  MaxSubArray(arr,mid+1,e);
        Tuple cross = CrossingSum(arr,s,mid,e);
        
        if(left.sum>right.sum && left.sum>cross.sum){
            return left;
        }else if(right.sum>left.sum && right.sum>cross.sum){
            return right;
        }else{
            return cross;
        }
    }
    
    
    public static Tuple CrossingSum(int arr[],int s,int mid,int e){
    
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int rightIndex = 0;
        int leftIndex = 0;
        
        int sum = 0;
        
         for(int i= mid ; i>=s;i--){
            sum += arr[i];
            if(sum > leftSum){
                leftSum = sum;
                leftIndex = i;
            }
        }
        
         sum = 0;
        
        for(int j=mid+1;j<=e;j++){
            sum += arr[j];
            if(sum > rightSum){
                rightSum = sum;
                rightIndex = j;
            }
        }
                
        return new Tuple(leftIndex,rightIndex,rightSum+leftSum);
    
    }
   
    
}
