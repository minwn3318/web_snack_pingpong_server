# 모바일 슈팅 퍼즐 게임 - 웹 서버 프로젝트
> 제작기한 : 2025-01-15 ~ 2025-06-17   
> 클라이언트 깃허브 주소 : https://github.com/minwn3318/WebSnackPingPong

## 1. 프로젝트 소개
교통수단을 이용중에도 이용자가 적극적으로 몰입하여 쉽게 즐길 수 있는 여가활동 거리를 제공하기 위한 모바일 게임을 제작합니다   
게임의 몰입성을 높이기 위한 랭킹 시스템을 도입하여 웹 서버를 해당 프로젝트에서 제작합니다

## 2. 주요 기능
- 회원가입/로그인/ 로그아웃
- 플레이 후 유저의 랭킹 생성
- 유저의 최고 점수, 스테이지, 랭킹 조회
- 탑 3랭킹  조회
  

## 2. 주요 기능
- 회원가입/로그인/ 로그아웃
- 플레이 후 유저의 랭킹 생성
- 유저의 최고 점수, 스테이지, 랭킹 조회
- 탑 3랭킹  조회
   
## 3. 기술 스택
- SpringBoots
- RESTful API
- jsession
- mysql
- Docker

## 4. 빌드 및 실행
아래에 주어진 도커허브의 이미지를 사용합니다
> 서버 이미지 :    
https://hub.docker.com/repository/docker/jmj1380/shootingminer-server/general   
> 데이터베이스 이미지 :    
https://hub.docker.com/repository/docker/jmj1380/shootingminer-db/general   
<br>

- 프로젝트에 주어진 ShootingMiner/docker-compose.yml 파일을 사용하여 서버컨테이너와 데이터베이스 컨테이너를 생성 후 네트워크 연결하여 서버를 시작합니다
```
docker-compose up -d
```

<br>   

## 5. 시스템 아키텍처 구조
모바일 슈팅 퍼즐 게임 - 웹 서버 프로젝트는 RESTful API 컨트롤러, jsession 기반 인증 시스템, 

그리고 유니티 클라이언트의 webRequest API와 연동되는 구조로 설계되었습니다 . 

서버는 도커기반 환경에서 구축되었습니다.

![Archtecter](https://github.com/user-attachments/assets/e275d02b-e743-4dcc-9b0e-d33202c339f7)   
<br>   

## 6. 주요 API 명세 
### Rank API 목록
| 기능              | Method     | Endpoint                        | 설명                            |
| --------------- | ---------- | ------------------------------- | ----------------------------- |
| 랭킹 등록           | **POST**   | `/play-records/save`                    | 플레이한 게임 결과의 랭킹 생성                       |
| 최고 점수 조회     | **GET**    | `/play-records/serach/max-score`                    | 유저의 최고 점수 조회                      |
| 최고 스테이지 조회        | **GET**    | `/play-records/serach/max-stage`                | 유저의 최고 스테이지 조회                  |
| 최고 랭킹 조회        | **GET**    | `/play-records/serach/max-total`           | 유저의 최고 랭킹 조회         |
| 탑 3 랭킹 조회           | **GET**    | `//play-records/serach/top-users}`           | 모든 랭킹들 중 탑 3 랭킹 조                  |

### User API 목록
| 기능              | Method     | Endpoint                        | 설명                            |
| --------------- | ---------- | ------------------------------- | ----------------------------- |
| 회원가입           | **POST**   | `/userids/join`                    | 회원가입 후 바로 로그인                       |
| 로그인     | **POST**    | `/userids/login`               제                  |

## 7. 프로젝트 설계 문서 링크
프로젝트 전반의 흐름, ERD 구조, API 명세서, 협업 규칙 등이 담겨 있습니다.

📄 프로젝트 흐름(notion)
```
🔗 https://www.notion.so/252cf55931a881f79d20f93c74f69cdb

```


## 8. 개발 중 배운 점 & 개선점
### 🔍 1) Jsession기반 인증 설계 경험

- jsession 도입 전에는 만약 중복 로그인이 되어도 알 수 없어 랭킹 조작이 용이하게 될 수 있는 환경이었음

- 프로젝트의 규모를 고려하여 jsesion을 사용하였고 그 결과 중복 로그인을 비허가하여 랭킹 조작 환경을 방지하였음  

### 🔍 2) 서버 배포 도커 이미지 사용 경험

- 기존 개발환경과 서버 배포 환경이 달라서 개발된 프로젝트를 옮기는 데 어려움 겪음

- 도커 이미지와 도커 허브, docker-compose.yaml를 사용하여 개발프로젝트를 서버에 옮기는데 용이할 뿐만 아니라 환경을 통일시켜 호환성 문제를 해결함


### 🔍 4) 개선해야 할 점

- 아이디나 비밀번호를 잃어버렸을 때 찾을 수 있는 서비스 필요

- 통합 테스트(JUnit) 도입 미완료 → 추후 CI/CD 환경에서 필요
