#### preload customers

sleep 60; # wait for the services to be up

echo '\nPreload Customer: Google';
curl -X POST -H "Content-Type:application/json" -d \
'{"companyName":"Google",
"address":"1600 Amphitheatre Parkway, Mountain View, California",
"country":"USA",
"contact":
{"name": "Test Testerson",
"phone": "0400000000",
"email": "mail@example.com", 
"position": "CEO"}}' \
http://localhost:8080/customers

echo '\nPreload Customer: Apple';
curl -X POST -H "Content-Type:application/json" -d \
'{"companyName":"Apple",
"address":"1 Apple Park Way, Cupertino, CA 95014",
"country":"USA",
"contact":
{"name": "Tim Apple",
"phone": "123456",
"email": "tim@apple.com", 
"position": "CEO"}}' \
http://localhost:8080/customers

echo '\nPreload Customer: SpaceX';
curl -X POST -H "Content-Type:application/json" -d \
'{"companyName":"SpaceX",
"address":"42 Galactic Drive, San Francisco, CA 97468",
"country":"USA",
"contact":
{"name": "Elon Musk",
"phone": "69420",
"email": "elon@spacex.com", 
"position": "CEO"}}' \
http://localhost:8080/customers

echo '\nPreload Customer: Microsoft';
curl -X POST -H "Content-Type:application/json" -d \
'{"companyName":"Microsoft",
"address":"One Microsoft Way, Redmond, Washington",
"country":"USA",
"contact":
{"name": "Satya Nadella",
"phone": "123456",
"email": "Satya@microsoft.com", 
"position": "CEO"}}' \
http://localhost:8080/customers

echo '\nPreload Customer: Facebook';
curl -X POST -H "Content-Type:application/json" -d \
'{"companyName":"Facebook",
"address":"1 Hacker Way, Menlo Park, California 94025",
"country":"USA",
"contact":
{"name": "Mark Zuckerberg",
"phone": "123456",
"email": "Mark@Facebook.com", 
"position": "CEO"}}' \
http://localhost:8080/customers


# #### preload products

echo '\nPreload Product: Pear';
curl -X POST -H "Content-Type:application/json" -d \
'{"productCategory":"Fruit",
"name":"Packham Pear",
"price":0.67,
"stockQuantity":200,
"productDetail":
{"description":"Crispy white juicy sweet flesh",
"comment":"Seasonality: March - December"}}' \
http://localhost:8080/products

echo '\nPreload Product: Apple';
curl -X POST -H "Content-Type:application/json" -d \
'{"productCategory":"Fruit",
"name":"Royal Gala Apple",
"price":0.62,
"stockQuantity":200,
"productDetail":
{"description":"Apples are juicy",
"comment":"Store your apples in the fridge"}}' \
http://localhost:8080/products

echo '\nPreload Product: Banana';
curl -X POST -H "Content-Type:application/json" -d \
'{"productCategory":"Fruit",
"name":"Cavendish Banana",
"price":0.72,
"stockQuantity":200,
"productDetail":
{"description":"used in baking, fruit salads and smoothies",
"comment":"Bananas are the worlds oldest fruit!"}}' \
http://localhost:8080/products

echo '\nPreload Product: Orange';
curl -X POST -H "Content-Type:application/json" -d \
'{"productCategory":"Fruit",
"name":"Navel Orange",
"price":0.64,
"stockQuantity":200,
"productDetail":
{"description":"the fruit of citrus species in the family Rutaceae",
"comment":" 2 week selflife"}}' \
http://localhost:8080/products

echo '\nPreload Product: Avocado';
curl -X POST -H "Content-Type:application/json" -d \
'{"productCategory":"Fruit",
"name":"Avocado",
"price":1.0,
"stockQuantity":200,
"productDetail":
{"description":"a large berry containing a large seed",
"comment":"around 73% water"}}' \
http://localhost:8080/products

echo '\Bootup complete: all services ready.';
read; # prevent the script from exiting
