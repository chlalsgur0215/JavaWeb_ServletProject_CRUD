# JavaWeb_ServletProject_CRUD

## 프로젝트 소개

Jakarta Servlet, JSP(JSTL)를 활용한 회원 관리 웹 애플리케이션입니다.

회원 정보의 생성(Create), 조회(Read), 수정(Update), 삭제(Delete)를 구현하며
Servlet 기반 MVC 구조와 MySQL 연동 방법을 학습하기 위해 개발하였습니다.

---

## 블로그

- https://miyuck0215.tistory.com/
- Java 웹 프로그래밍 1~14주차 학습 내용 정리

---

## 개발 목적

- Servlet 구조 이해
- CRUD 구현 숙달
- MVC 패턴 학습
- MySQL 연동 학습
- JSP 및 JSTL 활용

---

## 개발 환경

### Tool

- IntelliJ IDEA
- Apache Tomcat
- MySQL
- Start Bootstrap (SB Admin 2)

### Tech Stack

- Java
- Jakarta Servlet
- JSP
- JSTL
- MySQL
- Lombok
- Gradle

---

## 주요 기능

- 회원 등록(Create)
- 회원 목록 조회(Read)
- 회원 정보 수정(Update)
- 회원 삭제(Delete)
- 로그인 기능
- 로그아웃 기능
- 로그인 사용자 이메일 표시
- 세션(Session) 기반 사용자 인증

---

## 프로젝트 구조

```text
Controller(Servlet)
        ↓
Service
        ↓
Repository(DAO)
        ↓
MySQL
```

DTO(Domain) 객체는 Controller, Service, Repository 계층 사이에서
데이터를 전달하는 역할을 수행합니다.

---

## 구현 과정

### 1. 웹 서버 구축

- Apache Tomcat을 설치하여 웹 애플리케이션 실행 환경 구축
- Jakarta Servlet 기반 프로젝트 생성

### 2. UI 적용

- Start Bootstrap의 SB Admin 2 템플릿 적용
- 회원 관리 화면 구성

### 3. 데이터베이스 구축

- MySQL 설치 및 데이터베이스 생성
- IntelliJ와 MySQL 연결
- 회원 정보 저장 테이블 생성

### 4. MySQL 연동

Gradle 의존성 추가

```gradle
implementation 'com.mysql:mysql-connector-j:8.4.0'
```

MySQL JDBC Driver를 통해 데이터베이스와 연결하여 CRUD 기능 구현

### 5. Lombok 적용

Gradle 의존성 추가

```gradle
implementation 'org.projectlombok:lombok:1.18.42'
annotationProcessor 'org.projectlombok:lombok:1.18.42'
```

- Getter / Setter 자동 생성
- 생성자 자동 생성
- 반복 코드 감소
- 가독성 향상

### 6. JSP 및 JSTL 적용

Gradle 의존성 추가

```gradle
implementation 'jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.2'
implementation 'org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1'
```

JSP를 사용하여 동적인 웹 페이지를 구현하였습니다.

JSTL을 활용하여:

- 반복문(c:forEach)
- 조건문(c:if)
- 데이터 출력

등을 처리하였습니다.

#### JSTL API와 구현체의 차이

```gradle
jakarta.servlet.jsp.jstl-api
```

- JSTL 사용 규격(API)
- c:forEach 등의 태그 정의 제공

```gradle
org.glassfish.web:jakarta.servlet.jsp.jstl
```

- JSTL 실제 구현체
- 태그를 실제로 실행하는 엔진

즉,

- API = 설계도
- Implementation = 실제 동작 코드

의 관계입니다.

### 7. Servlet 기반 MVC 구현

Servlet을 Controller로 사용하여 요청을 처리하였습니다.

```text
Client
 ↓
Servlet(Controller)
 ↓
Service
 ↓
Repository(DAO)
 ↓
MySQL
```

회원 관리 CRUD 기능과 로그인 기능을 구현하였습니다.

---

## 개선 사항

### 현재 상태

- 로그인 상태에서 재로그인 가능
- 로그아웃 상태에서 재로그아웃 가능

### 향후 개선 예정

- 로그인 여부 검사
- 중복 로그인 방지
- 비로그인 상태 접근 제한
- 예외 처리 강화
- 비밀번호 암호화 적용
