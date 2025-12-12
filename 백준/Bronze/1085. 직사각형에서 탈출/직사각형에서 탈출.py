x, y, w, h = map(int, input().split())
compare1 = x if x * 2 < w else w - x
compare2 = y if y * 2 < h else h - y
print(compare1 if compare1 < compare2 else compare2)