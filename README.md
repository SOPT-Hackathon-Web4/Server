# Server

## 서비스 이름
### 퀴즈를 통해 향하는 너와 나 사이의 거리 0km, To Zero

친해지고 싶지만 계기와 명분이 부족한 이들에게, 성향 퀴즈 문답을 통해 상대방을 알아가며 최종적으로 친해질 기회를 마련해주는 서비스 

## API 명세서
[API 명세서](https://just-a-little-braver.notion.site/c2134b4195c64fa28b6b1877e254d186?v=d1bdcc7a61d14222a327dfb55947eb37&pvs=25)

## 역할 분배
### 기훈
- 멤버 인스타 아이디 중복 체크 API : GET
- 마이페이지 디테일 정보 조회 API : GET
- 퀴즈 등록하기 API : POST

- 배포 및 CI/CD

### 민규
- 비밀번호 체크 API : GET
- 퀴즈 맞추기 API : GET
- 퀴즈 삭제 API : GET

- ERD 작성

## 코드 컨벤션
## 1. 네이밍 (Naming)

---

### 1-1. Package는 소문자로만 생성한다.

### 1-2. Class는 명사로 하고, 각 단어의 첫글자는 대문자로 생성한다. 약어는 사용하지 않는다.

### 1-3. Method는 동사로 하고, 소문자로 시작하며 처음을 제외한 각 단어의 첫글자는 대문자로 생성한다.

### 1-4. Variable은 Method와 동일한 문자 규칙을 적용하고, 사용 의도를 알 수 있도록 명확하게 짓는다.

### 1-5. 컬렉션(Collection) 데이터는 **복수형(s)**을 사용한다. → users (o), userList(x)

## 2. 줄바꿈 (Line-wrapping)

---

### 2-1. 메서드 파라미터로 들어가는 값이나 빌더 속성들은 가독성을 위해 모두 각각 줄바꿈을 한다.

잘못된 예시

```java
public ResponseEntity<ResponseDto<UserCreateResponse>> createUser(@RequestBody final UserCreateRequest userCreate) {
```

옳은 예시

```java
    public ResponseEntity<ResponseDto<UserCreateResponse>> createUser(
            @RequestBody final UserCreateRequest userCreate
    ) {
```

## 3. 세부 코딩 스타일 관련

---

### 3-1. 수정이 필요하지 않은 경우 안정성을 위해 꼭 final로 선언한다.

### 3-2. GET, POST,  DELETE, PUT 메서드 이름은 각각 get~ create~ delete~ update~로 통일한다.

### 3-3. API 주소는 Controller RequestMapping에 domain까지 포함해서 생성한다.

잘못된 예시

```java
@RequestMapping("/api")
public class UserController {

    @PostMapping("/user")
    public ResponseEntity<ResponseDto<UserCreateResponse>> createUser(
            @RequestBody final UserCreateRequest userCreate
    )
```

옳은 예시

```java
@RequestMapping("/api/user")
public class UserController {

    @PostMapping
    public ResponseEntity<ResponseDto<UserCreateResponse>> createUser(
            @RequestBody final UserCreateRequest userCreate
    )
```

## 4. 조건문과 중괄호 (Braces)

---

### 4-1. 조건/반복문에 한 줄이더라도 중괄호 필수로 사용하고 K&R 스타일을 따른다.

줄의 마지막에서 시작 중괄호`{`를 쓰고 열고 새줄을 삽입한다. 블럭을 마친후에는 새줄 삽입 후 중괄호를 닫는다.

닫는 중괄호와 같은 줄에 `else`, `catch`, `finally`, `while` 선언하도록 한다.

단, 내용이 없는 블럭을 선언할 때는 같은 줄에서 중괄호를 닫는 것을 허용한다.

## 5. 기타 추가사항

---

필요한 경우 주석을 통해 해당 객체나 메서드의 쓰임새에 대해 설명하도록 한다.

여기서 명시되어있지 않은 기타 사항(네이밍, 들여쓰기, 줄바꿈 등의 사항들은 세미나의 내용을 기반으로 따른다.

## 프로젝트 폴더링

![image](https://github.com/SOPT-Hackathon-Web4/Server/assets/40743105/43ec5b23-5d5c-46e4-90b6-ae9c5fd7bc99)

## ERD 
![image](https://github.com/SOPT-Hackathon-Web4/Server/assets/40743105/2b651135-a40e-4805-80aa-61f70f6ffbff)

## 상쾌한 서버들 (하트민규!~)
![image](https://github.com/SOPT-Hackathon-Web4/Server/assets/40743105/4b890d92-82e3-4bb8-b192-3d500fcc8a14)


