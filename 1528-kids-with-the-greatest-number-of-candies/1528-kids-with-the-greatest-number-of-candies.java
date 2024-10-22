class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int count=0;
        for(int candy:candies)
        {
            if(candy>count)
            {
                count=candy;
            }
        }
        List<Boolean>re=new ArrayList<>();
        for(int candy:candies)
        {
            re.add(candy+extraCandies>=count);
        }
        return re;
    }
}