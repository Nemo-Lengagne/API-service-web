# Projet Spring Boot REST API

## Vue d’ensemble

Il s’agit d’une RESTful API construite avec Spring Boot qui fournit des opérations CRUD pour la gestion des Product. Elle répond aux mêmes conditions que le projet d’API JAX-RS.

## Structure du projet

```
SpringBoot/
├── pom.xml                                  # Configuration Maven
├── application.properties                   # Configuration Spring Boot
├── SpringBootRestApiApplication.java        # Classe principale de l’application
├── Product.java                             # Modèle d’entité Product
├── ProductRepository.java                   # Couche d’accès aux données
├── ProductService.java                      # Couche de logique métier
└── ProductController.java                   # Endpoints REST API
```

## Stack technologique

* **Java 17**
* **Spring Boot 3.2.0**
* **Spring Data JPA**
* **H2 Database** (en mémoire)
* **Maven** (outil de build)

## Construction du projet

### Prérequis

* Java 17 ou supérieur
* Maven 3.6+

### Étapes de build

1. Naviguer vers le dossier SpringBoot :

   ```powershell
   cd "c:\Users\Yuusha\Desktop\B3\services web comm\api1\SpringBoot"
   ```

2. Construire le projet :

   ```powershell
   mvn clean install
   ```

3. Lancer l’application :

   ```powershell
   mvn spring-boot:run
   ```

L’application démarrera sur **[http://localhost:8081/api](http://localhost:8081/api)**

## Endpoints de l’API

### 1. GET - Récupérer les Products

```
GET http://localhost:8081/api/products
Response: "GET"
```

### 2. GET - Récupérer un Product par ID

```
GET http://localhost:8081/api/products/1
Response: "GET"
```

### 3. POST - Créer un nouveau Product

```
POST http://localhost:8081/api/products
Content-Type: application/json

Request Body:
{
  "productName": "Laptop",
  "productPrice": 999.99
}

Response: "POST" (Status: 201 Created)
```

**Requis** : `productName` et `productPrice` doivent être fournis.

### 4. PUT - Mettre à jour un Product existant

```
PUT http://localhost:8081/api/products/1
Content-Type: application/json

Request Body:
{
  "productName": "Updated Laptop",
  "productPrice": 1099.99
}

Response: "PUT"
```

**Requis** : au moins un champ (`productName` ou `productPrice`) doit être fourni.

### 5. DELETE - Supprimer un Product

```
DELETE http://localhost:8081/api/products/1
Response: "DELETE"
```

**Requis** : l’ID du Product doit exister.

## Tests avec Postman

### Configuration

1. Ouvrir Postman
2. Créer une nouvelle collection : "Spring Boot API Tests"

### Cas de test

#### Test 1 : GET All Products

* **Method** : GET
* **URL** : `http://localhost:8081/api/products`
* **Réponse attendue** : "GET"
* **Status** : 200 OK

#### Test 2 : POST Create Product

* **Method** : POST
* **URL** : `http://localhost:8081/api/products`
* **Headers** : `Content-Type: application/json`
* **Body** :

  ```json
  {
    "productName": "Laptop",
    "productPrice": 999.99
  }
  ```
* **Réponse attendue** : "POST"
* **Status** : 201 Created

#### Test 3 : POST avec données incomplètes

* **Method** : POST
* **URL** : `http://localhost:8081/api/products`
* **Headers** : `Content-Type: application/json`
* **Body** :

  ```json
  {
    "productName": "Laptop"
  }
  ```
* **Réponse attendue** : message d’erreur
* **Status** : 400 Bad Request

#### Test 4 : PUT Update Product

* **Method** : PUT
* **URL** : `http://localhost:8081/api/products/1`
* **Headers** : `Content-Type: application/json`
* **Body** :

  ```json
  {
    "productName": "Updated Laptop"
  }
  ```
* **Réponse attendue** : "PUT"
* **Status** : 200 OK

#### Test 5 : DELETE Product

* **Method** : DELETE
* **URL** : `http://localhost:8081/api/products/1`
* **Réponse attendue** : "DELETE"
* **Status** : 200 OK

## Console de base de données

Accéder à la console H2 à : **[http://localhost:8081/api/h2-console](http://localhost:8081/api/h2-console)**

* JDBC URL : `jdbc:h2:mem:testdb`
* Username : `sa`
* Password : (laisser vide)

## Comparaison : Spring Boot vs JAX-RS

| Fonctionnalité           | Spring Boot     | JAX-RS                |
| ------------------------ | --------------- | --------------------- |
| **Framework**            | Spring Boot     | JAX-RS (Jersey)       |
| **Server**               | Embedded Tomcat | Grizzly HTTP          |
| **Port**                 | 8081            | 8080                  |
| **Database**             | H2 In-Memory    | In-Memory (optionnel) |
| **Dependency Injection** | Spring DI       | CDI                   |
| **Build Tool**           | Maven           | Maven                 |

## Propriétés de l’application

* **Server Port** : 8081
* **Context Path** : /api
* **Database** : H2 (In-Memory)
* **JPA DDL** : update (crée automatiquement les tables)
* **Logging Level** : DEBUG pour l’application, INFO pour les autres

## Dépannage

### Port déjà utilisé

Si le port 8081 est déjà utilisé, le modifier dans `application.properties` :

```properties
server.port=8082
```

### Échecs de build

Vérifier que Maven est correctement configuré :

```powershell
mvn --version
```

### Problèmes de base de données

Réinitialiser la base de données en redémarrant l’application (H2 est en mémoire).
