#자바의 정석

## Chap 10.  날짜와 시간 & 형식화 date, time and formatting

### 1. 날짜와 시간

#### 1.1 Calendar와 Date

- Date 클래스는 JDK 1.0부터, Calendar는 1.1부터 제공되었다. 시간과 날짜를 다루는 목적
- JDK 1.8부터 java.time 패키지로 기존 단점을 개선한 클래스들이 추가.
- 널리 쓰이기 때문에 간단한 용법 정도는 익히고 가는 정도

##### Calendar와 GregorianCalendar

```java
	Calendar cal = new Calendar() // Error, Calendar is abstract class
	
	Calendar cla = Calendar.getInstance(); // general use
```

- Calendar의 구현 클래스는  GregorianCalendar(그레고리력)와 BuddihistCalendar(불멸기원)가 있다.
- 태국에서는 불멸기원을 사용하고 나머지는 그레고리력을 사용한다.
- 원한다면 해당 구현클래스를 직접 구현할 수 있다.
- 인스턴스 생성 시 기본적으로 현재날짜와 시간으로 설정된다.

##### Date와 Calendar 간 변환

- Calandar 도입과 함께 Date 대부분은 deprecated 됐다. 하지만 그럼에도 Date의 메서드가 필요한 경우가 있다.

```java
//cal->date
Calendar cal = Calendar.getInstance();
Date d = new Date(cal.getTimeInMillis());

//date->cal
Date d= new Date();
Calendar cal = Calendar.getInstance();
cal.setTime(d)
```

### 2. 형식화 클래스

- 숫짜, 날짜, 텍스트 데이터를 다루는 표준화된 클래스들
- java.text 패키지에 포함되어있다.
- '가 이스케이프 문자

#### 2.1 DecimalFormat

- 숫자의 형식화
- 정수, 부동소수점, 금액 등의 형식이 있다.
- 텍스트->숫자도 가능하다.
- 우리가 할일은 패턴 정의

```java
double number = 1234567.89;
DecimalFormat df = new DecimalFormat("#.#E0");
String result = df.format(number);
```

#### 2.2 SimpleDateFormat

- [SimpleDateFormatAPI](https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html)
- 날짜 용 패턴을 작성한다.

```java
Date today = new Date();
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

String result = df.format(today);
------------------------------------------
DateFormat df =  new SimpleDateFormat("yyyy년 M월 d일");

try {
	Date d = df.parse("2015년 11월 23일");
	System.out.println(df2.format(d));
```

- parse는 스페이스바도 빠짐없이 중요하게 여긴다. -> 예외처리에 신경써야한다.

#### 2.3 ChoiceFormat

- 범위에 해당하는 문자열을 찾아준다.
- 사용방법이 두 개 정도 있으니 보고 쓸 것

```java
		double [] limits = {60, 70, 80, 90};
		String[] grades = { "D", "C", "B", "A"};
		ChoiceFormat form = new ChoiceFormat(limits, grades);	
		----------------------------------------------
		String pat = "60#D|70#C|80<B|90#A";
		ChoiceFormat form = new ChoiceFormat(pat);
	
		int [] scores = {100, 95, 91, 90, 88, 70, 52, 60, -20};
		for(int score : scores) {
			System.out.println(score + " : " + form.format(score));
		}

```

#### 2.4 MessageFormat

- 정해진 양식을 출력
- parse()로 원하는 데이터를 뽑기도 간편
- 예제를 보고 써보자.
- {숫자}는 순차적일 필요는 없다.
- '는 MessageFormat에서 escape문자이다.


1. ex1: 사용용례
2. ex2: 사용용례
3. ex3: parse()사용용례

```java
		Object[] arguments = {
				"이자바", "02-123-1234", "27", "07-09"
		};

		String msg = "Name: {0} \nTel: {1} \nAge:{2}\nBirthday:{3}";
		String result = MessageFormat.format(msg, arguments);
		
		System.out.println(result);
```

### 3. java.time 패키지

-Date와 Calender의 단점을 해소하기 위한 패키지
-	java.time : 날짜와 시간을 다루는 데 필요한 핵심 클래스
-	java.time.chrono : 표준(ISO)가 아닌 달력 시스템을 위한 클래스
-	java.time.format : 날짜와 시간을 파싱, 포맷팅(형식화)하는 클래스
-	java.time.temporal : 날짜와 시간의 필드, 단위를 위한 클래스
-	java.time.zone : 시간대(time-zone)와 관련된 클래스
- immutable하다. like String
- thread-safe하다.

#### 3.1 java.time패키지의 핵심 클래스
- 날짜와 시간을 별도 클래스로 분리함
- 시간: LocalTime 클래스
- 날짜: LocalDate 클래스
- 둘다: LocalDateTime 클래스
- +시간대: ZonedDateTime ==> Calender의 기능이 여기까지
- Instant ==> Date와 유사, 나노초 단위로 센다. 

##### Period와 Duration

- Peroiod : 날짜 ~ 날짜
- Duration : 시간 ~ 시간

##### 객체생성 - now(), of()

```java
LocalDate date = LocalDate.now();
LocalTime time = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();
ZonedDateTime dateTimeInKr = ZonedDateTime.now();

LocalDate date = LocalDate.of(2015, 11, 23); //2015 11월 23일
LocalTime time = LocalTime.of(23, 59, 59); //23시 59분 59초
LocalDateTime dateTime = LocalDateTime.of(date, time);
ZonedDateTime dateTimeInKr = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul");
```

##### Temporal, TemporalAmount
- LcoalDate, LocalTime, LocalDateTime, ZonedDateTime는 모두 Temporal, TemporalAccessor, TemporalAdjuster 인터페이스를 구현함
- Duration, Period는 TemporalAmount 인터페이스를 구현
- Temporal, TemporalAmount 인터페이스를 실제 사용할 때도 쓰이니 구분할 수 있어야한다.

##### TemporalUnit, TemporalField
- 날짜, 시간 단위 정의: TemporalUnit 인터페이스 ---->ChronoUnit(구현, 열거형)
- 년, 월, 일 등 날짜 시간 필드 단위 정의: TemporalField 인터페이스 ---->ChronoField(구현, 열거형)

```java
LocalDate today = LocalDate.now();
Localdate tomorrow = today.plus(1, ChronoUnit.Days);
```

#### 3.2 LocalDate와 LoclaTime
- java.time의 제일 기본 클래스 ---> 나머지는 이 둘의 확장형이다.
- now, of로 객체를 생성해서 쓴다.

##### get(), getXXX()
- Calendar와 다른점 => 월범위:1~12, 월요일1~일요일7
- get(TemporalField field)의 경우 ChronoField에서 찾아쓰면 된다.

```java
System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range()); //범위 확인 예시
```

##### 필드 값 변경하기 - with(), plus(), minus()

- withXXX(value), with(TemporalField field, long newValue) : 선택한 수치로 변경
- plusXXX() : 수치만큼 더하기
- minusXXX() : 수치만큼 빼기
- LocalTime에는 truncatedTo()가 있는 데 지정된 거보다 작은 단위를 0으로 만든다. 날짜는 0이 될수 없으므로 LocalDate 클래스에는 없다.

##### 날짜, 시간 비교 - isAfter(), isBefore(), isEqual()
- compareTo()로 비교도 가능하다.
- equals(), isEqual()가 둘다 있는 이유는 연표(chronology)가 다른 두 날짜의 비교때문이다. 

#### 3.3 Instant

```java
Instant now = Instant.now();
now = Instant.ofEpochSecond(now.getEpochSecond());
now = Instant.ofEpochSecond(now.getEpochSecond(), now.getNano());
```

