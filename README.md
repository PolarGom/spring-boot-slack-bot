### Spring Boot Demo
- Spring Boot 2.5 및 도커 연습

#### 실습환경
- Windows 10 WSL2 
- Windows Docker
- Microsoft Store 의 Ubuntu 18.04 LTS 

#### Dockerfile
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