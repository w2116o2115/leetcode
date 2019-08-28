package breadth_first_search;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import javafx.util.Pair;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class WordLadder$M {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    List<String> list = new ArrayList<>();
    list.add("hot");
    list.add("dot");
    list.add("dog");
    list.add("lot");
    list.add("log");
    list.add("cog");
    System.out.println(new WordLadder$M().ladderLength("hit", "cog", list));
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int L = beginWord.length();
    Map<String,List<String>> allWord = new HashMap<>();
    wordList.forEach(word ->{//创建图数据模型
      for (int i=0;i<L;i++){
        String newWord = word.substring(0,i) + "*" + word.substring(i+1,L);
        List<String> list = allWord.getOrDefault(newWord,new ArrayList<>());
        list.add(word);
        allWord.put(newWord,list);
      }
    });

    Queue<Pair<String,Integer>> Q = new LinkedList<>();
    Q.add(new Pair<>(beginWord,1));

    Map<String,Boolean> visited = new HashMap<>();
    visited.put(beginWord,true);

    while (!Q.isEmpty()){
      Pair<String,Integer> pair = Q.remove();
      int level = pair.getValue();
      String word = pair.getKey();
      for (int i=0;i<L;i++){
        String newWord = word.substring(0,i) + "*" + word.substring(i+1,L);
        for (String addWord : allWord.getOrDefault(newWord,new ArrayList<>())){
          if (addWord.equals(endWord))
            return level + 1;

          if (!visited.containsKey(addWord)){
            visited.put(addWord,true);
            Q.add(new Pair<>(addWord,level+1));
          }
        }
      }
    }
    return 0;
  }
}
