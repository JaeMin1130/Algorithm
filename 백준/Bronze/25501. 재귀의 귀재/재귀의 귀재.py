def problem_25501():
    def recursion(s, l, r, cnt):
        if l >= r: return f"1 {cnt}"
        elif s[l] != s[r]: return f"0 {cnt}"
        else: return recursion(s, l+1, r-1, cnt+1)

    def isPalindrome(s):
        return recursion(s, 0, len(s)-1, 1)
    
    n = int(input())
    for i in range(n):
        print(isPalindrome(input()))

problem_25501()