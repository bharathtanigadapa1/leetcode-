

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftRem = 0;
        int rightRem = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                if (leftRem > 0) {
                    leftRem--;
                } else {
                    rightRem++;
                }
            }
        }

        Set<String> resultSet = new HashSet<>();
        dfs(s, 0, leftRem, rightRem, 0, new StringBuilder(), resultSet);
        return new ArrayList<>(resultSet);
    }

    private void dfs(String s, int index, int leftRem, int rightRem, int balance, StringBuilder current, Set<String> result) {
        if (balance < 0) {
            return;
        }

        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0 && balance == 0) {
                result.add(current.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int len = current.length();

        if (c == '(') {
            if (leftRem > 0) {
                dfs(s, index + 1, leftRem - 1, rightRem, balance, current, result);
            }
            current.append(c);
            dfs(s, index + 1, leftRem, rightRem, balance + 1, current, result);
            current.setLength(len);

        } else if (c == ')') {
            if (rightRem > 0) {
                dfs(s, index + 1, leftRem, rightRem - 1, balance, current, result);
            }
            current.append(c);
            dfs(s, index + 1, leftRem, rightRem, balance - 1, current, result);
            current.setLength(len);

        } else {
            current.append(c);
            dfs(s, index + 1, leftRem, rightRem, balance, current, result);
            current.setLength(len);
        }
    }
}