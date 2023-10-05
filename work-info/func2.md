# 주문 정보 조회 API

## API 정보

- Method: `GET`
- URI: `URI 는 해당 기능에 맞게 설계하시면 됩니다.`

## Request

### 파라미터

| Parameter | Type   | Length | Required | Description   |
|-----------|--------|--------|----------|---------------|
| orderId   | String | 6      | Y        | 주문 고유 식별자 |

## Response (응답값 예시는 `func2.json` 을 참고해주세요.)

### 공통 응답

| Parameter | Type   | Length | Required | Description         |
|-----------|--------|--------|----------|---------------------|
| code      | INT    | 4      | Y        | 결과코드(0 성공, 0 이외 실패) |
| message   | String | 255    | Y        | 서버 메시지              |
| data      | Object | -      | Y        | 성공 응답 데이터           |

### 성공 응답 데이터 (data 필드 하위)

| Parameter    | Type   | Length | Required | Description     |
|--------------|--------|--------|----------|-----------------|
| orderAmount  | INT    | 10     | Y        | 주문금액         |
| orderDate    | String | 10     | Y        | 주문날짜         |
| orderMenus   | List   | -      | Y        | 주문메뉴         |
| └ productName | String | 255    | Y        | 상품 이름       |
| └ price      | INT    | 10     | Y        | 상품 가격       |
| orderPayments | List   | -      | Y        | 결제정보        |
| └ paymentId  | INT    | 10     | Y        | 결제 정보 고유 식별자 |
| └ paymentMethod | String | 255  | Y        | 결제 수단       |
| └ paymentDate | String | 10     | Y        | 결제 날짜       |
