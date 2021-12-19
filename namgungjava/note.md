#�ڹ��� ����

## Chap 10.  ��¥�� �ð� & ����ȭ date, time and formatting

### 1. ��¥�� �ð�

#### 1.1 Calendar�� Date

- Date Ŭ������ JDK 1.0����, Calendar�� 1.1���� �����Ǿ���. �ð��� ��¥�� �ٷ�� ����
- JDK 1.8���� java.time ��Ű���� ���� ������ ������ Ŭ�������� �߰�.
- �θ� ���̱� ������ ������ ��� ������ ������ ���� ����

##### Calendar�� GregorianCalendar

```java
	Calendar cal = new Calendar() // Error, Calendar is abstract class
	
	Calendar cla = Calendar.getInstance(); // general use
```

- Calendar�� ���� Ŭ������  GregorianCalendar(�׷�����)�� BuddihistCalendar(�Ҹ���)�� �ִ�.
- �±������� �Ҹ����� ����ϰ� �������� �׷������� ����Ѵ�.
- ���Ѵٸ� �ش� ����Ŭ������ ���� ������ �� �ִ�.
- �ν��Ͻ� ���� �� �⺻������ ���糯¥�� �ð����� �����ȴ�.

##### Date�� Calendar �� ��ȯ

- Calandar ���԰� �Բ� Date ��κ��� deprecated �ƴ�. ������ �׷����� Date�� �޼��尡 �ʿ��� ��찡 �ִ�.

```java
//cal->date
Calendar cal = Calendar.getInstance();
Date d = new Date(cal.getTimeInMillis());

//date->cal
Date d= new Date();
Calendar cal = Calendar.getInstance();
cal.setTime(d)
```

### 2. ����ȭ Ŭ����

- ��¥, ��¥, �ؽ�Ʈ �����͸� �ٷ�� ǥ��ȭ�� Ŭ������
- java.text ��Ű���� ���ԵǾ��ִ�.
- '�� �̽������� ����

#### 2.1 DecimalFormat

- ������ ����ȭ
- ����, �ε��Ҽ���, �ݾ� ���� ������ �ִ�.
- �ؽ�Ʈ->���ڵ� �����ϴ�.
- �츮�� ������ ���� ����

```java
double number = 1234567.89;
DecimalFormat df = new DecimalFormat("#.#E0");
String result = df.format(number);
```

#### 2.2 SimpleDateFormat

- [SimpleDateFormatAPI](https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html)
- ��¥ �� ������ �ۼ��Ѵ�.

```java
Date today = new Date();
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

String result = df.format(today);
------------------------------------------
DateFormat df =  new SimpleDateFormat("yyyy�� M�� d��");

try {
	Date d = df.parse("2015�� 11�� 23��");
	System.out.println(df2.format(d));
```

- parse�� �����̽��ٵ� �������� �߿��ϰ� �����. -> ����ó���� �Ű����Ѵ�.

#### 2.3 ChoiceFormat

- ������ �ش��ϴ� ���ڿ��� ã���ش�.
- ������� �� �� ���� ������ ���� �� ��

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

- ������ ����� ���
- parse()�� ���ϴ� �����͸� �̱⵵ ����
- ������ ���� �Ẹ��.
- {����}�� �������� �ʿ�� ����.
- '�� MessageFormat���� escape�����̴�.


1. ex1: �����
2. ex2: �����
3. ex3: parse()�����

```java
		Object[] arguments = {
				"���ڹ�", "02-123-1234", "27", "07-09"
		};

		String msg = "Name: {0} \nTel: {1} \nAge:{2}\nBirthday:{3}";
		String result = MessageFormat.format(msg, arguments);
		
		System.out.println(result);
```

### 3. java.time ��Ű��

-Date�� Calender�� ������ �ؼ��ϱ� ���� ��Ű��
-	java.time : ��¥�� �ð��� �ٷ�� �� �ʿ��� �ٽ� Ŭ����
-	java.time.chrono : ǥ��(ISO)�� �ƴ� �޷� �ý����� ���� Ŭ����
-	java.time.format : ��¥�� �ð��� �Ľ�, ������(����ȭ)�ϴ� Ŭ����
-	java.time.temporal : ��¥�� �ð��� �ʵ�, ������ ���� Ŭ����
-	java.time.zone : �ð���(time-zone)�� ���õ� Ŭ����
- immutable�ϴ�. like String
- thread-safe�ϴ�.

#### 3.1 java.time��Ű���� �ٽ� Ŭ����
- ��¥�� �ð��� ���� Ŭ������ �и���
- �ð�: LocalTime Ŭ����
- ��¥: LocalDate Ŭ����
- �Ѵ�: LocalDateTime Ŭ����
- +�ð���: ZonedDateTime ==> Calender�� ����� �������
- Instant ==> Date�� ����, ������ ������ ����. 

##### Period�� Duration

- Peroiod : ��¥ ~ ��¥
- Duration : �ð� ~ �ð�

##### ��ü���� - now(), of()

```java
LocalDate date = LocalDate.now();
LocalTime time = LocalTime.now();
LocalDateTime dateTime = LocalDateTime.now();
ZonedDateTime dateTimeInKr = ZonedDateTime.now();

LocalDate date = LocalDate.of(2015, 11, 23); //2015 11�� 23��
LocalTime time = LocalTime.of(23, 59, 59); //23�� 59�� 59��
LocalDateTime dateTime = LocalDateTime.of(date, time);
ZonedDateTime dateTimeInKr = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul");
```

##### Temporal, TemporalAmount
- LcoalDate, LocalTime, LocalDateTime, ZonedDateTime�� ��� Temporal, TemporalAccessor, TemporalAdjuster �������̽��� ������
- Duration, Period�� TemporalAmount �������̽��� ����
- Temporal, TemporalAmount �������̽��� ���� ����� ���� ���̴� ������ �� �־���Ѵ�.

##### TemporalUnit, TemporalField
- ��¥, �ð� ���� ����: TemporalUnit �������̽� ---->ChronoUnit(����, ������)
- ��, ��, �� �� ��¥ �ð� �ʵ� ���� ����: TemporalField �������̽� ---->ChronoField(����, ������)

```java
LocalDate today = LocalDate.now();
Localdate tomorrow = today.plus(1, ChronoUnit.Days);
```

#### 3.2 LocalDate�� LoclaTime
- java.time�� ���� �⺻ Ŭ���� ---> �������� �� ���� Ȯ�����̴�.
- now, of�� ��ü�� �����ؼ� ����.

##### get(), getXXX()
- Calendar�� �ٸ��� => ������:1~12, ������1~�Ͽ���7
- get(TemporalField field)�� ��� ChronoField���� ã�ƾ��� �ȴ�.

```java
System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range()); //���� Ȯ�� ����
```

##### �ʵ� �� �����ϱ� - with(), plus(), minus()

- withXXX(value), with(TemporalField field, long newValue) : ������ ��ġ�� ����
- plusXXX() : ��ġ��ŭ ���ϱ�
- minusXXX() : ��ġ��ŭ ����
- LocalTime���� truncatedTo()�� �ִ� �� ������ �ź��� ���� ������ 0���� �����. ��¥�� 0�� �ɼ� �����Ƿ� LocalDate Ŭ�������� ����.

##### ��¥, �ð� �� - isAfter(), isBefore(), isEqual()
- compareTo()�� �񱳵� �����ϴ�.
- equals(), isEqual()�� �Ѵ� �ִ� ������ ��ǥ(chronology)�� �ٸ� �� ��¥�� �񱳶����̴�. 

#### 3.3 Instant

