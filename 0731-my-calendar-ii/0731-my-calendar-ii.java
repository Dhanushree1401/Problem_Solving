class MyCalendarTwo {
    private List<int[]>book,over;
    public MyCalendarTwo() {
        book=new ArrayList<>();
        over=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] i:over)
        {
            if(start<i[1] && end>i[0])
            {

                return false;
            }
        }
        for(int[] j:book)
        {
            if(start<j[1] && end>j[0])
            {
                over.add(new int[]{Math.max(start,j[0]),Math.min(end,j[1])});
            }
        }
        book.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */