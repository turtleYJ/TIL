# Spring Boot Actuator

## 개요
Spring Boot Actuator는 애플리케이션의 상태를 모니터링하고 관리하기 위한 다양한 에드포인트와 기능을 제공합니다. 이를 통해 개발자는 애플리케이션의 내부 상태를 쉽게 확인하고, 운영 환경에서 발생할 수 있는 문제를 빠르게 탐지하고 대응할 수 있습니다.

## 의존성 추가
Spring Boot Actuator를 사용함려면 'pom.xml' 또는 'build.gradle' 파일에 다음과 같은 의존성을 추가해야 합니다.

### Maven
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

### Gradle
```xml
implementation 'org.springframework.boot:spring-boot-starter-actuator'
```

## 주요 엔드포인트
Spring Boot Actuator는 기본적으로 다양한 엔드포인트를 제공합니다. 이들은 '/actuator'경로 아래에서 접근할 수 있습니다.
- /actuator/health: 애플리케이션의 상태 정보를 제공합니다.
- /actuator/info: 애플리케이션에 대한 간단한 정보를 제공합니다.
- /actuator/metrics: 메트릭 데이터를 제공합니다.
- /actuator/env: 애플리케이션의 환경 속성 정보를 제공합니다.
- /actuator/loggers: 로깅 레벨을 조회하고 설정할 수 있습니다.
- /actuator/threaddump: 애플리케이션의 스레드 덤프를 제공합니다.
- /actuator/httptrace: HTTP 추적 정보를 제공합니다.

## 엔드포인트 활성화 및 보안 설정
Actruator의 특정 엔드포인트를 활성화하거나 비활성화하고, 보안 설정을 통해 접근을 제한할 수 있습니다.

### 엔드포인트 활성화
기본적으로 일부 엔드포인트는 비활성화되어 있습니다. 필요한 엔드포인트를 활성화하려면 'application.properties' 파일에 다음 설정을 추가합니다.
```properties
management.endpoints.web.exposure.include=health,info
```

### 보안 설정
Actuator 엔드포인트에 대한 접근을 보호하려면 다음과 같은 설정을 사용할 수 있습니다.
```properties
management.endpoint.health.show-details=always # 노출 정보 제한
management.endpoint.web.exposure.include=* # 노출 엔드포인트 제한
```

추가적인 보안을 위한 설정이 필요함 (스프링 시큐리티를 이용하여 인증과 접근 제어를 활용할 수 있음)

## 모니터링 및 메트릭스
Actuator는 애플리케이션의 성능 및 자원 사용량을 모니터링하기 위한 다양한 메트릭을 수집합니다. 이러한 메트릭을 Prometheus, Grafana등과 같은 외부 모니터링 시스템과 통합하여 사용할 수 있습니다.

## 커스터마이징
필요에 따라 사용자 정의 엔드포인트를 만들 수 있습니다. 예를 들어, 다음과 같이 간단한 커스텀 엔드포인트를 생성할 수 있습니다.

```java
@RestController
public class CustomEndpoint {

    @GetMapping("/actuator/custom")
    public String customEndpoint() {
        return "Custom endpoint response";
    }
}
```

## 실습 및 예제
```java
@SpringBootApplication
public class ActuatorExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorExampleApplication.class, args);
    }
}
```
```properties
management.endpoints.web.exposure.include=health,info,metrics
management.endpoint.health.show-details=always
```

### 엔드포인트 접근
애플리케이션을 실행한 후 브라우저 또는 curl을 사용하여 다음 엔드포인트에 접근할 수 있습니다.
```sh
curl http://localhost:8080/actuator/health
curl http://localhost:8080/actuator/info
curl http://localhost:8080/actuator/metrics
```

## 문서 및 참고자료
[Spring Boot Actuator Documentation](https://docs.spring.io/spring-boot/reference/actuator/index.html)