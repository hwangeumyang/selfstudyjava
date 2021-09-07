#ȥ�� �����ϴ� �ڹ�


## 14. ��Ʈ��

- ��Ʈ�� => �Է� / ���
- ������ ��Ʈ�� => ����Ʈ��� / ���ڱ��

### 14-1 ����½�Ʈ��

#### ����Ʈ ��� ��Ʈ��: OutputStream

![OutputStream methods](./img/OutputStream_methods.png)
- write(int)�� int�������� 1byte�� ©�� ����Ѵ�.
	- byte�� ©�� int�ڸ��� �־ ����
- ��� ��Ʈ���� �ٷ� ������� �ʰ�, ���� ���ۿ� �켱 �����س��´�.
- flush()�� ��¹��ۿ� �ܷ��ϴ� ��� ����Ʈ�� ����Ѵ�.

#### ����Ʈ �Է� ��Ʈ��: InputStream

- ��� ����Ʈ ��� �Է� ��Ʈ���� �θ�

![InputStream methods](./img/InputStream_methods.png)

- �Է½�Ʈ������ 1byte�а� int(4byte)�� ���� -> 4����Ʈ �� 1byte���� �����Ͱ� ����ִ�.
- read()�� 1����Ʈ�� �д´�. return���� int��� �������� ����.
- read(byte []b): �־��� �迭����*����Ʈ��ŭ �а� �迭�� ����. ������ �ű���� �д´�. ������ŭ ���� ���� �� ���ٸ� -1 ����


#### ���� ��� ��Ʈ�� : Writer

![](./img/WriterMethods.png)
- ���ڱ�� ��� ��Ʈ���� Writer���� ��ӹ޾� �����.
- write�� int������ 2����Ʈ�� ©�� ����Ѵ�.

#### ���� �Է� ��Ʈ�� : Reader

![](./img/ReaderMethods.png)
- read()�� char���� ����ȯ���Ѽ� �־��ٰ��� -1�� 65535�� �Ǿ -1�δ� ���� �� ���� �ȴ�.

### 14-2 ���� ��Ʈ��

- �ٸ� ��Ʈ���� �����ؼ� ���� ��Ʈ��
- ��ü�����δ� ����� ���� X => reader, writer, input/outputstream �� �Բ���
- ���α׷��� ���� ��/��½�Ʈ���� �Ű澲�� �ʰ�, ������Ʈ���� �ٷ�� �������� ����Ѵ�.

#### ���� ��Ʈ�� �����ϱ�

- ������Ʈ�� ���� = new ������Ʈ��(���ὺƮ��)
- ����½�Ʈ���� ����� ������Ʈ���� ���ļ� ���ο� ����½�Ʈ���� �ȴ�.
- ������Ʈ���� �Ǵٸ� ������Ʈ���� ���� �� �ִٴ� ��

```java
InputSTream is = System.in;
InputStreamReader reader = new InputStreamReader(is)
BufferedReader br = new BufferedReader(reader);
```

#### ���� ��ȯ ��Ʈ��

- ����Ʈ ��� ��Ʈ���� ���ڸ� �ٷ�� ������ ���� �ֱ⿡ Reader�� Writer�� ������ ���⵵ �Ѵ�.

```java
FileOutputStream fos = new FileOutputStream("C:/temp/test1.txt");
Writer writer = new OutputStreamWriter(fos);
```
```java
FileInputStream fis = new FileInputStream("c:/temp/test1.txt");
Reader reader = new InputStreamReader(fis);
```

#### ������� ���� ��Ʈ��

- ���α׷��� ������ ������ġ �� ���� ���� �Ϳ� ����ȴ�.(critical path)
- ������� �밳 ������ ������ ����(�޸�)�� �� ������� Ƚ���� ���δ�.
- �⺻������ ���ۿ� �׾Ƴ��ٰ� �� ���� ����Ѵ�.
- ��½�Ʈ���� �⺻������ ���� ���۸� ������ �ִ�. ������ �� ū ���۸� �����ϴ� ģ���鵵 �ִ�.
- BufferedInputStream, BufferedOutputStream
- BufferedReader, BufferedWriter
- BufferedReader���� readLine()�� �ִ�. ����.

```java
BufferedOutputStream bos = new BufferedOutputStream(ByteBasedOutputStream);
BufferedWriter bw = new BUfferedWriter(CharacterBasedOutputStream);
BufferedInputStream bis = new BufferedInputStream(ByteBasedInputStream);
BufferedReader br = new BufferedReader(CharacterBasedInputStream);
```

