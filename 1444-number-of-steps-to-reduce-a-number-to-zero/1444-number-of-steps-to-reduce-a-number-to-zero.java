class Solution {
    public int numberOfSteps(int num) {
        return reduce(num,0);
    }
    private static int reduce(int num,int count){
        if(num==0) return count;
        num = ((num&1)==0) ? num/2 : num-1;
        return reduce(num,++count);
    }
}