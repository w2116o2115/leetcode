package bytedance;

/**
 * 面编程题，10个格子排成一条，从某格子出发，每次可以向左或向右走一步，给定步数k问有多少种走法可回到原点。
 */
public class Question1 {
    int res = 0;

    private void backTrack(int[] nums,int index,int target,int step,int k){
        if (step > k)
            return;
        if (step == k && index == target){
            res++;
        }

        if (index+1 < nums.length){
            backTrack(nums,index+1,target,step+1,k);
        }
        if (index-1 > 0){
            backTrack(nums,index-1,target,step+1,k);
        }
    }

    private int question(int[] nums){
        backTrack(nums,5,5,0,4);
        return res;
    }

    public static void main(String[] args) {
        Question1 q = new Question1();
        int[] nums = new int[10];

        System.out.println(q.question(nums));
    }
}