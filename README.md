# UrlShortener_Library

### 단축 URL구현을 편리하게 해주는 라이브러리 입니다.

## Install

### Maven

pom.xml에 해당 디펜던시 추가

```java

<dependency>
    <groupId>io.github.jay-choe</groupId>
    <artifactId>UrlShortenerLibrary</artifactId>
    <version>1.0</version>
</dependency>

```

### Gradle

build.gradle에 해당 디펜던시 추가

```java

implementation group: 'io.github.jay-choe', name: 'UrlShortenerLibrary', version: '1.0'

```

## 사용방법


### 주요 함수들

#### 객체 생성

```java

UrlShortener shortener = new UrlShortener("your domain");

```

      해당 단축 Url을 사용하실 도메인을 입력해주시면 단축 Url을 찾을 때

      도메인 + /단축내용 으로 값을 리턴합니다.

      입력해주지 않을 경우, /단축내용 으로 값을 리턴합니다.
  
  
#### 단축 Url 생성

```java

String shortUrl = shortener.getShortUrl("your unique key");

```

    unique key의 타입은 long이며 
    
    해당 키를 Base62로 인코딩한 값을
    
    domain + /value 형식으로 리턴을 합니다.

    어떤 값이던지, 해당 key가 유일하다면 동일한 값을 보장합니다.

    데이터베이스의 id값을 사용하는 것을 권장합니다.

#### Unique key 다시 얻기

```java

long uniqueKey = shortener.getUniqueKey(shortUrl)

```
    shorturl 파라미터는 domain을 제외한 / + value 에 나오는 value 값 입니다.

    생성시 주었던 unique key를 리턴합니다.

    내부에서 정규표현식으로 단축된 Url의 값이
    
    Base62 값("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789")에 해당하지 않을경우
    
    IllegalArgumentException을 쓰로우합니다.


### Tutorial
