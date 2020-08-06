package leetcode.top250;

/**
 * 137. 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * 1.位运算求解此题;
 * 2.如果把所有出现三次的数字的二进制表示的每一位加起来,那么每一位都能被3整除;
 * 3.如果某一位的和能被3整除,那么只出现一次数字的二进制位中对应的那一位就是0,否则就是1;
 * 4.完结。
 *
 * 由于所有数都是整数，所以最大位数为32位，对于出现三次的数，统计每一位上1出现的次数一定能被3整除，
 * 而不能被三整除的位一定是单独出现的数造成的，所以依次统计每一位的次数，并把不能被3整除的位数设为1赋给结果。
 *
 * 每一个数组都可以用一个32位的二进制表示，累加二进制位上的数字，如果一个数字出3次  %3 ==0  就剔除了，上下的位加起来就是剩下的数字
 */
public class SingleNumber$$$SOS {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];

        for (int i=0;i<32;i++){
            for (int num:nums){
                int n = num >> i;
                bit[i] += n&1;
            }
        }

        int res = 0;

        for (int i=31;i>=0;i--){
            res = res << 1;
            int num = bit[i]%3;
            res+=num;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber$$$SOS().singleNumber(new int[]{22,22,23,22}));
    }
}
