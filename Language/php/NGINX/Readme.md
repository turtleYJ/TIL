
# Nginx란?
- 경량 웹 서버
- HTTP Web Server로 활용되기도 하고,
- Reverse Proxy Server로 활용하여 WAS 서버의 부하를 줄일 수 있는 로드 밸러서로 활용되기도 한다.

Apache의 C10K 문제점(한 시스템에 동시 접속사수가 1만 명이 넘어갈 때 느려지는 문제점) 해결을 위해 만들어진 Event_Driven 구조의 웹서버.

## Nginx와 Apache의 차이점?
Nginx : Event-Driven 방식으로 작동
Apache : 쓰레드 / 프로세스 기반으로 작동

Event-Driven :
- 서버로 들어오는 여러 개의 커넥션을 Event-Handler를 통해 비동기방식으로 처리를 하게 한다.
- 이러한 방식으로 인해 적은 메모리로 서버를 운영할 수 있다.
- 싱글 스레드, 프로세스로 작동한다.
- socker read / writer, I/O 등 CPU가 관여하지 않아도 되는 작업을 진행할 때는 기다리지 않고 다른 작업을 수행한다. 진행 중인 I/O 등의 작업이 종료되면 이벤트가 발생하며 그 다음 작업 처리를 시작한다.

## Nginx의 구조
- 하나의 Master Process와 다수의 Worker Process로 구성.
- Master Process : 설정파일을 읽고 유효성 검사 및 Worker Process를 관리.
- 모든 요청은 Worker Process에서 처리함.
- Nginx는 이벤트 기반 모델을 사용.
- Worker Process사이에 요청을 효율적으로 분배하기 위해 OS에 의존적인 메커니즘을 사용.
- Worker Process의 개수는 설정 파일에서 정의되며, 정의된 프로세스 개수와 사용 가능한 CPU코어 숫자에 맞게 자동으로 조정됨.


# Starting, Stopping, and Reloading Configuration
> nginx -s signal

- signal
    - stop — fast shutdown
    - quit — graceful shutdown
    - reload — reloading the configuration file
    - reopen — reopening the log files

## NGINX with linux
### To kill process
- A signal may also be sent to nginx processes with the help of Unix tools such as the kill utility.
- nginx.pid를 찾아본다. (in the directory /usr/local/nginx/logs or /var/run.)
- vi nginx.pid

```
    kill -s QUIT [pid]
```

### getting the list of all running nginx processes (ps utility)
```
    ps -ax | grep nginx
```

# Using nginx as HTTP load balancer

## Load balancing methods supported in nginx
1. round-robin
- 프로세스가 도착한 순서대로 프로세스를 디스패치한다.
- 정해진 할당량(또는 시간 간격)에 의해 실행을 제한한다.
- 즉, 프로세스마다 할당된 시간이 있고 이 시간안에 작업을 완료하지 못하면 큐의 맨 뒤에 배치된다.
- 이렇게 하여 CPU를 독점하지 않고 공평하게 이용하도록 한다.
- round-robin 방식의 성능은 시간 할당에 달려있다.
- 시간 할당이 너무 크다면, FCFS(first come first served) 정도로 성능이 낮아질 것이며
- 시간 할당이 너무 적으면 잦은 문맥 교환이 작업 수행을 방해하여 오버헤드가 증가될 것이다.
2. least-connected
- 서버마다 연결된 커넥션이 몇개인지 체크하여 커넥션이 가장 적은 서버로 요청을 분배한다.
- Real Server의 Open세션 수를 고려한 다음, 가장 적은 수의 open session을 가진 Real Server로 session을 맺어주는 방식.
3. ip-hash

# NGINX Reverse Proxy
cf.
일반적인 프로시의 장점
1. 익명성 (ip를 숨김)
2. 캐싱(캐시 정보를 프록시 서버에 저장할 수 있음) - 속도의 증가
3. Blocking unwanted sites

## Reverse Proxy Benefit
1. Load Balancing
2. Cashing
3. Isolating internal traffic
4. Logging


