# cd ./gateway;
# ./mvnw package -f "pom.xml";
# cd ..;
# cd ./customerSystem;
# ./mvnw package -f "pom.xml";
# cd ..;
# cd ./productSystem;
# ./mvnw package -f "pom.xml";
# cd ..;
# cd ./purchaseSystem;
# ./mvnw package -f "pom.xml";
# cd ..;
# cd ./biSystem;
# ./mvnw package -f "pom.xml";

# check kafka /kafka_2.13-2.8.1 available
if [ -e kafka_2.13-2.8.1.tgz ]
then
    echo "kafka ok"
    rm -rf kafka_2.13-2.8.1
    tar zxvf kafka_2.13-2.8.1.tgz;
else
    curl https://archive.apache.org/dist/kafka/2.8.1/kafka_2.13-2.8.1.tgz -o kafka_2.13-2.8.1.tgz;
    tar zxvf kafka_2.13-2.8.1.tgz;
    echo "kafka ok"
fi