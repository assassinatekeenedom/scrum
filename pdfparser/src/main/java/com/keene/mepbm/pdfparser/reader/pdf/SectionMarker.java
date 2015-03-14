package com.keene.mepbm.pdfparser.reader.pdf;

public enum SectionMarker {
    
    MARKET_PRICES ("MARKET PRICES");

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
    
    private String section;
    
    SectionMarker(String section) {
        this.section = section;
    }

}
