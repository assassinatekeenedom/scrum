package com.keene.mepbm.pdfparser.reader.pdf;

import com.keene.mepbm.pdfparser.reader.file.MEFileProcess;
import com.keene.mepbm.pdfparser.sections.ArmiesAndNavies;
import com.keene.mepbm.pdfparser.sections.CharacterSummary;
import com.keene.mepbm.pdfparser.sections.Messages;
import com.keene.mepbm.pdfparser.sections.Miscellaneous;
import com.keene.mepbm.pdfparser.sections.NationMeta;
import com.keene.mepbm.pdfparser.sections.Orders;
import com.keene.mepbm.pdfparser.sections.PopCenters;
import com.keene.mepbm.pdfparser.sections.Relations;
import com.keene.mepbm.pdfparser.sections.TurnMarket;
import com.keene.mepbm.pdfparser.sections.TurnPDFSection;

public class PDFProcessor<S extends TurnPDFSection> extends MEFileProcess<PDFReaderData, PDFProcessor, S> {

    public PDFProcessor() {
        this.addSection((S) new NationMeta());
        this.addSection((S) new Relations());
        this.addSection((S) new PopCenters());
        this.addSection((S) new ArmiesAndNavies());
        this.addSection((S) new TurnMarket());
        this.addSection((S) new Miscellaneous());
        this.addSection((S) new Messages());
        this.addSection((S) new Orders());
        this.addSection((S) new CharacterSummary());
    }
}
