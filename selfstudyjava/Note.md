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

