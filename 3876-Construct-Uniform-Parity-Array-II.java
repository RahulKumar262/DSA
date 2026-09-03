class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=Integer.MAX_VALUE,minodd=Integer.MAX_VALUE;
        for(int i=0;i<nums1.length;i++) {
            min=Math.min(min,nums1[i]);
            if(nums1[i]%2!=0)
            minodd=Math.min(minodd,nums1[i]);
        }
        boolean even=false;int cnt=0;
        if(min%2==0) even=true;
        for(int i=0;i<nums1.length;i++){
            if(even && nums1[i]%2!=0 && nums1[i]>minodd){
               nums1[i]-=minodd;
               cnt++;
            }else if(!even && nums1[i]%2==0 && nums1[i]>min){
                nums1[i]-=min;
                cnt++;
            }else if(even && nums1[i]%2==0){
                cnt++;
            }else if(!even && nums1[i]%2!=0){
                cnt++;
            }
        }
       
        return cnt==nums1.length;
    }
}