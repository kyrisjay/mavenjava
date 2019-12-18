package example.xmlSax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {
    private List list;
    private Student st;
    private String s;

    public List getList() {
        return list;
    }

    @Override
    public void startDocument() throws SAXException {
        //当你开始解析文档的时候创建集合
        list = new ArrayList<>();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("结束解析...");
    }

    @Override  //开始标签
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("---->>" + qName);
        if (qName != null) {
            s = qName;
            if (qName.equals("student")) {
                st = new Student();
            }
        }
    }

    @Override    //结束标签
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName != null) {
            if (qName.equals("student")) {
                list.add(st);
            }
        }
        s = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        if (s != null) {
            if (s.equals("name")) {
                st.setName(str);
            }
            if (s.equals("age")) {
                st.setAge(Integer.valueOf(str));
            }
            if (s.equals("address")) {
                st.setAddress(str);
            }
        }

    }
}
