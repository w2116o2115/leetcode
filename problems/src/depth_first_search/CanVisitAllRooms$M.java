package depth_first_search;

import java.util.*;

/**
 * 841. 钥匙和房间
 *
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 示例 1：
 *
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 *
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 */
public class CanVisitAllRooms$M {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            Set<Integer> visited = new HashSet<>();
            visited.add(0);
            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            while (!stack.isEmpty()){
                int room_index = stack.pop();
                for (int key : rooms.get(room_index)){
                    if (!visited.contains(key)) {
                        visited.add(key);
                        stack.add(key);
                    }
                }
            }
            return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(2));
        rooms.add(new ArrayList<>());
        rooms.add(Arrays.asList(1));
        System.out.println(new CanVisitAllRooms$M().canVisitAllRooms(rooms));
    }
}
