t=int(input())
for _ in range(t):
    n=int(input())
    li=list(map(int,input().split()))
    sum=0
    for i in li:
        sum+=i
    print(sum)