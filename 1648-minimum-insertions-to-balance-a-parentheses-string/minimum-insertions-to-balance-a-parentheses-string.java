
import java.util.Stack;

class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        int i = 0;

        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == '(') {
                st.push(c);
                i++;
            } else {
                char t = (i + 1 < s.length())
                         ? s.charAt(i + 1) : '\0';

                if (t == ')') {
                    if (!st.isEmpty()) {
                        st.pop();
                    } else {
                        count++;
                    }
                    i += 2;
                } else {
                    if (!st.isEmpty()) {
                        st.pop();
                        count++;
                    } else {
                        count += 2;
                    }
                    i++;
                }
            }
        }

        return count + 2 * st.size();
    }
}
