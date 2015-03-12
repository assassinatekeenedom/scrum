package com.keene.mepbm.reader.xml;

import com.keene.mepbm.model.Game;
import com.keene.mepbm.reader.xml.section.Characters;
import com.keene.mepbm.reader.xml.section.TurnXMLSection;
import com.keene.mepbm.reader.file.MEFileProcess;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLProcessor<S extends TurnXMLSection> extends MEFileProcess<XMLReaderData, XMLProcessor, S> {

    public XMLProcessor() {
        this.addSection((S)new Characters());
    }

    @Override
    public void process() {     
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom = null;
        try {
            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            //parse using builder to get DOM representation of the XML file
            dom = db.parse(this.getData().getPath());
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }        
        this.getData().setDom(dom);
        super.process();
    }
}
