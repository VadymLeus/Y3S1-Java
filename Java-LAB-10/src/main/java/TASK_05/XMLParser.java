package TASK_05;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLParser {

    public static void readXML(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));

            document.getDocumentElement().normalize();
            NodeList teamList = document.getElementsByTagName("team");

            for (int i = 0; i < teamList.getLength(); i++) {
                Node teamNode = teamList.item(i);
                if (teamNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element teamElement = (Element) teamNode;
                    System.out.println("Team: " + teamElement.getAttribute("name"));

                    NodeList participants = teamElement.getElementsByTagName("participant");
                    for (int j = 0; j < participants.getLength(); j++) {
                        Node participantNode = participants.item(j);
                        if (participantNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element participantElement = (Element) participantNode;
                            String name = participantElement.getElementsByTagName("name").item(0).getTextContent();
                            String age = participantElement.getElementsByTagName("age").item(0).getTextContent();
                            System.out.println("  Participant: " + name + ", Age: " + age);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveXML(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("teams");
            document.appendChild(root);

            Element team = document.createElement("team");
            team.setAttribute("name", "Dragon");
            root.appendChild(team);

            Element participant = document.createElement("participant");
            team.appendChild(participant);

            Element name = document.createElement("name");
            name.setTextContent("Ivan");
            participant.appendChild(name);

            Element age = document.createElement("age");
            age.setTextContent("13");
            participant.appendChild(age);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

            System.out.println("XML saved to " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "teams.xml";
        saveXML(filePath);
        readXML(filePath);
    }
}
