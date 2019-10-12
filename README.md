# Simple base SOAP via Spring-Boot

endpoints:
```
http://localhost:8080/ws/countries.wsdl
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