- ����� ��Ʈ�� �� ���� ���� �ִ� �͸� ����� �� �ִ� ���� �ƴϴ�.
- ����� ��Ʈ�� �� �ϳ��� ������ �������� ������ �ȴ�. IOExcpetion:Stream Closed <br/> os1 - os2 - os3 �̷������� �������� ���, os3�� ������ �������� ���������� �ݰ� os1�� ������ os3 - os2�� Ÿ�� os1�� ������ ������ �̷� ���� �ƴұ� �ʹ�. Ȯ������ ������.
- ���� ��Ʈ������ ��� ����� �� ū ������ ���ǹ������� �Է� ���� ����� ���ǹ��� ��ġ�� ��������� �����Դ�. ������ �޸𸮿� �����ߴ� ����ϴ� ��°� �޸� �Է��� �ᱹ �ϵ��ũ���� ����¿��� ���ǹ��� Ƚ�����̸� ������ ���� ū ��������� ������ ������ ���������� �׷��� �ʾҴ�.

> - only non buffer used: 449488900
 - only buffer used: 2880000
 - non buffer input, buffer output: 150116900
 - buffered input, non buffered output: 279717100

#### �⺻Ÿ�� ����� ���� ��Ʈ��

- DataInputStream, DataOutputStream
- primitive Ÿ���� ������� �� �ִ�.
- ��/����� ���� ���� �������� ������Ѵ�.

```java
DataInputSTream dis = new DataInputStream(bytebasedInputStream)
DataOutputStream dos = new DataOutputSTtream(bytebasedOutputStream)
```

- ����� ���������� �۵��Ѵ�. ���� 2, 3�� ������ �κ��� ���� 32��Ʈ�� ������ ���� Ȯ���� �� �ִ�.(�ڹٴ� int���� �׻� 32��Ʈ�� �����Ѵ�.)

```java
		write("ȫ�浿", 95.5, 1);
		write("���ڹ�", 90.3, 2);
		os.writeInt(2);
		os.writeInt(3);
		os.flush();
		os.close();
```
![](./img/datastream.png)

- �ΰ��� ��Ʈ�� ����־� ���������� ���� �� �ִ�.��Ű�� Double-precision floating-point format���� 1�� �ش��ϴ� example�� �����ߴ�.

```java
		
		dos.writeInt(0b00111111111100000000000000000000); //������ 0�� ������ 20bit�̴�,���� 1�� ���� 10�� / 0�� ���� 2�� 32��Ʈ 
		dos.writeInt(0);  //0 32��Ʈ
		
		System.out.println(dis.readDouble());		
		-----
		> 1.0		

```

#### ������ ���� ��Ʈ��

- PrintStream, PrintWriter
- print(), println�� ������ �ִ� ���� ��Ʈ��
- System.out => PrintStream

```java
	PrintStream ps = new PrintStream(BytebasedStream);
	PrintWriter pw = new PrintWriter(CharacterBasedStream);
```

- ����Ʈ ��Ʈ���� ������ ���۵� ��Ʈ���� ���� ���� ���� ����� �̾��ϰ� �ִ� �� ���Ҵ�.
- printstream�� �����ʰ� BufferedOutputStream�� ���� ����� �� ������ ���ڿ��� �״�� �� �� ���� �������� �ִ�.(string->byte[]�� �ð��� �����ϸ� �� ���̰� ������.)

```java
	FileOutputStream fos = new FileOutputStream(fp);
	BufferedOutputStream bos = new BufferedOutputStream(fos);
	PrintStream ps = new PrintStream(bos);
```
```
����	f-b	f-b-p	f-p
1ȸ	792300	1373800	1566200
2ȸ	565400	1046600	985900
3ȸ	766400	877300	948400
4ȸ	676600	878700	1062700
5ȸ	576300	829800	829700
6ȸ	707600	739700	1335200
7ȸ	748800	793300	1397000
8ȸ	555800	1025300	950600
9ȸ	477200	849900	922000
10ȸ	438800	651000	831700
���	630520	906540	1082940
```
- ���� ǥ��  bufferedWriter�� ��� �̸� string�� byte�� �迭�� ��ȯ���� ����ߴ�. �׳� ���� ����Ʈ ��Ʈ���� ���ٰ� ���� ū �������ش� ���� ������ ���ȴ�.

#### ��ü ����� ���� ��Ʈ��

- ObjectInputStream, ObjectOutputStream
- ����Ʈ ��� ����� ��Ʈ���� �����ؼ� ���� �ȴ�.
- java.io.Serializable�������̽��� ������ ��ü�� ����ȭ�� �����ϴ�.
- �ش� ��ü �� �ƴ϶� �ش� ��ü�� �ʵ嵵 ��� ����ȭ�� �����ؾ��Ѵ�. (�ٸ� ��ü�� ������ ���� Ŭ���� ������ �ִ� ���� �� �������.)

