How to use crawler application?
There are 3 endpoints have been exposed by the application
1. http://localhost:8080/crawler/crawl
  -This end point triggers crawling request and returns a token which is uqique and is used for polling and fetch processed data of the request.
  -It takes 2 mandatory parameter 1. url to be crawled, 2. depth 
2. http://localhost:8080/crawler/process/data?token={tokenId}
  -This endpoint is used to fetch crawl request data based on given token id which is received in 1st endpoint
3.   http://localhost:8080/crawler/process/status?token={tokenId}
  -This endpoint is used to fetch crawl request status based on given token id which is received in 1st endpoint. Status are  WAITING, PROCESSING, C  COMPLETED,
 -COMPLETED_WITH_ERROR is not implemented yet.

Application silent features:
1. Exception handling has been implemented both in http request and processing the request.
2. Application process a crawl request in async mode and supporrt prallel processiong.
3. Various logical layers has been created to create modular application and loose coupling
    -Controller layer
    -Service Layer
    -Crawl Request Processor layer
    -Data Extractor layer
    So this application can be extended easily if required.
 4. It used various cofiguration 
      - type of crawler. Right now it is a web crawler however a different one like file crawler be implemented and configure it in application.yml and it will start using it.
      - size of threadpool used.
      
Ehancement points:
1. Application supports crawl request level parallelism however it could be enhanced by by implementating crawl level parallelism within a request.
2. If a link which is crawled throw a IOException then the title, imagecount and links field will not be updated for those.
3. Application maintains crawled data in-memory. All data lost on restart of application however a persistent layer can be implemented with minimal change to survive the restarts.
