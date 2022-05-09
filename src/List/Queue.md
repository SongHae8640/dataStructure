# Queue(큐)

# 1. Queue 란

---

- 먼저 들어오는 것이 먼저 처리 되는 구조를 가진 자료구조(FIFO) ex)줄서기
- 데이터가 삽입되는 쪽을 rear,  반대로 데이터가 삭제되는 front 라 한다.

## 1.2 Java에서는 어떻게 구현되어 있을까?

LinkedList 로 구현하고 있고 내부는 node의 연결로 구성되어 있다.
(LinkedList를 공부하면서 이 개념 그대로 Queue로 쓰이겠는데? 라고 생각했는데 역시나 그랬다.)

당연히 LinkedList 의 성능을 보여준다.

```java
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
{
    transient int size = 0;

    /**
     * Pointer to first node.
     */
    transient Node<E> first;

    /**
     * Pointer to last node.
     */
    transient Node<E> last;

...

}

//Queue 선언
Queue<Integer> queue = new LinkedList<>();
```

# 2. List에는 없지만 Queue(LinkedList)에는 있는 메서드(offer, poll , peek)

---

자바 API 에 보면 LinkedList는 ArrayList 와 다르게 Deque(Queue)를 상속한다.

```java
/*
 * @author  Josh Bloch
 * @see     List
 * @see     ArrayList
 * @since 1.2
 * @param <E> the type of elements held in this collection
 */

public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, **Deque<E>**, Cloneable, java.io.Serializable{

	...

}
```

Queue에 있는 데이터 추가 삭제 확인 하는 메서드가 각각 2개 씩 있다.

자바 컬랙션 프레임워크의 Queue 인터페이스에서 각기능을 하는 메서드의 차이를 잘 요약하였다.

```java
Summary of Queue methods

Throws exception  / Returns special value
-----------------------------------------
Insert | add(e)   / offer(e)         
Remove | remove() / poll()
Examine| element()/ peek()

```

add, remove, element는 해당 매서드에서 오류를 발생할 수 있고

offer, poll, peek는 값이 없을땐 null, 없을땐 해당 값을 반환한다는 것이다.

구현체인 LinkedList의 내부 코드를 보며 무슨 말인지 하나씩 살펴보자.

## 2.1 offer 와 add

반환 타입이 boolean 인 offer와 add 는 내부적으로 동일하다.

add는 index를 설정해줄 수 있고 이 과정에서 에러가 발생할 수 있다.

```java
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable{

	...

	public boolean offer(E e) {
	  return add(e);
	}

	public boolean add(E e) {
	  linkLast(e);
	  return true;
  }

	public void add(int index, E element) {
    checkPositionIndex(index);

    if (index == size)
        linkLast(element);
    else
        linkBefore(element, node(index));
  }

	private void checkPositionIndex(int index) {
    if (!isPositionIndex(index))
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
  }

	...

}
```

## 2.2 poll 와 remove

poll은 값이 없다면 null

remove는 값이 없다면 NoSuchElementException 예외처리

```java
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable{

	...

	public E poll() {
    final Node<E> f = first;
    return (f == null) ? null : unlinkFirst(f);
  }

	public E remove() {
    return removeFirst();
  }

	public E removeFirst() {
    final Node<E> f = first;
    if (f == null)
        throw new NoSuchElementException();
    return unlinkFirst(f);
  }

	...

}

```

## 2.3 peek 와 element

peek는 값이 없다면 null

element는 값이 없다면 NoSuchElementException 예외처리

```java
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable	...

	...

	public E peek() {
    final Node<E> f = first;
    return (f == null) ? null : f.item;
  }

	public E element() {
    return getFirst();
  }

	public E getFirst() {
    final Node<E> f = first;
    if (f == null)
        throw new NoSuchElementException();
    return f.item;
  }

	...

}

```

# 3. 왜?

---

## 3.1 왜 Queue를 LinkedList로 구현하였을까?

ArrayList 하 구현하면 메모리도 적게 들텐데 왜 그럴까? 그 답은 ArrayList 와 LinkedList의 성능 비교를 통해 유추해볼 수 있다.

`ArrayAndLinkedListCompareTest.java` 의 `compareAddTest`  매서드의 addAsc(last에 데이터 추가) 의 성능을 보면 arrayList와 linkedList 둘다 비슷한것을 볼 수 있다. 하지만 `compareRemoveTest` 매서드의removeAsc(0번째 데이터를 삭제)의 성능을 보면 arrayList의 성능이 linkedList에 비해 떨어지는 것을 볼 수 있다.

arrayList는 배열이기 때문에 poll을 할때 0번째 index에 있는 값을 꺼내고 array 에 있는 값들을 한칸씩 앞으로 댕기는 과정을 해야하는데 이 과정이 비효율적이다.

때문에 LinkedList로 구현한 것이다.

## 3.2 반대로 Stack은 왜 ArrayList 처럼 내부가 array 로 되어 있을까?

이거는 Stack 정리에서!