# 백준 25166 배고픈 아리의 샌드위치 구매하기

import sys
sandwich, cougie = map(int, sys.stdin.readline().rstrip().split())
if sandwich < 1024:
    print("No thanks")
else:
    debt = sandwich - 1023
    if debt & cougie == debt:
        print("Thanks")
    else:
        print("Impossible")