import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/**
 * Created by igor on 05-Jan-16.
 */
public class Runner {
    public static void main(String[] args) throws IOException, SAXException, TransformerConfigurationException {
        File xml = new File("C:/Users/igor/Desktop/git/pdf/src/main/resources/samples/014626.xml");
        File xslt = new File("C:/Users/igor/Desktop/git/pdf/src/main/resources/samples/017487-PB-RU.xsl");
        File pdfFile = new File("C:/Users/igor/Desktop/git/pdf/src/TseluikoCvv.pdf");

        FopFactory fopFactory = FopFactory.newInstance();
        fopFactory.setUserConfig(new File("C:/Users/igor/Desktop/git/pdf/src/main/resources/fop-config.xml"));

        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(pdfFile))) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xslt));
            transformer.setParameter("versionParam","2.0");

            Source src = new StreamSource(xml);
            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(src,res);
            System.out.println("PDF file created successfully!");
        }catch(Exception e) {
            System.err.println("Error while creating pdf: " + e);
        }
    }
}
