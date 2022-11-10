# SSH(Secure Shell)
    암호화된 원격접속 프로토콜.

- 셸로 원격 접속함.
- 기본적으로 CLI 상에서 작업함.
- 기본 포트는 22번 포트이다.
- 키(Key)를 통해 접속하게 된다.

## 동작방식
- 키를 생성하여 접속한다. (ssh-keygen)
- 공개키(public key) -  리모트 머신에 위치
- 비공개키(private key) -  로컬 머신에 위치
- SSH 접속을 시도하면 SSH Client가 로컬 머신의 비공개키와 원격 머신의 공개키를 비교해서 둘이 일치하는지를 확인한다.

사용방법
https://velog.io/@hyeseong-dev/%EB%A6%AC%EB%88%85%EC%8A%A4-ssh%EB%9E%80
