def problem_19532():
    a,b,c,d,e,f = map(int, input().split())
    print((c*e - b*f)//(a*e - b*d), (c*d - a*f)//(b*d - a*e))

problem_19532()