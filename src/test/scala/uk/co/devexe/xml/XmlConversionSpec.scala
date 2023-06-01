package uk.co.devexe.xml

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.xml.Text

class XmlConversionSpec extends AnyWordSpec with Matchers {

  "stringToXmlNodes" must {
    "return an empty Text node when passed an empty string" in {
      val result = XmlConversion.stringToXmlNodes("")
      result.get.head mustBe Text("")
    }
    "return an empty text node when passed a string containing only a carriage return" in {
      val result = XmlConversion.stringToXmlNodes("\n")
      result.get.head mustBe Text("")
    }
    "return a sequence containing one XML node when passed a valid XML string an single node" in {
      val result = XmlConversion.stringToXmlNodes("<test>test</test>")
      result.get mustBe Seq(<test>test</test>)
    }
    "return a sequence of XML nodes when passed a valid XML string containing multiple nodes" in {
      val result = XmlConversion.stringToXmlNodes("<test>test1</test><test>test2</test>")
      result.get mustBe <test>test1</test><test>test2</test>
    }
    "return a Failure if the XML cannot be parsed" in {
      val result = XmlConversion.stringToXmlNodes("<test>&</test>")
      result.isFailure mustBe true
    }
  }

}
