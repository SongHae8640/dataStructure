# ArrayList

# 개념

---

자바의 List를 상속받는 클래스 중 하나

배열과 동일하게 연속되 메모리를 사용

배열을 크기가 고정이지만 ArrayList 는 가변

메모리 용량(Capacity)와 크기(Size)가 있고 현재 용량을 넘으려고 하면 더 큰 메모리를 할당

메모리 용량이 커져야 하는 상황이 되면 커진 용량의 배열을 생성

List 내부에 있는 값을 지울때 null 처리 하여 GC가 알아서 관리 해줌


# 내부 코드 까보기

---

함수를 다 보진 않고 ArrayList의 특징을 잘 나타내는 함수 몇개만 봐보자.

java 1.1버전의 ArrayList를 중심으로 함수를 추려보았다.

[ArrayList (Personal Basis Profile 1.1.2)](https://docs.oracle.com/javame/config/cdc/ref-impl/pbp1.1.2/jsr217/java/util/ArrayList.html)

add - List에 객체 추가

clear - List 안에 있는 내용 비우기

contains - List 안에 객체가 있는지 여부

ensureCapacity - List의 용량 보장

get - List 안에 있는 객제 불러오기

indexOf - 첫번째 객체의 있는지

isEmpty - List 안에 객체가 없는지 여부

lastIndexOf - 마지막 객체의 인덱스

remove - 객체 삭제

set - 인덱스 번째로 객체 세팅

toArray - array 반환


# ArrayList와 비교

---

테스트 케이스에서 보면 ArrayList는 remove 할때도 배열의 길이를 바로 줄임