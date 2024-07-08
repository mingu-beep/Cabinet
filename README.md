
<p align="center">
  <img width="70%" alt="logo" src="https://github.com/mingu-beep/Cabinet/assets/82128032/ae95597d-2084-48db-9711-29821af00217"/>
</p>

## 1. 프로젝트 개요

> 사용자 간의 자유로운 중고 품목 거래를 도와주는 서비스
> 
> 사용자가 직접 물건을 등록할 수 있고, 거래 방식을 직거래 혹은 사물함(cabinet) 이용으로 선택할 수 있다.

- 국비 학원 졸업 팀 프로젝트
- 개발 기간 : 5주 (2021.08 ~ 2021.09)

- 팀 소개
  - 민채현 [<a href = "https://github.com/Hun-Se"><img alt="GitHub" src ="https://img.shields.io/badge/GitHub-181717.svg?&style=for-the-badge&logo=GitHub&logoColor=white"/>
</a> ](https://github.com/mingu-beep) : 웹 관련 총괄
  - 신윤경 [<a href = "https://github.com/Hun-Se"><img alt="GitHub" src ="https://img.shields.io/badge/GitHub-181717.svg?&style=for-the-badge&logo=GitHub&logoColor=white"/>
</a> ](https://github.com/elody2) : 아두이노 관련 총괄

## 2. 프로젝트 

### 1. 사용 기술 <br>
  Web : Java,  Spring boot, BootStrap, Thymeleaf, HTML, CSS, JavaScript, jQuery, Ajax, MyBatis <br>
  DB : MySQL <br>
  Arduino : Arduino Sketch <br>
  형상 관리 : Git, Github
### 2. 요구 사항 <br>
  ![web_table](https://github.com/mingu-beep/Cabinet/assets/82128032/2935249f-2c58-4e04-9b7c-7d52401de715)
### 3. 구현 기능 <br>
#### a. 사용자 서비스 및 기능
    - 회원 가입
      - 아이디 및 이메일 입력 시 Ajax를 활용하여 중복 확인이 가능하도록 함
    - 로그인 
      - 아이디 및 비밀번호 찾기 기능을 제공하도록 함
    - 거래 게시판
      - 등록된 물건 등록 순 나열
      - 판매 완료 상품 포함 / 미포함 선택 가능
      - 댓글 기능
      - 거래요청 클릭 시 채팅방 페이지로 이동
      - 거래 상태방 아이디 입력 시 거래 방식에 따라 버튼 생성
      - 캐비닛 거래시 위치와 비밀번호 입력 후 완료
    - 고객 센터 게시판
      - QnA 등록 가능
      - 등록된 QnA 확인 가능


#### b. 관리자 서비스 기능
      - 게시글 관리
      - 카테고리 관리 : 물품 카테고리 추가/수정/삭제 기능, 카테고리별 물품 수 확인 가능
      - 이벤트 관리
      - 회원 관리
      - QnA 관리
      - 서비스 지역 관리
  

### 4. DB 구조 <br>
  ![db_struct](https://github.com/mingu-beep/Cabinet/assets/82128032/19471be1-0038-49ed-917a-dced2ae8149c)
  



