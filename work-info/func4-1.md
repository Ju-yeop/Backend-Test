# 포인트 조회 API

## API 정보

- Method: `GET`
- URI: `URI 는 해당 기능에 맞게 설계하시면 됩니다.`

## 요청(Request)

### 파라미터

| Parameter | Type   | Length | Required | Description                   |
|-----------|--------|--------|----------|-------------------------------|
| pointType | String | 6      | Y        | 포인트 type(`CODE_A` ~ `CODE_G`) |

## Response (응답값 예시는 `func4.json` 을 참고해주세요.)

### 공통 응답

| Parameter | Type   | Length | Required | Description      |
|-----------|--------|--------|----------|------------------|
| code      | INT    | 4      | Y        | 결과코드(0 성공, 0 이외 실패) |
| message   | String | 255    | Y        | 서버 메시지       |
| data      | Object | -      | Y        | 성공 응답 데이터  |

### 성공 응답 데이터 (data 필드 하위)

| Parameter    | Type   | Length | Required | Description     |
|--------------|--------|--------|----------|-----------------|
| orderAmt    | INT    | 10     | Y        | 주문 금액            |
| myPoint     | INT    | 10     | Y        | 잔여포인트(포인트 잔액) |
| useMinPoint | INT    | 10     | Y        | 사용가능최소적립포인트 |
| useMaxPoint | INT    | 10     | Y        | 사용가능최대적립포인트 |
| useUnitPoint | INT   | 10     | Y        | 적립포인트 사용 단위   |
