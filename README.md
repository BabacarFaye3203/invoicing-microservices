💼# invoicing-microservices

🧾 Description

Invoicing Microservices est une application de facturation complète développée en Spring Boot, organisée en microservices indépendants.
Elle permet la gestion des factures, des produits, des clients, des devises et des paiements, tout en garantissant une communication fluide entre les services grâce à Eureka Server.

⚙️ Architecture du système

L’application est composée des microservices suivants :

Microservice	Rôle	Détails
eureka-server: 	Service Discovery	Centralise l’enregistrement et la découverte des microservices
invoices : 	Gestion des factures	Gère la création, la consultation et la mise à jour des factures. Contient aussi les InvoiceProducts
products : 	Gestion des produits	Gère les produits disponibles à la vente
individual-customers : 	Gestion des clients individuels	Permet la création et la gestion des clients
currencies : 	Gestion des devises	Permet d’ajouter et de valider les devises utilisées pour les factures
payments : 	Gestion des paiements	Gère les transactions associées aux factures
pricing : 	Gestion des prix	Calcule et ajuste les prix en fonction de la devise ou des règles métiers

Chaque microservice dispose de sa propre base de données PostgreSQL pour garantir l’isolation des données et la scalabilité.

🧠 Détails du fonctionnement
🧾 1. Microservice invoices
Le microservice Invoices est au cœur du système.
Il contient :

L’entité Invoice

L’entité InvoiceProducts, qui représente les produits liés à une facture (@OneToMany).

La gestion des liens avec :

IndividualCustomer (client)

Currency (devise)

Payment (paiement)

Products (produits sélectionnés)

Lors de la création d’une facture :

Le service vérifie que le client existe dans le microservice individual-customers.

Il valide la devise dans currencies.

Il récupère les informations produits depuis le microservice products.

Il crée la facture et ses lignes de produits (InvoiceProducts).



📦 Autres microservices

🛒 products

Gère les produits : nom, description, prix, catégorie, image, stock.

Chaque produit possède un UUID unique.

Les fichiers d’images sont stockés localement dans le dossier products_file/.



👤 individual-customers

Gère les clients individuels.

Chaque client est lié à plusieurs factures.


💱 currencies

Permet d’ajouter de nouvelles devises.

Vérifie la validité du code ISO (ex: MAD, EUR, USD) avant la création d’une facture.



💰 payments

Gère le paiement des factures.

Chaque paiement est lié à une facture par son uuid.



💹 pricing

Gère la logique de calcul de prix et conversion de devises.



🧩 Technologies utilisées
🖥️ Backend

Java 17

Spring Boot 3

Spring Cloud Netflix Eureka

Spring Data JPA

Spring Validation

Spring Web

Lombok

Mapstruct

💾 Base de données

PostgreSQL

🧰 Outils

Maven
Swagger / OpenAPI
Docker
Git / GitHub



📘 Exemple de flux de travail

➕ Création d’un produit
Endpoint :

POST /products


Type de requête : multipart/form-data

Champs :

request → JSON (CreateProductRequest)

file → Image du produit

Exemple JSON :

{
  "name": "hp",
  "description": "télephone portable G...",
  "price": 1000,
  "category": "MULTIMEDIA",
  "isActive": true
}

🧾 Création d’une facture

Endpoint :

POST /invoices


Exemple JSON :

{
  "date": "2025-10-17",
  "language": "string",
  "number": 0,
  "status": "string",
  "creationDate": "2025-10-17T12:27:48.602Z",
  "note": "string",
  "individualCustomer": "string",
  "invoiceProducts": [
    {
      "product": "string",
      "quantity": 0.1,
      "discount": 0.1,
      "taxe": 0.1,
      "discountType": "string",
      "invoice": {
        "language": "string",
        "number": "string",
        "status": "string",
        "note": "string",
        "individualCustomer": "string",
        "invoiceProducts": [
          "string"
        ]
      }
    }
  ],
  "currency": "string"
}


Processus :

Vérification du client (individual-customers)

Validation de la devise (currencies)

Récupération du produit (products)

Création de la facture et des InvoiceProducts

🧪 Lancer le projet
1️⃣ Cloner le dépôt
git clone https://github.com/BabacarFaye3203/invoicing-microservices.git
cd invoicing-microservices

2️⃣ Démarrer Eureka
cd eureka-server
mvn spring-boot:run

3️⃣ Démarrer les autres microservices
cd invoices
mvn spring-boot:run


(Et répéter pour products, currencies, payments, etc.)

🌐 Documentation Swagger

Chaque microservice expose sa documentation :

http://localhost:8085/swagger-ui/index.html   (Invoices)
http://localhost:8086/swagger-ui/index.html   (Products)
http://localhost:8087/swagger-ui/index.html   (Currencies)
...


👨‍💻 Auteur

Babacar Faye
🎓 Titulaire d'une licence Informatique – FST Beni Mellal
🎓 Étudiant en Master Artificial Intelligence & Digital Computing – FST Beni Mellal
💼 Développeur Java / Spring Boot/Angular chez CodingArt
📧 bf322003@gmail.com

📍 Beni Mellal, Maroc – 🇸🇳 Sénégal
