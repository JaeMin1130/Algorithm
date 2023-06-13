def binary_search(i, arr, start, end):
    idx = (start + end) // 2
    if(start < end):
        if i > arr[idx]:
            start = idx+1
            return binary_search(i, arr, start, end)
        elif i < arr[idx]:
            end = idx        
            return binary_search(i, arr, start, end)
        else:
            return 1
    elif start == end:
        if i == arr[idx]:
            return 1
        else:
            return 0
    else:
        return 0

N = int(input())
arr = list(map(int, input().split()))
arr = sorted(arr)
M = int(input())
check_arr = list(map(int, input().split()))

for i in check_arr:
    print(binary_search(i, arr, 0, len(arr) - 1))