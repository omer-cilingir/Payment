
[![Coverage Status](https://coveralls.io/repos/github/omerxl/Payment/badge.svg?branch=ticket-payment)](https://coveralls.io/github/omerxl/Payment?branch=ticket-payment)
#### Ödeme yapmak için
```http
POST https://omer-payment.herokuapp.com/payment
```

Request example
```json
{
	"processId": "002",
	"createDate": "2017-12-02",
	"cardNumber": "5526080000000006",
	"promotionCode": ""
}
```
| Parameter | Description |
|-------------| ----------- |
| `processId` | Ürün sipariş numarası |
| `createDate` | Tarih formatı  \"yyyy-MM-dd\" şeklinde olmalıdır. |
| `cardNumber` | Kullanıcın card numarası |
| `promotionCode` | Kullanıcı tarafından girilen promosyon kodu |

Response example
```json
{
"result": "Ödeme Alındı"
}
```

#### Bilet eklemek için
```http
POST https://omer-payment.herokuapp.com/tickets
```
Request Example
```json
{
	"startDate":"2017-06-01",
	"endDate":"2018-01-15",
	"type":"Blind Bird",
	"price":250,
	"currency":"TL"
}
```
| Parameter | Description |
|-------------| ----------- |
| `startDate` | Bilet satışının başladığı tarih Tarih formatı  \"yyyy-MM-dd\" şeklinde olmalıdır.|
| `endDate` |Bilet satışının sonlandığı tarih.Tarih formatı \"yyyy-MM-dd\" şeklinde olmalıdır. |
| `type` | Biletin satıldığı dönemin ismi |
| `price` | Bilet fiyatı |
| `currency` | Para birimi |
 
Response example
```json
{
   "id": 1,
   "startDate": "Jun 1, 2017 12:00:00 AM",
   "endDate": "Jan 15, 2018 12:00:00 AM",
   "type": "Blind Bird",
   "price": 250,
   "currency": "TL"
}
```

#### Biletleri listelemek için
```http
GET https://omer-payment.herokuapp.com/tickets
```
Response example
```json
[
      {
      "id": 1,
      "startDate": "Jun 1, 2017 12:00:00 AM",
      "endDate": "Jan 15, 2018 12:00:00 AM",
      "type": "Blind Bird",
      "price": 250,
      "currency": "TL"
   },
      {
      "id": 2,
      "startDate": "Mar 1, 2018 12:00:00 AM",
      "endDate": "Apr 30, 2018 12:00:00 AM",
      "type": "Regular",
      "price": 750,
      "currency": "TL"
   }
]
```
#### Satışları listelemek için
```http
GET https://omer-payment.herokuapp.com/sales
```
Response example
```json
[
      {
      "id": 1,
      "processId": "001",
      "result": "FAIL"
   },
      {
      "id": 2,
      "processId": "002",
      "result": "SUCCESS",
      "price": 250
   }
]
```
#### Logları listelemek için
```http
GET https://omer-payment.herokuapp.com/logs
```
Response example
```json
[
  {
    "id": 1,
    "processId": "001",
    "createDate": "Mar 7, 2018 9:50:54 PM",
    "cardNumber": "5890040000000016"
  },
  {
    "id": 2,
    "processId": "002",
    "createDate": "Mar 7, 2018 9:50:55 PM",
    "cardNumber": "5526080000000006"
  }
]
```
