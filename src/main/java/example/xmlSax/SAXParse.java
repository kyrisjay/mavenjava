package example.xmlSax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SAXParse {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //得到解析工厂
        SAXParserFactory sf = SAXParserFactory.newInstance();
        //获取SAX解析器
        SAXParser sp = sf.newSAXParser();
        MyHandler mh = new MyHandler();
        //对文件进行解析
        sp.parse("student.xml", mh);
        List list = mh.getList();
        for (Object o : list) {
            Student s = (Student) o;
            System.out.println(s.toString());
        }
    }

}
