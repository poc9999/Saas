## SpringBoot Mybatis Saas 多租户Demo
> author caishe
#### 如何使用
```
请求地址:http://localhost:8888/index?tenantId=0
```
```json
{
    "code": 200,
    "message": "ok",
    "data": [
        {
            "id": 4,
            "tenantId": 0,
            "name": "Sandy",
            "addrName": null
        },
        {
            "id": 5,
            "tenantId": 0,
            "name": "Billie",
            "addrName": null
        }
    ],
    "path": "/index"
}
```
切换租户Id
```
http://localhost:8888/index?tenantId=1
```
```json
{
    "code": 200,
    "message": "ok",
    "data": [
        {
            "id": 1,
            "tenantId": 1,
            "name": "Jone",
            "addrName": null
        },
        {
            "id": 2,
            "tenantId": 1,
            "name": "Jack",
            "addrName": null
        },
        {
            "id": 3,
            "tenantId": 1,
            "name": "Tom",
            "addrName": null
        }
    ],
    "path": "/index"
}
```