# CPU Scheduling
## 프로세스의 특성 분석
- I/O bound process
  - CPU를 잡고 계산하는 시간보다 I/O에 많은 시간이 필요한 jop
  - (many short CPU bursts)
- CPU bound process
  - 계산 위주의 job
  - (few very long CPU bursts)

## CPU Scheduler & Dispatcher
### CPU Scheduler
- Ready 상태의 프로세스 중 이번에 CPU를 줄 프로세스를 고른다.

### Dispatcher
- CPU 제어권을 CPU Scheduler에 의해 선택된 프로세스에게 넘긴다.
- 이 과정을 context switch(문맥 교환)라고 한다.

> 둘 다 운영체제 커널 속에 있는 함수? 코드 들이다.

### 용어
nonpreemptive : CPU를 강제로 뺏기지 않고 자진반납  
preemptive : CPU를 강제로 뺏김