- java.util.Date 클래스를 대체하기 위한 것, Date클래스에도 Instant로 변환할 수 있는 메서드가 추가되었다.
- 에포크타임(EPOCH TIME, 1970-01-01 00:00:00 UTC)부터 경과된 시간을 나노초단위로 계산
- 단일진법이라 계신이 쉽다.
- UTC기준이라 한국 시간대(+09:00)랑 수치가 다를 수 있다.
- 시간대를 고려해야하면 OffsetDateTime이 있다.

#### 3.4 LocalDateTime, ZonedDateTime
- LocalDateTime <- LocalDate + LocalTime
    - LDT는 LcoalDate, LocalTime이 각각 제공하는 메서드로 생성할 수도있다.(부족한 시간과 날짜를 채워넣음)
    -	now(), of()메서드로 생성가능하다.
    -	LDT에서 LD, LT로 변환도 가능하다.
    - ZonedDateTime <- LocalDateTime + 시간대
- ZonedId를 LDT에 포함시켜서 만들 수 있다.

    ```java
    ZoneId zid = ZoneId.of("Asia/Seoul");
    ZonedDateTime zdt = dateTime.atZone(zid);
    System.out.prnitln(zdt);
    ```
    
##### ZoneOffset

- UTC부터 얼마나 떨어져있는 지를 표현

```java
ZoneOffset krOffset = ZonedDateTime.now().getOffset();
int krOffsetInSec = krOffset.get(ChronoField.OFFSET_SECONDS);
```

##### OffsetDateTime

- ZoneId가 아닌 ZoneOffset을 사용.
- 시간대를 시간의 차이로만 구분

```java
ZonedDateTime zdt = ZonedDateTime.of(date, time, zid);
OffsetDatetime odt = OffsetDateTime.of(date, time,krOffset);

OffsetDateTime dt = zdt.toOffsetDaetTime();
```

#### 3.5 TemporalAdjusters
- 자주쓰이는 날짜 계산 메서드 정의
- TemporalAdjusters는 TemporalAdjuster를 반환하는 여러 메서드를 가지고 있지만 본인은 그냥 extends Object이다.

##### TemporalAdjuster 직접 구현하기
- 추가 기능이 필요한 경우 메서드를 직접 만들 수 있다.
- adjustInto()를 구현하면 된다.
- 하지만 사용은 with()를 사용하자.

#### 3.6 Period, Duration

- Period : 날짜 차이
- Duration : 시간차이

##### between()

```java
LocalDate d1 = LocalDate.of(2014, 1, 1);
LocalDate d2 = LocalDate.of(2015,12,31);
Period pe = Period.between(d1, d2);
System.out.println(pe); // =>P1Y11M30D, pe.get(ChronoUnit.YEARS) --> 1

LocalTime t1 = LocalTime.of(00, 00, 00);
LocalTime t2 = LocalTime.of(12, 34, 56);
Duration du = Duration.between(t1, t2);
System.out.println(du); // =>PT12H34M56S
```

#### 3.7 파싱과 포맷

- java.time.formate패키지에 들어있음.
- DateTimeFormatter를 우선 숙지하자.
- [DateTimeFormatter API](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)

```java
LocalDate date = LocalDate.of(2016, 1, 2);
String yyyymmdd = DateTimeFormatter.ISO_LOCAL_DATE.format(date); //"2016-01-02"
String yyyymmdd = date.format(DateTimeFormatter.ISO_LOCAL_DATE); // "2016-01-02"
```

- 두 format()이 같은 기능을 함으로 원하는 쪽을 선택해서 쓰면된다.
- DateTimeFormmater에 상수로 정의된 형식들이다.

<img src="img/PredesignedFormatters.png"/>

##### 로케일에 종속된 형식화
- DateTimeFormatter의 static 메서드 ofLocalizedDate9), ofLocalizedTime(), ofLocalizedDateTime()으로 로케일 종속 적인 포맷터가 생성된다.

```java
DateTimeFormatter formatter = DateTimeFormatter.ofLocalized(FormatStyle.SHORT);
String shorFormat = formatter.format(LocalDate.now());
```

##### 포맷 직접 정의하기

-format 기호는 API를 참조

```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
```

##### 파싱하기

- parse() 메서드를 사용하면 된다.

```java
//미리 정의된 포맷 사용 예
LocalDate date = LocalDate.parse("2016-01-02", DateTimeFormatter.ISO_LOCAL_DATE);
//자주 쓰는 형식의 문자열은 parse(text)만으로 파싱이 가능하다.
LocalDate newDate = LocalDate.parse("2001-01-01");
```
- 보면 알겠지만 문자열 -> Temporal로 간다.
- 사용자 정의 패턴을 이용해 파싱할 수도 있다.

```java
DateTimeFormatter pat = DateTimeFormatter.ofPattenr("yyyy-MM-dd HH:mm:ss");
LocalDateTime endOfYear = LocalDateTime.parse("2015-12-31 23:59:59", pat);
```

## Chap 11 컬렉션 프레임웍

### 1. 컬렉션 프레임웍

- 데이터 군(群)을 저장하는 클래스들을 표준화한 설계
    - 컬렉션: 데이터그룹
    - 프레임웍: 표준화된 프로그래밍 방식
- JDK는 Vector, Hashtable, Properties같은 클래스들을 서로 다른 방식으로 처리했으나 JDK1.2부터 모든 컬렉션을 표준화된 방식으로 다룰 수 있게 되었다.

#### 1.1 컬렉션 프레임웍의 핵심 인터페이스

<img src="img/11-1_Collection_Interface.png" width="50%" style="display:block; margin: auto" alt="직접그림";/>

- List와 Set을 구현한 컬렉션 클래스들은 서로 공통점이 많아 Collection 인터페이스로 정의되었다. Map은 이질적이기에 그렇지 못했다.
- Iterable 인터페이스는 JDK1.5부터 추가되었는 데 iterator()로 중복을 없애기위함이므로 컬렉션으로서의 의미는 작다.

<table summary="general purpose implementations and interfaces" border="2" align="center">
<thead>
<tr>
<th id="interfaces">Interface</th>
<th id="hashtable">Hash Table</th>
<th id="resizablearray">Resizable Array</th>
<th id="balancedtree">Balanced Tree</th>
<th id="linkedlist">Linked List</th>
<th id="hashtableandlinkedlist">Hash Table + Linked List</th>
</tr>
<tr>
<td headers="interfaces"><code>Set</code></td>
<td headers="hashtable"><a href="../../../api/java/util/HashSet.html"><tt>HashSet</tt></a></td>
<td headers="resizablearray">&nbsp;</td>
<td headers="balancedtree"><a href="../../../api/java/util/TreeSet.html"><tt>TreeSet</tt></a></td>
<td headers="linkedlist">&nbsp;</td>
<td headers="hashtableandlinkedlist"><a href="../../../api/java/util/LinkedHashSet.html"><tt>LinkedHashSet</tt></a></td>
</tr>
<tr>
<td headers="interfaces"><code>List</code></td>
<td headers="hashtable">&nbsp;</td>
<td headers="resizablearray"><a href="../../../api/java/util/ArrayList.html"><tt>ArrayList</tt></a></td>
<td headers="balancedtree">&nbsp;</td>
<td headers="linkedlist"><a href="../../../api/java/util/LinkedList.html"><tt>LinkedList</tt></a></td>
<td headers="hashtableandlinkedlist">&nbsp;</td>
</tr>
<tr>
<td headers="interfaces"><code>Deque</code></td>
<td headers="hashtable">&nbsp;</td>
<td headers="resizablearray"><a href="../../../api/java/util/ArrayDeque.html"><tt>ArrayDeque</tt></a></td>
<td headers="balancedtree">&nbsp;</td>
<td headers="linkedlist"><a href="../../../api/java/util/LinkedList.html"><tt>LinkedList</tt></a></td>
<td headers="hashtableandlinkedlist">&nbsp;</td>
</tr>
<tr>
<td headers="interfaces"><code>Map</code></td>
<td headers="hashtable"><a href="../../../api/java/util/HashMap.html"><tt>HashMap</tt></a></td>
<td headers="resizablearray">&nbsp;</td>
<td headers="balancedtree"><a href="../../../api/java/util/TreeMap.html"><tt>TreeMap</tt></a></td>
<td headers="linkedlist">&nbsp;</td>
<td headers="hashtableandlinkedlist"><a href="../../../api/java/util/LinkedHashMap.html"><tt>LinkedHashMap</tt></a></td>
</tr>
</thead>
</table> 

