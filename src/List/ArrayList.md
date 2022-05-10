# LinkedList

# 1. 개념

---

- 자바의 List를 상속받는 클래스 중 하나
- 노드의 연속으로  각 노드가 데이터와 다음 노드의 주소인 포인터를 가져 체인 처럼 연결된 구조로 되어 있다.
- header는 첫번째 노드를 가리키는 포인터 역할만 한다.
  그 이후부터는 각 노드가 자신의 데이터와 다음 노드의 주소를 갖는다.

![Untitled](img/Untitled.png)

- 데이터가 추가 삭제 되면 주소만 연결해주면 된다.

![Untitled](img/Untitled%201.png)

![Untitled](img/Untitled%202.png)

- 노드 끼리 연결 되어 있어 LinkedList라고 불린다.
- 앞뒤 주소 둘다 가지고 있으면 양방향 LinkedList 즉, Double LinkedList 라 한다.

![Untitled](img/Untitled%203.png)

# 2. 내부 코드 까보기

---

함수를 다 보진 않고 ArrayList의 특징을 잘 나타내는 함수 몇개만 봐보자.

java 1.1버전의 ArrayList를 중심으로 함수를 추려보았다.

[LinkedList (Personal Basis Profile 1.1.2)](https://docs.oracle.com/javame/config/cdc/ref-impl/pbp1.1.2/jsr217/java/util/LinkedList.html)

add - List에 객체 추가

addFirst

addLast

clear - List 안에 있는 내용 비우기

contains - List 안에 객체가 있는지 여부

get - List 안에 있는 객제 불러오기

getFirst

getLast

indexOf - 첫번째 객체의 있는지

lastIndexOf - 마지막 객체의 인덱스

remove - 객체 삭제

removeFirst

removeLast

set - 인덱스 번째로 객체 세팅

size

toArray - array 반환

# 3. ArrayList와 LinkedList 의 성능비교

---

[ArrayAndLinkedListCompareTest.java](../../test/List/ArrayAndLinkedListCompareTest.java) 에서 두 List 자료구조의 성능을 테스트 케이스를 만들어서 비교해보았다

## 3.1 데이터 추가

### 3.1.1 순차 추가

내부가 array 로 구성되어 있는 ArrayList 가 빠를 것으로 예상.

현재 파일에서는 한자릿수 밀리세컨드로 비교가 불가능 하지만 [QueueAndStackCompareTest.java](../../test/List/QueueAndStackCompareTest.java) 에서 보면 array 로 구성된 자료구조가 예상대로 빠른것을 볼 수 있다.

### 3.1.2 역차 추가

ArrayList의 0번째 index에 값을 추가하면 array의 용량을 늘리고 각 값을 +1 번째 index로 옴겨야 한다.

반면에 LinkedList는 first 노드 앞에 신규 노드를 추가하기만 하면 된다.

때문에 LinkedList 가 ArrayList에 비해서 월등히 빠른 것을 볼 수 있다.

### 3.1.3 중간 추가

ArrayList는 중간 index의 값부터 한칸씩 옴겨야 하기 때문에 순차 추가와 역차 추가 사이 정도의 시간이 걸린다.

LinkedList는 데이터 추가는 빠르지만 i 번째 index를 찾는데 0번째 부터 노드를 타고 들어가야 하기 때문에 오래 걸린다.(중간을 찾고 연속적으로 데이터를 추가한다면 빠를것임)

### 3.1.4 랜덤 추가

ArrayList는 i 번째 값을 바로 찾지만 LinkedList는 i번째 노드를 찾는데 시간이 오래 걸린다.

## 3.2 데이터 삭제

### 3.2.1 순차 삭제

(순차 삭제를 0번째 데이터를 삭제하는 것으로 생각하고 진행)

역차 데이터 추가와 비슷하게 ArrayList는 0번째 데이터를 삭제하고 각 값을 -1 번째 index로 옴겨야 한다.

LinkedList는 first의 노드를 제거하기만 하면 된다.

때문에 ArrayList가 LinkedList 보다 느린것을 볼 수 있다.

### 3.2.2 역차 데이터 삭제

역차 데이터 삭제는  순차 데이터 추가와 같은 이유로

array 로 구성된 자료구조가 예상대로 빠르다.

### 3.2.3 랜덤 데이터 삭제

랜덤 삭제는 랜덤 삭제와 같은 이유로 LinkedList가 ArrayList 에 비해서 느리다.

## 3.3 데이터 조회

ArrayList의 데이터 조회는 i번째 값으로 바로 접근하기 때문에 항상 빠르다.

반면에 LinkedList는 노드를 타고 들어가야하기 때문에 i 번째 값으로의 접근이 상대적으로 느리다.

LinkedList안에 있는 값을 를 순차적으로 가져오고 싶다면 iterator 를 이용하여 i 번째 값을 가져올때 i-1 번째 노드의 next 주소를 이용하여 바로 가져오면 훨씬 빠르게 데이터를 가져 올 수 있다.
(역차 조회도 비슷한 방법)