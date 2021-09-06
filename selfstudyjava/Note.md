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
