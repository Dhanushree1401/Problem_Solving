class MyCalendar {
    TreeMap<Integer,Integer>calc;
    public MyCalendar() {
    calc = new TreeMap();    
    }
    
    public boolean book(int start, int end) {
    Integer prevBook = calc.floorKey(start);
    Integer nextBook = calc.ceilingKey(start);
    if((prevBook==null || calc.get(prevBook)<=start) && (nextBook==null || end<=nextBook)) 
    { 
    calc.put(start, end);
    return true;
    }
    return false;      
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */