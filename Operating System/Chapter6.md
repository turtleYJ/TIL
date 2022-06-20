# Process Synchronization
## Race Condition
![](Image/OS%20chapter5-4.png)
- Race Condition이란 경쟁 상태로 가운데(녹색)의 데이터를 처리하는 두가지 프로그램을 두고 경쟁하는 상태를 말한다.
- 이 Race Condition에서 데이터의 동시성 문제가 생긴다.
- CPU가 여러 개 있는 시스템(Multiprocessor system)에서 발생하기 쉽다.
- 공유 메모리를 사용하는 프로세스들 

### Race Condition이 발생하는 경우
1. kernel 수행 중 인터럽트 발생 시
2. Process가 system call을 하여 kernel mode로 실행 중인데 context switch가 일어나는 경우
3. Multiprocess에서 shared memory내의 kernel data

예제1 - 커널 수행 중 인터럽트 발생
![](Image/OS%20chapter6-1.png)
- 커널의 작업(카운트의 숫자를 올려주는 작업)이 끝나기 전까지 인터럽트를 허용하지 않는다.

예제2 - 커널모드 수행 중 제한시간이 끝나 context switch가 발생하는 경우
![](Image/OS%20chapter6-2.png)

예제3 - 멀티프로세스환경 즉, CPU가 여러 개인 환경
![](Image/OS%20chapter6-3.png)
- 방법 1 : 커널 전체에 락을 거는 경우
- 방법 2 : 데이터에만 락을 거는 경우