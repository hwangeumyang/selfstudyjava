#혼자 공부하는 자바


## 14. 스트림

- 스트림 => 입력 / 출력
- 각각의 스트림 => 바이트기반 / 문자기반

### 출력스트림

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
