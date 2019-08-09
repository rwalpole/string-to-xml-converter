# string-to-xml-converter
a simple wrapper around `scala.xml.XML.loadString(..)` that checks for a `SAXParseException` being thrown and returns a `scala.util.Try` with either the a `Success` containing the parsed XML or a `Failure` containing the exception.
## usage examples

for a single XML root element:

```
XmlConversion.stringToXmlNodes("<a>A</a>")
```
for a sequence of XML elements:

```
XmlConversion.stringToXmlNodes("<a>A</a><b>B</b>"")
```