class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        INT_MAX = 2**31 - 1
        INT_MIN = -2**31

        result = 0
        sign = 1 if x > 0 else -1
        x = abs(x)

        while x != 0:
            pop = x % 10
            x //= 10

            # Check for overflow/underflow
            if (result > INT_MAX // 10) or (result == INT_MAX // 10 and pop > 7):
                return 0
            if (result < INT_MIN // 10) or (result == INT_MIN // 10 and pop < -8):
                return 0

            result = result * 10 + pop

        return sign * result