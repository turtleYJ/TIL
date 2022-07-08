#  Deadlocks(교착상태)

## 문제
- Deadlock
  - 일련의 프로세스들이 서로가 가진 자원을 기다리며 block된 상태
- Resource(자원)
  - 하드웨어, 소프트웨어 등을 포함하는 개념
  - (예) I/O device, CPU cycle, memory space, semaphore 등
  - 프로세스가 자원을 사용하는 절차
    - Request, Allocate, Use, Release

## Deadlock 발생의 4가지 조건
- Mutual exclusion(상호 배제)
  - 매 순간 하나의 프로세스만이 자원을 사용할 수 있음
- No preemption(비선점)
  - 프로세스는 자원을 스스로 내어놓을 뿐 강제로 빼앗기지 않음
- Hold and wait(보유대기)
  - 자원을 가진 프로세스가 다른 자원을 기다릴 떄 보유 자원을 놓지 않고 계속 가지고 있음
- Circular wait(순환대기)
  - 자원을 기다리는 프로세스간에 사이클이 형성되어야 함
  - 서로가 꼬리의 꼬리를 물며 자원을 원하는 경우

![](Image/OS%20chapter7-1.png)

## Deadlock의 처리 방법
### Deadlock Prevention
> 자원 할당 시 Deadlock의 4가지 필요 조건 중 어느 하나가 만족되지 않도록 하는 것.
- Hold and Wait (자진 반납)
  - 프로세스가 자원을 요청할 때 다른 어떤 자원도 가지고 있지 않아야 한다.
  - 방법 1 : 프로세스 시작 시 모든 필요한 자원을 할당받게 하는 방법
  - 방법 2 : 자원이 필요할 경우 보유 자원을 모두 놓고 다시 요청

- No preemption
  - process가 어떤 자원을 기다려야 하는 경우 이미 보유한 자원이 선점됨
  - 모든 필요한 자원을 얻을 수 있을 때 그 프로세스는 다시 시작된다.
  - State를 쉽게 save하고 restore할 수 있는 자원에서 주로 사용(CPU, memory)

- Circular Wait
  - 모든 자원 유형에 할당 순서를 정하여 정해진 순서대로만 자원 할당
  - 1, 2, 3... 순으로 자원을 획득해야 한다.
  - 예를 들어 순서가 3인 자원 Ri를 보유 중인 프로세스가 순서가 1인 자원 Rj을 할당받기 위해서는 우선 Ri를 release해야 한다.

### Deadlock Avoidance
> 자원 요청에 대한 부가적인 정보를 이용해서 deadlock의 가능성이 없는 경우에만 자원을 할당
> 시스템 state가 원래 state로 돌아올 수 있는 경우에만 자원 할당

- 자원 요총에 대한 부가정보를 이용해서 자원 할당이 deadlock으로 부터 안전(safe) 한지를 동적으로 조사해서 안전한 경우에만 할당.
- 가장 단순하고 일반적인 모델은 프로세스들이 필요로 하는 각 자원별 최대 사용량을 미리 선언하도록 하는 방법임
- 뱅커스 알고리즘


> Deadlock Prevention과 Deadlock Avoidance 는 데드락을 원천적으로 차단하는 방법.

### Deadlock Detection and recovery


### Deadlock Ignorance
> 데드락이 생기든 말든 상관하지 않는 방식
> 사용자가 데드락을 처리하도록 하고 운영체제는 데드락에 대처하지 않음
> 현재 대부분의 운영체제들이 사용하는 방식

Deadlock Prevention
- Utilization 저하, throughput 감소, starvation 문제