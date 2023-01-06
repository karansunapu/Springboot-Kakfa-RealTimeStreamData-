# Springboot-Kakfa-RealTimeStreamData-

This application recieves real time data from wikiMedia <https://stream.wikimedia.org/v2/stream/recentchange> which a stream of json data

We have two sub-modules - Producer and the Consumer

Producer
  - create an Event Source by connecting to wikimedia for the data
  - give that event to Event Handler which will handle the events(recieving data) and publish it to the Kafka Topic
  
Consumer
  - it will consume the events/messages from the Topic 
  - Store them in a Mysql Database
  
  
  Architecture:
  
  
  
                              Kafka    Cluster
                               Kafka Broker
  WikiMedia ---> Producer ----->  Topic ----> Consumer -----> Database
