import java.util.Arrays;

class GeneratePermutation {
    int count = 0;
    public int countArrangement(int n) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++)
            nums[i - 1] = i;
        permute(nums, 0);

        return count;
    }

    public void permute(int[] nums, int l){
        if(l == nums.length-1){
            count++;
            System.out.println(Arrays.toString(nums));
        }
        for (int i = l; i < nums.length; i++) {
            swap(nums, i, l);
            permute(nums, l + 1);
            swap(nums, i, l);
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        GeneratePermutation s = new GeneratePermutation();
        System.out.println(s.countArrangement(3));
    }
}