```java
Instant now = Instant.now();
now = Instant.ofEpochSecond(now.getEpochSecond());
now = Instant.ofEpochSecond(now.getEpochSecond(), now.getNano());
```

- java.util.Date Ŭ������ ��ü�ϱ� ���� ��, DateŬ�������� Instant�� ��ȯ�� �� �ִ� �޼��尡 �߰��Ǿ���.
- ����ũŸ��(EPOCH TIME, 1970-01-01 00:00:00 UTC)���� ����� �ð��� �����ʴ����� ���
- ���������̶� ����� ����.
- UTC�����̶� �ѱ� �ð���(+09:00)�� ��ġ�� �ٸ� �� �ִ�.
- �ð��븦 ����ؾ��ϸ� OffsetDateTime�� �ִ�.

#### 3.4 LocalDateTime, ZonedDateTime
- LocalDateTime <- LocalDate + LocalTime
    - LDT�� LcoalDate, LocalTime�� ���� �����ϴ� �޼���� ������ �����ִ�.(������ �ð��� ��¥�� ä������)
    -	now(), of()�޼���� ���������ϴ�.
    -	LDT���� LD, LT�� ��ȯ�� �����ϴ�.
    - ZonedDateTime <- LocalDateTime + �ð���
- ZonedId�� LDT�� ���Խ��Ѽ� ���� �� �ִ�.

    ```java
    ZoneId zid = ZoneId.of("Asia/Seoul");
    ZonedDateTime zdt = dateTime.atZone(zid);
    System.out.prnitln(zdt);
    ```
    
##### ZoneOffset

- UTC���� �󸶳� �������ִ� ���� ǥ��

```java
ZoneOffset krOffset = ZonedDateTime.now().getOffset();
int krOffsetInSec = krOffset.get(ChronoField.OFFSET_SECONDS);
```

##### OffsetDateTime

- ZoneId�� �ƴ� ZoneOffset�� ���.
- �ð��븦 �ð��� ���̷θ� ����

```java
ZonedDateTime zdt = ZonedDateTime.of(date, time, zid);
OffsetDatetime odt = OffsetDateTime.of(date, time,krOffset);

OffsetDateTime dt = zdt.toOffsetDaetTime();
```

#### 3.5 TemporalAdjusters
- ���־��̴� ��¥ ��� �޼��� ����
- TemporalAdjusters�� TemporalAdjuster�� ��ȯ�ϴ� ���� �޼��带 ������ ������ ������ �׳� extends Object�̴�.

##### TemporalAdjuster ���� �����ϱ�
- �߰� ����� �ʿ��� ��� �޼��带 ���� ���� �� �ִ�.
- adjustInto()�� �����ϸ� �ȴ�.
- ������ ����� with()�� �������.

#### 3.6 Period, Duration

- Period : ��¥ ����
- Duration : �ð�����

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

#### 3.7 �Ľ̰� ����

- java.time.formate��Ű���� �������.
- DateTimeFormatter�� �켱 ��������.
- [DateTimeFormatter API](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)

```java
LocalDate date = LocalDate.of(2016, 1, 2);
String yyyymmdd = DateTimeFormatter.ISO_LOCAL_DATE.format(date); //"2016-01-02"
String yyyymmdd = date.format(DateTimeFormatter.ISO_LOCAL_DATE); // "2016-01-02"
```

- �� format()�� ���� ����� ������ ���ϴ� ���� �����ؼ� ����ȴ�.
- DateTimeFormmater�� ����� ���ǵ� ���ĵ��̴�.

<img src="img/PredesignedFormatters.png"/>

##### �����Ͽ� ���ӵ� ����ȭ
- DateTimeFormatter�� static �޼��� ofLocalizedDate9), ofLocalizedTime(), ofLocalizedDateTime()���� ������ ���� ���� �����Ͱ� �����ȴ�.

```java
DateTimeFormatter formatter = DateTimeFormatter.ofLocalized(FormatStyle.SHORT);
String shorFormat = formatter.format(LocalDate.now());
```

##### ���� ���� �����ϱ�

-format ��ȣ�� API�� ����

```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
```

##### �Ľ��ϱ�

- parse() �޼��带 ����ϸ� �ȴ�.

```java
//�̸� ���ǵ� ���� ��� ��
LocalDate date = LocalDate.parse("2016-01-02", DateTimeFormatter.ISO_LOCAL_DATE);
//���� ���� ������ ���ڿ��� parse(text)������ �Ľ��� �����ϴ�.
LocalDate newDate = LocalDate.parse("2001-01-01");
```
- ���� �˰����� ���ڿ� -> Temporal�� ����.
- ����� ���� ������ �̿��� �Ľ��� ���� �ִ�.

```java
DateTimeFormatter pat = DateTimeFormatter.ofPattenr("yyyy-MM-dd HH:mm:ss");
LocalDateTime endOfYear = LocalDateTime.parse("2015-12-31 23:59:59", pat);
```

## Chap 11 �÷��� �����ӿ�

### 1. �÷��� �����ӿ�

- ������ ��(��)�� �����ϴ� Ŭ�������� ǥ��ȭ�� ����
    - �÷���: �����ͱ׷�
    - �����ӿ�: ǥ��ȭ�� ���α׷��� ���
- JDK�� Vector, Hashtable, Properties���� Ŭ�������� ���� �ٸ� ������� ó�������� JDK1.2���� ��� �÷����� ǥ��ȭ�� ������� �ٷ� �� �ְ� �Ǿ���.

#### 1.1 �÷��� �����ӿ��� �ٽ� �������̽�

<img src="img/11-1_Collection_Interface.png" width="50%" style="display:block; margin: auto" alt="�����׸�";/>

- List�� Set�� ������ �÷��� Ŭ�������� ���� �������� ���� Collection �������̽��� ���ǵǾ���. Map�� �������̱⿡ �׷��� ���ߴ�.
- Iterable �������̽��� JDK1.5���� �߰��Ǿ��� �� iterator()�� �ߺ��� ���ֱ������̹Ƿ� �÷������μ��� �ǹ̴� �۴�.

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

- List: ������ �ִ� �������� ����. �������� �ߺ��� ���
    - ArrayList, LInkedList, Stack, Vector ��
- Set : ������ �������� �ʴ� �������� ����, �������� �ߺ� �����
    - HashSet, TreeSet ��
- Map : Ű�� ���� ������ �̷���� �������� ����, �������� X, Ű�� �ߺ������, �����ʹ� �ߺ� ���
    - HashMap, TreeMap, HashTable, Properties ��
- Vector, Stack, Hashtable, Properties�� �÷��� �����ӿ� ������ ������� ����Ģ�� ���Ŀ� �ٸ���.
- Vector, Hashtable�� ȣȯ���� ���� ���ܳ��� ��Ӱ��赵 ������ �������� ������ �����Ұ�

##### Collection �������̽�

- �÷��� Ŭ������ ����� �������� �б�, �߰�, ���� �� �⺻�޼������ �����ϰ��ֵ�.
- [API_�޼���� ����Ȯ�ιٶ�](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)

##### List �������̽�

- �ߺ� ���, ������� �����Ǵ� �÷��� ������ ���
- Vector, Stack, ArrayList, LinkedList ���� �ִ�.
- [LIST API](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)

##### Set �������̽�

- �ߺ� �����, ������� ���� X

##### Map �������̽�

- Ű�� �� ������ �����ϴ� �÷��� Ŭ������ �����ϴ� �� ���� �������̽�
- Hashtable, HashMap, LInkedHashMap, SortedMap, TreeMap ���� �ִ�.
- [Map API](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)
- values()�� �ߺ��� ����ϱ� ������ CollectionŸ���̰�,
- keys()�� �ߺ��� ������� �ʱ� ������ SetŸ���̴�.

