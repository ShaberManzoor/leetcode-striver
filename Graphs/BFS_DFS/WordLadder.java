package Graphs.BFS_DFS;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

        WordLadder wordLadder = new WordLadder();
        int result = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println("Length of the shortest transformation sequence: " + result);
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>(wordList);

        if (!hs.contains(endWord))
            return 0;

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        int sequence = 1;   // beginWord itself

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                String word = q.poll();

                if (word.equals(endWord))
                    return sequence;

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original)
                            continue;

                        chars[i] = ch;
                        String next = new String(chars);

                        if (hs.contains(next)) {
                            hs.remove(next);
                            q.offer(next);
                        }
                    }

                    chars[i] = original;
                }
            }

            sequence++;
        }

        return 0;
    }
}
