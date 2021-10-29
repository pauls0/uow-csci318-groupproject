zookeeper: ./kafka_2.13-2.8.1/bin/zookeeper-server-start.sh ./kafka_2.13-2.8.1/config/zookeeper.properties
kafka: sleep 15; ./kafka_2.13-2.8.1/bin/kafka-server-start.sh ./kafka_2.13-2.8.1/config/server.properties
gateway: sleep 30; java -jar ./gateway/target/gateway-2.0.0.jar
customer: sleep 30; java -jar ./customerSystem/target/customerSystem-2.0.0.jar
product: sleep 30; java -jar ./productSystem/target/productSystem-2.0.0.jar
purchase: sleep 30; java -jar ./purchaseSystem/target/purchaseSystem-2.0.0.jar
bi: sleep 30; java -jar ./biSystem/target/biSystem-2.0.0.jar