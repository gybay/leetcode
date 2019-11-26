class MissingNumber {
    /**
    * Lets say the size of array is s. Since the range of items is [0,s], the sum of the array should be s*(s+1)/2. 
    * The difference between the sum of array and the actual sum it should be is the missing number.
    */
    public int missingNumber(int[] nums) {
        return nums.length * (nums.length+1)/2 - Arrays.stream(nums).sum();
    }
}
