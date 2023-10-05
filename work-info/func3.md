# 주문 예약 기능 API

## API 정보

- Method: `POST`
- URI: `URI 는 해당 기능에 맞게 설계하시면 됩니다.`

## 요청(Request)

### RequestHeaders

| Key           | Value             |
|---------------|-------------------|
| Content-Type  | application/json  |

### RequestBody

| Parameter      | Type   | Length | Required | Description        |
|----------------|--------|--------|----------|--------------------|
| paymentType    | String | 4      | Y        | 결제 타입 (CARD, CASH) |
| shopCode       | String | 10     | Y        | 매장코드               |
| orderAmount   | INT    | 10     | Y        | 주문금액               |
| discountAmount | INT    | 10     | Y        | 할인 금액              |
| paymentAmount  | INT    | 10     | Y        | 결제 금액              |

## Response (응답값 예시는 `func3.json` 을 참고해주세요.)

### 공통 응답

| Parameter     | Type   | Length | Required | Description          |
|---------------|--------|--------|----------|----------------------|
| code          | INT    | 4      | Y        | 결과코드(0 성공, 0 이외 실패) |
| message       | String | 255    | Y        | 서버 메시지           |
| data          | Object | -      | Y        | 성공 응답 데이터      |

### 성공 응답 데이터 (data 필드 하위)

| Parameter     | Type   | Length | Required | Description |
|---------------|--------|--------|----------|-------------|
| reservationId | CHAR   | 9      | Y        | 예약 고유 식별자(9자리 알파벳+숫자 랜덤값) |