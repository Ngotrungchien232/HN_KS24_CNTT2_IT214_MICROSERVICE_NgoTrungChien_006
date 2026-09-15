
 1. Cac port cua service
- eureka-server: port 8761
- config-server: port 8888
- api-gateway: port 8080
- roomtype-service: port 8081
- room-service: port 8082

## 2. Cach chay he thong
Chay cac service theo thu tu sau trong IntelliJ:
1. Chay EurekaServerApplication (port 8761)
2. Chay ConfigServerApplication (port 8888)
3. Chay RoomTypeServiceApplication (port 8081)
4. Chay RoomServiceApplication (port 8082)
5. Chay ApiGatewayApplication (port 8080)

Kiem tra Eureka tai: http://localhost:8761 da hien du cac service chua.

## 3. Test API tren Postman (test qua Gateway port 8080)

 Tao loai phong
- POST: http://localhost:8080/api/roomtypes
- Body (raw JSON):
{
  "name": "Phong VIP",
  "description": "Phong danh cho khach VIP"
}

 Tao phong moi (Thanh cong)
- POST: http://localhost:8080/api/rooms
- Body (raw JSON):
{
  "roomNumber": "VIP-101",
  "price": 1500000,
  "roomTypeId": 1
}

 Tao phong moi (That bai do sai roomTypeId)
- POST: http://localhost:8080/api/rooms
- Body (raw JSON):
{
  "roomNumber": "VIP-999",
  "price": 1500000,
  "roomTypeId": 9999
}
-> Ket qua: Tra ve ma loi 404 Not Found

Lay danh sach tat ca cac phong
- GET: http://localhost:8080/api/rooms
