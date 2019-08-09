package uk.co.devexe.xml

import org.scalatest.{Matchers, WordSpec}

import scala.xml.Text

class XmlConversionSpec extends WordSpec with Matchers {

  "stringToXmlNodes" should {
    "return an empty Text node when passed an empty string" in {
      val result = XmlConversion.stringToXmlNodes("")
      result.get.head shouldBe Text("")
    }
    "return an empty text node when passed a string containing only a carriage return" in {
      val result = XmlConversion.stringToXmlNodes("\n")
      result.get.head shouldBe Text("")
    }
    "return a sequence containing one XML node when passed a valid XML string an single node" in {
      val result = XmlConversion.stringToXmlNodes("<test>test</test>")
      result.get shouldBe Seq(<test>test</test>)
    }
    "return a sequence of XML nodes when passed a valid XML string containing multiple nodes" in {
      val result = XmlConversion.stringToXmlNodes("<test>test1</test><test>test2</test>")
      result.get shouldBe <test>test1</test><test>test2</test>
    }
    "return a Failure if the XML cannot be parsed" in {
      val result = XmlConversion.stringToXmlNodes("<test>&</test>")
      result.isFailure shouldBe true
    }
  }

}