##### Map.Entry �������̽�

-Map�������̽��� ���� �������̽��̴�.

```java
public interface Map {
	...
	interface Entry {
	...
	}
}
```

- key-value ���� �ٷ�� ���� ���������� Entry�������̽��� ���ǵǾ��ִ�.
- Map�� �����Ҷ��� Map.ENtry�� �����ؾ��Ѵ�.

#### 1.2 ArrayList

- List�������̽��� �����Ǿ��ִ�.
- Vector���ٴ� ArrayList�� �������.
- Object�迭�� �̿��� �����͸� ���������� �����Ѵ�.
- ArrayList�� �⺻�����ڴ� 10�� ũ���� �迭�� �����Ѵ�.
- ������ ũ�Ⱑ ������ �ȴٸ� �װź��� ��¦ �� ũ�� �����ϴ� ���� �����ϰ� �ִ�. ũ�⸦ �ø��� �� �ð��� �ҿ��ϴ� �۾��̱� ����.
- �迭�� ũ�⸦ �ٲ� �� ���� ������ ���ο� �迭�� �����͸� �ű�� ������� ����ϰ��ִ�.
    - �׷��� ������ ������ ������ ����Ͽ� ����� �뷮�� �ν��Ͻ��� �����ϴ� �� ����.

#### 1.3 LinkedList

- ���� ũ�⸦ ������ �� ���� �迭�� ������ �غ��ϱ� ���� �������.
- �⺻���� ��ũ�帮��Ʈ
- �յڷ� �Դٰ����� �� ������ ����ũ�帮��Ʈ
- ��ŧ�� ��ũ�� ����Ʈ�� �������� ������ ���� ���̴�.
- �÷��������ӿ����� �����ϴ� ��ũ�帮��Ʈ�� ���߿�����ũ�帮��Ʈ�̴�.
- List�������̽��� �����߱� ������ ArrayList�� �ܰ߻� �޼���� ����

#### 1.4 Stack�� Queue
- ���� : LIFO
- ť : FIFO
- ������ ArrayList, ť�� LinkedList�� �����Ѵ�.

##### PriorityQueue

- �������������� �켱������ ���� ���� ����
- null�� �������� ����(NullPointerException)
- �迭���, ���� ���·� ����.(���� ū��, ���� ���� ������ ã�� �� ����)
- Number ģ������ ��ü������ ���ڸ� ���ϴ� ����� �����ؼ� ����� �������� �ʾƵ��ȴ�.
- ��ü�� ��� �񱳹���� �����ؾ��Ѵ�.

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
- �������� �߰�/������ ����
- �������� �ᵵ�ǰ� ť�� �ᵵ�ȴ�.

#### Iterator, ListIterator, Enumeration

- �÷��ǿ� ����� ��ҿ� �����ϴ� �� ���̴� �������̽�
- Enumeration�� Iterator�� ������,
- ListIterator�� Iterator�� �����Ų ��

##### Iterator

- �÷��ǿ� ����� ��ҵ��� �д� ����� ǥ��ȭ�� ��
- �÷����� �ڽſ��� ����� ��ҿ� �����ϴ� Iterator �������̽��� �����ϰ� Iterator()�� ���� ��ȯ�Ѵ�.

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

- Iterator�� �÷����� Ư���� �ݿ��Ѵ�. List�� Iterator�� ������ ����ϰ� Set�� Iterator�� ������ �ݿ����� �ʴ´�.
- Iterator�� ������� �ʾƼ� �� ������ ���� �޾ƿ;��Ѵ�.

##### ListIterator�� Enumeration

