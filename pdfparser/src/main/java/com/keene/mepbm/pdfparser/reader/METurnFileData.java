package com.keene.mepbm.pdfparser.reader;

import com.keene.mepbm.core.Data;

public abstract class METurnFileData extends Data {

    private METurnReaderData data;

    public METurnFileData(METurnReaderData data) {
        this.data = data;
    }

    public String getPath() {
        return data.getPath();
    }
}
