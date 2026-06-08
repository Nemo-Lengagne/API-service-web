# Postman Testing Guide for CRUD APIs

## Overview
This guide provides detailed instructions for testing both the JAX-RS and Spring Boot REST APIs using Postman.

## Prerequisites
- **Postman** installed (https://www.postman.com/downloads/)
- **JAX-RS API** running on http://localhost:8080/api/
- **Spring Boot API** running on http://localhost:8081/api/

## Starting the Servers

### JAX-RS API
```powershell
cd "c:\Users\Yuusha\Desktop\B3\services web comm\api1\JAX-RS"
mvn exec:java -Dexec.mainClass="api.Main"
```
Expected output: "Server running at http://localhost:8080/api/"

### Spring Boot API
```powershell
cd "c:\Users\Yuusha\Desktop\B3\services web comm\api1\SpringBoot"
mvn spring-boot:run
```
Expected output: "Started SpringBootRestApiApplication"

---

## JAX-RS API Testing

### 1. GET Operation

**Request Configuration:**
- **Method**: GET
- **URL**: `http://localhost:8080/api/products`
- **Headers**: None required
- **Body**: Empty

**Expected Response:**
- **Status Code**: 200 OK
- **Response Body**: `"GET"`

**Steps to Test:**
1. Open Postman
2. Click "New" → "Request"
3. Set Method to GET
4. Paste URL: `http://localhost:8080/api/products`
5. Click Send
6. Verify the response shows "GET"
7. **Take Screenshot**: Screenshot showing GET request and response

---

### 2. POST Operation (With Complete Data)

**Request Configuration:**
- **Method**: POST
- **URL**: `http://localhost:8080/api/products`
- **Headers**: `Content-Type: application/json`
- **Body**:
```json
{
  "name": "Dell Laptop",
  "price": 1299.99
}
```

**Expected Response:**
- **Status Code**: 201 Created
- **Response Body**: `"POST"`

**Steps to Test:**
1. Click "New" → "Request"
2. Set Method to POST
3. Paste URL: `http://localhost:8080/api/products`
4. Go to Headers tab
5. Add header: `Content-Type: application/json`
6. Go to Body tab, select "raw", paste the JSON
7. Click Send
8. Verify the response shows "POST" with status 201
9. **Take Screenshot**: Screenshot showing POST request, headers, body, and response

---

### 3. POST Operation (With Incomplete Data - Error Case)

**Request Configuration:**
- **Method**: POST
- **URL**: `http://localhost:8080/api/products`
- **Headers**: `Content-Type: application/json`
- **Body**:
```json
{
  "name": "Dell Laptop"
}
```

**Expected Response:**
- **Status Code**: 400 Bad Request
- **Response Body**: Error message about missing price

**Steps to Test:**
1. Modify the previous POST request
2. Remove the "price" field from JSON body
3. Click Send
4. Verify the response shows an error message
5. **Take Screenshot**: Screenshot showing the error response

---

### 4. PUT Operation (Partial Update)

**Request Configuration:**
- **Method**: PUT
- **URL**: `http://localhost:8080/api/products/1`
- **Headers**: `Content-Type: application/json`
- **Body**:
```json
{
  "name": "HP Laptop Pro",
  "price": 1500.00
}
```

**Expected Response:**
- **Status Code**: 200 OK
- **Response Body**: `"PUT"`

**Steps to Test:**
1. Click "New" → "Request"
2. Set Method to PUT
3. Paste URL: `http://localhost:8080/api/products/1`
4. Go to Headers tab
5. Add header: `Content-Type: application/json`
6. Go to Body tab, select "raw", paste the JSON
7. Click Send
8. Verify the response shows "PUT"
9. **Take Screenshot**: Screenshot showing PUT request and response

---

### 5. DELETE Operation

**Request Configuration:**
- **Method**: DELETE
- **URL**: `http://localhost:8080/api/products/1`
- **Headers**: None required
- **Body**: Empty

**Expected Response:**
- **Status Code**: 200 OK
- **Response Body**: `"DELETE"`

**Steps to Test:**
1. Click "New" → "Request"
2. Set Method to DELETE
3. Paste URL: `http://localhost:8080/api/products/1`
4. Click Send
5. Verify the response shows "DELETE"
6. **Take Screenshot**: Screenshot showing DELETE request and response

---

## Spring Boot API Testing

### 1. GET Operation

**Request Configuration:**
- **Method**: GET
- **URL**: `http://localhost:8081/api/products`
- **Headers**: None required
- **Body**: Empty

**Expected Response:**
- **Status Code**: 200 OK
- **Response Body**: `"GET"`

**Steps to Test:**
1. Open Postman
2. Click "New" → "Request"
3. Set Method to GET
4. Paste URL: `http://localhost:8081/api/products`
5. Click Send
6. Verify the response shows "GET"
7. **Take Screenshot**: Screenshot showing GET request and response

---

### 2. POST Operation (With Complete Data)

**Request Configuration:**
- **Method**: POST
- **URL**: `http://localhost:8081/api/products`
- **Headers**: `Content-Type: application/json`
- **Body**:
```json
{
  "productName": "Apple MacBook Pro",
  "productPrice": 2299.99
}
```

**Expected Response:**
- **Status Code**: 201 Created
- **Response Body**: `"POST"`

**Steps to Test:**
1. Click "New" → "Request"
2. Set Method to POST
3. Paste URL: `http://localhost:8081/api/products`
4. Go to Headers tab
5. Add header: `Content-Type: application/json`
6. Go to Body tab, select "raw", paste the JSON
7. Click Send
8. Verify the response shows "POST" with status 201
9. **Take Screenshot**: Screenshot showing POST request, headers, body, and response

---

### 3. POST Operation (With Incomplete Data - Error Case)

**Request Configuration:**
- **Method**: POST
- **URL**: `http://localhost:8081/api/products`
- **Headers**: `Content-Type: application/json`
- **Body**:
```json
{
  "productName": "Apple MacBook Pro"
}
```

**Expected Response:**
- **Status Code**: 400 Bad Request
- **Response Body**: Error message about missing price

**Steps to Test:**
1. Modify the previous POST request
2. Remove the "productPrice" field from JSON body
3. Click Send
4. Verify the response shows an error message
5. **Take Screenshot**: Screenshot showing the error response

---

### 4. PUT Operation (Partial Update)

**Request Configuration:**
- **Method**: PUT
- **URL**: `http://localhost:8081/api/products/1`
- **Headers**: `Content-Type: application/json`
- **Body**:
```json
{
  "productName": "Lenovo ThinkPad",
  "productPrice": 999.99
}
```

**Expected Response:**
- **Status Code**: 200 OK
- **Response Body**: `"PUT"`

**Steps to Test:**
1. Click "New" → "Request"
2. Set Method to PUT
3. Paste URL: `http://localhost:8081/api/products/1`
4. Go to Headers tab
5. Add header: `Content-Type: application/json`
6. Go to Body tab, select "raw", paste the JSON
7. Click Send
8. Verify the response shows "PUT"
9. **Take Screenshot**: Screenshot showing PUT request and response

---

### 5. DELETE Operation

**Request Configuration:**
- **Method**: DELETE
- **URL**: `http://localhost:8081/api/products/1`
- **Headers**: None required
- **Body**: Empty

**Expected Response:**
- **Status Code**: 200 OK
- **Response Body**: `"DELETE"`

**Steps to Test:**
1. Click "New" → "Request"
2. Set Method to DELETE
3. Paste URL: `http://localhost:8081/api/products/1`
4. Click Send
5. Verify the response shows "DELETE"
6. **Take Screenshot**: Screenshot showing DELETE request and response

---

## Screenshot Checklist

For the final deliverable, you should have **10 screenshots total**:

### JAX-RS API (5 screenshots):
- [ ] GET request/response
- [ ] POST request/response (with complete data)
- [ ] POST error response (incomplete data)
- [ ] PUT request/response
- [ ] DELETE request/response

### Spring Boot API (5 screenshots):
- [ ] GET request/response
- [ ] POST request/response (with complete data)
- [ ] POST error response (incomplete data)
- [ ] PUT request/response
- [ ] DELETE request/response

---

## Exporting Postman Collection

To save and share your tests:

1. In Postman, click the three dots (⋮) next to your collection name
2. Select "Export"
3. Choose "Collection v2.1"
4. Save the file as `Postman_Collection_CRUD_APIs.json`
5. Include this in your deliverable

---

## Troubleshooting

### Port Connection Refused
- **Issue**: "Could not connect to localhost:8080" or "localhost:8081"
- **Solution**: Verify the server is running by checking the terminal window

### CORS Error
- **Issue**: "CORS policy: No 'Access-Control-Allow-Origin' header"
- **Solution**: Both APIs are configured to allow CORS. Make sure to use the correct URLs.

### Response is HTML instead of JSON
- **Issue**: Response shows HTML error page
- **Solution**: Verify the endpoint path is correct and the server is running

### 404 Not Found
- **Issue**: Response status 404
- **Solution**: Check that the URL path is correct (e.g., `/api/products` not `/products`)

---

## API Comparison Table

| Operation | JAX-RS | Spring Boot | Response |
|-----------|--------|------------|----------|
| GET | http://localhost:8080/api/products | http://localhost:8081/api/products | "GET" |
| POST (complete) | http://localhost:8080/api/products | http://localhost:8081/api/products | "POST" (201) |
| POST (incomplete) | http://localhost:8080/api/products | http://localhost:8081/api/products | Error (400) |
| PUT (partial) | http://localhost:8080/api/products/1 | http://localhost:8081/api/products/1 | "PUT" (200) |
| DELETE | http://localhost:8080/api/products/1 | http://localhost:8081/api/products/1 | "DELETE" (200) |

---

## Conclusion

By following this guide, you will have successfully tested both CRUD APIs and gathered evidence of their functionality through Postman screenshots. This documentation can be included in your final deliverable.
