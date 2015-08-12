package ian.guo.xml;

import java.net.URL;

import org.junit.Test;

public class XmlReaderTest {

  @Test
  public void testPrintXml() throws Exception {
    URL url = Thread.currentThread().getContextClassLoader().getResource("ian/guo/xml/test.xml");
    XmlReader.printXml(url.getPath());
  }
}
