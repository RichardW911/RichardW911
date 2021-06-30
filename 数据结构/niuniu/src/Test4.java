import java.util.HashSet;

public class Test4 {
    public static void main(String[] args) {

    }

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return -1;
    }
}