- List: 순서가 있는 데이터의 집합. 데이터의 중복을 허용
    - ArrayList, LInkedList, Stack, Vector 등
- Set : 순서를 유지하지 않는 데이터의 집합, 데이터의 중복 비허용
    - HashSet, TreeSet 등
- Map : 키와 값의 쌍으로 이루어진 데이터의 집합, 순서유지 X, 키는 중복비허용, 데이터는 중복 허용
    - HashMap, TreeMap, HashTable, Properties 등
- Vector, Stack, Hashtable, Properties는 컬렉션 프레임웍 이전에 만들어져 명명규칙이 이후와 다르다.
- Vector, Hashtable은 호환성을 위해 남겨놓고 상속관계도 구현해 놓았으나 가급적 지양할것

##### Collection 인터페이스

- 컬렉션 클래스에 저장된 데이터의 읽기, 추가, 삭제 등 기본메서드들을 정의하고있따.
- [API_메서드는 직접확인바람](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)

##### List 인터페이스

- 중복 허용, 저장순서 유지되는 컬렉션 구현에 사용
- Vector, Stack, ArrayList, LinkedList 등이 있다.
- [LIST API](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)

##### Set 인터페이스

- 중복 비허용, 저장순서 유지 X

##### Map 인터페이스

- 키와 값 쌍으로 저장하는 컬렉션 클래스를 구현하는 데 쓰는 인터페이스
- Hashtable, HashMap, LInkedHashMap, SortedMap, TreeMap 등이 있다.
- [Map API](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)
- values()는 중복을 허용하기 때문에 Collection타입이고,
- keys()는 중복을 허용하지 않기 때문에 Set타입이다.

##### Map.Entry 인터페이스

-Map인터페이스의 내부 인터페이스이다.

```java
public interface Map {
	...
	interface Entry {
	...
	}
}
```

- key-value 쌍을 다루기 위해 내부적으로 Entry인터페이스가 정의되어있다.
- Map을 구현할때는 Map.ENtry도 구현해야한다.

#### 1.2 ArrayList

- List인터페이스가 구현되어있다.
- Vector보다는 ArrayList를 사용하자.
- Object배열을 이용해 데이터를 순차적으로 저장한다.
- ArrayList의 기본생성자는 10개 크기의 배열을 생성한다.
- 저장할 크기가 짐작이 된다면 그거보다 살짝 더 크게 생성하는 것을 권장하고 있다. 크기를 늘리는 게 시간을 소요하는 작업이기 때문.
- 배열은 크기를 바꿀 수 없기 때문에 새로운 배열에 데이터를 옮기는 방식으로 사용하고있다.
    - 그래서 데이터 개수를 적당히 고려하여 충분한 용량의 인스턴스를 생성하는 게 좋다.

#### 1.3 LinkedList

- 원래 크기를 변경할 수 없는 배열의 단점을 극복하기 위해 만들었다.
- 기본형이 링크드리스트
- 앞뒤로 왔다갔다할 수 있으면 더블링크드리스트
- 써큘러 링크드 리스트는 끝과끝을 연결해 놓은 것이다.
- 컬렉션프레임웍에서 제공하는 링크드리스트는 이중원형링크드리스트이다.
- List인터페이스를 구현했기 때문에 ArrayList와 외견상 메서드는 같다

#### 1.4 Stack과 Queue
- 스택 : LIFO
- 큐 : FIFO
- 스택은 ArrayList, 큐는 LinkedList로 구현한다.

##### PriorityQueue

- 저장순서상관없이 우선순위가 높을 것을 꺼냄
- null은 저장하지 못함(NullPointerException)
- 배열사용, 힙의 형태로 저장.(가장 큰값, 작은 값을 빠르게 찾을 수 있음)
- Number 친구들은 자체적으로 숫자를 비교하는 방법을 정의해서 방법을 지정하지 않아도된다.
- 객체의 경우 비교방법을 제공해야한다.

```
public class ComparatorTest {
	public static void main(String [] args) {
		Queue pq = new PriorityQueue(new ComparatorTest().new Comp());
		pq.offer(new FakeInt(3));
		pq.offer(new FakeInt(5));
		pq.offer(new FakeInt(2));
		pq.offer(new FakeInt(1));
		pq.offer(new FakeInt(7));
		
		System.out.println(pq);
	}
	
	class Comp implements Comparator<FakeInt>{
		@Override
		public int compare(FakeInt o1, FakeInt o2) {
			if(o1.getV()<o2.getV()) return -1;
			else if(o1.getV()==o2.getV()) return 0;
			
			return 1;
		}
		
	}
	static class FakeInt{
		int value;
		FakeInt(int value){
			this.value = value;			
		}
		int getV(){
			return value;
		}
		@Override
		public String toString() {
			return value + ""; 
		}
	}
}
```

##### Deque(Double-Ended Queue)
- 양쪽으로 추가/삭제가 가능
- 스택으로 써도되고 큐로 써도된다.

#### Iterator, ListIterator, Enumeration

- 컬렉션에 저장된 요소에 접근하는 데 쓰이는 인터페이스
- Enumeration은 Iterator의 구버젼,
- ListIterator는 Iterator를 상향시킨 것

##### Iterator

- 컬렉션에 저장된 요소들을 읽는 방법을 표준화한 것
- 컬렉션이 자신에게 저장된 요소에 접근하는 Iterator 인터페이스를 정의하고 Iterator()를 통해 반환한다.

```java
List list = new ArrayList();
Iterator it = list.iterator();

while(it.hasNext()) System.out.println(it.next());
```

```java
Map map = new HashMap();
...
Iterator it = map.keySet().iterator();
Iterator enIt = map.entrySet().iterator();
```

- Iterator는 컬렉션의 특성을 반영한다. List의 Iterator는 순서를 기억하고 Set의 Iterator는 순서를 반영하지 않는다.
- Iterator는 재사용되지 않아서 또 쓰려면 새로 받아와야한다.

##### ListIterator와 Enumeration

