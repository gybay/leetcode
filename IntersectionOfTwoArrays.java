class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>(),
                     set2 = new HashSet<>();
        // find unique items in both arrays
        for(int i : nums1)
            set1.add(i);
        for(int i : nums2)
            set2.add(i);
        
        // get the intersection of two sets 
        set1.retainAll(set2);
        
        // generate result array
        int[] arr = new int[set1.size()];
        int index = 0;
        for(Integer i : set1)
            arr[index++] = i;
        
        return arr;
    }
}
