package ian.guo.xml;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

public class JavaBean2XmlTest {

  @Test
  public void test() {

    XmlDto xmlDto = new XmlDto();
    xmlDto.byteValue = 1;
    xmlDto.shortValue = 2;
    xmlDto.intValue = 3;
    xmlDto.longValue = 4;
    xmlDto.booleanValue = true;
    xmlDto.charValue = 't';
    xmlDto.floatValue = 1.23f;
    xmlDto.doubleValue = 3.52d;
    xmlDto.stringValue = "xstream";
    xmlDto.stringList = Arrays.asList("a1", "a2", "a3");
    xmlDto.stringList = new ArrayList<>();
    xmlDto.stringList.add("a1");
    xmlDto.stringList.add("a2");
    xmlDto.stringList.add("a3");

    xmlDto.xmlInternalDto = new XmlInternalDto();
    xmlDto.xmlInternalDto.byteValue = 1;
    xmlDto.xmlInternalDto.shortValue = 2;
    xmlDto.xmlInternalDto.intValue = 3;
    xmlDto.xmlInternalDto.longValue = 4;
    xmlDto.xmlInternalDto.booleanValue = true;
    xmlDto.xmlInternalDto.charValue = 't';
    xmlDto.xmlInternalDto.floatValue = 1.23f;
    xmlDto.xmlInternalDto.doubleValue = 3.52d;
    xmlDto.xmlInternalDto.stringValue = "xstream";

    xmlDto.internalDtos = new ArrayList<>();
    xmlDto.internalDtos.add(xmlDto.xmlInternalDto);
    xmlDto.internalDtos.add(xmlDto.xmlInternalDto);

    XStream xStream = new XStream(new JsonHierarchicalStreamDriver() {

      public HierarchicalStreamWriter createWriter(Writer writer) {
        return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
      }
    });
    String xml = xStream.toXML(xmlDto);
    System.out.println(xml);
  }
}
