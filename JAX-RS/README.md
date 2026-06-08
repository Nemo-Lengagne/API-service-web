# Projet JAX-RS REST API

## Vue d’ensemble

Il s’agit d’une RESTful API construite avec JAX-RS et Jersey qui fournit des opérations CRUD pour la gestion des Product en utilisant les protocoles SOAP et HTTP.

## Structure du projet

```
JAX-RS/
├── pom.xml                          # Configuration Maven
├── Product.java                     # Classe ressource Product
├── ProductData.java                 # Data Transfer Object (DTO)
├── Main.java                        # Classe de démarrage du serveur
└── ProductService.wsdl              # Description du service WSDL
```

## Stack technologique

* **Java 11+**
* **JAX-RS 2.1.1** (API)
* **Jersey 2.35** (implémentation JAX-RS)
* **Grizzly HTTP Server 2.4.4**
* **Maven** (outil de build)

## Construction du projet

### Prérequis

* Java 11 ou supérieur
* Maven 3.6+

### Étapes de build

1. Naviguer vers le dossier JAX-RS :

   ```powershell
   cd "c:\Users\Yuusha\Desktop\B3\services web comm\api1\JAX-RS"
   ```

2. Construire le projet :

   ```powershell
   mvn clean install
   ```

3. Lancer l’application :

   ```powershell
   mvn exec:java -Dexec.mainClass="api.Main"
   ```

L’application démarrera sur **[http://localhost:8080/api/](http://localhost:8080/api/)**

## Endpoints de l’API

### 1. GET - Récupérer les Products

```
GET http://localhost:8080/api/products
Response: "GET"
```

### 2. POST - Créer un nouveau Product

```
POST http://localhost:8080/api/products
Content-Type: application/json

Request Body:
{
  "name": "Laptop",
  "price": 999.99
}

Response: "POST" (Status: 201 Created)
```

**Requis** : `name` et `price` doivent être fournis.

### 3. PUT - Mettre à jour un Product existant

```
PUT http://localhost:8080/api/products/1
Content-Type: application/json

Request Body:
{
  "name": "Updated Laptop",
  "price": 1099.99
}

Response: "PUT"
```

**Requis** : au moins un champ (`name` ou `price`) doit être fourni.

### 4. DELETE - Supprimer un Product

```
DELETE http://localhost:8080/api/products/1
Response: "DELETE"
```

**Requis** : l’ID du Product doit être valide.

## Tests avec Postman

### Configuration

1. Ouvrir Postman
2. Créer une nouvelle collection : "JAX-RS API Tests"

### Cas de test

#### Test 1 : GET All Products

* **Method** : GET
* **URL** : `http://localhost:8080/api/products`
* **Réponse attendue** : "GET"
* **Status** : 200 OK

#### Test 2 : POST Create Product

* **Method** : POST
* **URL** : `http://localhost:8080/api/products`
* **Headers** : `Content-Type: application/json`
* **Body** :

  ```json
  {
    "name": "Laptop",
    "price": 999.99
  }
  ```
* **Réponse attendue** : "POST"
* **Status** : 201 Created

#### Test 3 : POST avec données incomplètes

* **Method** : POST
* **URL** : `http://localhost:8080/api/products`
* **Headers** : `Content-Type: application/json`
* **Body** :

  ```json
  {
    "name": "Laptop"
  }
  ```
* **Réponse attendue** : message d’erreur
* **Status** : 400 Bad Request

#### Test 4 : PUT Update Product

* **Method** : PUT
* **URL** : `http://localhost:8080/api/products/1`
* **Headers** : `Content-Type: application/json`
* **Body** :

  ```json
  {
    "name": "Updated Laptop"
  }
  ```
* **Réponse attendue** : "PUT"
* **Status** : 200 OK

#### Test 5 : DELETE Product

* **Method** : DELETE
* **URL** : `http://localhost:8080/api/products/1`
* **Réponse attendue** : "DELETE"
* **Status** : 200 OK

## Description du service WSDL

Accéder au fichier WSDL : **ProductService.wsdl** (situé à la racine du projet)

Le WSDL décrit un service SOAP avec l’opération suivante :

* **Operation** : getProductDetails
* **Input** : ProductDetailsRequest (avec ProductId)
* **Output** : ProductDetailsResponse (avec ProductId, ProductName, ProductPrice)

## Comparaison : JAX-RS vs Spring Boot

| Fonctionnalité           | JAX-RS                | Spring Boot     |
| ------------------------ | --------------------- | --------------- |
| **Framework**            | JAX-RS (Jersey)       | Spring Boot     |
| **Server**               | Grizzly HTTP          | Embedded Tomcat |
| **Port**                 | 8080                  | 8081            |
| **Database**             | In-Memory (optionnel) | H2 In-Memory    |
| **Dependency Injection** | CDI                   | Spring DI       |
| **Build Tool**           | Maven                 | Maven           |

## Dépannage

### Port déjà utilisé

Si le port 8080 est déjà utilisé, modifier le BASE_URI dans Main.java :

```java
public static final String BASE_URI = "http://localhost:9090/api/";
```

### Échecs de build

Vérifier que Maven est correctement configuré :

```powershell
mvn --version
```

### Le serveur ne démarre pas

Vérifier que toutes les dépendances sont correctement résolues :

```powershell
mvn dependency:resolve
```

## Vue d’ensemble des classes

### Product.java

* Classe ressource exposant les endpoints REST
* Annotations : @Path, @GET, @POST, @PUT, @DELETE
* Gère les opérations CRUD

### ProductData.java

* Data Transfer Object (DTO)
* Contient les champs name et price
* Utilisé pour la sérialisation/désérialisation JSON

### Main.java

* Classe de démarrage pour le Grizzly HTTP server
* Configure ResourceConfig pour scanner les ressources JAX-RS
* Configure l’application sur [http://localhost:8080/api/](http://localhost:8080/api/)
