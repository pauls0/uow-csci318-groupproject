while true; do

    if [ $((RANDOM%10)) == 1 ]
    then
        curl -X POST -H "Content-Type:application/json" -d '{"quantity":1,"productID":1, "customerID":1}' http://localhost:8080/purchases;
    fi

    if [ $((RANDOM%10)) == 3 ]
    then
        curl -X POST -H "Content-Type:application/json" -d '{"quantity":1,"productID":3, "customerID":1}' http://localhost:8080/purchases;
    fi

    if [ $((RANDOM%10)) == 5 ]
    then
        curl -X POST -H "Content-Type:application/json" -d '{"quantity":1,"productID":5, "customerID":1}' http://localhost:8080/purchases;
    fi

    if [ $((RANDOM%10)) == 7 ]
    then
        curl -X POST -H "Content-Type:application/json" -d '{"quantity":1,"productID":7, "customerID":1}' http://localhost:8080/purchases;
    fi

    if [ $((RANDOM%10)) == 9 ]
    then
        curl -X POST -H "Content-Type:application/json" -d '{"quantity":1,"productID":9, "customerID":1}' http://localhost:8080/purchases;
    fi
    
    sleep 0.5;
done