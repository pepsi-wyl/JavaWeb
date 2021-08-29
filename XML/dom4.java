

package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import pojo.Person;

import java.util.List;

public class dom4j {


  /**
   * 利用  dom4j  解析XML数据
   */

  /**
   *    dom4j.jar maven配置文件
   *
   *    <dependency>
   *       <groupId>org.apache.directory.studio</groupId>
   *       <artifactId>org.dom4j.dom4j</artifactId>
   *       <version>1.6.1</version>
   *    </dependency>
   *
   */

  @Test
  public void dom4j_T() throws DocumentException {
    SAXReader saxReader = new SAXReader();

    //读取persons.xml文件  得到document对象
    Document document = saxReader.read("src/main/java/persons.xml");
    System.out.println(document);

    //通过document对象获取根元素
    Element rootElement = document.getRootElement();
    System.out.println(rootElement);

    //通过根元素获取person标签对象
    List<Element> persons = rootElement.elements("person");

    //遍历 处理每个person标签转化为person类
    persons.forEach((person) -> {
      Integer id = Integer.parseInt(person.attributeValue("id"));
      String name_1 = person.element("name").getText();
      String name_2 = person.elementText("name");
      System.out.println("Person1:" + new Person(id, name_1) + "   Person2:" + new Person(id, name_2));
    });

  }
}
