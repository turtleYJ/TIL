# 프로세스
- 실행중인 프로그램
- 프로세스가 실행되게 되면 그 프로세스만의 독자적인 메모리 주소공간(code, data, stack)이 생긴다.
- 그 이후, 프로세스가 CPU를 잡게되면 프로그램 카운터라는 레지스터가 이 프로세스의 코드 어느부분을 가르키게 된다.
- 매 순간 기계어를 읽어 CPU 안으로 불러들인다.
- 레지스터에 값을 넣고 산수 논리 연산장치(ALU)를 통해 그 것을 계산한다.
- 코드가 함수를 호출하면 스택에 저장된다.

![](/Operating%20System/Image/OS%20chapter3-1.png)

## 프로세스의 문맥(context)
- CPU 수행 상태를 나타내는 하드웨어 문맥
  - 프로세스가 CPU를 잡고 매순간 인스트럭션을 실행한다.
  - 이는 'register에 어떤 값을 넣고 있었는지', 'Program Counter가 코드상의 어디를 가리키고 있었는지'와 같은 요소들이 필요하다.
- 프로세스의 주소 공간
  - code, data, stack
- 프로세스 관련 커널 자료 구조
  - PCB(Process Control Block)
  - Kernel stack
    - 각 프로세스가 자기 자신의 코드를 실행 중일때, 함수호출이 이루어 진다면 본인의 스택에다 함수를 호출한 다음 리턴을 하고 관련된 정보를 쌓아두게 된다.
    - 근데 프로세스가 실행 중, 본인이 할 수 없는 경우 시스템콜을 하게된다.
    - 이때, 프로그램 카운터가 OS의 커널 주소공간을 가리키게되고 커널의 코드를 실행한다.
    - 커널은 모든 프로세스들이 공유한다.
    - 커널에서 함수호출이 이루어져서 스택에 쌓을 때는 프로세스별로 커널을 어느 프로세스가 호출했는지에 따라 스택을 별도로 둔다. -> 정보의 꼬임 방지

- * 현대의 컴퓨터시스템은 시분할 방식이기에 프로세스 문맥을 파악해야 유동적이고 효율적인 시분할을 진행할 수 있다.

## 프로세스의 상태(State)
- Running
  - CPU를 잡고 인스트럭션을 수행중인 상태
- Ready
  - CPU를 기다리는 상태(메모리 등 다른 조건을 모두 만족하고)
- Blocked(wait, sleep)
  - CPU를 주어도 당장 instruction을 수행할 수 없는 상태
  - Process 자신이 요청한 event(예: I/O, 디스크)가 즉시 만족되지 않아 이를 기다리는 상태
  - 예) 디스크에서 file을 읽어와야 하는 경우
- Suspended(stopped)
  - 외부적인 이유로 프로세스의 수행이 정지된 상태
  - 프로세스는 통쨰로 디스크에 swqp out 된다.
  - 예) 사용자가 프로그램을 일시 정지시킨 경우(break key)


  - 시스템이 여러 이유로 프로세스를 잠시 중단시킴 (메모리에 너무 많은 프로세스가 올라와 있을 때, 중기스케줄러가 swqp out 시킨다.)
- New : 프로세스가 생성중인 상태
- Terminated : 수행(execution)이 끝난 상태

### Blocked와 Suspened의 차이
- Blocked : 자신이 요청한 event가 만족되면 Ready
- Suspended : 외부에서 resume해 주어야 Active

![](/Operating%20System/Image/OS%20chapter3-2.png)

- CPU의 큐(기다리는 줄)는 운영체제 커널이 본인의 데이터 영역에 자료구조로 큐를 만들어 놓고 프로세스의 상태(레디, 블럭드)에 따라 바꿔가면서 운영을할때 사용된다.

## Process Control Block (PCB)
- 운영체제가 각 프로세스를 관리하기 위해 프로세스당 유지하는 정보
- 운영체제가 자신의 data영역에 두고 있다.
### PCB의 구성
(1) OS가 관리상 사용하는 정보
    - Process state, Process ID
    - scheduling information, priority
(2) CPU 수행 관련 하드웨어 값
    - Program counter, registers
(3) 메모리 관련
    - Code, data, stack의 위치 정보
(4) 파일 관련
    - Open file descriptors


![](/Operating%20System/Image/OS%20chapter3-3.png)

## 문맥 교환(Context Switch)
- CPU를 한 프로세스에서 다른 프로세스로 넘겨주는 과정
- CPU가 다른 프로세스에게 넘어갈 때 운영체제는 다음을 수행
  - CPU를 내어주는 프로세스의 상태를 그 프로세스의 PCB에 저장
  - CPU를 새롭게 얻는 프로세스의 상태를 PCB에서 읽어옴

![](/Operating%20System/Image/OS%20chapter3-4.png)
![](/Operating%20System/Image/OS%20chapter3-5.png)

## 스케줄러(Scheduler)
### Long-term scheduler(장기 스케줄러 or job scheduler)
- 시작 프로세스 중 어떤 것들을 ready queue로 보낼지 결정
- 프로세스에 **memory**(및 각종 자원)을 주는 문제
- degree of Multiprogramming(메모리에 프로그램이 몇개 올라가 있는가)을 제어
- time sharing system에는 보통 장기 스케줄러가 없음(무조건 ready)

### Short-term scheduler(단기 스케줄러 or CPU scheduler)
- 어떤 프로세스를 다음번에 running시킬지 결정
- 프로세스에 **CPU**를 주는 문제
- 충분히 빨라야 함(millisecond 단위)

### Medium-Term Scheduler(중기 스케줄러 or Swapper)
- 여유 공간 마련을 위해 프로세스를 통쨰로 메모리에서 디스크로 쫓아냄
- 프로세스에게서 memory를 뺏는 문제
- degree of Multiprogramming을 제어

# Thread
> 프로세스 내부에 CPU 수행 단위가 여러개 있는 것.  
> 프로세스 하나에 CPU 수행 단위만 여러개 가지고 있는 것.  
> lightweight process라고도 한다.

![](./Image/OS%20chapter3-6.png) ![](./Image/OS%20chapter3-7.png)

- 쓰레드 하나가 코드 어느부분을 실행하다가 함수 호출을 하면, 
- 함수를 호출하고 리턴하는 것과 관련된 정보는 Stack에 쌓아야한다.
- 이런 상황에서 CPU수행 단위가 여러 개 있으면 개별적인 스택이 필요하다.

### Thread가 독립적으로 가지는 것
- program counter
- register set
- stack space

### Thread들 끼리 공유하는 부분(= task)
- code section
- data section
- OS resources

## Thread의 장점
- 스레드 하나가 blocked(waiting) 상태일 때, 다른 스레드가 CPU를 잡고 실행(running)되어 빠른 처리가 가능하다.
- 메모리사용을 줄일 수 있다. 

## 스레드의 실행
- 커널이 쓰레드의 존재를 알고 있는 경우(커널 스레드)
- 커널이 모르고 지원해주지 않는 상태에서 작업을 진행하는 경우(유저 스레드)
