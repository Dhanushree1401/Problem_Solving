class SummaryRanges {
    private final TreeMap<Integer, Integer> orderedMap;

    public SummaryRanges() {
        this.orderedMap = new TreeMap<>();
    }
    
    public void addNum(final int value) {
        if(!this.orderedMap.containsKey(value)) {
            final Map.Entry<Integer, Integer> low = this.orderedMap.lowerEntry(value);

            if(low == null) {
                if(this.orderedMap.containsKey(value + 1)) {
                    this.orderedMap.put(value, this.orderedMap.get(value + 1));
                    this.orderedMap.remove(value + 1);
                } else {
                    this.orderedMap.put(value, value);
                }
            } else {
                if(value > low.getValue()) {
                    if(low.getValue() == value - 1) {
                        int right = value;

                        if(this.orderedMap.containsKey(value + 1)) {
                            right = this.orderedMap.get(value + 1);
                            this.orderedMap.remove(value + 1);
                        }

                        this.orderedMap.put(low.getKey(), right);
                    } else {
                        if(this.orderedMap.containsKey(value + 1)) {
                            this.orderedMap.put(value, this.orderedMap.get(value + 1));
                            this.orderedMap.remove(value + 1);
                        } else {
                            this.orderedMap.put(value, value);
                        }
                    }
                }
            }
        }
    }
    
    public int[][] getIntervals() {
        final int[][] intervals = new int[this.orderedMap.size()][2];

        int i = 0;

        for(final Map.Entry<Integer, Integer> interval : this.orderedMap.entrySet()) {
            intervals[i][0] = interval.getKey();
            intervals[i++][1] = interval.getValue();
        }

        return intervals;
    }
}
