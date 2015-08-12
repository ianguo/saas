package ian.guo.xml;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlReader {

  public static void printXml(String path) throws IOException, DocumentException {
    SAXReader reader = new SAXReader();
    Document document = reader.read(new File(path));
    printXml(0, document.getRootElement());
  }

  private static void printXml(int indent, Element element) {
    @SuppressWarnings("unchecked")
    List<Element> elements = (List<Element>) element.elements();
    if (elements.isEmpty()) {
      print(indent, element.getName() + ": " + element.getTextTrim());
    } else {
      print(indent, element.getName());
    }
    for (Element e : elements) {
      printXml(indent + 1, e);
    }
  }

  private static void print(int indent, String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < indent; i++) {
      sb.append("  ");
    }
    sb.append(str);
    System.out.println(sb.toString());
  }

}
