# Memory Management
- Logical address (= virtual address)
  - 프로세스마다 독립적으로 가지는 주소 공간
  - 각 프로세스마다 0번지부터 시작
  - CPU 가 보는 주소는 logical address임
- Physical address
  - 메모리에 실제 올라가는 위치

주소 바인딩 : 주소를 결정하는 것
Symbolic Address -> Logical Address -> Physical address

Symbolic Address : 프로그래머가 사용하는 변수(변수명)

## 주소 바인딩(Address Binding)
- Compile time binding
  - 물리적 메모리 주소(physical address)가 컴파일 시 알려짐
  - 시작 위치 변경시 재컴파일
  - 컴파일러는 절대 코드(absolute code) 생성
- Load time binding
  - Loader의 책임하에 물리적 메모리 주소 부여
  - 컴파일러가 재배치가능코드(relocatable code)를 생성한 경우 가능
- Execution time binding (=Run time binding)
  - 수행이 시작된 이후에도 프로세스의 메모리 상 위치를 옮길 수 있음
  - CPU가 주소를 참조할 때마다 binding을 점검(address mapping table)
  - 하드웨어적인 지원이 필요

![](Image/OS%20chapter8-1.png)

## Memory-Management Unit(MMU)
- MMU(Memory-Management Unit)
  - logical address를 physical address로 매핑해 주는 Hardware device
- MMU scheme
  - 사용자 프로세스가 CPU에서 수행되며 생성해내는 모든 주소값에 대해 base register(=relocation register)의 값을 더한다.
- user program
  - logical address만을 다룬다.
  - 실제 physical address를 볼 수 없으며 알 필요가 없다.

![](Image/OS%20chapter8-2.png)

## Hardware Support for Address Translation

![](Image/OS%20chapter8-2.png)

운영체제 및 사용자 프로세스 간의 메모리 보호를 위해 사용하는 레지스터
- Relocation register(=base register) : 접근할 수 있는 물리적 메모리 주소의 최소값
- Limit register : 논리적 주소의 범위

## Dynamic Loading
- 프로세스 전체를 메모리에 미리 다 올리는 것이 아니라 해당 루틴이 불려질 때 메모리에 load하는 것
- memory utilization의 향상
- 가끔씩 사용되는 많은 양의 코드의 경우 유용(예 : 오류처리 루틴)
- 운영체제의 특별한 지원 없이 프로그램 자체에서 구현 가능(OS는 라이브러리를 통해 지원 가능)
- Loading : 메모리로 올리는 것

## Overlays
- 메모리에 프로세스의 부분 중 실제 필요한 정보만을 올림
- 프로세스의 크기가 메모리보다 클 때 유용
- 운영체제의 지원없이 사용자에 의해 구현
- 작은 공간의 메모리를 사용하던 총창기 시스템에서 수작업으로 프로그래머가 구현
  - "Manual Overlay"
  - 프로그래밍이 매우 복잡

## Sqapping
> 프로세스를 일시적으로 메모리에서  backing store로 쫓아내는 것

- Backin store(= swap area)
  - 디스크
    - 많은 사용자의 프로세스 이미지를 담을 만큼 충분히 빠르고 큰 저장 공간
- Swap in / Swap out
  - 일반적으로 중기 스케줄러(swapper)에 의해 swap out 시킬 프로세스 선정
  - priority-based CPU scheduling algorithm
    - priority가 낮은 프로세스를 swapped out 시킴
    - priority가 높은 프로세스를 메모리에 올려 놓음
  - Compile time 혹은 load time binding에서는 원래 메모리 위치로 swap in 해야 함
  - Execution time binding 에서는 추후 빈 메모리 영역 아무 곳에나 올릴 수 있음
  - swap time은 대부분 transfer time(swap되는 양에 비례하는 시간)임