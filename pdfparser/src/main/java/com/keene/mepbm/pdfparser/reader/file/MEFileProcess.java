package com.keene.mepbm.pdfparser.reader.file;

import com.keene.mepbm.core.Section;
import com.keene.mepbm.core.Process;
import com.keene.mepbm.pdfparser.reader.METurnFileData;

public abstract class MEFileProcess<D extends METurnFileData, M extends MEFileProcess, S extends Section> extends Process<D, M, S> {

    public MEFileProcess() {
    }
}
