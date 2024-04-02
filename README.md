# java-chess

체스 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

# 기능 구현 목록

## 체스판
- [x] 체스말과 체스판을 생성한다.
- [x] 입력에 맞춰 말을 이동 시킨다.
  - [x] 본인의 턴에서 다른 색의 말을 옮기려고 할 경우 예외 발생
  - [x] 이동 경로에 막힌 곳이 있으면 하면 예외가 발생한다.
    - [x] 첫 이동 폰, 룩, 비숍, 퀸은 이동 경로 찾기를 실시한다.
      1. 8방향 중 갈 수 있는 방향을 거른다.
      2. 걸러진 후보 방향 중 목적지 방향을 찾는다.
      3. 이후 해당 방향으로만 계속해서 직진한다. (수직, 수평, 대각)
      4. 1 ~ 3번을 목적지에 도착할때 까지 반복한다.
    - [x] 경로 찾기를 실행하는 중 다른 말을 만나면 예외가 발생한다.
  - [x] 목적지에 같은 색의 말이 있으면 예외가 발생한다.
  - [x] 목적지에 다른 색의 말이 있으면 말을 잡는다.
    - [x] 폰은 목적지가 아니라 대각선에 있으면 말을 수 있다.
- [x] 해당 위치에 있는 말의 색을 반환한다.
- [x] 킹이 잡히면 게임을 종료한다.
- [x] 체스판에 남아있는 말들의 총점을 계산한다.
  
## 체스말
- [x] 체스말은 종류와 색을 갖고 생성한다.
- [x] 다음 좌표가 규칙에 맞는지 확인한다.
  - [x] 규칙에 맞지 않은 이동이면 예외가 발생한다.
### 체스말 이동 규칙
- 폰
  - 처음은 2칸 혹은 1칸 직진할 수 있다.
  - 처음 위치를 벗어난 후부터는 1칸만 직진할 수 있다.
  - 폰은 해당 위치에 다른 색 말이 있는 경우 대각선 이동이 가능하다. 
- 나이트
  - 1칸 이동 후 대각선으로 이동할 수 있다.
  - 막힌 경로여도 뛰어넘을 수 있다.
- 비숍
  - 대각선으로 이동할 수 있다.
  - 중간에 다른 말로 막혀있으면 이동할 수 없다.
- 룩
  - 상하좌우 이동할 수 있다.
  - 중간에 다른 말로 막혀있으면 이동할 수 없다.
- 퀸
  - 상하좌우, 대각선으로 이동할 수 있다.
  - 중간에 다른 말로 막혀있으면 이동할 수 없다.
- 킹
  - 상하좌우, 대각선 1칸을 이동할 수 있다.

- [x] 체스말은 본인의 점수를 계산해 알려준다.
### 점수 계산 규칙
- 폰
  - 기본 점수는 1점이다.
  - 세로 줄에 같은 진영의 말이 있으면 0.5점으로 계산한다.
- 나이트
  - 2.5점이다.
- 비숍
  - 3점이다.
- 룩
  - 5점이다.
- 퀸
  - 9점이다.
- 킹
  - 킹이 잡히면 게임이 종료되므로 0점이다. 


## 입력
- [x] 사용자는 start를 입력해 게임을 시작할 수 있다.
- [x] 사용자는 end를 입력해 게임을 종료할 수 있다.
  - [x] start / end가 아닌 입력은 예외가 발생한다.
- [x] 사용자는 source와 target을 입력해 말을 이동시킬 수 있다.
  - [x] 잘못된 명렁어가 들어오면 예외가 발생한다.
- [x] 사용자는 status를 입력해 각 진영의 점수와 우승자를 볼 수 있다.
  - [x] status외의 입력이 들어오면 예외가 발생한다.

## 출력
- [x] 만들어진 체스판을 출력한다.
