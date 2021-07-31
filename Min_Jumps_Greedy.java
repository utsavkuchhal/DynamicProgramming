class Solution{
    static int minJumps(int[] arr){
       int maxReacheableindex = arr[0];
       int stepsWeCanMove = arr[0];
       int minJumps = 1;
       if(arr.length == 1){
           return 0;
       }
       
       if(arr[0] == 0){
           return -1;
       }
       int n = arr.length;
       for(int i = 1; i < arr.length; i++){
           if(i > maxReacheableindex){
               return -1;
           }
           
           if(i == n - 1){
               return minJumps;
           }
           
           maxReacheableindex = Math.max(maxReacheableindex,i + arr[i]);
           stepsWeCanMove--;
           
           if(stepsWeCanMove == 0){
               minJumps++;
               stepsWeCanMove = maxReacheableindex - i;
           }
       }
       return -1;
    }
}
