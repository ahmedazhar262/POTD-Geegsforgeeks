// Split Array Largest Sum

class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int start= 0;
        int end= 0;
        
        for(int x: arr){
            start = Math.max(start, x);
            end+= x;
        }
        while(start<end){
            int mid= start+ (end-start)/2;
            
            int pieces=1;
            int sum= 0;
            
            for(int x: arr){
                if(x+ sum<=mid){
                    sum+= x;
                }else{
                    pieces++;
                    sum= x;
                }
            }
            if(pieces<=K){
                end= mid;
            }else{
                start= mid+1;
            }
        }
       return end;
    }
};