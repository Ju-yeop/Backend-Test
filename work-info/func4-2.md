# 외부 포인트 데이터 조회 API

## API 정보

- Method: `GET`
- URI: `https://test-menu.payco.kr/test/api/work/point`

## 요청(Request)

### RequestBody

| Parameter | Type   | Length | Required | Description                 |
|-----------|--------|--------|----------|-----------------------------|
| type      | String | 1      | Y        | 요청 타입 (A, B, C, D, E, F, G) |

## 응답(Response)

### 응답 데이터

| Parameter   | Type   | Length | Required | Description          |
|-------------|--------|--------|----------|----------------------|
| orderAmt    | INT    | 10     | Y        | 주문 금액            |
| myPoint     | INT    | 10     | Y        | 잔여포인트(포인트 잔액) |
| useMinPoint | INT    | 10     | Y        | 사용가능최소적립포인트 |
| useMaxPoint | INT    | 10     | Y        | 사용가능최대적립포인트 |
| useUnitPoint | INT   | 10     | Y        | 적립포인트 사용 단위   |
