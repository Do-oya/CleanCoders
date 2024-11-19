# Special Cases

capacity 0인 stack을 생성하면 어떻게 되나 ? 새로운 exception을 추가해야 하나 ?
하지만 너무 많은 Exception을 생성하는 것도 문제이다.
게다다 정말 capacity 0인 stack은 오류인가 ? 아니면 zero size stack이 의미 있는 객체인가 ?
zero size stack은 잘 정의된 행위를 가진다는 것이 밝혀졌다.

- push를 호출하면 Overflow
- pop을 호출하면 Underflow
- getSize는 0을 반환

이런 기능 구현을 Stack 클래스의 모든 메소드에 size가 0인지 비교하는 로직을 추가할 수 있다.
하지만 이 보다 좋은 방법이 있다. ← NullObject Pattern(Special Cases Pattern)

※ `git nb extract-interface origin/extract-interface`해서 실습 가능

## Extract Interface - Stack

![Alt text](https://monosnap.com/image/4lACuLFyj4vecfH0rduHI2T2XamsJf.png)

- "Rename original class and use interface where possible"을 선택해서 interface을 이름을 Stack으로 유지
- "Rename implementation class to:"에 기존 Stack 클래스의 변경할 이름을 "BoundedStack"으로 입력
- "Members to form interface"에서 getSize, isEmpty, push, pop 등 interface로 추출할 member를 선택

## Implements logic for stack that has 0 as capacity

![Alt text](https://monosnap.com/image/ajVy5xlNxGaUfsMUbkKzYrCazLI1WV.png)

## Move anonymous class to ZeroCapacityStack