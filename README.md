# API Kullanımı
`http://localhost:8080/api/v1/expedition/show` end-pointi üzerinden `GET` methodu kullanılarak tüm seferler görülebilir. Aşağıdaki formatta bir dönüş alınacaktır.
```json
[
    {
        "id": 1,
        "expeditionType": {
            "id": 1,
            "name": "İç Hatlar"
        },
        "airLine": {
            "id": 1,
            "name": "THY"
        },
        "expeditionDate": "3923-07-23T14:20:00.000+00:00"
    },
    {
        "id": 2,
        "expeditionType": {
            "id": 2,
            "name": "Dış Hatlar"
        },
        "airLine": {
            "id": 1,
            "name": "THY"
        },
        "expeditionDate": "3923-07-23T14:40:00.000+00:00"
    }
]
```
Ayrıca bu end-point 2 parametre alır. Bu parametreler opsiyoneldir. `expedition_type` ve `airline` parametreleridir. Yine bu parametreler sayısal değer alırlar. `http://localhost:8080/api/v1/expedition/show?expedition_type=2&airline=1` gibi bir istekte bulunulabilir.

---
`http://localhost:8080/api/v1/chair/show?expeditionId=2` end-pointi üzerinden `GET` methodu kullanılarak o seferdeki boş koltuklar görülebilir.
```json
[
    {
        "id": 3,
        "chairType": {
            "id": 2,
            "name": "BUSINESS"
        },
        "price": 300.0
    }
]
```
formatında bir dönüş alınacaktır.

---
`http://localhost:8080/api/v1/ticket/buy` end-pointi üzerinden `POST` methodu kullanılarak `raw` data `json` formatında
```json
{
  "chair_id": 1,
  "phone": "+905355555555"
}
```
şeklinde istek gönderilerek ticket alınabilir.

---
Alınan ticket `GET` methodu kullanılarak `http://localhost:8080/api/v1/ticket/show?ticket_id=1` end-pointi üzerinden id değeri değiştirilerek görüntülenebilir.