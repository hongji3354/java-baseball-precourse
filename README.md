# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
* [X] 컴퓨터는 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 생성할 수 있어야 한다. 
  * [X] 컴퓨터는 1부터 9까지 숫자만 생성할 수 있어야 한다. 
  * [X] 컴퓨터는 3자리 수를 생성할 수 있어야 한다.
  * [X] 컴퓨터는 서로 다른 수만 생성할 수 있어야 한다.
* [X] 사용자는 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 입력할 수 있어야 한다. 
  * [X] 사용자는 1부터 9까지 숫자만 입력할 수 있어야 한다.
    * [X] 숫자 0 입력은 불가능하다.
    * [X] 문자 입력은 불가능흐다.
  * [X] 사용자는 3자리 숫자를 입력할 수 있어야 한다.
    * [X] 3자리 미만/초과는 불가능하다.
  * [X] 사용자는 서로 다른 수만 입력할 수 있어야 한다.
    * [X] 동일한 숫자 입력은 불가능하다.
  * [X] 사용자가 잘못된 값을 입력할 경우 [ERROR]로 시작하는 에러 메시지를 출력
* [ ] 입력한 값에 대한 결과 
  * [ ] 같은 수가 같은 자리에 있다면 스트라이크이다.
  * [ ] 같은 수가 다른 자리에 있다면 볼이다.
  * [ ] 같은 수가 같은 자리에 있고 같은 수가 다른 자리에 있다면 스트라이크&볼이다.
  * [ ] 같은 수가 전혀 없다면 낫싱이다.
* [ ] 사용자가 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 종료된다.
  * [ ] 사용자가 입력한 값에 대한 결과값이 출력되어야 한다.
  * [ ] 사용자가 잘못된 값을 입력할 경우 에러 메시지를 출력하고 게임을 계속 진행할 수 있어야 한다.
  * [ ] 종료시 게임을 다시 시작하거나 완전히 종료할 수 있다.
