class MyCalendar {
    TreeMap<Integer, Integer> tree;
    public MyCalendar() {
        this.tree = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        Integer lowerKey = tree.floorKey(start);
        if(lowerKey != null)
            if(lowerKey == start || tree.get(lowerKey) > start)
                return false;
        Integer upperKey = tree.ceilingKey(start);
        if(upperKey != null && upperKey < end)
            return false;
        tree.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */