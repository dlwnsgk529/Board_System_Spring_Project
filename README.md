# Board_System_Spring_Project
Spring Boot를 사용하여 게시판 기능을 구현한 웹 애플리케이션입니다.

<br/>

## 📌 프로젝트 소개
- 회원가입 및 로그인 기능을 구현하고, 로그인한 사용자가 게시글 작성, 조회, 수정, 삭제할 수 있도록 구현했습니다.
- Spring Security를 적용하여 사용자 인증 및 제어 기능을 구현했습니다.
- 이 프로젝트는 웹 애플리케이션의 구조와 데이터 흐름을 이해하기 위해서 시작한 프로젝트입니다.
<br/>

## 📑 목차
1. 기술 스택
2. 프로젝트 구조
3. 주요 기능
4. 실행 화면
5. 데이터베이스 구조
6. API 설계 및 명세
7. 프로젝트 수행 과정 및 결과
8. 프로젝트 후기
<br/>

## 🛠 기술 스택

### 백엔드

| Technology | Description |
|---|---|
| Java 17 | 프로젝트 개발 언어 |
| Spring Boot 3.3.4 | 웹 애플리케이션 프레임워크 |
| Spring Security | 사용자 인증 및 로그인 처리 |
| MyBatis | 데이터베이스 연동 및 SQL 매핑 |

### 데이터베이스
| Technology | Description |
|---|---|
| MySQL | 사용자 및 게시글 데이터 저장 |

### 프론트엔드

| Technology | Description |
|---|---|
| JSP | View 구성 |
| JavaScript | 게시판 기능 구현 |
| CSS | 화면 스타일 |

### API 문서

| Technology | Description |
|---|---|
| Swagger | REST API 문서 및 테스트 |

### 개발 환경

| Technology | Description |
|---|---|
| Eclipse | 개발 IDE |
| Gradle | 빌드 도구 |
<br/>

## 📂 파일 구조
    Board_System_Spring_Project
     ┣ src
     ┃ ┣ main
     ┃ ┃ ┣ java
     ┃ ┃ ┃ ┗ com.dlwnsgk.Board_System_Spring_Project
     ┃ ┃ ┃    ┣ controller
     ┃ ┃ ┃    ┣ service
     ┃ ┃ ┃    ┣ mapper
     ┃ ┃ ┃    ┗ config
     ┃ ┃ ┣ resources
     ┃ ┃ ┃ ┗ application.properties
     ┃ ┃ ┗ webapp
     ┃ ┃    ┣ resources
     ┃ ┃    ┃  ┣ css
     ┃ ┃    ┃  ┗ js
     ┃ ┃    ┗ WEB-INF
     ┃ ┃       ┗ views
     ┃ ┗ test
     ┣ build.gradle
     ┗ README.md
<br/>

## ✨ 주요 기능

### 👤 회원 기능

- 회원가입
- 로그인 (Spring Security 인증)
- 로그아웃
  
### 📝 게시판 기능

- 게시글 작성 (관리자)
- 게시글 목록 조회 (전체 사용자)
- 게시글 상세 조회 (전체 사용자)
- 게시글 수정 (관리자)
- 게시글 삭제 (관리자)
- 게시글 조회수 증가 (로그인 사용자)
<br/>

## 🖥 실행 화면

### 홈 화면
<p align="left">
  <img width="665" height="315" alt="image" src="https://github.com/user-attachments/assets/08d26a0f-80d5-4fe3-865f-c456880d37c3" />
</p>



### 로그인 화면
<p align="left">
 <img width="665" height="315" alt="image" src="https://github.com/user-attachments/assets/b4030a51-565b-43d7-91fa-bef90803d075" />
</p>



### 회원가입 화면
<p align="left">
 <img width="665" height="315" alt="image" src="https://github.com/user-attachments/assets/e8f06596-4f95-4e0f-8ad0-0d9caac2e126" />
</p>



### 게시글 작성 (관리자)
<p align="left">
 <img width="665" height="315" alt="image" src="https://github.com/user-attachments/assets/de9bd93f-8923-4ec1-94a3-44c2937b10c3" />
</p>



### 게시글 상세 조회 (일반 회원 / 관리자)
<p align="left">
    <img width="475" height="225" alt="image" src="https://github.com/user-attachments/assets/74d2faca-3abd-4bfd-a083-c1b5735907d7" />
    <img width="475" height="225" alt="image" src="https://github.com/user-attachments/assets/6d756e1d-91f3-45ce-8b0e-c0a0ee39f4ef" />
</p>


### 게시글 수정 (관리자)

<p align="left">
    <img width="665" height="315" alt="image" src="https://github.com/user-attachments/assets/bd736766-192c-4af5-9190-09d33515f463" />
</p>
<br/>

## 🗄 데이터베이스 구조
<p align="left">
<img width="389" height="241" alt="DB" src="https://github.com/user-attachments/assets/0077ded7-0296-4b6d-a420-237a5b897833" />
</p>
<br/>

## 📡 API 설계 및 명세
| Method | URL                | Description |
| ------ | ------------------ | ----------- |
| DELETE | /menu/delete/{idx} | 특정 idx의 게시글 삭제      |
| GET    | /menu/{idx}        | 특정 idx의 게시글 조회      |
| GET    | /menu/all          | 전체 게시글 목록 조회   |
| POST   | /menu/add          | 게시글 작성      |
| PUT    | /menu/update/{idx} | 특정 idx의 게시글 수정      |
| PUT    | /menu/count/{idx}  | 특정 idx의 게시글 조회수 증가      |
<br/>

## ⛳ 프로젝트 수행 과정 및 결과
- 프로젝트 기간: 2026.02 ~ 2026.03
1. Spring Boot 프로젝트 환경 구축하고 MySQL 데이터베이스를 연동
2. Spring Security를 사용하여 웹 애플리케이션의 인증 및 보안 기능을 설정
3. MVC(Model-View-Controller) 구조로 웹 애플리케이션 구성
4. Controller–Service–Mapper 구조를 적용하여 로직과 데이터 접근 계층 분리 (백엔드와 데이터베이스간의 데이터 흐름 관리)
5. 사용자 회원 가입 및 로그인, 그리고 게시글 작성, 조회, 수정, 삭제 (CRUD) 기능을 구현하여 완성
<br/>

## 💡 프로젝트 후기
- 이 프로젝트를 통해 Spring Boot 기반 웹 애플리케이션의 구조와 동작 방식을 이해할 수 있었습니다.
  - MVC 기반 웹 애플리케이션 구조 이해
  - Controler-Service-Mapper 계층 구조와 데이터의 흐름 학습
  - MySQL 데이터베이스 연동 및 데이터 관리
  - Spring Security를 이용한 인증 처리
- 향후 개선 사항:
  - 게시글 페이징 처리
  - 댓글 기능 추가
