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

- 에포크타임(EPOCH TIME, 1970-01-01 00:00:00 UTC)부터 경과된 시간을 나노초단위로 계산
- 단일진법이라 계신이 쉽다.
- UTC기준이라 한국 시간대(+09:00)랑 수치가 다를 수 있다.
- 시간대를 고려해야하면 OffsetDateTime이 있다.
- java.util.Date 클래스를 대체하기 위한 것, Date클래스에도 Instant로 변환할 수 있는 메서드가 추가되었다.

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

-format 기호는 [여기서확인](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)

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

