package com.keene.mepbm.reader.xml;

import com.keene.mepbm.reader.*;
import com.keene.mepbm.reader.pdf.PDFReaderData;
import java.util.HashSet;
import java.util.Set;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReaderData extends METurnFileData {

    private PDFReaderData pdfData;
    private Document dom;

    public XMLReaderData(METurnReaderData data) {
        super(data);
    }
    
    @Override
    public String getPath(){
        return super.getPath()+".xml";
    }

    public Document getDom() {
        return dom;
    }

    public void setDom(Document dom) {
        this.dom = dom;
    }

    public Set<Element> getElements(String element) {
        //get the root element
        Element docEle = this.getDom().getDocumentElement();
        Set<Element> elements = new HashSet<Element>();
        //get a nodelist of  elements
        NodeList nl = docEle.getElementsByTagName(element);
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                elements.add((Element) nl.item(i));
            }
        }
        return elements;
    }

    public NodeList getElements(Element element, String name) {
        return element.getElementsByTagName(name);
    }

    public String getTextValue(Element ele, String tagName) {
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
        }

        return textVal;
    }

    public int getIntValue(Element ele, String tagName) {
        //in production application you would catch the exception
        return Integer.parseInt(getTextValue(ele, tagName));
    }

    public String getTextValue(Node node) {
        return node.getFirstChild().getNodeValue();
    }

    public int getIntValue(Node node) {
        return Integer.parseInt(getTextValue(node));
    }

    public PDFReaderData getPdfData() {
        return pdfData;
    }

    public void setPdfData(PDFReaderData pdfData) {
        this.pdfData = pdfData;
    }

}
