class Solution:
    def numWays(self, a: List[str], t: str) -> int:
        z = [*map(Counter, zip(*a))]

        @cache
        def f(i, j):
            if i == len(t):
                return 1
            if j < len(a[0]):
                return z[j][t[i]]*f(i+1,j+1) + f(i,j+1)
            
            return 0
        
        return f(0, 0)%(10**9+7)