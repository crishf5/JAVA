import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //Creamos DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("Empleados.xml"));
        //Siempre hay que normalizarlo
        document.getDocumentElement().normalize();

        //Extraemos el nodo raiz
        //Element es empleados y luego cada empleado
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName()); //empleados

        //Para transformarlo en JAVA -> NodeList
        NodeList nList = document.getElementsByTagName("empleado");
        System.out.println("======================================");
        System.out.println(nList.getLength());
        //Para realizar recorrido completo, por elemento
        //Se mete en un nodo y se transforma a elemento
        Node nodo;
        for(int i=0; i<nList.getLength();i++){
            nodo = nList.item(i);
            System.out.println("Inicio del empleado");
            System.out.println("");

            if(nodo.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) nodo;
                System.out.println("Su id es: "+element.getAttribute("id"));
                System.out.println("Nombre: "+element.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("Apellido "+element.getElementsByTagName("apellido").item(0).getTextContent());
                System.out.println("-------------");
                System.out.println("Ciudad: "+element.getElementsByTagName("ciudad").item(0).getTextContent());
                System.out.println("==============================");

                //Añadir datos según "si pertenede a Madrid di X"
                if(element.getElementsByTagName("ciudad").item(0).getTextContent().equals("Madrid")){
                    System.out.println("Gato");
                }
            }

        }
    }
}

