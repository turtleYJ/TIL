# Process Management
## Process의 생성
- 부모 프로세스가 자식 프로세스를 생성 
- 프로세스의 트리(계층 구조)를 형성
- 프로세스를 자원을 필요로 함.
  - 운영체제로 부터 받는다.
  - 부모와 공유한다.
- 자원의 공유
  - 부모와 자식이 자원을 공유하는 모델
  - 일부를 공유하는 모델
  - 전혀 공유하지 않는 모델
- 수행
  - 부모와 자식이 공존하며 수행되는 모델
  - 자식이 종료(terminate)될 때까지 기다리는(wait) 모델 
- 주소 공간(Address space)
  - 자식이 부모의 공간을 그대로 복사함(binary & OS data)
  - 자식은 그 공간에 새로운 프로그램을 올림
- 유닉스의 예
  - fork() 시스템 콜이 새로운 프로세스를 생성
    - 부모를 그대로 복사한다.(OS data except PID + binary)
    - 주소공간 할당
  - fork 다음에 이어지는 exec() 시스템 콜을 통해 새로운 프로그램을 메모리에 올림

## Process의 종료
- 프로세스가 마지막 명령을 수행한 후 운영체계에게 알려줌(exit)
  - 자식이 부모에게 output 데이타를 보냄(via wait)
  - 프로세스의 각종 자원들이 운영체제에 반납됨
- 부모 프로세스가 자식 프로세스를 종료시킴(abort)
  - 자식이 할당 자원의 한계치를 넘어설 때
  - 자식에게 할당된 테스크가 더 이상 필요하지 않음
  - 부모가 종료(exit)하는 경우
    - 운영체제의 경우 부모 프로세스가 종료되는 경우에 자식도 종료시킨다.
    - 단계적인 종료

## Process 관련 시스템 콜
- fork() : code data stack을 복사
- exec() : 새로운 함수를 실행(새로운 프로그램을 실행)
- wait() : 부모 프로세스가 자식 프로세스가 종료될 때 까지 기다려줌(block상태로 대기)
- exit() : 모든 코드를 다 실행 했거나(자발적 종료), 부모가 종료되거나 kill, break명령어로 강제 종료하는 경우(비자발적 종료)

## 프로세스 간 협력
### 독립적 프로세스
- 기본적으로 프로세스는 각자의 주소공간을 가지고 수행되므로 독립적이다.

### 협력 프로세스
- **프로세스 협력 메커니즘**을 통해 프로세스간 협력할 수 있다.
  
### 프로세스 협력 메커니즘(IPC : Interprocess Communication)
- 메세지를 전달하는 방법
    - message passing : 커널을 통해 메세지 전달, 프로세스사이의 공유 변수(shared variable)를 일체 사용하지 않고 통신하는 시스템
      - Direct Communication : 통신하려는 프로세스의 이름을 명시하는 방법
      - Indirect Communication : mailbox(또는 port)를 통해 메세지를 간접 전달
    - shared message : 서로 다른 프로세스간에도 일부 주소 공간을 공유하게 하는 shared memory 메커니즘이 있음

![](Image/OS%20chapter4-1.png)http://cafe.naver.com/javachobostudy.cafe