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
