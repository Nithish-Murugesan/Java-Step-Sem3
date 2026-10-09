
import java.util.HashSet;

public class PairWithTargetSum {
    static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(target - num))
                return true;

            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] b = {3, 4, 6};

        System.out.println(hasPairWithSum(a, 9));
        System.out.println(hasPairWithSum(b, 20));
    }
}
