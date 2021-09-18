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
