# API Quick Reference Card

## 🚀 Quick Commands

### Start JAX-RS Server (Terminal 1)
```powershell
cd "c:\Users\Yuusha\Desktop\B3\services web comm\api1\JAX-RS"
mvn exec:java -Dexec.mainClass="api.Main"
```
**Result**: Server on http://localhost:8080/api/

### Start Spring Boot Server (Terminal 2)
```powershell
cd "c:\Users\Yuusha\Desktop\B3\services web comm\api1\SpringBoot"
mvn spring-boot:run
```
**Result**: Server on http://localhost:8081/api/

---

## 📡 JAX-RS API Endpoints

| Method | Endpoint | Body | Response | Status |
|--------|----------|------|----------|--------|
| **GET** | /products | - | "GET" | 200 |
| **POST** | /products | `{"name":"...", "price": 99.99}` | "POST" | 201 |
| **PUT** | /products/{id} | `{"name":"..."}` or `{"price": 99.99}` or both | "PUT" | 200 |
| **DELETE** | /products/{id} | - | "DELETE" | 200 |

### Full URLs
- GET: `http://localhost:8080/api/products`
- POST: `http://localhost:8080/api/products`
- PUT: `http://localhost:8080/api/products/1`
- DELETE: `http://localhost:8080/api/products/1`

### Request Examples

**POST (Complete)**
```json
{
  "name": "Dell Laptop",
  "price": 1299.99
}
```

**POST (Incomplete - Error)**
```json
{
  "name": "Dell Laptop"
}
```

**PUT (Partial Update)**
```json
{
  "name": "HP Laptop Pro"
}
```

---

## 📡 Spring Boot API Endpoints

| Method | Endpoint | Body | Response | Status |
|--------|----------|------|----------|--------|
| **GET** | /products | - | "GET" | 200 |
| **POST** | /products | `{"productName":"...", "productPrice": 99.99}` | "POST" | 201 |
| **PUT** | /products/{id} | `{"productName":"..."}` or `{"productPrice": 99.99}` or both | "PUT" | 200 |
| **DELETE** | /products/{id} | - | "DELETE" | 200 |

### Full URLs
- GET: `http://localhost:8081/api/products`
- POST: `http://localhost:8081/api/products`
- PUT: `http://localhost:8081/api/products/1`
- DELETE: `http://localhost:8081/api/products/1`

### Request Examples

**POST (Complete)**
```json
{
  "productName": "Apple MacBook Pro",
  "productPrice": 2299.99
}
```

**POST (Incomplete - Error)**
```json
{
  "productName": "Apple MacBook Pro"
}
```

**PUT (Partial Update)**
```json
{
  "productName": "Lenovo ThinkPad"
}
```

---

## 🔑 Key Differences in Field Names

| Operation | JAX-RS | Spring Boot |
|-----------|--------|------------|
| **Product Name Field** | `name` | `productName` |
| **Product Price Field** | `price` | `productPrice` |

---

## ✅ Postman Configuration

### Headers for POST/PUT
```
Content-Type: application/json
```

### Test Sequence
1. POST with complete data → expect "POST" (201)
2. POST with incomplete data → expect error (400)
3. PUT with partial data → expect "PUT" (200)
4. GET all → expect "GET" (200)
5. DELETE → expect "DELETE" (200)

---

## 🐛 Status Codes Reference

| Code | Meaning | Scenario |
|------|---------|----------|
| 200 | OK | Successful GET, PUT, DELETE |
| 201 | Created | Successful POST |
| 400 | Bad Request | Missing required fields |
| 404 | Not Found | Resource doesn't exist |
| 500 | Server Error | Unexpected error |

---

## 💾 Database Info

### JAX-RS
- **Database**: None (in-memory data only)
- **Persistence**: No
- **Resets**: On server restart

### Spring Boot
- **Database**: H2 (in-memory SQL)
- **Persistence**: Limited (H2 in-memory)
- **Access**: http://localhost:8081/api/h2-console
- **Username**: sa
- **Password**: (empty)
- **Resets**: On server restart

---

## 🎯 Testing Workflow

