package zp;
import java.io.IOException;
import java.sql.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Connect 
{
    private Connection myConn;
    private String url,name,pass;
    public Connect() {}
    
    private void ConnectInfo() throws ParserConfigurationException, SAXException, IOException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("Config.xml");
        NodeList ConfItems = doc.getDocumentElement().getElementsByTagName("connect");
        Node conf = ConfItems.item(0);
        NamedNodeMap attr = conf.getAttributes();
        url = attr.getNamedItem("url").getNodeValue();
        name = attr.getNamedItem("name").getNodeValue();
        pass = attr.getNamedItem("pass").getNodeValue();
    }
    
    public void init() throws ParserConfigurationException, SAXException, IOException
    {
        try
        {
            ConnectInfo();
            //myConn = DriverManager.getConnection("jdbc:mysql://localhost/zp", "root", "1234");
            myConn = DriverManager.getConnection(url, name, pass);
            
        }
        catch(SQLException e)
        {
            System.out.println("Connect error: " + e);
        }
    }
    
    public Connection getMyConnect()
    {
        return myConn;
    }
    
    public void close(ResultSet rs)
    {
        if(rs != null)
        {
            try
            {
                rs.close();
            }
            catch(SQLException e)
            {
                System.out.println("Close error rs: " + e);
            }
        }
    }
    
    public void close(Statement stmt)
    {
        if(stmt != null)
        {
            try
            {
                stmt.close();
            }
            catch (SQLException e)
            {
                System.out.println("Close error stmt: " + e);
            }
        }
    }
    
    public void destroy()
    {
        if(myConn != null)
        {
            try
            {
                myConn.close();
            }
            catch (SQLException e)
            {
                System.out.print("Close error connect: " + e);
            }
        }
    }
}
