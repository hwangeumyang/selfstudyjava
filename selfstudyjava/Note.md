#혼자 공부하는 자바


## 14. 스트림

- 스트림 => 입력 / 출력
- 각각의 스트림 => 바이트기반 / 문자기반

### 14-1 입출력스트림

#### 바이트 출력 스트림: OutputStream

![OutputStream methods](./img/OutputStream_methods.png)
- write(int)는 int형이지만 1byte만 짤라서 출력한다.
	- byte를 짤라 int자리에 넣어도 무방
- 출력 스트림은 바로 출력하지 않고, 내부 버퍼에 우선 저장해놓는다.
- flush()는 출력버퍼에 잔류하는 모든 바이트를 출력한다.

#### 바이트 입력 스트림: InputStream

- 모든 바이트 기반 입력 스트림의 부모

![InputStream methods](./img/InputStream_methods.png)

- 입력스트림에서 1byte읽고 int(4byte)로 리턴 -> 4바이트 중 1byte에만 데이터가 들어있다.
- read()는 1바이트씩 읽는다. return형이 int라고 착각하지 말자.
- read(byte []b): 주어진 배열길이*바이트만큼 읽고 배열에 저장. 적으면 거기까지 읽는다. 읽은만큼 리턴 읽은 게 없다면 -1 리턴


#### 문자 출력 스트림 : Writer

![](./img/WriterMethods.png)
- 문자기반 출력 스트림은 Writer에서 상속받아 만든다.
- write는 int형에서 2바이트를 짤라서 사용한다.

#### 문자 입력 스트림 : Reader

![](./img/ReaderMethods.png)
- read()를 char형에 형변환시켜서 넣었다가는 -1이 65535가 되어서 -1로는 멈출 수 없게 된다.

### 14-2 보조 스트림

- 다른 스트림에 연결해서 쓰는 스트림
- 자체적으로는 입출력 수행 X => reader, writer, input/outputstream 과 함께씀
- 프로그램은 실제 입/출력스트림은 신경쓰지 않고, 보조스트림을 다루는 느낌으로 사용한다.

#### 보조 스트림 연결하기

- 보조스트림 변수 = new 보조스트림(연결스트림)
- 입출력스트림과 연결된 보조스트림은 합쳐서 새로운 입출력스트림이 된다.
- 보조스트림에 또다른 보조스트림을 이을 수 있다는 말

```java
InputSTream is = System.in;
InputStreamReader reader = new InputStreamReader(is)
BufferedReader br = new BufferedReader(reader);
```

#### 문자 변환 스트림

- 바이트 기반 스트림은 문자를 다루기 불편한 점이 있기에 Reader와 Writer에 연결해 쓰기도 한다.

```java
FileOutputStream fos = new FileOutputStream("C:/temp/test1.txt");
Writer writer = new OutputStreamWriter(fos);
```
```java
FileInputStream fis = new FileInputStream("c:/temp/test1.txt");
Reader reader = new InputStreamReader(fis);
```

#### 성능향상 보조 스트림

- 프로그램의 실행은 연관장치 중 제일 느린 것에 직결된다.(critical path)
- 입출력이 대개 느리기 때문에 버퍼(메모리)를 써 입출력의 횟수를 줄인다.
- 기본적으로 버퍼에 쌓아놓다가 다 차면 출력한다.
- 출력스트림은 기본적으로 작은 버퍼를 가지고 있다. 하지만 더 큰 버퍼를 제공하는 친구들도 있다.
- BufferedInputStream, BufferedOutputStream
- BufferedReader, BufferedWriter
```java
BufferedOutputStream bos = new BufferedOutputStream(ByteBasedOutputStream);
BufferedWriter bw = new BUfferedWriter(CharacterBasedOutputStream);
BufferedInputStream bis = new BufferedInputStream(ByteBasedInputStream);
BufferedReader br = new BufferedReader(CharacterBasedInputStream);
```

- 연결된 스트림 중 제일 끝에 있는 것만 사용할 수 있는 것은 아니다.
- 연결된 스트림 중 하나가 닫히면 나머지도 못쓰게 된다. IOExcpetion:Stream Closed <br/> os1 - os2 - os3 이런식으로 연결했을 경우, os3을 닫으면 나머지를 연쇄적으로 닫고 os1을 닫으면 os3 - os2를 타다 os1이 닫혀서 못쓰고 이런 식이 아닐까 싶다. 확인하진 못했음.
- 버퍼 스트림들의 경우 출력이 더 큰 폭으로 유의미했으나 입력 역시 충분히 유의미한 수치의 성능향상을 가져왔다. 모조리 메모리에 저장했다 출력하는 출력과 달리 입력은 결국 하드디스크와의 입출력에서 유의미한 횟수차이를 벌리지 못해 큰 성능향상을 못내지 않을까 생각했으나 그렇지 않았다.

> - only non buffer used: 449488900
 - only buffer used: 2880000
 - non buffer input, buffer output: 150116900
 - buffered input, non buffered output: 279717100

#### 기본타입 입출력 보조 스트림

- DataInputStream, DataOutputStream
- primitive 타입을 입출력할 수 있다.
- 입/출력할 때는 같은 형식으로 맞춰야한다.

```java
DataInputSTream dis = new DataInputStream(bytebasedInputStream)
DataOutputStream dos = new DataOutputSTtream(bytebasedOutputStream)
```
