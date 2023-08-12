import java.util.ArrayList;

public class LeetCode_82_MergerSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1ptr=0;
        int n2ptr=0;
        ArrayList<Integer> result = new ArrayList<>();
        
        if(n==0 && m==1){
            result.add(nums1[0]);
            for (int i = 0; i < result.size(); i++){
                nums1[i] = result.get(i);
            }           
                
            //System.out.println(result);
            //System.exit(0);
        }
        else if(m==0&&n==1){
                result.add(nums2[0]);
                for (int i = 0; i < result.size(); i++){
                    nums1[i] = result.get(i);
                }
                //System.out.println(result);
                //System.exit(0);
        }
        else{
            while(n1ptr<(m) && n2ptr<n){
                if(nums1[n1ptr]<nums2[n2ptr] ){
                    result.add(nums1[n1ptr]);
                    n1ptr++;  
                }
                else if(nums1[n1ptr]>nums2[n2ptr] ){
                    result.add(nums2[n2ptr]);
                    n2ptr++;
                }
                else if(nums1[n1ptr]==nums2[n2ptr] ){
                    result.add(nums1[n1ptr]);
                    result.add(nums2[n2ptr]);
                    n1ptr++;
                    n2ptr++;
                }
            }

            if(n1ptr<m){
                for(int i=n1ptr;i<(m);i++){
                    result.add(nums1[i]);
                    n1ptr++;
                }
                
            }
            if(n2ptr<n){
                for(int i=n2ptr;i<n;i++){
                    result.add(nums2[i]);
                    n2ptr++;
                }
            }
        }
        //System.out.println(result);  
        for (int i = 0; i < result.size(); i++){
                nums1[i] = result.get(i);
                System.out.print(nums1[i]+" ");
            }
             

    }
    public static void main(String[] args) {
        int nums1[] = {2,0}, m=1;
        int nums2[] = {1}, n=1;
        merge(nums1, m, nums2, n);        

    }
}
