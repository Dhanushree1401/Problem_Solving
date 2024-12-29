class Solution:
    def numWays(self, a: List[str], t: str) -> int:
        return (f:=cache(lambda i,j,z=[*map(Counter,zip(*a))]:i==len(t) or j<len(a[0]) and z[j][t[i]]*f(i+1,j+1)+f(i,j+1)))(0,0)%(10**9+7)