- [ListIterator API] (https://docs.oracle.com/javase/8/docs/api/java/util/ListIterator.html)
- Enumeration은 컬렉션 프레임웍 이전의 것, 호환을 위해서 남겨놓고있다. ==> 되도록이면 Iterator를 쓰자.
- ListIterator는 Iterator를 상속받아 기능을 추가했다. 양방향으로 이동이 가능하다.(List인터페이스 전용)
- 선택적 기능(optional operation)은 구현하지 않아도되고, 아래와 같이 처리하면 된다.

```java
public void remove() { throw new UnsupportedOperationException(); }
```

- 이와같은 것은 java api문서에서도 그렇게 하라고 쓰여잇다. UnsupportedOperationException은 RuntimeException의 자손이다.
- remove()는 next()와 같이 써야한다. remove()만 단독으로 쓰인다면 IllegalStateException이 발생한다.

#### 1.6 Arrays

- 배열을 다루는 데 유용한 메서드들이 정의되어있는 클래스
- 오버로딩이 많이 돼서 많아보이지만 사실 몇개 안된다고한다.

##### 배열 복사 - copyOf(), copyOfRange()

- 배열을 복사하는 메서드, Range는 범위복사이다.,

```java
int[] arr = {0,1 ,2, 3, 4};
int[] arr2 = Arrays.copyOfRange(arr, 2, 4); // {2, 3}
int[] arr3 = Arrays.copyOf(arr, 3); // {0, 1, 2}
```

##### 배열 채우기 - fill(), setAll()

- fill()은 값으로 채우고, setAll()은 함수형 인터페이스, 람다식을 기반으로 채운다.

```java
int[] arr = new int[5];
Arrays.fill(arr, 9); // {9, 9, 9, 9, 9}
Arrays.setAll(arr, () ->(int)(Math.random()*5)+1); // {1, 5, 2, 1, 1}
```

##### 배열 정렬과 검색 - sort(), binarySearch()

-binarysearch는 당연하지만 정렬된 기준이다.

```java
int[] arr = {3, 2, 0, 1, 4};

Arrays.sort(arr);
System.out.println(Arrays.toString(arr));
int idx = Arrays.binarySearch(arr, 2); //idx=2
```

##### 문자열의 비교와 출력 - equals(), toString()

- 다차원 배열 용으로 deepToString()이라는 것이 있다., 이는 3차원 배열에서도 동작한다.
- 마찬가지로 다차원배열 용으로 deepEquals()라는 것도 있다.

##### 배열 -> List - asList(Object ... a)

- 가변 인수기 때문에 저장할 요소를 나열하는 것도 가능하다.

```java
List list;
list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
list = Arrays.asList(1, 2, 3, 4, 5);
list.add(6); // UnsupportedOperationException
```

- asList로 반환한 List는 크기변경이 되지 않는다.

```java
List list = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
```

##### parallelXXX(), spliterator, stream()

- parallel~~~()은 여러 쓰레드로 나누어 처리한다.
- spliterator()는 Spliterator()를 반환하는 데 이도 여러 쓰레드로 처리할 수 있게 작업을 나누어놓는다.
- stream()은 컬렉션을 스트림으로 변환한다.

#### 1.7 Comparator와 Comparable

- 컬렉션을 정렬하는 데 필요한 메서드를 정의하고 있다.
- Arrays.sort()는 Comparable의 구현에 의해 정렬한다.

```java
public interface Comparator {
	int compare(Object o1, Object o2);
	boolean equals(Object obj);
}
public interface Comparable {
	public int compareTo(Object o);
}
```

- Comparable => 기본 정렬기준을 구현하는 데 사용한다.
    - compareTo()는 비교하는 값보다 작으면 음수, 같으면 0, 크면 양수를 반환하도록 구현한다.
    - 기본적으로 오름차 순
- Comparator => 기본 정렬 기준 외 다른 기준으로 정렬하고자 할 때 사용한다.
    - equals()는 Comparator를 구현한다면 오버라이딩을 할 필요가 있을 수도 있기에 정의되어있는 것이고compare()만 정의해도 무방하다.
    - 내림차 순 등 다른 기준으로 정렬을 내고 싶을 때는 Comparator를 구현한다.

#### 1.8 HashSet

- Set인터페이스를 구현한 가장 대표적인 컬렉션, 중복 X
- add(), addAll()을 사용하면 된다.
- 참고
    - 컬렉션 내 중복을 제거할 때도 쓰인다.
    - 저장순서를 유지하고 싶다면 LinkedHashSet이 있다.
    - 내부적으로 HashMap을 썼다.
    - localfactor는 기본값이 0.75로 75%용량이 찼을 경우 2배로 확장시킨다.
    - JDK1.8에서 스트림관련 내용이 추가되었다.
- HashSet에서 커스텀 클래스의 비교를 설계대로 진행하기 위해서는 equals()와 HashCode()를 작성해야할 수도 있다.(둘 다 적합해야한다.)
- JDK 1.8부터 도입된 Objects클래스의 hash()를 이용한 예

```java
public int hashCode() {
	return Objects.hash(name, age); // int hash(Object ... values);
}
```
- equals() 비교에 쓰인 정보가 수정되지 않다면, 실행 중인 자바 앱 내 동일 객체에 한 번 이상의 호출들은 일관성 있게 유지해야합니다. 그러나 항상 같은 값을 반환해야하는 것은 아닙니다.
- equals()에 의해 같다고 판명되는 두 객체의 hashcode() 호출은 같은 integer 결과를 생성해야한다.
- equals() 메서드에 의해 같지 않은 두 객체는, hashCode()를 부른다고 다른 integer 값을 생성해야하는 것은 아니다. 그러나 같지 않은 오브젝트들에 대해 다른 integer 값을 생성하는 것이 해시테이블의 퍼포먼스를 향상시킬 수 있음을 유념해야한다.


- The general contract of hashCode is:
     - Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified. This integer need not remain consistent from one execution of an application to another execution of the same application.
     - If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
     - It is not required that if two objects are unequal according to the equals(java.lang.Object) method, then calling the hashCode method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.
     
#### 1.9 TreeSet

- 이진 검색 트리 형태로 데이터를 저장한다. 이진 검색 트리의 성능을 향상시킨 레드-블랙 트리로 구현했다.
- 중복데이터의 저장을 허용하지 않고, 정렬을 하면서 저장한다.
- 저장되는 객체가 Comparable을 구현하던가 Comparaotr를 함께 제공해줘야한다. 그렇지 않으면 예외가 발생한다.

#### 1.10 HashMap, HashTable

- MashMap을 사용할 것을 권장한다.
- 키, 값의 쌍을 데이터(entry)로 저장
- 해싱을 이용해서 검색에 뛰어나다.
- HashMap은 내부에 Entry라는 내부클래스를 정의하고 Entry의 배열을 사용한다. 별개의 배열로 저장하지 않는 건 두 값을 하나로 긴밀하게 연결하고 싶어서이다.
- 키는 대개 String의 대문자나 소문자로 통일해서 쓴다.

##### 해싱과 해시 함수

- 해싱이란 해시 함수를 이용해서 데이터를 해시테이블에 저장하고 검색하는 기법을 말한다.
- 컬렉션에서 Hash가 붙어있다면 해싱을 구현한 것
- 데이터의 키를 해시함수에 넣어서 배열의 한 요소를 얻고, 그 곳에 연결된 링크드리스트에 저장한다.
    - HashMap같은 경우는 Object의 hashCode()를 이용해서 해싱한다.
    - String은 값을 이용해서 hashcode를 만들도록 hashCode()가 오버라이딩되어있다.
    - 사용자 정의 클래슨느 equals()와 hashCode()를 오버라이딩 해서 맞춰줘야 컬렉션에 넣을 때 원하는 대로 중복 혹은 중복 없이 넣을 수 있다.
    
#### 1.11 TreeMap

- 이진 트리 형태로 데이터를 저장한다.
- 검색은 HashMap이 기본적으로 뛰어나나 범위검색, 정렬이 필요할 때는 TreeMap이 유용하다.

#### 1.12 Properties 

- 애플리케이션 환경설정에 관련된 속성(property)를 저장하는 사용하는 게 일반적.
- 파일로부터 데이터를 읽고 쓰는 편의기능을 제공함. xml로 저장도 가능
- HashTable을 상속받아 구현
- (키, 값)을 (String, String)의 형태로 저장한다.
- [Properites API](https://docs.oracle.com/javase/10/docs/api/java/util/Properties.html)
- 읽어온 데이터의 문자셋 변환

```java
		String name = new String(prop.getProperty("name").getBytes("8859_1"), StandardCharsets.UTF_8 );
```

#### 1.13 Collections

- Arrays 처럼 sort(), fill(), copy() 등등이 제공된다.

##### 컬렉션의 동기화

- 멀티스레드환경에서 하나의 객체가 여러 스레드에서 사용할 때 데이터의 일관성을 유지하기 위해서는 객체에 동기화(synchronization)가 필요하다.
- ArrayList, HashMap 등 컬렉션은 필요한 경우에 java.util.Collections 클래스의 동기화 메서드를 이용해 동기화처리가 가능하게 되어있다.

```java
List syncList = Collections.synchronizedList(new ArrayList(...));
```

##### 변경불가 컬렉션 만들기

- 읽기전용으로 만든다.
- unmodifaibleXXX()를 이용하면된다.

##### 기타 여러 기능

- 싱글톤 컬렉션 만들기
- 한 종류의 객체만 저장하는 컬렉션 만들기(jdk 1.5 이전의 호환성때문에 만듬)

## Chap12 지네릭스, 열거형, 애너테이션

### 1. 지네릭스

- 다소 어려우면 적당히 이해하고 보고 넘어가자.
- 다음부터는 오라클에서 가져온 내용이다.
- A generic type is a generic class or interface that is parameterized over types.
- An invocation of a generic type is generally known as a prameterized.

#### 1.1 지네릭스란

- 다양한 타입의 객체들을 다루는 메서드나 클래스에 컴파일 시에 타입체크를 해주는 기능.
- 형변환의 번거로움을 줄이고, 타입안정성을 높인다.
    - 의도하지 않은 타입의 객체를 다루는 걸 막는다.
- 지네릭스의 장점
    1. 타입 안정성 제공
    1. 코드의 간결화(타입체크, 형변환의 생략)

#### 1.2 지네릭 클래스의 선언

- 클래스와 메서드에 선언할 수 있다.

```java
class Box {
	Object item;
	
	void setItem(Object item) { this.item = item; }
	Object getItem() { return item; }
}
-----------------
class Box<T> {
	T item;
	void setItem(T item) { this.item = item; }
	T getItem() { return item; }
}
```

- Box&lt;T>에서 T를 타입매개변수(Type parameters)이라고 한다.
    - ArrayList&lt;E>는 요소(Element)에서 E를 따왔다.
    - T를 고집하지 말고 적당히 어울리는 것을 선택해서 쓰자.
    - type parameters는 type variables 라고 부르기도한다.
    
- 타입변수는 결국 '임의의 참조형 타입'을 의미한다.
- You can also substitute a type parameter (that is, K or V) with a parameterized type (that is, List<String>): 파라미터화된 타입과 함께 쓸 때는 타입파라미터를 생략해도 된다.

```java
OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>(...));
```

```java
Box<String> b = new Box<String>();
//b.setItem(new Object()); //Error
b.setItem("ABC");
String item = b.getItem();
```
- 지네릭 클래스는 호환성을 위해 지네릭 이전의 방식으로 쓰는 것도 허용한다.
- 하지만 &lt;Object&gt;로라도 명시하지 않으면 경고를 낸다.

##### 지네릭스의 용어

- Box&lt;T> 지네릭 클래스, T의 Box 혹은 T Box라고 읽는다.
    - T - 타입변수, 타입 매개변수(T는 타입문자)
    - Box - 원시타입(Raw Type): the name of a generic class or interface without any type arguments
- 이름이 타입매개변수인 이유는 메서드의 매개변수와 비슷한 측면이 있어서
- Box&lt;String>은 매개변수화(parameterized type)된 타입이라고한다. - 매개변수화가 끝난?
    - An invocation of a generic type is generally known as a parameterized type.
- 컴파일 후 Box&lt;String>도 Box&lt;Integer>도 원시타입인 Box로 바뀐다.(지네릭 타입의 제거)

##### 지네릭스의 제한

- static 멤버에 타입변수 T를 사용할 수 없다.(모든 객체에 동일하게 동작해야하기 때문) T는 인스턴스변수로 간주된다.
    - 형이 매개변수화 되기 전에는 T가 정해지지 않는다. static T를 설정할 경우 매개변수화 시킬 때마다 static 타입인  T가 일반형이라는 것인 데 성립해서는 안된다.(모순적이다)----> 하나의 클래스변수에 동시에 존재하는 여러가지 형을 가지라는 것이므로
- 지네릭 타입의 참조변수는 선언가능하지만, 배열은 생성할 수 없다.
    - new 연산자가 컴파일 시점에 타입 T가 무엇인지 정확히 알아야한다.
- 배열을 생성해야할 필요가 있을 경우
    - new연산자 대신 Reflection API의 newInstance()같이 동적으로 객체를 생성하는 메서드로 배열을 만들거나.
    - Object 배열을 생성해서 복사한 후에 T[]로 형변환 해서 사용한다.


#### 1.3 지네릭 클래스의 객체 생성과 사용

- 참조변수와 생성자에 대입된 타입알규먼트가 일치하지 않으면 에러가 발생한다.

```java
Box<Apple> appleBox = new Box<Grape>(); //Error
```

- 일반형(Generic Type)은 상속을 허용한다.

```java
Box<Apple> appleBox = new FruitBox<Apple>();
```

- JDK 1.7에서는 추정이 가능한 경우 타입이 생략이 가능하게 되었다. 참조변수에 타입변수을 명시했다면 생성자에서는 타입변수를 생략해도 좋다.

#### 1.4 제한된 지네릭 클래스

- 타입변수에 지정하는 특정 종류를 제한할 수 있다.
- 인터페이스를 이용할 때도 extends를 사용한다.(implements는 사용 X)
- 2 개 이상의 상속을 받을 때는 &를 사용한다.(아래 예제의 경우 Fruit와 Eatable을 동시에 만족해야한다.)

```java
class FruitBox<T extends Fruit & Eatable> {
 ArrayList<T> list = new ArrayList<T>();
}
```

#### 1.5 와일드 카드

- 메서드 매개변수의 제너릭 타입에 쓰인다. 메서드의 매개변수에 지네릭 타입이 들어갈 때 타입변수가 다르게 해서는 오버로딩이 되지 않고 중복된 메서드가 되버린다.

```java
static Juice makeJuice(FruitBox<Fruit> box) { ... }

...

  FruitBox<Apple> appleBox = new FuirtBox<>();
  makeJuice(appleBox); // error
```
```java
//사실 예제에서 확인할 수 있지만 FruitBox의 타입변수는 항상 Fruit를 상속받아야하므로
//<?>로도 FruitBox에서 쓰이는 타입변수는 Fruit의 기능을 사용할 수 있다는 것을 보증받는다.
static Juice makeJuice(FruitBox<? extends Fruit> box) { ... }
```

- &lt;? extends T> 와일드 카드의 상한 제한, T와 자손만 가능
- &lt;? super T> 와일드카드의 하한제한, T와 조상만 가능
- &lt;?> 제한없음. &lt;? extends Object>와 상동
- 와일드 카드는 &연산자를 사용할 수 없다.
- 나중에 꺼내 쓰거나 하는 것을 고려해서 와일드카드를 잘 써 보자. 
	- Object형으로 받으면 그 객체 고유 클래스 기능을 사용할 수 없지만, 지네릭 클래스 자체에서 애초에 제한이 걸려있다면 그 클래스 기능을 사용할 수 있다.


#### 1.6 지네릭 메서드

- Generic methods are methods that introduce their own type parameters. This is similar to declaring a generic type, but the type parameter's scope is limited to the method where it is declared. Static and non-static generic methods are allowed, as well as generic class constructors.
- 지네릭 메서드는 고유의 타입 파라미터를 가지는 메서드들이다. 이 타입 파라미터의 스쿠프는 정의된 메서드 안으로 한정된다.(클래스에서 선언한 것과 이름은 같아도 구별되는 다른 것이다)
- static 함수는 클래스에서 선언한 타입 파라미터를 쓸 수는 없지만, 자체적으로 타입파라미터를 선언해서 사용할 수는 있다. 

```java
static <T> void sort(List<T> list, Comparator<? super T> c){}
```

```java
//와일드 카드
static Juice makeJuice(FruitBox<? extends Fruit> box) {
 ...
}
//지네릭 메서드
static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
 ...
}
```

```java
//지네릭 메서드의 호출
   Juice juice = Juicer.<Fruit>makeJuice(fruitBox);
   Juice juice = Juicer.<Apple>makeJuice(appleBox);
```

- 지네릭 메서드는 참조변수나 클래스 이름을 생략할 수 없다.
- 컴파일러가 추정이 가능하다면 타입파라미터를 생략할 수 있다.
- 아래와 같이 코드의 양을 줄일 수 있다.

```java
public static void printAll(ArrayList<? extends Product> l1, ArrayList<? extends Product> l2) { ...}

public static <T extends Product> void printAll(ArrayList<T> l1, ArrayList<T> l2) {
...
}
```

#### 1.7 지네릭 타입의 형변환

- 지네릭타입과 넌지네릭 타입간 형변환은 가능하다. ==> 경고 발생
- 형매개변수(type parameter)가 다른 지네릭 타입끼리의 형변환은 안된다.

```java
Box b1 = new Box();
Box<T> b2 = new Box<>();

b1 = (Box)b2;
b2 = (Box<T>)b1;
```

#### 1.8 지네릭 타입 비고

- 지네릭 타입은 여기까지 다룬다. 이 이상의 내용이 쉽게 머리에 들어오지 않는 내용임에 반해 그 능률이 다른 것들을 익히는 데 투자할 때의 능률보다 심하게 떨어진다고 여겨지기 때문이다.

#### 개인적인 지네릭 타입 정리

- 지네릭 타입은 결국 범용성 있는 레퍼런스 타입에 관한 것인가 보다.


### 2. 열거형(enums)

#### 2.1 열거형이란?

- JDK 1.5부터 추가
- typesafe enum이다.
    - C와 다르게 타입까지 함께 관리(논리적 오류 줄어듬)
    - C같은 경우 타입이 달라도 값이 같으면 논리연산상 참으로 처리됐다.
    
```java
class Card1 {
	static final int CLOVER = 0;
	static final int HEART = 1;
	static final int DIAMOND = 2;
	static final int SPADE = 3;
	
	static final int TWO = 0;
	static final int THREE = 1;
	static final int FOUR = 2;
	
	final int kind;
	final int num;
}
class Card2 {
	enum Kind { CLOVER, HEART, DIAMOND, SPADE }
	enum Value { TWO, THREE, FOUR }
	
	final Kind kind;
	final Value value;
}
```

```
Card1.CLOVER == Card2.TWO; // true, 의미상 false
Card2.Kind.CLOVER == Card.Value.Two; // false, 값은 같음
```
- 위의 경우 상수의 값이 바뀔 경우 모든 소스를 다시 컴파일해야한다.(상수는 컴파일 시 값 그대로 박아버리는 듯 하다)
- 상수의 변동이 있을 경우 위의 방식으로는 값을 수정할 일이 생기거나 추가하거나 할 때 귀찮아질 수 있다. ==> 열거형은 그럴 때 유용할 것이다.

#### 2.2 열거형의 정의와 사용

```
enum 열거형이름 { 상수명1, 상수명2, ... }
```

- equals()말고 ==로 연산 가능하다.(후자가 빠르다고한다.)
- 비교연산자는 사용이 불가능하다.
- compareTo()는 사용가능하다.
    - 동일할 시 0 왼쪽이 크면 양수, 오른쪽이 크면 음수를 반환한다.
- switch ~ case 문에 사용 가능하다.
    - case문에는 열거형의 이름은 적지 않고 상수의 이름만 적는다.
    - 정확한 이유는 저자도 몰?루?인가 봄 ==> 보기 좋아 보인다는 추측이 있다.
    
``` java
enums Direction { EAST, WEST, NORTH, SOUTH }
class Unit {
	int x, y; // place of unit
	Direction dir; // declare enums for instance variable
	
	void init() {
		dir = Direction.EAST; //init unit direction
	}
	
	void move() {
		/*
		if(dir == Direction.EAST) { x++; }
		else if(dir > Direction.WEST) {} //Error, can't use comparison operator
		else if(dir.compareTo(Direction.WEST) > 0) { ... } //can use compareTo()		
		*/
	
		switch(dir) {
			case EAST: x++;
				break;	
			case WEST: x--;
				break;
			case SOUTH: y++;
				break;	
			case NORTH: y--;
				break;
		}		
	}
}
```

##### 모든 열거형의 조상 - java.lang.Enum

- 열거형 상수 출력 예제
- [Enum API](https://docs.oracle.com/javase/7/docs/api/java/lang/Enum.html)

```java

Direction dArr = Direction.values();

for(Direction d : dArr){ 
  System.out.printf("%s = %d%n", d.name(), d.ordinal());
}
```

- Enum 클래스의 메서드들
    - Class<E> getDeclaringClass : 열거형의 class 객체 반환.
    - String name() : 열거형 상수의 이름을 문자열로 반환
    - int ordinal() : 열거형 상수가 정의된 순서 반환(0부터)
    - T valueOf(class<T> enumTypoe, Stirng name) : 지정된 열거형에서 name과 일치하는 열거형 상수 반환.


#### 2.3 열거형에 멤버 추가하기

- ordinal()은 열거형 상수가 정의된 순서를 반환한다. 하지만 그 값은 내부적으인 용도로 쓰는 게 옳다고 저자는 소개한다.
- 열거형 상수의 값을 (값)의 형태로 적어줌으로 불연속적으로 정의할 수 있다.
    - 열거형 상수를 먼저 정의한다.
    - 지정된 값을 저장할 수 있는 인스턴스 변수와 생성자를 새로 추가해주어야한다.
- 열거형의 인스턴스 변수가 반드시 final은 아니다.
    - 열거형 상수의 값을 저장해야 한다면 final이 붙는다.
- 열거형의 생성자는 외부에서 호출이 불가능하다.(묵시적으로 private이다.)
- 열거형의 상수에 여러 값을 지정할 수 있으나 그에 맞게 인스턴스 변수, 생성자 등을 새로 추가해야한다.


```java
enum Direction {
	EAST(1, ">"), SOUTH(5, "V"), WEST(-1, "<"), NORTH(10, "^");
	
	private final int value;
	private final String symbol;
	Direction(int value, String symbol) { this.value = value; this.symbol = symbol; }
	
	public int getValue() { return this.value; }
	public String getSymbol() { return this.symbol; }
}	
```


##### 열거형에 추상 메서드 추가하기.

- 열거형의 각 상수?마다 다르게 동작하는 메서드를 추상메서드로 선언할 수 있다.
- 각 상수를 정의할때마다 따로 정의해주면 된다.


#### 2.4 열거형의 이해

- 열거형의 상수하나는 사실 그 열거형의 객체이다.

``` java
enum Direction { EAST, WEST, , SOUTH, NORTH } // Direction의 객체 EAST, WEST, SOUTH, NORTH

class Direction {
	static final Direction EAST =  new Direction("EAST");
	static final Direction SOUTH = new Direction("SOUTH");
	static final Direction WEST =  new Direction("WEST");
	static final Direction NORTH = new Direction("NORTH");
	
	private String name;
	private Direction(String name) { this.name = name; }
	
}
```

- Direction 클래스의 static 상수 EAST, SOUTH, WEST, NORTH의 값은 객체의 주소이고, 이 값은 바뀌지 않아 ==로 비교가 가능하다.
- 모든 열거형은 추상 클래스 Enum의 자손이다.



#### 개인적인 열거형 정리

- 이름이 같더라도 다른 열거형은 서로 논리연산의 대상이 되지 않는다.(에러)
- 다른 자바 파일에 정의된 열거형도 찾아낸다. 이것은 신기하네
    - 아마 클래스패스에만 있으면 같이 찾는 모양?
    - enum 역시 클래스인데 전처리를 시키는 문법을 컴파일 단위로 만든 것일 수도 있겠다는 생각이 든다. 아닐 수도 있지만.

```java
enum Animal { dog } 
class MyAnimal { enum Animal { dog } }
class Drive {
	public static void main(String [] args ) {
		System.out.println( Animal.dog == MyAnimal.Animal.dog ); // Error 
	
	}
}
```

- 열거형에 값을 지정할 때는 생성자만 있다면 컴파일 가능하다.
- 다만 그 값을 적절히 활용하기 위해서는 별도로 사용자 정의가 필요하다.

- 개인적인 감상
    - 당분간 열거형을 일종의 사용자 설계 타입이라고 생각하고 쓰면 되지 않을까 싶다.
    - 프리미티브 타입의  boolean은 false와 true의 도메인을 가진 것처럼, 내가 도메인을 설계해서 쓰는 사용자 정의 타입
    - 저자가 열거형 변수를 final로 지정한 건 아마 원칙같은 것 때문일 것 같다. 열거형 변수가 지정되면 immutable하기를 바라서가 아닐까 싶다.
    
### 3. 애너테이션Annotation

#### 3.1. 애너테이션이란

- 주석, 주해, 메모
- 초기: 자바 문서를 소스 파일과 함께 만들어서 주석으로 HTML을 만들어서 사용함(javadoc.exe를 이용함)
- 소스코드 안에 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨 것.
- 사용할 수 있는 애너테이션은 다른 프로그램에서 정의한 것도 있다.

#### 3.X Predefined Annotation Types

- 3.2. 표준 애너테이션과 오라클의 [Predifined Annotation Types](https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html)를 섞어서 정리하겠다.
- java SE api 안에 선정의된 애노테이션 타입의 집합
- 일부는 자바 컴파일러에 의해, 일부는 다른 애노테이션에 의해 사용된다. 

##### 3.X.1 Annotation Types used by the Java Language

- @Deprecated, @Override, @SuppressWarnings, @SupressWarnings는 java.lang에 선정의되어있다. 그 외에도  @FunctionalInterface 어느테이션이 있다.


- @Deprecated
    - 더 이상 쓰지 않게 알림.
    - 컴파일러에서도 이것이 쓰인 클래스나 메서드, 필드를 쓰게 되면 경고를 발생시킨다.
    - deprecated 되면 javadoc에서도 @deprecated 태그를 확인할 수 있다.(주석에서도, 코드상에서도), 주석상에 이유도 같이 기술함.
- @Override
    - 컴파일러에게 해당 요소가 superclass에 정의된 요소를 오버라이드 한다는 것을 알려줌
    - 꼭 써야할 필요는 없지만, 에러 방지를 방지하는 역할
    - 수퍼클래스에 것을 정확히 오버라이딩하지 않으면 컴파일러가 에러를 생성한다.
- @SuppressWarnings
    - 컴파일러에게 특정 경고를 억누르게 한다.
    - Every compiler warning belongs to a category. The Java Language Specification lists two categories: deprecation and unchecked.
    - *unchekced는 제너릭 도래 이전 레거시 코드에서 발생하기 쉽다.
    - To suppress multiple categories of warnings, use the following syntax:
        - @SuppressWarnings({"unchecked", "depreacation"})
- @SafeVarargs
    - *varargs : 가변인자, '메서드 이름(형 ... 이름)'의 형태로 쓰인다.
    - 메서드나 생성자에 쓰면 varargs 파라미터 상에 잠재적으로 안전하지 않은 동작을 이행하지 않는다고 주장하는 꼴이 된다.
    - varagres 관련 unchecked 경고를 막아준다.
    - unchecked 경고는 억눌러주지만 varargs 경고는 억누르지 못하니 그럴 경우에는 @SuppressWarnings(varargs)를 붙인다.
        - 해당경고는 -Xlint 옵션과 함꼐 쓰지 않으면 경고가 보이지 않는다고 한다. 
- @FunctionalInterface
    - @FunctionalInterface annotation, introduced in Java SE 8, indicates that the type declaration is intended to be a functional interface, as defined by the Java Language Specification.

##### 3.X.2 Annotations That Apply to Other Annotations

- 다른 어노테이션에 적용되는 어노테이션들은 meta-annotaions라고 불린다.
- 여러 메타 어노테이션 형들이 java.lang.annotation에 정의되어있다.


- @Retention
    - 마크된 어노테이션이 얼마나 유지되는 지를 명기합니다
        - RetentionPolicy.SOURCE: The marked annotation is retained(존속, 유지) only in the source level and is ignored by the compiler.
      - RetentionPolicy.CLASS: The marked annotation is retained by the compiler at compile time, but is ignored by the Java Virtual Machine (JVM).
      - RetentionPolicy.RUNTIME: The marked annotation is retained by the JVM so it can be used by the runtime environment.
        
- @Documented
    - javadoc 툴을 사용해 문서화해야하는 요소에 사용된다.
    - 기본적으로 애노테이션들은 자바독에 포함되지 않는다.
- @Target
    - 다른 어노테이션에 어느 종류의 자바 요소(elements)가 해당 어노태이션에 의해 적용될 수 있는 지를 한정시킨다.
    - 타겟 어노테이션은 아래 요소 형(element type)을 값으로 취하도록 명시되어있다.
        - ElementType.ANNOTATION_TYPE can be applied to an annotation type.
        - ElementType.CONSTRUCTOR can be applied to a constructor.
        - ElementType.FIELD can be applied to a field or property.
        - ElementType.LOCAL_VARIABLE can be applied to a local variable.
        - ElementType.METHOD can be applied to a method-level annotation.
        - ElementType.PACKAGE can be applied to a package declaration.
        - ElementType.PARAMETER can be applied to the parameters of a method.
        - ElementType.TYPE can be applied to any element of a class.      
- @Inherited
    - 애노테이션 타입에 수퍼 클래스로부터 상속 될 수 있게 지시합니다.
    - 클래스 명세에만 적용됩니다.
- @Repeatable
    - 자바 se8에서 소개됨.
    - 한 번 이상 적용가능될 수 있게 함.

- @Native
    - 네이티브 메서드에 의해 참조되는 상수필드에 붙이는 애노테이션
        - *네이티브 메서드
            - jvm이 설치된 os의 메서드
            - 보통 c언어로 작성
            - 보통 선언부만 정의하고 구현은 하지 않는다.

#### 3.4 애너테이션 타입 정의하기


@를 붙이고, Interface를 정의한다.

```java
@interface 애너테이션이름 {
    타입 요소이름();
    ...
}
```

- *@Override <= 애너테이션
- *Override <= 애너테이션 타입

##### 애너테이션의 요소

- 애너테이션 내에 선언된 메서드
    - 반환값이 있고, 매개변수는 없는 추상 메서드의 형태
    - 상속으로 구현 하지 않아도 된다. => 대신 애너테이션 적용할 때 요소들의 이름과 값을 지정해야함.(순서는 상관 없음)
- 애너테이션에는 상수는 정의할 수 있으나 디폴트 메서드는 정의할 수 없다.
- 애너테이션의 요소에 기본값 지정 가능하다. 이 경우 값을 지정하지 않으면 기본값을 사용한다. 기본값은 null을 제외한 모든 리터럴literal(소스 코드 상의 고정된 값) 가능
- 애너테이션의 요소가 하나이고 이름의 value인 경우 애너테이션 요소의 이름을 생략하고 값만 넣어도 된다.
- 요소 값이 배열인 경우 {} 안에 여러 값을 지정할 수 잇따.
 

```java
//정의 예
//TestInfo는 5개의 요소를 가지고 있다.
@Interface TestInfo{
    int count();
    String testedBy();
    String[] testTools();
    TestType testType(); // enum TestType { FIRST, FINAL }
    DateTime testDate(); // 자신이 아닌 다른 애너테이션(@DateTime)을 포함할 수 있따.
}
@Interface DateTiem {
	String yymmdd();
	String hhmmss();
}
```

```java
//사용 예
@TestInfo(
	count = 3, testedBy="Kim",
	testTools={"JUnit", "AutoTester"),
	testType=TestType.FIRST,
	testDate=@DateTime(yymmdd="160101", hhmmss="235959")
)
public class NewClass { ... }
```

```java
//기본값의 예, 괄호의 예
@interface TestInfo {
	int count() default 1;
	String[] info() default { "example", "of", "defaultValue" }
}
```

```java
//SuppressWarnings, 요소가 value 하나인 경우,
@interface SuppressWarnings{
	String[] value();
}

//이용 예
@SuppressWarnings( {"deprecation", "unchecked" } )
class NewClass { ... }
```

##### java.lang.annotation.Annotation

- 모든 애너테이션의 조상은 Annotation 인터페이스
- 애너테이션은 상속이허용되지 않는다.(애너테이션 정의문법을 말하는 것)

```java
@interface TestInfo extends Annotation { // error
...
}

```

- Annotation 인터페이스에 정의된 메서드들은 모든 애너테이션 객체에서 호출 가능하다.

##### Marker Annotation

- 값을 지정할 필요가 없는 경우, 요소가 정의되지 않은 애노태이션

##### 애너테이션 요소 규칙

- 요소 타입 : 기본형, String, enum, enum, 애너테이션, Class만 허용
- ()안에 매개변수 선언 불가.
- 예외 선언 불가
- 요소를 타입 매개변수로 정의할 수 없음.


#### 개인적인 정리

- 어노테이션 타입도 별도로 import 가능했다. 처음알았다.
- 열거형도 마찬가지였다.


## Chap 14 람다와 스트림

One issue with anonymous classes is that if the implementation of your anonymous class is very simple, such as an interface that contains only one method, then the syntax of anonymous classes may seem unwieldy and unclear. In these cases, you're usually trying to pass functionality as an argument to another method, such as what action should be taken when someone clicks a button. Lambda expressions enable you to do this, to treat functionality as method argument, or code as data.

The previous section, Anonymous Classes, shows you how to implement a base class without giving it a name. Although this is often more concise than a named class, for classes with only one method, even an anonymous class seems a bit excessive and cumbersome. Lambda expressions let you express instances of single-method classes more compactly.

### 1. 람다식

- JDK1.8에 추가
- 함수형 언어의 특징을 지니게 함.


#### 1.1 람다식이란?Lambda expression

- 메서드를 하나의 식(expression)으로 나타낸 것.
- 람다식을 익명함수라고 부르기도한다. <= 메서드의 이름과 반환값이 사라져서

```java
int[] arr = new int[5];
Arrays.setAll(arr, () -> (int)(Math.random()*5)+1);
```

#### 1.2 람다식 작성하기

- 이름과 반환타입을 제거하고 선언부와 몸통 사이에 -> 를 추가함
- 반환 값이 있는 경우 식(expression)으로 return을 대신할 수 있다.(세미콜론을 붙이지 않는다.)
- 추론이 가능한 경우에는 생략할 수 있다.
    - 매개변수의 타입
    - 반환값 역시 추론이 가능하기 때문에 생략된다. 

```java
int max(int a, int b) {
	return a > b ? a : b;
}

...

(int a, int b) -> a > b ? a : b

```

- 매개변수가 하나인 경우 괄호 생략 가능하다.

```java
//기본형
(int a, int b) -> {
   a += 5;
	return a + b;
}

//파라미터가 유추 가능한 경우
(a, b) -> {
	a+=5;
	return a+b;
}

//파라미터가 하나인 경우
a -> {
	a+=5;
	return a;
}

//반환값만 쓸 경우(바로 리턴한다.)
a -> a+5

// 몸통의 문장이 하나인 경우
void 
(a, b) -> a+b
```

#### 1.3 함수형 인터페이스

- 람다식을 다루기 위한 인터페이스
    - 추상 메서드는 하나만 있어야 한다.
    - static, default 메서드에는 개수제약이 없다. 
- 람다식은 익명객체와 동등하다.
- @FunctionalInterface 애너테이션을 이용해 조건을 체크할 수 있다.


##### 외부 변수를 참조하는 람다식

- 람다식이 외부의 지역 변수 등을 이용할 때는 그 변수가 final이거나 그에 준할 필요가 있다.(변화한다면 안된다, 컴파일러가 상수로 박아놔야 가능한 듯 하다.)
    - 람다식 내부든, 외부든 변화하는 변수를 사용하려한다면 에러가 발생
    - static의 경우는 해당 없다. 중간에 바꿔도 무방했다.
- 외부지역변수와 같은 이름의 람다식 매개변수는 허용되지 않는다.

#### 1.4 java.util.function 패키지

- 일반적으로 자주 쓰이는 함수형 인터페이스들을 정의
- 새로운 함수형 인터페이스를 정의할 것 없이 여기에 있는 것을 가져다 써도 되면 쓰면 된다.
    - 재사용성, 유지보수 등에 유리
- 

##### Predicate

- Function의 변형
- boolean을 반환한다. 

#### 개인적인 정리

- 람다식은 하나의 빈 메서드(추상 메서드)를 자동으로 채워주는 것과 그에 관한 익명객체에 생성을 간략화 시켜주는 식(expression)이다. 그 결과는 익명객체로서 반환된다.
- 람다식의 타겟은 반드시 함수형 인터페이스여야 한다.
- 함수형 인터페이스 애너테이션은 컴파일 단계에서 함수형 인터페이스 조건을 충족하는 지 알려주기 위한 것인듯 싶다. 붙이든 안붙이든 람다식을 붙여 쓰는 데 사소한 차이도 발견하지 못하였다.