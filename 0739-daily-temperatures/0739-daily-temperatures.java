class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
     Stack<Integer>ss=new Stack<>();
     int[] result=new int[temperatures.length];
     for(int i=0;i<temperatures.length;i++)
     {
        while(!ss.isEmpty() && temperatures[i]>temperatures[ss.peek()])
        {
            int index=ss.pop();
            result[index]=i-index;
        }
        ss.push(i);
     }   
     return result;
    }
}