- [ListIterator API] (https://docs.oracle.com/javase/8/docs/api/java/util/ListIterator.html)
- Enumeration�� �÷��� �����ӿ� ������ ��, ȣȯ�� ���ؼ� ���ܳ����ִ�. ==> �ǵ����̸� Iterator�� ����.
- ListIterator�� Iterator�� ��ӹ޾� ����� �߰��ߴ�. ��������� �̵��� �����ϴ�.(List�������̽� ����)
- ������ ���(optional operation)�� �������� �ʾƵ��ǰ�, �Ʒ��� ���� ó���ϸ� �ȴ�.

```java
public void remove() { throw new UnsupportedOperationException(); }
```

- �̿Ͱ��� ���� java api���������� �׷��� �϶�� �����մ�. UnsupportedOperationException�� RuntimeException�� �ڼ��̴�.
- remove()�� next()�� ���� ����Ѵ�. remove()�� �ܵ����� ���δٸ� IllegalStateException�� �߻��Ѵ�.

#### 1.6 Arrays

- �迭�� �ٷ�� �� ������ �޼������ ���ǵǾ��ִ� Ŭ����
- �����ε��� ���� �ż� ���ƺ������� ��� � �ȵȴٰ��Ѵ�.

##### �迭 ���� - copyOf(), copyOfRange()

- �迭�� �����ϴ� �޼���, Range�� ���������̴�.,

```java
int[] arr = {0,1 ,2, 3, 4};
int[] arr2 = Arrays.copyOfRange(arr, 2, 4); // {2, 3}
int[] arr3 = Arrays.copyOf(arr, 3); // {0, 1, 2}
```

##### �迭 ä��� - fill(), setAll()

- fill()�� ������ ä���, setAll()�� �Լ��� �������̽�, ���ٽ��� ������� ä���.

```java
int[] arr = new int[5];
Arrays.fill(arr, 9); // {9, 9, 9, 9, 9}
Arrays.setAll(arr, () ->(int)(Math.random()*5)+1); // {1, 5, 2, 1, 1}
```

##### �迭 ���İ� �˻� - sort(), binarySearch()

-binarysearch�� �翬������ ���ĵ� �����̴�.

```java
int[] arr = {3, 2, 0, 1, 4};

Arrays.sort(arr);
System.out.println(Arrays.toString(arr));
int idx = Arrays.binarySearch(arr, 2); //idx=2
```

##### ���ڿ��� �񱳿� ��� - equals(), toString()

- ������ �迭 ������ deepToString()�̶�� ���� �ִ�., �̴� 3���� �迭������ �����Ѵ�.
- ���������� �������迭 ������ deepEquals()��� �͵� �ִ�.

##### �迭 -> List - asList(Object ... a)

- ���� �μ��� ������ ������ ��Ҹ� �����ϴ� �͵� �����ϴ�.

```java
List list;
list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
list = Arrays.asList(1, 2, 3, 4, 5);
list.add(6); // UnsupportedOperationException
```

- asList�� ��ȯ�� List�� ũ�⺯���� ���� �ʴ´�.

```java
List list = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
```

##### parallelXXX(), spliterator, stream()

- parallel~~~()�� ���� ������� ������ ó���Ѵ�.
- spliterator()�� Spliterator()�� ��ȯ�ϴ� �� �̵� ���� ������� ó���� �� �ְ� �۾��� ��������´�.
- stream()�� �÷����� ��Ʈ������ ��ȯ�Ѵ�.

#### 1.7 Comparator�� Comparable

- �÷����� �����ϴ� �� �ʿ��� �޼��带 �����ϰ� �ִ�.
- Arrays.sort()�� Comparable�� ������ ���� �����Ѵ�.

```java
public interface Comparator {
	int compare(Object o1, Object o2);
	boolean equals(Object obj);
}
public interface Comparable {
	public int compareTo(Object o);
}
```

- Comparable => �⺻ ���ı����� �����ϴ� �� ����Ѵ�.
    - compareTo()�� ���ϴ� ������ ������ ����, ������ 0, ũ�� ����� ��ȯ�ϵ��� �����Ѵ�.
    - �⺻������ ������ ��
- Comparator => �⺻ ���� ���� �� �ٸ� �������� �����ϰ��� �� �� ����Ѵ�.
    - equals()�� Comparator�� �����Ѵٸ� �������̵��� �� �ʿ䰡 ���� ���� �ֱ⿡ ���ǵǾ��ִ� ���̰�compare()�� �����ص� �����ϴ�.
    - ������ �� �� �ٸ� �������� ������ ���� ���� ���� Comparator�� �����Ѵ�.

#### 1.8 HashSet

- Set�������̽��� ������ ���� ��ǥ���� �÷���, �ߺ� X
- add(), addAll()�� ����ϸ� �ȴ�.
- ����
    - �÷��� �� �ߺ��� ������ ���� ���δ�.
    - ��������� �����ϰ� �ʹٸ� LinkedHashSet�� �ִ�.
    - ���������� HashMap�� ���.
    - localfactor�� �⺻���� 0.75�� 75%�뷮�� á�� ��� 2��� Ȯ���Ų��.
    - JDK1.8���� ��Ʈ������ ������ �߰��Ǿ���.
- HashSet���� Ŀ���� Ŭ������ �񱳸� ������ �����ϱ� ���ؼ��� equals()�� HashCode()�� �ۼ��ؾ��� ���� �ִ�.(�� �� �����ؾ��Ѵ�.)
- JDK 1.8���� ���Ե� ObjectsŬ������ hash()�� �̿��� ��

```java
public int hashCode() {
	return Objects.hash(name, age); // int hash(Object ... values);
}
```
- equals() �񱳿� ���� ������ �������� �ʴٸ�, ���� ���� �ڹ� �� �� ���� ��ü�� �� �� �̻��� ȣ����� �ϰ��� �ְ� �����ؾ��մϴ�. �׷��� �׻� ���� ���� ��ȯ�ؾ��ϴ� ���� �ƴմϴ�.
- equals()�� ���� ���ٰ� �Ǹ�Ǵ� �� ��ü�� hashcode() ȣ���� ���� integer ����� �����ؾ��Ѵ�.
- equals() �޼��忡 ���� ���� ���� �� ��ü��, hashCode()�� �θ��ٰ� �ٸ� integer ���� �����ؾ��ϴ� ���� �ƴϴ�. �׷��� ���� ���� ������Ʈ�鿡 ���� �ٸ� integer ���� �����ϴ� ���� �ؽ����̺��� �����ս��� ����ų �� ������ �����ؾ��Ѵ�.


- The general contract of hashCode is:
     - Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified. This integer need not remain consistent from one execution of an application to another execution of the same application.
     - If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
     - It is not required that if two objects are unequal according to the equals(java.lang.Object) method, then calling the hashCode method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.
     
#### 1.9 TreeSet

- ���� �˻� Ʈ�� ���·� �����͸� �����Ѵ�. ���� �˻� Ʈ���� ������ ����Ų ����-�� Ʈ���� �����ߴ�.
- �ߺ��������� ������ ������� �ʰ�, ������ �ϸ鼭 �����Ѵ�.
- ����Ǵ� ��ü�� Comparable�� �����ϴ��� Comparaotr�� �Բ� ����������Ѵ�. �׷��� ������ ���ܰ� �߻��Ѵ�.

#### 1.10 HashMap, HashTable

- MashMap�� ����� ���� �����Ѵ�.
- Ű, ���� ���� ������(entry)�� ����
- �ؽ��� �̿��ؼ� �˻��� �پ��.
- HashMap�� ���ο� Entry��� ����Ŭ������ �����ϰ� Entry�� �迭�� ����Ѵ�. ������ �迭�� �������� �ʴ� �� �� ���� �ϳ��� ����ϰ� �����ϰ� �;�̴�.
- Ű�� �밳 String�� �빮�ڳ� �ҹ��ڷ� �����ؼ� ����.

##### �ؽ̰� �ؽ� �Լ�

- �ؽ��̶� �ؽ� �Լ��� �̿��ؼ� �����͸� �ؽ����̺� �����ϰ� �˻��ϴ� ����� ���Ѵ�.
- �÷��ǿ��� Hash�� �پ��ִٸ� �ؽ��� ������ ��
- �������� Ű�� �ؽ��Լ��� �־ �迭�� �� ��Ҹ� ���, �� ���� ����� ��ũ�帮��Ʈ�� �����Ѵ�.
    - HashMap���� ���� Object�� hashCode()�� �̿��ؼ� �ؽ��Ѵ�.
    - String�� ���� �̿��ؼ� hashcode�� ���鵵�� hashCode()�� �������̵��Ǿ��ִ�.
    - ����� ���� Ŭ������ equals()�� hashCode()�� �������̵� �ؼ� ������� �÷��ǿ� ���� �� ���ϴ� ��� �ߺ� Ȥ�� �ߺ� ���� ���� �� �ִ�.
    
#### 1.11 TreeMap

- ���� Ʈ�� ���·� �����͸� �����Ѵ�.
- �˻��� HashMap�� �⺻������ �پ�� �����˻�, ������ �ʿ��� ���� TreeMap�� �����ϴ�.

#### 1.12 Properties 

- ���ø����̼� ȯ�漳���� ���õ� �Ӽ�(property)�� �����ϴ� ����ϴ� �� �Ϲ���.
- ���Ϸκ��� �����͸� �а� ���� ���Ǳ���� ������. xml�� ���嵵 ����
- HashTable�� ��ӹ޾� ����
- (Ű, ��)�� (String, String)�� ���·� �����Ѵ�.
- [Properites API](https://docs.oracle.com/javase/10/docs/api/java/util/Properties.html)
- �о�� �������� ���ڼ� ��ȯ

```java
		String name = new String(prop.getProperty("name").getBytes("8859_1"), StandardCharsets.UTF_8 );
```

#### 1.13 Collections

- Arrays ó�� sort(), fill(), copy() ����� �����ȴ�.

##### �÷����� ����ȭ

- ��Ƽ������ȯ�濡�� �ϳ��� ��ü�� ���� �����忡�� ����� �� �������� �ϰ����� �����ϱ� ���ؼ��� ��ü�� ����ȭ(synchronization)�� �ʿ��ϴ�.
- ArrayList, HashMap �� �÷����� �ʿ��� ��쿡 java.util.Collections Ŭ������ ����ȭ �޼��带 �̿��� ����ȭó���� �����ϰ� �Ǿ��ִ�.

```java
List syncList = Collections.synchronizedList(new ArrayList(...));
```

##### ����Ұ� �÷��� �����

- �б��������� �����.
- unmodifaibleXXX()�� �̿��ϸ�ȴ�.

##### ��Ÿ ���� ���

- �̱��� �÷��� �����
- �� ������ ��ü�� �����ϴ� �÷��� �����(jdk 1.5 ������ ȣȯ�������� ����)

## Chap12 ���׸���, ������, �ֳ����̼�

### 1. ���׸���

- �ټ� ������ ������ �����ϰ� ���� �Ѿ��.
- �������ʹ� ����Ŭ���� ������ �����̴�.
- A generic type is a generic class or interface that is parameterized over types.
- An invocation of a generic type is generally known as a prameterized.

#### 1.1 ���׸�����

- �پ��� Ÿ���� ��ü���� �ٷ�� �޼��峪 Ŭ������ ������ �ÿ� Ÿ��üũ�� ���ִ� ���.
- ����ȯ�� ���ŷο��� ���̰�, Ÿ�Ծ������� ���δ�.
    - �ǵ����� ���� Ÿ���� ��ü�� �ٷ�� �� ���´�.
- ���׸����� ����
    1. Ÿ�� ������ ����
    1. �ڵ��� ����ȭ(Ÿ��üũ, ����ȯ�� ����)

#### 1.2 ���׸� Ŭ������ ����

- Ŭ������ �޼��忡 ������ �� �ִ�.

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

- Box&lt;T>���� T�� Ÿ�ԸŰ�����(Type parameters)�̶�� �Ѵ�.
    - ArrayList&lt;E>�� ���(Element)���� E�� ���Դ�.
    - T�� �������� ���� ������ ��︮�� ���� �����ؼ� ����.
    - type parameters�� type variables ��� �θ��⵵�Ѵ�.
    
- Ÿ�Ժ����� �ᱹ '������ ������ Ÿ��'�� �ǹ��Ѵ�.
- You can also substitute a type parameter (that is, K or V) with a parameterized type (that is, List<String>): �Ķ����ȭ�� Ÿ�԰� �Բ� �� ���� Ÿ���Ķ���͸� �����ص� �ȴ�.

```java
OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>(...));
```

```java
Box<String> b = new Box<String>();
//b.setItem(new Object()); //Error
b.setItem("ABC");
String item = b.getItem();
```
- ���׸� Ŭ������ ȣȯ���� ���� ���׸� ������ ������� ���� �͵� ����Ѵ�.
- ������ &lt;Object&gt;�ζ� ������� ������ ��� ����.

##### ���׸����� ���

- Box&lt;T> ���׸� Ŭ����, T�� Box Ȥ�� T Box��� �д´�.
    - T - Ÿ�Ժ���, Ÿ�� �Ű�����(T�� Ÿ�Թ���)
    - Box - ����Ÿ��(Raw Type): the name of a generic class or interface without any type arguments
- �̸��� Ÿ�ԸŰ������� ������ �޼����� �Ű������� ����� ������ �־
- Box&lt;String>�� �Ű�����ȭ(parameterized type)�� Ÿ���̶���Ѵ�. - �Ű�����ȭ�� ����?
    - An invocation of a generic type is generally known as a parameterized type.
- ������ �� Box&lt;String>�� Box&lt;Integer>�� ����Ÿ���� Box�� �ٲ��.(���׸� Ÿ���� ����)

##### ���׸����� ����

- static ����� Ÿ�Ժ��� T�� ����� �� ����.(��� ��ü�� �����ϰ� �����ؾ��ϱ� ����) T�� �ν��Ͻ������� ���ֵȴ�.
    - ���� �Ű�����ȭ �Ǳ� ������ T�� �������� �ʴ´�. static T�� ������ ��� �Ű�����ȭ ��ų ������ static Ÿ����  T�� �Ϲ����̶�� ���� �� �����ؼ��� �ȵȴ�.(������̴�)----> �ϳ��� Ŭ���������� ���ÿ� �����ϴ� �������� ���� ������� ���̹Ƿ�
- ���׸� Ÿ���� ���������� ���𰡴�������, �迭�� ������ �� ����.
    - new �����ڰ� ������ ������ Ÿ�� T�� �������� ��Ȯ�� �˾ƾ��Ѵ�.
- �迭�� �����ؾ��� �ʿ䰡 ���� ���
    - new������ ��� Reflection API�� newInstance()���� �������� ��ü�� �����ϴ� �޼���� �迭�� ����ų�.
    - Object �迭�� �����ؼ� ������ �Ŀ� T[]�� ����ȯ �ؼ� ����Ѵ�.


#### 1.3 ���׸� Ŭ������ ��ü ������ ���

- ���������� �����ڿ� ���Ե� Ÿ�Ծ˱Ը�Ʈ�� ��ġ���� ������ ������ �߻��Ѵ�.

```java
Box<Apple> appleBox = new Box<Grape>(); //Error
```

- �Ϲ���(Generic Type)�� ����� ����Ѵ�.

```java
Box<Apple> appleBox = new FruitBox<Apple>();
```

- JDK 1.7������ ������ ������ ��� Ÿ���� ������ �����ϰ� �Ǿ���. ���������� Ÿ�Ժ����� ����ߴٸ� �����ڿ����� Ÿ�Ժ����� �����ص� ����.

#### 1.4 ���ѵ� ���׸� Ŭ����

- Ÿ�Ժ����� �����ϴ� Ư�� ������ ������ �� �ִ�.
- �������̽��� �̿��� ���� extends�� ����Ѵ�.(implements�� ��� X)
- 2 �� �̻��� ����� ���� ���� &�� ����Ѵ�.(�Ʒ� ������ ��� Fruit�� Eatable�� ���ÿ� �����ؾ��Ѵ�.)

```java
class FruitBox<T extends Fruit & Eatable> {
 ArrayList<T> list = new ArrayList<T>();
}
```

#### 1.5 ���ϵ� ī��

- �޼��� �Ű������� ���ʸ� Ÿ�Կ� ���δ�. �޼����� �Ű������� ���׸� Ÿ���� �� �� Ÿ�Ժ����� �ٸ��� �ؼ��� �����ε��� ���� �ʰ� �ߺ��� �޼��尡 �ǹ�����.

```java
static Juice makeJuice(FruitBox<Fruit> box) { ... }

...

  FruitBox<Apple> appleBox = new FuirtBox<>();
  makeJuice(appleBox); // error
```
```java
//��� �������� Ȯ���� �� ������ FruitBox�� Ÿ�Ժ����� �׻� Fruit�� ��ӹ޾ƾ��ϹǷ�
//<?>�ε� FruitBox���� ���̴� Ÿ�Ժ����� Fruit�� ����� ����� �� �ִٴ� ���� �����޴´�.
static Juice makeJuice(FruitBox<? extends Fruit> box) { ... }
```

- &lt;? extends T> ���ϵ� ī���� ���� ����, T�� �ڼո� ����
- &lt;? super T> ���ϵ�ī���� ��������, T�� ���� ����
- &lt;?> ���Ѿ���. &lt;? extends Object>�� ��
- ���ϵ� ī��� &�����ڸ� ����� �� ����.
- ���߿� ���� ���ų� �ϴ� ���� ����ؼ� ���ϵ�ī�带 �� �� ����. 
	- Object������ ������ �� ��ü ���� Ŭ���� ����� ����� �� ������, ���׸� Ŭ���� ��ü���� ���ʿ� ������ �ɷ��ִٸ� �� Ŭ���� ����� ����� �� �ִ�.


#### 1.6 ���׸� �޼���

- Generic methods are methods that introduce their own type parameters. This is similar to declaring a generic type, but the type parameter's scope is limited to the method where it is declared. Static and non-static generic methods are allowed, as well as generic class constructors.
- ���׸� �޼���� ������ Ÿ�� �Ķ���͸� ������ �޼�����̴�. �� Ÿ�� �Ķ������ �������� ���ǵ� �޼��� ������ �����ȴ�.(Ŭ�������� ������ �Ͱ� �̸��� ���Ƶ� �����Ǵ� �ٸ� ���̴�)
- static �Լ��� Ŭ�������� ������ Ÿ�� �Ķ���͸� �� ���� ������, ��ü������ Ÿ���Ķ���͸� �����ؼ� ����� ���� �ִ�. 

```java
static <T> void sort(List<T> list, Comparator<? super T> c){}
```

```java
//���ϵ� ī��
static Juice makeJuice(FruitBox<? extends Fruit> box) {
 ...
}
//���׸� �޼���
static <T extends Fruit> Juice makeJuice(FruitBox<T> box) {
 ...
}
```

```java
//���׸� �޼����� ȣ��
   Juice juice = Juicer.<Fruit>makeJuice(fruitBox);
   Juice juice = Juicer.<Apple>makeJuice(appleBox);
```

- ���׸� �޼���� ���������� Ŭ���� �̸��� ������ �� ����.
- �����Ϸ��� ������ �����ϴٸ� Ÿ���Ķ���͸� ������ �� �ִ�.
- �Ʒ��� ���� �ڵ��� ���� ���� �� �ִ�.

```java
public static void printAll(ArrayList<? extends Product> l1, ArrayList<? extends Product> l2) { ...}

public static <T extends Product> void printAll(ArrayList<T> l1, ArrayList<T> l2) {
...
}
```

#### 1.7 ���׸� Ÿ���� ����ȯ

- ���׸�Ÿ�԰� �����׸� Ÿ�԰� ����ȯ�� �����ϴ�. ==> ��� �߻�
- ���Ű�����(type parameter)�� �ٸ� ���׸� Ÿ�Գ����� ����ȯ�� �ȵȴ�.

```java
Box b1 = new Box();
Box<T> b2 = new Box<>();

b1 = (Box)b2;
b2 = (Box<T>)b1;
```

#### 1.8 ���׸� Ÿ�� ���

- ���׸� Ÿ���� ������� �ٷ��. �� �̻��� ������ ���� �Ӹ��� ������ �ʴ� �����ӿ� ���� �� �ɷ��� �ٸ� �͵��� ������ �� ������ ���� �ɷ����� ���ϰ� �������ٰ� �������� �����̴�.

#### �������� ���׸� Ÿ�� ����

- ���׸� Ÿ���� �ᱹ ���뼺 �ִ� ���۷��� Ÿ�Կ� ���� ���ΰ� ����.


### 2. ������(enums)

#### 2.1 �������̶�?

- JDK 1.5���� �߰�
- typesafe enum�̴�.
    - C�� �ٸ��� Ÿ�Ա��� �Բ� ����(���� ���� �پ��)
    - C���� ��� Ÿ���� �޶� ���� ������ ������� ������ ó���ƴ�.
    
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
Card1.CLOVER == Card2.TWO; // true, �ǹ̻� false
Card2.Kind.CLOVER == Card.Value.Two; // false, ���� ����
```
- ���� ��� ����� ���� �ٲ� ��� ��� �ҽ��� �ٽ� �������ؾ��Ѵ�.(����� ������ �� �� �״�� �ھƹ����� �� �ϴ�)
- ����� ������ ���� ��� ���� ������δ� ���� ������ ���� ����ų� �߰��ϰų� �� �� �������� �� �ִ�. ==> �������� �׷� �� ������ ���̴�.

#### 2.2 �������� ���ǿ� ���

```
enum �������̸� { �����1, �����2, ... }
```

- equals()���� ==�� ���� �����ϴ�.(���ڰ� �����ٰ��Ѵ�.)
- �񱳿����ڴ� ����� �Ұ����ϴ�.
- compareTo()�� ��밡���ϴ�.
    - ������ �� 0 ������ ũ�� ���, �������� ũ�� ������ ��ȯ�Ѵ�.
- switch ~ case ���� ��� �����ϴ�.
    - case������ �������� �̸��� ���� �ʰ� ����� �̸��� ���´�.
    - ��Ȯ�� ������ ���ڵ� ��?��?�ΰ� �� ==> ���� ���� ���δٴ� ������ �ִ�.
    
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

##### ��� �������� ���� - java.lang.Enum

- ������ ��� ��� ����
- [Enum API](https://docs.oracle.com/javase/7/docs/api/java/lang/Enum.html)

```java

Direction dArr = Direction.values();

for(Direction d : dArr){ 
  System.out.printf("%s = %d%n", d.name(), d.ordinal());
}
```

- Enum Ŭ������ �޼����
    - Class<E> getDeclaringClass : �������� class ��ü ��ȯ.
    - String name() : ������ ����� �̸��� ���ڿ��� ��ȯ
    - int ordinal() : ������ ����� ���ǵ� ���� ��ȯ(0����)
    - T valueOf(class<T> enumTypoe, Stirng name) : ������ ���������� name�� ��ġ�ϴ� ������ ��� ��ȯ.


#### 2.3 �������� ��� �߰��ϱ�

- ordinal()�� ������ ����� ���ǵ� ������ ��ȯ�Ѵ�. ������ �� ���� ���������� �뵵�� ���� �� �Ǵٰ� ���ڴ� �Ұ��Ѵ�.
- ������ ����� ���� (��)�� ���·� ���������� �ҿ��������� ������ �� �ִ�.
    - ������ ����� ���� �����Ѵ�.
    - ������ ���� ������ �� �ִ� �ν��Ͻ� ������ �����ڸ� ���� �߰����־���Ѵ�.
- �������� �ν��Ͻ� ������ �ݵ�� final�� �ƴϴ�.
    - ������ ����� ���� �����ؾ� �Ѵٸ� final�� �ٴ´�.
- �������� �����ڴ� �ܺο��� ȣ���� �Ұ����ϴ�.(���������� private�̴�.)
- �������� ����� ���� ���� ������ �� ������ �׿� �°� �ν��Ͻ� ����, ������ ���� ���� �߰��ؾ��Ѵ�.


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


##### �������� �߻� �޼��� �߰��ϱ�.

- �������� �� ���?���� �ٸ��� �����ϴ� �޼��带 �߻�޼���� ������ �� �ִ�.
- �� ����� �����Ҷ����� ���� �������ָ� �ȴ�.


#### 2.4 �������� ����

- �������� ����ϳ��� ��� �� �������� ��ü�̴�.

``` java
enum Direction { EAST, WEST, , SOUTH, NORTH } // Direction�� ��ü EAST, WEST, SOUTH, NORTH

class Direction {
	static final Direction EAST =  new Direction("EAST");
	static final Direction SOUTH = new Direction("SOUTH");
	static final Direction WEST =  new Direction("WEST");
	static final Direction NORTH = new Direction("NORTH");
	
	private String name;
	private Direction(String name) { this.name = name; }
	
}
```

- Direction Ŭ������ static ��� EAST, SOUTH, WEST, NORTH�� ���� ��ü�� �ּ��̰�, �� ���� �ٲ��� �ʾ� ==�� �񱳰� �����ϴ�.
- ��� �������� �߻� Ŭ���� Enum�� �ڼ��̴�.



#### �������� ������ ����

- �̸��� ������ �ٸ� �������� ���� �������� ����� ���� �ʴ´�.(����)
- �ٸ� �ڹ� ���Ͽ� ���ǵ� �������� ã�Ƴ���. �̰��� �ű��ϳ�
    - �Ƹ� Ŭ�����н����� ������ ���� ã�� ���?
    - enum ���� Ŭ�����ε� ��ó���� ��Ű�� ������ ������ ������ ���� ���� ���� �ְڴٴ� ������ ���. �ƴ� ���� ������.

```java
enum Animal { dog } 
class MyAnimal { enum Animal { dog } }
class Drive {
	public static void main(String [] args ) {
		System.out.println( Animal.dog == MyAnimal.Animal.dog ); // Error 
	
	}
}
```

- �������� ���� ������ ���� �����ڸ� �ִٸ� ������ �����ϴ�.
- �ٸ� �� ���� ������ Ȱ���ϱ� ���ؼ��� ������ ����� ���ǰ� �ʿ��ϴ�.

- �������� ����
    - ��а� �������� ������ ����� ���� Ÿ���̶�� �����ϰ� ���� ���� ������ �ʹ�.
    - ������Ƽ�� Ÿ����  boolean�� false�� true�� �������� ���� ��ó��, ���� �������� �����ؼ� ���� ����� ���� Ÿ��
    - ���ڰ� ������ ������ final�� ������ �� �Ƹ� ��Ģ���� �� ������ �� ����. ������ ������ �����Ǹ� immutable�ϱ⸦ �ٶ󼭰� �ƴұ� �ʹ�.
    
### 3. �ֳ����̼�Annotation

#### 3.1. �ֳ����̼��̶�

- �ּ�, ����, �޸�
- �ʱ�: �ڹ� ������ �ҽ� ���ϰ� �Բ� ���� �ּ����� HTML�� ���� �����(javadoc.exe�� �̿���)
- �ҽ��ڵ� �ȿ� �ٸ� ���α׷��� ���� ������ �̸� ��ӵ� �������� ���Խ�Ų ��.
- ����� �� �ִ� �ֳ����̼��� �ٸ� ���α׷����� ������ �͵� �ִ�.

#### 3.X Predefined Annotation Types

- 3.2. ǥ�� �ֳ����̼ǰ� ����Ŭ�� [Predifined Annotation Types](https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html)�� ��� �����ϰڴ�.
- java SE api �ȿ� �����ǵ� �ֳ����̼� Ÿ���� ����
- �Ϻδ� �ڹ� �����Ϸ��� ����, �Ϻδ� �ٸ� �ֳ����̼ǿ� ���� ���ȴ�. 

##### 3.X.1 Annotation Types used by the Java Language

- @Deprecated, @Override, @SuppressWarnings, @SupressWarnings�� java.lang�� �����ǵǾ��ִ�. �� �ܿ���  @FunctionalInterface ������̼��� �ִ�.


- @Deprecated
    - �� �̻� ���� �ʰ� �˸�.
    - �����Ϸ������� �̰��� ���� Ŭ������ �޼���, �ʵ带 ���� �Ǹ� ��� �߻���Ų��.
    - deprecated �Ǹ� javadoc������ @deprecated �±׸� Ȯ���� �� �ִ�.(�ּ�������, �ڵ�󿡼���), �ּ��� ������ ���� �����.
- @Override
    - �����Ϸ����� �ش� ��Ұ� superclass�� ���ǵ� ��Ҹ� �������̵� �Ѵٴ� ���� �˷���
    - �� ����� �ʿ�� ������, ���� ������ �����ϴ� ����
    - ����Ŭ������ ���� ��Ȯ�� �������̵����� ������ �����Ϸ��� ������ �����Ѵ�.
- @SuppressWarnings
    - �����Ϸ����� Ư�� ��� �ﴩ���� �Ѵ�.
    - Every compiler warning belongs to a category. The Java Language Specification lists two categories: deprecation and unchecked.
    - *unchekced�� ���ʸ� ���� ���� ���Ž� �ڵ忡�� �߻��ϱ� ����.
    - To suppress multiple categories of warnings, use the following syntax:
        - @SuppressWarnings({"unchecked", "depreacation"})
- @SafeVarargs
    - *varargs : ��������, '�޼��� �̸�(�� ... �̸�)'�� ���·� ���δ�.
    - �޼��峪 �����ڿ� ���� varargs �Ķ���� �� ���������� �������� ���� ������ �������� �ʴ´ٰ� �����ϴ� ���� �ȴ�.
    - varagres ���� unchecked ��� �����ش�.
    - unchecked ���� �ﴭ�������� varargs ���� �ﴩ���� ���ϴ� �׷� ��쿡�� @SuppressWarnings(varargs)�� ���δ�.
        - �ش���� -Xlint �ɼǰ� �Բ� ���� ������ ��� ������ �ʴ´ٰ� �Ѵ�. 
- @FunctionalInterface
    - @FunctionalInterface annotation, introduced in Java SE 8, indicates that the type declaration is intended to be a functional interface, as defined by the Java Language Specification.

##### 3.X.2 Annotations That Apply to Other Annotations

- �ٸ� ������̼ǿ� ����Ǵ� ������̼ǵ��� meta-annotaions��� �Ҹ���.
- ���� ��Ÿ ������̼� ������ java.lang.annotation�� ���ǵǾ��ִ�.


- @Retention
    - ��ũ�� ������̼��� �󸶳� �����Ǵ� ���� ����մϴ�
        - RetentionPolicy.SOURCE: The marked annotation is retained(����, ����) only in the source level and is ignored by the compiler.
      - RetentionPolicy.CLASS: The marked annotation is retained by the compiler at compile time, but is ignored by the Java Virtual Machine (JVM).
      - RetentionPolicy.RUNTIME: The marked annotation is retained by the JVM so it can be used by the runtime environment.
        
- @Documented
    - javadoc ���� ����� ����ȭ�ؾ��ϴ� ��ҿ� ���ȴ�.
    - �⺻������ �ֳ����̼ǵ��� �ڹٵ��� ���Ե��� �ʴ´�.
- @Target
    - �ٸ� ������̼ǿ� ��� ������ �ڹ� ���(elements)�� �ش� ������̼ǿ� ���� ����� �� �ִ� ���� ������Ų��.
    - Ÿ�� ������̼��� �Ʒ� ��� ��(element type)�� ������ ���ϵ��� ��õǾ��ִ�.
        - ElementType.ANNOTATION_TYPE can be applied to an annotation type.
        - ElementType.CONSTRUCTOR can be applied to a constructor.
        - ElementType.FIELD can be applied to a field or property.
        - ElementType.LOCAL_VARIABLE can be applied to a local variable.
        - ElementType.METHOD can be applied to a method-level annotation.
        - ElementType.PACKAGE can be applied to a package declaration.
        - ElementType.PARAMETER can be applied to the parameters of a method.
        - ElementType.TYPE can be applied to any element of a class.      
- @Inherited
    - �ֳ����̼� Ÿ�Կ� ���� Ŭ�����κ��� ��� �� �� �ְ� �����մϴ�.
    - Ŭ���� ������ ����˴ϴ�.
- @Repeatable
    - �ڹ� se8���� �Ұ���.
    - �� �� �̻� ���밡�ɵ� �� �ְ� ��.

- @Native
    - ����Ƽ�� �޼��忡 ���� �����Ǵ� ����ʵ忡 ���̴� �ֳ����̼�
        - *����Ƽ�� �޼���
            - jvm�� ��ġ�� os�� �޼���
            - ���� c���� �ۼ�
            - ���� ����θ� �����ϰ� ������ ���� �ʴ´�.

#### 3.4 �ֳ����̼� Ÿ�� �����ϱ�


@�� ���̰�, Interface�� �����Ѵ�.

```java
@interface �ֳ����̼��̸� {
    Ÿ�� ����̸�();
    ...
}
```

- *@Override <= �ֳ����̼�
- *Override <= �ֳ����̼� Ÿ��

##### �ֳ����̼��� ���

- �ֳ����̼� ���� ����� �޼���
    - ��ȯ���� �ְ�, �Ű������� ���� �߻� �޼����� ����
    - ������� ���� ���� �ʾƵ� �ȴ�. => ��� �ֳ����̼� ������ �� ��ҵ��� �̸��� ���� �����ؾ���.(������ ��� ����)
- �ֳ����̼ǿ��� ����� ������ �� ������ ����Ʈ �޼���� ������ �� ����.
- �ֳ����̼��� ��ҿ� �⺻�� ���� �����ϴ�. �� ��� ���� �������� ������ �⺻���� ����Ѵ�. �⺻���� null�� ������ ��� ���ͷ�literal(�ҽ� �ڵ� ���� ������ ��) ����
- �ֳ����̼��� ��Ұ� �ϳ��̰� �̸��� value�� ��� �ֳ����̼� ����� �̸��� �����ϰ� ���� �־ �ȴ�.
- ��� ���� �迭�� ��� {} �ȿ� ���� ���� ������ �� �յ�.
 

```java
//���� ��
//TestInfo�� 5���� ��Ҹ� ������ �ִ�.
@Interface TestInfo{
    int count();
    String testedBy();
    String[] testTools();
    TestType testType(); // enum TestType { FIRST, FINAL }
    DateTime testDate(); // �ڽ��� �ƴ� �ٸ� �ֳ����̼�(@DateTime)�� ������ �� �ֵ�.
}
@Interface DateTiem {
	String yymmdd();
	String hhmmss();
}
```

```java
//��� ��
@TestInfo(
	count = 3, testedBy="Kim",
	testTools={"JUnit", "AutoTester"),
	testType=TestType.FIRST,
	testDate=@DateTime(yymmdd="160101", hhmmss="235959")
)
public class NewClass { ... }
```

```java
//�⺻���� ��, ��ȣ�� ��
@interface TestInfo {
	int count() default 1;
	String[] info() default { "example", "of", "defaultValue" }
}
```

```java
//SuppressWarnings, ��Ұ� value �ϳ��� ���,
@interface SuppressWarnings{
	String[] value();
}

//�̿� ��
@SuppressWarnings( {"deprecation", "unchecked" } )
class NewClass { ... }
```

##### java.lang.annotation.Annotation

- ��� �ֳ����̼��� ������ Annotation �������̽�
- �ֳ����̼��� ����������� �ʴ´�.(�ֳ����̼� ���ǹ����� ���ϴ� ��)

```java
@interface TestInfo extends Annotation { // error
...
}

```

- Annotation �������̽��� ���ǵ� �޼������ ��� �ֳ����̼� ��ü���� ȣ�� �����ϴ�.

##### Marker Annotation

- ���� ������ �ʿ䰡 ���� ���, ��Ұ� ���ǵ��� ���� �ֳ����̼�

##### �ֳ����̼� ��� ��Ģ

- ��� Ÿ�� : �⺻��, String, enum, enum, �ֳ����̼�, Class�� ���
- ()�ȿ� �Ű����� ���� �Ұ�.
- ���� ���� �Ұ�
- ��Ҹ� Ÿ�� �Ű������� ������ �� ����.


#### �������� ����

- ������̼� Ÿ�Ե� ������ import �����ߴ�. ó���˾Ҵ�.
- �������� ������������.


## Chap 14 ���ٿ� ��Ʈ��

One issue with anonymous classes is that if the implementation of your anonymous class is very simple, such as an interface that contains only one method, then the syntax of anonymous classes may seem unwieldy and unclear. In these cases, you're usually trying to pass functionality as an argument to another method, such as what action should be taken when someone clicks a button. Lambda expressions enable you to do this, to treat functionality as method argument, or code as data.

The previous section, Anonymous Classes, shows you how to implement a base class without giving it a name. Although this is often more concise than a named class, for classes with only one method, even an anonymous class seems a bit excessive and cumbersome. Lambda expressions let you express instances of single-method classes more compactly.

### 1. ���ٽ�

- JDK1.8�� �߰�
- �Լ��� ����� Ư¡�� ���ϰ� ��.


#### 1.1 ���ٽ��̶�?Lambda expression

- �޼��带 �ϳ��� ��(expression)���� ��Ÿ�� ��.
- ���ٽ��� �͸��Լ���� �θ��⵵�Ѵ�. <= �޼����� �̸��� ��ȯ���� �������

```java
int[] arr = new int[5];
Arrays.setAll(arr, () -> (int)(Math.random()*5)+1);
```

#### 1.2 ���ٽ� �ۼ��ϱ�

- �̸��� ��ȯŸ���� �����ϰ� ����ο� ���� ���̿� -> �� �߰���
- ��ȯ ���� �ִ� ��� ��(expression)���� return�� ����� �� �ִ�.(�����ݷ��� ������ �ʴ´�.)
- �߷��� ������ ��쿡�� ������ �� �ִ�.
    - �Ű������� Ÿ��
    - ��ȯ�� ���� �߷��� �����ϱ� ������ �����ȴ�. 

```java
int max(int a, int b) {
	return a > b ? a : b;
}

...

(int a, int b) -> a > b ? a : b

```

- �Ű������� �ϳ��� ��� ��ȣ ���� �����ϴ�.

```java
//�⺻��
(int a, int b) -> {
   a += 5;
	return a + b;
}

//�Ķ���Ͱ� ���� ������ ���
(a, b) -> {
	a+=5;
	return a+b;
}

//�Ķ���Ͱ� �ϳ��� ���
a -> {
	a+=5;
	return a;
}

//��ȯ���� �� ���(�ٷ� �����Ѵ�.)
a -> a+5

// ������ ������ �ϳ��� ���
void 
(a, b) -> a+b
```

#### 1.3 �Լ��� �������̽�

- ���ٽ��� �ٷ�� ���� �������̽�
    - �߻� �޼���� �ϳ��� �־�� �Ѵ�.
    - static, default �޼��忡�� ���������� ����. 
- ���ٽ��� �͸�ü�� �����ϴ�.
- @FunctionalInterface �ֳ����̼��� �̿��� ������ üũ�� �� �ִ�.


##### �ܺ� ������ �����ϴ� ���ٽ�

- ���ٽ��� �ܺ��� ���� ���� ���� �̿��� ���� �� ������ final�̰ų� �׿� ���� �ʿ䰡 �ִ�.(��ȭ�Ѵٸ� �ȵȴ�, �����Ϸ��� ����� �ھƳ��� ������ �� �ϴ�.)
    - ���ٽ� ���ε�, �ܺε� ��ȭ�ϴ� ������ ����Ϸ��Ѵٸ� ������ �߻�
    - static�� ���� �ش� ����. �߰��� �ٲ㵵 �����ߴ�.
- �ܺ����������� ���� �̸��� ���ٽ� �Ű������� ������ �ʴ´�.

#### 1.4 java.util.function ��Ű��

- �Ϲ������� ���� ���̴� �Լ��� �������̽����� ����
- ���ο� �Լ��� �������̽��� ������ �� ���� ���⿡ �ִ� ���� ������ �ᵵ �Ǹ� ���� �ȴ�.
    - ���뼺, �������� � ����
- 

##### Predicate

- Function�� ����
- boolean�� ��ȯ�Ѵ�. 

#### �������� ����

- ���ٽ��� �ϳ��� �� �޼���(�߻� �޼���)�� �ڵ����� ä���ִ� �Ͱ� �׿� ���� �͸�ü�� ������ ����ȭ �����ִ� ��(expression)�̴�. �� ����� �͸�ü�μ� ��ȯ�ȴ�.
- ���ٽ��� Ÿ���� �ݵ�� �Լ��� �������̽����� �Ѵ�.
- �Լ��� �������̽� �ֳ����̼��� ������ �ܰ迡�� �Լ��� �������̽� ������ �����ϴ� �� �˷��ֱ� ���� ���ε� �ʹ�. ���̵� �Ⱥ��̵� ���ٽ��� �ٿ� ���� �� ����� ���̵� �߰����� ���Ͽ���.