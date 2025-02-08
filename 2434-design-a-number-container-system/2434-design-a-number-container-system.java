class NumberContainers {

    HashMap<Integer, TreeSet<Integer>> numIdx;
    HashMap<Integer, Integer> idxNum;
    public NumberContainers() {
        numIdx = new HashMap<>();
        idxNum = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(idxNum.containsKey(index)) {
            int num = idxNum.get(index);
            TreeSet<Integer> ts = numIdx.get(num);
            if(ts.size() == 1) {
                numIdx.remove(num);
            }
            else {
                ts.remove(Integer.valueOf(index));
                numIdx.put(num, ts);
            }
        }
        if(numIdx.containsKey(number)) {
            TreeSet<Integer> ts = numIdx.get(number);
            ts.add(index);
            numIdx.put(number, ts);
        }
        else {
            TreeSet<Integer> ts = new TreeSet<>();
            ts.add(index);
            numIdx.put(number, ts);
        }
        idxNum.put(index, number);
    }
    
    public int find(int number) {
        if(numIdx.containsKey(number)) {
            return numIdx.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */