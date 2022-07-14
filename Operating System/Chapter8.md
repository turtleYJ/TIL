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

## Dynamic Linking
> Linking을 실행 시간(execution time)까지 미루는 기법

- Static linking
  - 라이브러리가 프로그램의 실행 파일 코드에 포함됨
  - 실행 파일의 크기가 커짐
  - 동일한 라이브러리를 각각의 프로세스가 메모리에 올리므로 메모리 낭비
- Dynamic linking
  - 라이브러리가 실행시 연결(link)됨
  - 라이브러리 호출 부분에 라이브러리 루틴의 위치를 찾기 위한 stub이라는 작은 코드를 둠
  - 라이브러리가 이미 메모리에 있으면 그 루틴의 주소로 가고 없으면 디스크에서 읽어옴
  - 운영체제의 도움 필요

## Allocation of Physical memory
- 메모리는 일반적으로 두 영역으로 나뉘어 사용
  - OS 상주 영역
    - interrupt vector와 함께 낮은 주소 영역 사용
  - 사용자 프로세스 영역
    - 높은 주소 영역 사용

- 사용자 프로세스 영역의 할당 방법
  - Contiguous allocation : 각각의 프로세스가 메모리의 연속적인 공간에 적재되도록 하는 것
    - Fixed partition allocation
    - Variable partition allocation
  - Noncontiguous allocation : 하나의 프로세스가 메모리의 여러 영역에 분산되어 올라갈 수 있음
  - Paging
  - Segmentation
  - Paged Segmentation

### Contiguous Allocation
- 고정분할(Fixed partition) 방식
  - 물리적 메모리를 몇 개의 영구적 분할(partition)로 나눔
  - 분할의 크기가 모두 동일한 방식과 서로 다른 방식이 존재
  - 분할당 하나의 프로그램 적재
  - 융통성이 없음
    - 동시에 메모리에 load되는 프로그램의 수가 고정됨
    - 최대 수행 가능 프로그램 크기 제한
  - Internal fragmentation 발생 (external fragmentation도 발생)

- 가변분할(Variable partition) 방식
  - 프로그램의 크기를 고려해서 할당
  - 분할의 크기, 개수가 동적으로 변함
  - 기술적 관리 기법 필요
  - External fragmentation 발생

![](Image/OS%20chapter8-4.png)

## Paging
### Paging
- Process의 virtual memory를 **동일한 사이즈**의 page 단위로 나눔
- Virtual memory의 내용이 page 단위로 noncontiguous하게 저장됨
- 일부는 backing storage에, 일부는 physical memory에 저장
- page table을 사용하여 각각의 페이지들이 물리적 메모리의 어디에 올라가있는지를 확인.
- page table은 메모리에 올라가 있다.

### Basic Method
- physical memory를 동일한 크기의 frame 으로 나눔
- logical memory를 동일한 크기의 page로 나눔(frame과 같으 크기)
- 모든 가용 frame들을 관리
- page table을 사용하여 logical address를 physical address로 변환
- External fragmentation 발생 안함
- Internal fragmentation 발생 가능

### Implementation of Page Table
- Page table은 main memory에 상주
- Page-table base register(PTBR)가 page table을 가리킴
- Page-table length register(PTLR)가 테이블 크기를 보관
- 모든 모메리 접근 연산에는 2번의 memory access 필요
- page table 접근 1번, 실제 data/instruction 접근 1번
- 속도 향상을 위해 associative register(parallel search 가능) 혹은 translation look-aside buffer(TLB)라 불리는 고속의 lookup hardware cache 사용 

- TLB: 주소변환을 위한 캐시메모리
- page table에서 빈번히 참조되는 일부 entry(page number, 인덱스 같은 느낌)를 캐싱을 하고 있다.
- 2차례의 메모리 접근을 하기 전에 TLB에 저장이 되어 있는지를 확인한다.
- TLB는 context switch 때 flush(remove old entries)

### Two-Level Page Table
- 현대의 컴퓨터는 address space가 매우 큼
- 32비트로 표현가능한 서로 다른 정보가 몇개인가? 2의 32 제곱
- 32비트 주소체계를 쓴다면 메모리 주소가 0번지부터 2^32
- 2^10 =  K(킬로), 2^20 = M(메가), 2^30 = G(기가)
- 2^32B(4GB)
- 32 bit address 사용시 : 2^32B(4GB)의 주소 공간 

### Inverted Page Table
#### page table이 매우 큰 이유
- 모든 process별로 그 logical address에 대응하는 모든 page에 대해 apge table entry가 존재
- 대응하는 page가 메모리에 있든 아니든 간에 page table에는 entry로 존재

#### Inverted Page Table
- Page frame 하나당 page table에 하나의 entry를 둔 것 (system-wide)
- 각 page table entry는 각각의 물리적 메모리의 page frame이 담고 있는 내용 표시(process-id, process의 logical address)
- 단점
  - 테이블 전체를 탐색해야 함
- 조치
  - associative register 사용(병렬 탐색, expensive)

### Shared Page
#### Shared code
- Re-entrant Code(=Pure code)
- read-only로 하여 프로세스 간에 하나의 code만 메모리에 올림
- Shared code는 모든 프로세스의 logical address space에서 동일한 위치에 있어야 함
#### Private code and data
- 각 프로세스들은 독자적으로 메모리에 올림
- Private data는 logical address space의 아무 곳에 와도 무방

## Segmentation
>프로그램을 의미 단위인 여러 개의 segment로 구성
- 작게는 프로그램을 구성하는 함수 하나하나를 세그먼트로 정의
- 크게는 프로그램 전체를 하나의 세그먼트로 정의 가능
- 일반적으로는 code, data, stack 부분이 하나씩의 세그먼트로 정의됨

### Segmentation Architecture (Paging과 비슷)
- Logical address는 다음의 두 가지로 구성
  - <segment-number, offset>
- Segment table
  - each table entry has:
    - base - starting physical address of the segment
    - limit - length of the segment
- Segment-table base register(STBR)
  - 물리적 메모리에서의 segment table의 위치
- Segment-table length register(STLR)
  - 프로그램이 사용하는 segment의 수
    - segment number s(세그먼트 번호) is legal if s < STLR(총 세그먼트 수)