package uk.co.devexe.xml

import scala.util.{Failure, Success, Try}
import scala.xml.{Node, SAXParseException, Text}

object XmlConversion {

  /**
    * Returns one or more XML nodes parsed from the given string or an exception if the parsing fails.
    * If the string is empty an empty text node will be returned.
    */
  def stringToXmlNodes(string: String): Try[Seq[Node]] = {
    try {
      val xml = scala.xml.XML.loadString("<root>" + string.trim + "</root>")
      val result = xml.child
      if (result.isEmpty) {
        Success(Text(""))
      } else {
        Success(result)
      }
    } catch {
      case e: SAXParseException => Failure(e)
    }
  }

}
