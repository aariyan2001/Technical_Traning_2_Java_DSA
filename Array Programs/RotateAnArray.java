public class RotateAnArray {
    public static void reverse(int arr[], int low,int high){
        while(low<high){
            int tmp=arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
            low++;
            high--;
        }
    }
    public static void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k%nums.length;
        for(int i=0;i<k;i++){
            reverse(nums,0,l-1-k);
            reverse(nums,l-k,l-1);
        }
    }
    public static void main(String[] args) {
        int nums[]= {1,2,3,4,5,6,7};
         rotate(nums, 3);
         reverse(nums, 0, nums.length-1);
         for(int ele:nums){
            System.out.print(ele+" ");
         }
    }
}
