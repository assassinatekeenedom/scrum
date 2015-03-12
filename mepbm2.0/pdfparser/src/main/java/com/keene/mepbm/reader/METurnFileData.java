package com.keene.mepbm.reader;

import com.keene.mepbm.core.Data;
import com.keene.pdfparser.mepbm.persistence.MEPersistence;

public abstract class METurnFileData extends Data<MEPersistence>{

    private METurnReaderData data;

    public METurnFileData(METurnReaderData data) {
        this.data = data;
    }

    public String getPath(){
        return data.getPath();
    }

    @Override
    public MEPersistence getPersistence() {
        return data.getPersistence();
    }

    @Override
    public void setPersistence(MEPersistence persistence){
        this.data.setPersistence(persistence);
    }
}
