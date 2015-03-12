package com.keene.mepbm.reader.pdf;

import com.keene.mepbm.reader.pdf.section.ArmiesAndNavies;
import com.keene.mepbm.reader.pdf.section.CharacterSummary;
import com.keene.mepbm.reader.pdf.section.Messages;
import com.keene.mepbm.reader.pdf.section.Miscellaneous;
import com.keene.mepbm.reader.pdf.section.NationMeta;
import com.keene.mepbm.reader.pdf.section.Orders;
import com.keene.mepbm.reader.pdf.section.PopCenters;
import com.keene.mepbm.reader.pdf.section.Relations;
import com.keene.mepbm.reader.pdf.section.TurnMarket;
import com.keene.mepbm.reader.pdf.section.TurnPDFSection;
import com.keene.mepbm.reader.file.MEFileProcess;

public class PDFProcessor<S extends TurnPDFSection> extends MEFileProcess<PDFReaderData, PDFProcessor, S> {

    public PDFProcessor() {
        this.addSection((S)new NationMeta());
        this.addSection((S)new Relations());
        this.addSection((S)new PopCenters());
        this.addSection((S)new ArmiesAndNavies());
        this.addSection((S)new TurnMarket());
        this.addSection((S)new Miscellaneous());
        this.addSection((S)new Messages());
        this.addSection((S)new Orders());
        this.addSection((S)new CharacterSummary());
    }

}
