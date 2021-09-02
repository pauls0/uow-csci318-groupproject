curl -X GET http://localhost:8080/products  
[{"id":1,"productCategory":"Fruit","name":"Royal Gala Apple","price":0.62,"stockQuantity":200,"productDetail":{"id":2,"description":"Apples are juicy, crisp and come in a variety of colours including red, pink and green.","comment":"Store your apples in the fridge"}},{"id":3,"productCategory":"Fruit","name":"Cavendish Banana","price":0.72,"stockQuantity":200,"productDetail":{"id":4,"description":"Bananas are perfect for snacking, used in baking, fruit salads and smoothies.","comment":"Bananas are the worlds oldest fruit!"}}]%

curl -X GET http://localhost:8080/products/1

curl -X POST -H "Content-Type:application/json" -d \
'{"productCategory":"Fruit","name":"Packham Pear","price":0.67,"stockQuantity":200,"productDetail":{"description":"Crispy white juicy sweet flesh, with a beautiful green skin which turns light yellow when ripe","comment":"Seasonality: March - December"}}' http://localhost:8080/products

curl -X GET http://localhost:8080/products  
[{"id":1,"productCategory":"Fruit","name":"Royal Gala Apple","price":0.62,"stockQuantity":200,"productDetail":{"id":2,"description":"Apples are juicy, crisp and come in a variety of colours including red, pink and green.","comment":"Store your apples in the fridge"}},{"id":3,"productCategory":"Fruit","name":"Cavendish Banana","price":0.72,"stockQuantity":200,"productDetail":{"id":4,"description":"Bananas are perfect for snacking, used in baking, fruit salads and smoothies.","comment":"Bananas are the worlds oldest fruit!"}},{"id":5,"productCategory":"Fruit","name":"Packham Pear","price":0.67,"stockQuantity":200,"productDetail":{"id":6,"description":"Crispy white juicy sweet flesh, with a beautiful green skin which turns light yellow when ripe","comment":"Seasonality: March - December"}}]

curl -X PUT -H "Content-Type:application/json" -d \
'{"id":1,"productCategory":"Fruit","name":"Royal Gala Apple","price":0.70,"stockQuantity":200,"productDetail":{"id":2,"description":"Apples are juicy, crisp and come in a variety of colours including red, pink and green.","comment":"Store your apples in the fridge"}}' http://localhost:8080/products/1

[{"id":1,"productCategory":"Fruit","name":"Royal Gala Apple","price":0.7,"stockQuantity":200,"productDetail":{"id":2,"description":"Apples are juicy, crisp and come in a variety of colours including red, pink and green.","comment":"Store your apples in the fridge"}},{"id":3,"productCategory":"Fruit","name":"Cavendish Banana","price":0.72,"stockQuantity":200,"productDetail":{"id":4,"description":"Bananas are perfect for snacking, used in baking, fruit salads and smoothies.","comment":"Bananas are the worlds oldest fruit!"}},{"id":5,"productCategory":"Fruit","name":"Packham Pear","price":0.67,"stockQuantity":200,"productDetail":{"id":6,"description":"Crispy white juicy sweet flesh, with a beautiful green skin which turns light yellow when ripe","comment":"Seasonality: March - December"}}]
