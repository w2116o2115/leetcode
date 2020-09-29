package partition;

/**
 * 面试题 16.17. 连续数列
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray$$retry {
    int [] nums;
    public int maxSubArray(int[] nums) {
        this.nums=nums;
        return MaxSum(0,nums.length-1);
    }

    /*
    此函数计算nums[left]到nums[right]之间的最大连续总和
    最大连续总和只可能出现在数组的左边，或者右边，或者中间
    */
    private int MaxSum(int left,int right){
        if(left==right)
            return nums[left];
        int mid=(left+right)/2;
        int leftMaxSum=MaxSum(left,mid); //左边部分最大连续总和
        int rightMaxSum=MaxSum(mid+1,right); ////右边部分最大连续总和

        //下面计算中间部分最大连续总和
        int sum=0;
        int leftBorderMax=Integer.MIN_VALUE;
        for(int i=mid;i>=left;i--){ //从中间往左边延伸,找到左边边界最大和
            sum+=nums[i];
            leftBorderMax=Math.max(leftBorderMax,sum);
        }
        sum=0;
        int rightBorderMax=Integer.MIN_VALUE;
        for(int i=mid+1;i<=right;i++){ //从中间往右边延伸,找到右边边界最大和
            sum+=nums[i];
            rightBorderMax=Math.max(rightBorderMax,sum);
        }
        //返回左边，右边，中间之中的最大值
        return Math.max(leftMaxSum,Math.max(rightMaxSum, leftBorderMax+rightBorderMax));
    }
}