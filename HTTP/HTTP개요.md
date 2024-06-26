# HTTP개요
    HTTP는 HTML 문서와 같은 리소스들을 가져올 수 있도록 해주는 프로토콜이다.
- 웹에서 이루어지는 모든 데이터 교환의 기초
- 클라이언트-서버 프로토콜이기도 하다.
    - 클라이언트-서버 프로토콜이란 수신자(response를 받는) 측에 의해 요청이 초기화되는 프로토콜을 의미한다.
- 하나의 완전한 문서는 텍스트, 레이아웃 설명, 이미지, 비디오, 스크립트 등 불러온 하위 문서들로 재구성된다.
- 브라우저인 클라이언트에 의해 전송되는 메세지를 요청(requests)라 부르며, 그에 대한 서버의 응답을 응답(responses)이라고 부른다.
- HTTP는 애플리케이션 계층의 프로토콜이다.
- TCP혹은 암호화된 TCP연결인 TLS를 통해 주로 전송된다.
- 요청(requests)과 응답(responses) 사이에는 여러 개체들이 존재한다.(게이트웨이, (캐시 역할을 하는 프록시?))

# HTTP 기반 시스템의 구성요소
브러우저와 요청을 처리하는 서버 사이에는 좀 더 많은 컴퓨터들이 존재한다(라우터, 모뎀 등). 웹의 계층적인 설계로 인해, 이들은 네트워크와 전송 계층 내로 숨겨진다.

## 클라이언트(사용자 에이전트)
    클라이언트는 브라우저라 생각해도 무방하며 브라우저는 항상 요청을 보내는 객체이다.
## 웹 서버
## 프록시
    웹 브라우저와 서버 사이에서 수많은 컴퓨터와 머신이 HTTP 메세지를 이어 받고 전달한다. 대부분은 전송, 네트워크 혹은 물리 계층에서 동작하며, 성능에 큰 영향을 준다.

- 이러한 컴퓨터/머신 중에서도 애플리케이션 계층에서 동작하는 것들을 일반적으로 프록시라고 부른다.
- 프록시는 다양한 기능을 수행할 수 있다.
    - 캐싱
    - 필터링(바이러스 백신 스캔, 유해 컨텐츠 차단 기능)
    - 로드 밸런싱(여러 서버들이 서로 다른 요청을 처리하도록 허용)
    - 인증(다양한 리소스에 대한 접근 제어)
    - 로깅(이력 정보를 저장)
    
