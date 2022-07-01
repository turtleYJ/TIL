# Process Synchronization
## Race Condition
![](Image/OS%20chapter5-4.png)
- Race Condition이란 경쟁 상태로 가운데(녹색)의 데이터를 처리하는 두가지 프로그램을 두고 경쟁하는 상태를 말한다.
- 이 Race Condition에서 데이터의 동시성 문제가 생긴다.
- CPU가 여러 개 있는 시스템(Multiprocessor system)에서 발생하기 쉽다.
- 프로세스들이 공유메모리를 사용하는 경우 발생하기 쉽다.

### Race Condition이 발생하는 경우
1. kernel 수행 중 인터럽트 발생 시
2. Process가 system call을 하여 kernel mode로 실행 중인데 context switch가 일어나는 경우
3. Multiprocess에서 shared memory내의 kernel data

예제1 - 커널 수행 중 인터럽트 발생
![](Image/OS%20chapter6-1.png)
- 커널의 작업(카운트의 숫자를 올려주는 작업)이 끝나기 전까지 인터럽트를 허용하지 않는다.

예제2 - 커널모드 수행 중 제한시간이 끝나 context switch가 발생하는 경우
![](Image/OS%20chapter6-2.png)
- 제한시간이 좀 넘더라도 기존의 커널모드의 작업을 마치고 다음 작업을 시작하도록 한다.

예제3 - 멀티프로세스환경 즉, CPU가 여러 개인 환경
![](Image/OS%20chapter6-3.png)
- 방법 1 : 커널 전체에 락을 거는 경우
- 방법 2 : 데이터에만 락을 거는 경우

### Critical-Section
- 공유데이터에 접근하는 코드의 부분을 말함.

## 프로그램적 해결법의 충족 조건
- Mutal Exclusion(상호 배제)
  - 프로세스 
- Progress
  - 아무도 critical section에 있지 않은 상태에서 critical section에 들어가고자 하는 프로세스가 있으면 critical section에 들어가게 해주어야 한다.
- Bounded Waiting(유한 대기)
  - 프로세스가 critical section에 들어가려고 요청한 후부터 그 요청이 허용될 때까지 다른 프로세스들이 critical section에 들어가는 횟수에 한계가 있어야 한다.

예제 1


## Semaphores
- 추상 자료형
- Semaphore S
  - integer variable : 자원의 개수
  - 두가지 atomic 연산에 의해서만 접근이 가능하다
    - P(S) :
    ```
    while (S <= 0) do no-op; // busy-wait(=spin lock) 문제가 발생함
    S--;
    ```
    - V(S) :
    ```
    S++;
    ```
- busy-wait는 효율적이지 못함(=spin lock)
- Block & Wakeup방식의 구현(=sleep lock)

## Busy-wait vs Block/wakeup
### Block/wakeup overhead vs Critical section 길이
- Critical section의 길이가 긴 경우 Block/Wakeup이 적당
- Critical section의 길이가 매우 짧은 경우 Block/Wakeup 오버헤드가 busy-wait 오버헤드보다 더 커질 수 있음.
- 일반적으로는 Block/Wakeup방식이 더 좋음

## Two Types of Semaphores
- Counting semaphore
  - 도메인이 0 이상인 임의의 정수값
  - 주로 resource counting에 사용
- Binary semaphore(=mutex)
  - 0 또는 1의 값만 가질 수 있는 semaphore
  - 주로 mutual exclusion(lock/unlock)에 사용

## Deadlock and Startvation
### Deadlock
- 둘 이상의 프로세스가 서로 상대방에 의해 충족될 수 있는 event를 무한히 기다리는 현상
- S와 Q가 1로 초기화된 semaphore라 가정
![](Image/OS%20chapter6-4.png)
- 동시에 진행될 경우 한 프로세스가 S를 다른 한 프로세스가 Q를 잡고 서로 진행되니 못하는 경우가 발생 (Deadlock)
- 아래와 같이 바꿈으로써 데드락을 해결할 수 있음
![](Image/OS%20chapter6-5.png)
### Starvation
- **indefinite blocking** 프로세스가 suspend된 이유에 해당하는 세마포어 큐에서 빠져날갈 수 없는 현상
- 특정 프로세스들이 CPU를 독점하여 어느 프로세스가 CPU를 사용할 수 없는 경우.

## Classical Problems of Synchronization
### 1. Bounded-Buffer Problem(Producer-Consumer Problem)
  생산자
  - Empty 버퍼가 있나?(없으면 기다림)
  - 공유데이터에 lock을 건다.
  - Empty buffer에 데이터 입력 및 buffer 조작
  - lock을 푼다.
  - Full buffer하나 증가

  소비자
  - full 버퍼가 있나?(없으면 기다림)
  - 공유데이터에 lock을 건다.
  - Full buffer에서 데이터 꺼내고 buffer 조작
  - lock을 푼다.
  - empty buffer 하나 증가

![](Image/OS%20chapter6-6.png)

#### Shared data
- buffer 자체 및 buffer조작 변수(empty/full buffer의 시작 위치)
#### Synchronization variables
- semaphore full(처음에 0), empty(처음에 n), mutex(하나의 프로세스(생산자 or 소비사)만 접근할 수 있도록 하는 세마포어)
- mutual exclusion -> binary semaphore변수(mutex)가 필요
- resource count -> integer semaphore변수(full, empty)가 필요(empty/full buffer의 수 표시)

![](Image/OS%20chapter6-7.png)


### 2. Readers and Writers Problem
- 한 process가 DB에 write 중일 때 다른 process가 접근하면 안됨.
- read는 동시에 여럿이 해도 됨.
- solution
  - Writer가 DB에 접근 허가를 아직 얻지 못한 상태(읽는 중)에서는 모든 대기중인 Reader들을 다 DB에 접근하게 해준다.
  - Writer는 대기 중인 Reader가 하나도 없을 때 DB접근이 허용된다.
  - 일단, Writer가 DB에 접근 중이면 Reader들은 접근이 금지된다.
  - Writer가 DB에서 빠져나가야만 Reader의 접근이 허용된다.

#### Shared data
- DB 자체
- readcount; (현재 DB에 접근 중인 Reader의 수)

#### Synchronization variables
- muttex (공유 변수  readcount를 접근하는 코드(critical section)의 mutual exclusion 보장을 위해 사용)
- db (Reader와 writer가 공유 DB 자체를 올바르게 접근하게 하는 역할)

![](Image/OS%20chapter6-8.png)

- Starvation 발생 가능
- 리더들이 지속적으로 들어오게 되면 Writer의 Starvation이 발생한 코드이다.


### 3. Dining-Philosophers Problem