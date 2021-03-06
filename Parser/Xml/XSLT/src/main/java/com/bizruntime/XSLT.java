package com.bizruntime;

import java.io.*;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import org.apache.log4j.Logger;

public class XSLT {
static Logger log=Logger.getLogger("XSLT");
    public static void main(String[] args)
    {
        transformXMLToHtml();
    }
public static void transformXMLToHtml(){
try
        {
            TransformerFactory tFactory = TransformerFactory.newInstance();

            Source xslDoc = new StreamSource("src/main/resource/catalog.xsl");
            Source xmlDoc = new StreamSource("src/main/resource/catalog.xml");

            String outputFileName = "src/main/resource/catalog.html";
            OutputStream htmlFile = new FileOutputStream(outputFileName);

            Transformer transformer = tFactory.newTransformer(xslDoc);
            transformer.transform(xmlDoc, new StreamResult(htmlFile));
        }
        catch(Exception e)
        {
           log.error("Exception"+e.getMessage());
        }
}
}
