## Spring Boot Slack Bot
- Spring Boot 2.5 및 슬랙 봇 연습

### 실습환경
- Windows 10 WSL2 
- Windows Docker
- Microsoft Store 의 Ubuntu 18.04 LTS 

### Dockerfile
- 도커 이미지 생성하는 명령어
- 아래의 도커 이미지 및 컨테이너 생성/실행 확인 후 0.0.0.0:19090/api/v1/info 접속 하면 확인 가능

```
도커 이미지 및 컨테이너 생성(볼륨 및 포트포워딩)
[root@server-01]# sudo docker build -t spring-demo-docker:0.0.1 .
[root@server-01]# sudo docker run -it -d --name spring-demo -p 19090:9090 -v /mnt/d/data/docker:/usr/data/ spring-demo-docker:0.0.1
[root@server-01]# sudo docker ps
CONTAINER ID   IMAGE                     COMMAND               CREATED          STATUS          PORTS                                         NAMES
6c9e08a179c6   spring-demo-docker:0.0.1  "java -jar app.jar"   17 minutes ago   Up 17 minutes   0.0.0.0:19090->9090/tcp, :::19090->9090/tcp   spring-demo
```

### 슬랙 봇 설정 방법

1. Create New App 클릭 > From Scratch 선택 > 워크 스페이스를 생성합니다.
![일번](./docs-images/1.png)

2. OAuth & Permissions > OAuth Tokens for Your Workspace > 워크스페이스를 설치합니다.
![일번](./docs-images/2.png)

3. OAuth & Permissions > Scopes > Bot Token Scopes 를 추가 합니다.
![일번](./docs-images/3.png)

4. App Home > Your App's Presence in Slack > 봇에 대한 이름을 설정해 줍니다.
![일번](./docs-images/4.png)

5. Basic Infomation > Install Youer App > Install to Workspace 를 클릭합니다.
![일번](./docs-images/5.png)

6. 메세지 Echo를 위해 Event Subscriptions > Enable Events 주소를 설정합니다. 해당 주소는 자신이 만든 API 에서 슬랙이 호출이 Request Body에 challenge 값을 전달해 주는데 이 값을 그대로 Response 하면 됩니다.
![일번](./docs-images/6.png)

7. Event Subscriptions > Subscribe to event on behalf of users > message.channels 를 추가 합니다.
![일번](./docs-images/7.png)

8. 슬랙 앱을 실행 후 자신의 채널에 봇을 초대 하면 됩니다.

9. 모든 설정이 완료되었다면 슬랙에서 채팅 메세지를 보내면 슬랙 -> 내가 만든 API 으로 구독을 받을 수 있습니다. 이 메세지를 가지고 다른 작업을 진행 하면 됩니다.