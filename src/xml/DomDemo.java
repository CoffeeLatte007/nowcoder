package xml;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Dom解析，构建一个驻留内存的树结构
 * Created by lizhaoz on 2016/3/31.
 */

public class DomDemo implements XmlDocument {
    private Document document;
    private String fileName;
    public  void init(){
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            this.document=  builder.newDocument();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void createXml(String fileName) {
        Element root=this.document.createElement("example.xml");
        this.document.appendChild(root);
    }

    @Override
    public void parserXml(String fileName) {

    }
}
