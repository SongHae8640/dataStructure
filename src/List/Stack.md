# Stack

# **1. Stack 이란**

---

- 먼저 들어오는 것이 나중에 처리 되는 구조를 가진 자료구조(FILO) ex) ctrl + z

# 2. ****왜 Stack은 내부가 Array로 구현하였을까?****

queue는 내부가 node가 연결된 LinkedList로 구성되어 있다. Stack 도 node로 구성되도 상관 없을텐데 왜 array로 구성 되어 있을까?

array 와 node 의 차이라고 한다면 메모리를 차지하는 부분일텐데 이와 관련있지 않을까? 하고 검색 해보았는데 역시는 역시였다.

[Why stack using array why not linkedlist](https://stackoverflow.com/questions/24581818/why-stack-using-array-why-not-linkedlist)

node을 사용하여 구현되는 스택은 배열 기반 구현보다 스택 항목당 3~4배 많은 공간이 필요하다고 한다.