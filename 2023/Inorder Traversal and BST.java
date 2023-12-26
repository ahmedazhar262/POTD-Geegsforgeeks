// Given an array arr of size N, determine whether this array represents an inorder traversal of a BST. 

// Note: All keys in BST must be unique


class Solution
{
    static int isRepresentingBST(int arr[], int N)
    {
        // code here
        if(N<=1){
            return 1; 
        }
        int prev = arr[0];
        
        for (int i = 1; i < N; i++){
             int curr = arr[i];
             if (curr <= prev){
                 return 0;
             }
             prev = curr;
        }
        return 1;
    }
}