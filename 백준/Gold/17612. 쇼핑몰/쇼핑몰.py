from collections import deque
import heapq as hq
import sys

input = lambda : sys.stdin.readline().rstrip()

N, K = map(int, input().split())

Q = deque()
for _ in range(N):
	Q.append(list(map(int, input().split())))
	
heap = []
for counter_num in range(min(N, K)):
	id, time = Q.popleft()
	hq.heappush(heap, (time, -counter_num, id))
	
done = []
while Q:
	time, counter_num, id = hq.heappop(heap)
	done.append(id)
	empty = deque([counter_num])
	
	while heap:
		ntime, ncounter_num, nid = hq.heappop(heap)
		if time == ntime:
			done.append(nid)
			empty.append(ncounter_num)
		else:
			hq.heappush(heap, (ntime, ncounter_num, nid))
			break
	
	while empty:
		num = empty.pop()
		if Q:
			nid, ntime = Q.popleft()
			hq.heappush(heap, (time + ntime, num, nid))
		else:
			break

while heap:
	_,_,id = hq.heappop(heap)
	done.append(id)
									
res , cnt = 0, 1
for id in done:
	res += cnt * id
	cnt += 1
									
print(res)
	