```
1. Terminal 1: Start JAX-RS (port 8080)
        ↓
2. Terminal 2: Start Spring Boot (port 8081)
        ↓
3. Open Postman
        ↓
4. Test JAX-RS (5 tests) ← Screenshot each
        ↓
5. Test Spring Boot (5 tests) ← Screenshot each
        ↓
6. Total: 10 screenshots
        ↓
7. Create ZIP with all files
        ↓
8. Submit deliverable
```

---

## 📋 10 Required Tests

### JAX-RS Tests (1-5)
1. GET /products → "GET"
2. POST /products (complete) → "POST" (201)
3. POST /products (incomplete) → Error (400)
4. PUT /products/1 → "PUT" (200)
5. DELETE /products/1 → "DELETE" (200)

### Spring Boot Tests (6-10)
6. GET /products → "GET"
7. POST /products (complete) → "POST" (201)
8. POST /products (incomplete) → Error (400)
9. PUT /products/1 → "PUT" (200)
10. DELETE /products/1 → "DELETE" (200)

---

## 🔍 Postman Request Setup

### GET Request
1. Method: GET
2. URL: `http://localhost:8080/api/products`
3. Headers: None needed
4. Body: Empty
5. Send

### POST Request
1. Method: POST
2. URL: `http://localhost:8080/api/products`
3. Headers: Content-Type: application/json
4. Body: Raw JSON `{"name":"...", "price":99.99}`
5. Send

### PUT Request
1. Method: PUT
2. URL: `http://localhost:8080/api/products/1`
3. Headers: Content-Type: application/json
4. Body: Raw JSON `{"name":"..."}` (partial)
5. Send

### DELETE Request
1. Method: DELETE
2. URL: `http://localhost:8080/api/products/1`
3. Headers: None needed
4. Body: Empty
5. Send

---

## 📦 Project Files Summary

### JAX-RS (5 files + documentation)
```
Product.java          → REST resource (@GET, @POST, @PUT, @DELETE)
ProductData.java      → Data model (name, price)
Main.java             → Server startup (Grizzly on :8080)
pom.xml               → Dependencies (Jersey, Grizzly)
ProductService.wsdl   → SOAP service description
```

### Spring Boot (7 files + documentation)
```
SpringBootRestApiApplication.java  → Spring Boot main class
ProductController.java             → REST controller
ProductService.java                → Business logic
ProductRepository.java             → Data access
Product.java                       → JPA entity
application.properties             → Config (port :8081)
pom.xml                           → Dependencies (Spring Boot)
```

---

## 🎓 Exercise Completion Checklist

### Code Development
- [x] JAX-RS project created
- [x] Spring Boot project created
- [x] All CRUD operations implemented
- [x] Both projects build successfully

### Testing
- [ ] 10 Postman tests completed
- [ ] 10 screenshots captured
- [ ] All responses verified

### Documentation
- [x] README files created
- [x] Testing guide created
- [x] Project overview created
- [ ] Screenshots organized

### Deliverable
- [ ] ZIP file created
- [ ] All files included
- [ ] Named appropriately
- [ ] Ready to submit

---

## 🆘 Emergency Troubleshooting

| Problem | Solution |
|---------|----------|
| Port 8080 in use | Change Main.java port |
| Port 8081 in use | Change application.properties port |
| Build fails | Run `mvn clean install` |
| Can't connect | Verify server is running |
| Postman error | Check request Method/URL/Headers |
| No response | Check API is actually running |
| 400 Bad Request | Check request body JSON syntax |
| 404 Not Found | Check endpoint path is correct |

---

## 💡 Pro Tips

1. **Both servers running**: Use 2 separate terminal windows
2. **Postman collections**: Save your requests for reuse
3. **Screenshot quality**: Ensure URL, method, and response are visible
4. **JSON validation**: Use jsonlint.com if unsure about syntax
5. **File organization**: Create folders BEFORE adding files
6. **Naming convention**: Use clear, sequential numbering for screenshots
7. **Testing order**: Always test error cases last
8. **Port numbers**: Remember JAX-RS uses 8080, Spring Boot uses 8081

---

## 🚀 Get Started Now!

1. Open PowerShell
2. Start JAX-RS: `mvn exec:java -Dexec.mainClass="api.Main"` (Terminal 1)
3. Start Spring Boot: `mvn spring-boot:run` (Terminal 2)
4. Open Postman
5. Test away! 📸

---

**Good luck! You've got this! 🎉**
