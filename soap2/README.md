# Simple base SOAP via Spring-Boot with custom wsdl

endpoints:
```
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

generate by wsimport
```shell script
wsimport -keep -verbose http://localhost:8080/ws/service.wsdl
```

file package-info.java contains important information and it's namespace is used for marshalling/unmarshalling
don't forget to add one
```java
@javax.xml.bind.annotation.XmlSchema(namespace = "http://soap.reomor.ru/soap/model", elementFormDefault = javax.xml.bind.annotation.XmlNsForm.QUALIFIED)
package ru.github.reomor.soap.model;
```
without it u will get error like 
```shell script
unexpected element (uri:"http://soap.reomor.ru/soap/model", local:"getCountryRequest"). Expected elements are &lt;{}getCountryRequest
during unmarshalling JAXB
```
