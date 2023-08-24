# LottoProject

## :clipboard: 목차

- :books: <a href="#outline">개요</a>
- :wrench: <a href="#tech">기술 스택</a>
- :scroll: <a href="#erd">ERD(Entity-Relation Diagram)</a>
- :family: <a href="#team">팀원 역할 소개</a>
- :bookmark_tabs: <a href="#function">기능</a>
- :mag_right: <a href="#fullfill">보완할점</a>

# :books: <a name="outline">개요</a>
<br>

> **프로젝트** : GUI활용 로또 프로젝트
>
> **프로젝트 이름** : LottoGame
>
> **분류** : 팀 프로젝트
>
> **제작 기간** : 2023.05.25 ~ 2023.06.05
>
> **주제 선정 이유** : GUI활용하기 적합한 주제
> 
> **주 사용자층** : 로또에 대해 익숙하지 않은 사람들에게 간접경험
>
> **프로젝트 목표** :
> 1. 로또에 어색하거나 어려워하는 사람들에게 가볍게 접근하기 위한 프로그램 제작
> 2. 한눈에 흥미를 쉽게 가지도록 게임의 느낌을 주는 UI제작

<br>

# :wrench: <a name="tech">기술 스택</a>

<h4>데이터베이스</h4>
<div align="left">
   <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white" />
</div> 
<h4>언어</h4>
<div align="left">
    <img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=Java&logoColor=white"/>
</div>

<h4>API</h4>

[![MyGet pre-release](https://img.shields.io/myget/quartznet/vpre/Quartz)](#)

<h4>협업도구</h4>
<div align="left">
   <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white" />
   <img src="https://img.shields.io/badge/FIGMA-F24E1E?style=for-the-badge&logo=figma&logoColor=white" />
</div>

# :scroll: <a name="erd">ERD</a>

## 초기 ERD
<img src="https://github.com/Psh230412/0623Start/assets/110301333/18db84d4-60bd-4e4a-bef4-4cfb32e1143a" width="100%"/>

## 현재 ERD
<img src="https://github.com/Psh230412/0623Start/assets/110301333/3490b2b3-f836-43f1-a86f-0598953c6e90" width="100%"/>

### 변경이유
1. 낙찰/유찰된 물품을 포함한 전체 물품을 관리하는 copy_auction과 </br>
   경매 진행 중인 물품을 관리하는 auction으로 구분 하여 목적에 맞게 테이블 활용이 용이하도록 함
2. 낙찰/유찰 여부를 한 테이블로 관리함


# :family: <a name="team">팀원 역할 소개</a>
<br>

| 이름 | 박상현(팀장) / 김명완 | 유미홍 | 선보라 |
| :---: | :----------: | :----------: | :----------: |
| 역할 | 숫자선택기능 </br> 추첨 애니메이션기능 </br> 슬롯 선택기능 </br> 레코드기능 | 선택번호 비교기능 </br> 랜덤번호생성기능 </br> 오류검수 | UI디자인 </br> 리소스제작 </br> 사운드작업 </br> 튜토리얼 |

# :scroll: <a name="function">기능</a>
[상세보기](https://github.com/Psh230412/0623Start/blob/master/Presentation.md)

# :mag_right: <a name="#fullfill">보완할점</a>
### 1. 금액 충전, 결제시스템 추가
### 2. 입찰한 물품에 상위입찰이 들어오면 기존 입찰자에게 정보제공
### 3. 낙찰/유찰된 내역 삭제, 유찰물품 재등록
### 4. 이미 등록한 물품에 대한 정보 수정 기능
