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

- ����ũŸ��(EPOCH TIME, 1970-01-01 00:00:00 UTC)���� ����� �ð��� �����ʴ����� ���
- ���������̶� ����� ����.
- UTC�����̶� �ѱ� �ð���(+09:00)�� ��ġ�� �ٸ� �� �ִ�.
- �ð��븦 ����ؾ��ϸ� OffsetDateTime�� �ִ�.
- java.util.Date Ŭ������ ��ü�ϱ� ���� ��, DateŬ�������� Instant�� ��ȯ�� �� �ִ� �޼��尡 �߰��Ǿ���.

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

-format ��ȣ�� [���⼭Ȯ��](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)

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
