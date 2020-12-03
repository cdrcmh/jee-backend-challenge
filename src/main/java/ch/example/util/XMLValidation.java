package ch.example.util;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.StringReader;

import org.xml.sax.SAXException;

public class XMLValidation {

    private static final String XSD_STRING = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" elementFormDefault=\"qualified\">\n" +
            "    <xs:element name=\"persons\">\n" +
            "        <xs:complexType>\n" +
            "            <xs:sequence>\n" +
            "                <xs:element maxOccurs=\"unbounded\" ref=\"person\"/>\n" +
            "            </xs:sequence>\n" +
            "        </xs:complexType>\n" +
            "    </xs:element>\n" +
            "    <xs:element name=\"person\">\n" +
            "        <xs:complexType>\n" +
            "            <xs:sequence>\n" +
            "                <xs:element ref=\"name\"/>\n" +
            "                <xs:element ref=\"gender\"/>\n" +
            "                <xs:element ref=\"age\"/>\n" +
            "            </xs:sequence>\n" +
            "        </xs:complexType>\n" +
            "    </xs:element>\n" +
            "    <xs:element name=\"name\" type=\"xs:string\"/>\n" +
            "    <xs:element name=\"gender\">\n" +
            "        <xs:simpleType>\n" +
            "            <xs:restriction base=\"xs:string\">\n" +
            "                <xs:enumeration value=\"m\"/>\n" +
            "                <xs:enumeration value=\"f\"/>\n" +
            "                <xs:enumeration value=\"t\"/>\n" +
            "            </xs:restriction>\n" +
            "        </xs:simpleType>\n" +
            "    </xs:element>\n" +
            "    <xs:element name=\"age\" type=\"xs:integer\"/>\n" +
            "</xs:schema>\n";


    public static boolean validateXMLSchema(String xmlString) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//            Schema schema = factory.newSchema(new File("fullstack-backend-challenge.xsd")); todo
            Schema schema = factory.newSchema(new StreamSource(new StringReader(XSD_STRING)));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(xmlString)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }

}
