# Docker와 Nginx를 사용한 웹 서버 설정

이 문서는 Docker와 Nginx를 사용하여 경량화된 웹 서버를 설정하는 방법을 설명합니다.

## Docker 소개

Docker는 컨테이너화 기술을 사용하여 애플리케이션을 패키징하고 배포하는 플랫폼입니다. 컨테이너는 애플리케이션과 그 의존성을 함께 묶어서 어디서든 일관되게 실행할 수 있도록 합니다.

## Nginx

Nginx는 가볍고 고성능의 HTTP 및 Reverse Proxy 서버입니다. 정적 파일 서비스, 로드 밸런싱, 리버스 프록시 기능 등을 제공합니다.

## Docker 설치

Mac에서 Docker를 설치하는 방법은 다음과 같습니다:

1. Docker 공식 웹사이트(https://www.docker.com/)에서 Docker Desktop for Mac을 다운로드합니다.
2. 다운로드한 `.dmg` 파일을 실행하여 Docker를 설치합니다.
3. 설치가 완료되면 Docker Desktop을 실행합니다.
4. 터미널을 열고 `docker --version` 명령어를 입력하여 설치가 성공적으로 완료되었는지 확인합니다.

## `nginx` 이미지 사용 예시

다음은 `nginx` 이미지를 사용하여 간단한 Nginx 서버를 실행하는 Docker Compose 설정 예시입니다.

### Docker Compose 파일 생성

`docker-compose.yml` 파일을 생성하고 다음 내용을 추가합니다.

```yaml
version: '3'
services:
  web:
    image: nginx:latest:
    ports:
      - "8080:80"
```

이 설정은 Nginx 서버를 nginx:alpine 이미지를 기반으로 실행하며, 로컬의 8080 포트를 컨테이너의 80 포트에 매핑합니다.

### Docker Compose를 사용하여 서비스 시작
```
 docker-compose up -d
```
이 명령어는 docker-compose.yml 파일에 정의된 서비스를 백그라운드에서 실행합니다.

### 서비스 확인
웹 브라우저를 열고 http://localhost:8080으로 이동하여 Nginx 서버가 제대로 실행되고 있는지 확인합니다.

## 커스터마이징된 Nginx 설정
Nginx 설정 파일을 커스터마이징하고 싶다면, 다음과 같이 진행할 수 있습니다.

### 커스터마이징된 Nginx설정 파일 생성
예를 들어, 현재 디렉토리에 nginx.conf 파일을 생성합니다.
```
server {
    listen 80;
    server_name localhost;

    location / {
        root /usr/share/nginx/html;
        index index.html index.htm;
    }

    error_page 500 502 503 504 /50x.html;
    location = /50x.html {
        root /usr/share/nginx/html;
    }
}
```

### Docker Compose 파일 업데이트
docker-compose.yml 파일을 업데이트하여 Nginx 설정 파일을 마운트합니다.
```
version: '3'
services:
  web:
    image: nginx:alpine
    ports:
      - "8080:80"
    volumes:
      - ./nginx.conf:/etc/nginx/nginx.conf
```

## 변경 사항 적용
```
docker-compose down
docker-compose up -d
```
