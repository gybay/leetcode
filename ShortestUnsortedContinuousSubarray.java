class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return findUnsortedSubarray(list);
    }
    
    /**
    * recursive method that eleminates items in the sorted position in each iteration
    */
    private int findUnsortedSubarray(List<Integer> nums){
        if(nums.size() == 0)
            return 0;
        // min and max values in the array
        int min = Collections.min(nums),
            max = Collections.max(nums);
        // helper values
        int begin = 0, end = nums.size();
        
        // assign begin and end according to min, max and array values
        if(min == nums.get(0))
            begin = 1; // first item is the min value
        if (max == nums.get(end-1))
            end -= length-1; // last item is the max value
        
        /* return options */
        
        // neither min nor max is in the right place
        if(begin == 0 && end == nums.size()) 
            return end;
        // already sorted array
        if(begin >= end) 
            return 0;
        // keep looking
        return findUnsortedSubarray(nums.subList(begin, end));
    }
}
