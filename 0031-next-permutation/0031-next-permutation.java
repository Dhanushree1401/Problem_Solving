class Solution {
    public void nextPermutation(int[] arr) {
        int n=arr.length;
        int i=n-2;
        while(i>=0 && arr[i]>=arr[i+1])
        {
            i--;
        }

        if(i>=0)
        {
            int j=n-1;
            while(arr[i]>=arr[j])
            {
                j--;
            }
            swap(arr,i,j);
        }
        reverse(arr,i+1,n-1);
    }
    public static void swap(int arr[],int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void reverse(int arr[],int st,int end)
    {
        int i=st,j=end;
        while(i<j)
        {
            swap(arr,i,j);
            i++;
            j--;
        }
    }
}