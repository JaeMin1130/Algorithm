import sys

input = sys.stdin.readline

n, m = map(int, input().split(" "))

nums = sorted(list(map(int, input().split(" "))))


def make_sequence(m, idx, arr, nums, used):
    if len(arr) == m:
        print(" ".join(map(str, arr)))
    else:
        for i in range(idx, n):
            if not used[i]:
                used[i] = True
                new_arr = arr.copy()
                new_arr.append(nums[i])
                make_sequence(m, i + 1, new_arr, nums, used)
                used[i] = False


used = [False] * n
make_sequence(m, 0, [], nums, used)