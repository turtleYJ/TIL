# Web Service
> 네트워크 상에서 서로 다른 종류의 컴퓨터들 간에 상호작용하기 위한 소프트웨어 시스템

- 3 Keys
  - machine-to-machine(or application-to-application)간의 상호작용
  - 플래폼에 독립적
  - 어플리케이션간의 네트워크를 통한 커뮤니케이션 지원

## SOAP(Simple Object Access Protocol)
- HTTP, HTTPS위에서 XML메세지를 요청하고 응답받기위한 서비스

##  RESTful
- REST(REpresentational State Trnsfer)
  - Resource의  Representation 의한 상태 전달
  - HTTP Method를 통해 Resource를 처리하기 위한 아키텍쳐
  - 자원의 상태를 전달하는 것
  - HTTP 메소드를 이용하여 resource를 처리하도록 설계되어있는 아키텍쳐

## REST API
- REST service를 제공하는 API
- REST API 서비스를 제공하는 웹 서비스를 RESTful이라고 한다.

##  Resource
### URI(Uniform Resource Identifier), 인터넷 자원을 나타내는 유일한 주소
- RESTful 서비스에 의해서 제공될 수 있는 모든 자원들은 각각 고유한 주소값을 가지고 있는데 이러한 주소값을 URI라 한다.
- resource를 요청하거나 응답할 때는 XML, HTML, JSON과 같은 문서포맷이 사용된다.