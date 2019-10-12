# Simple base SOAP via Spring-Boot

> ##### [SOAP](https://github.com/reomor/springBootSoap/tree/master/soap1) 
> ##### [SOAP with custom wsdl](https://github.com/reomor/springBootSoap/tree/master/soap2)

endpoints:
```
http://localhost:8080/ws/countries.wsdl
http://localhost:8080/ws/service.wsdl
```

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:tns="http://soap.reomor.ru/soap">
    <soapenv:Header/>
    <soapenv:Body>
        <tns:getCountryRequest>
            <tns:name>Spain</tns:name>
        </tns:getCountryRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

```shell script
curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws
```
