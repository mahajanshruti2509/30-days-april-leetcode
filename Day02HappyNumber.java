/* Happy Number
 *
 * Write an algorithm to determine if a number n is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 * Input: 19
 * Output: true
 *\\\\\\\\\
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 10
 * 12 + 02 + 02 = 1
 * */

class Solution {
  public boolean isHappy(int n) {
    HashSet<Integer> seenSum = new HashSet<Integer>();
    while(!seenSum.contains(n)) {
      seenSum.add(n);
      n = computeSumOfSquares(n);
      if(n == 1) {
        return true;
      }
    }
    return false;
  }

  private int computeSumOfSquares(int number) {
    int sum = 0;
    int lastDigit = 0;
    int remainingNumber =0;

    while(number > 0) {
      lastDigit = number % 10;
      sum = sum + (lastDigit * lastDigit);
      remainingNumber = number / 10;
      number = remainingNumber;
    }
    return sum;
  }
}