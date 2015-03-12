package com.keene.mepbm.reader;

import com.keene.mepbm.core.Data;
import com.keene.pdfparser.mepbm.persistence.MEPersistence;

public class METurnReaderData extends Data<MEPersistence>{
    
    private MEPersistence persistence;
    private String path;

    public METurnReaderData() {        
    }

    @Override
    public MEPersistence getPersistence() {
        return this.persistence;
    }

    @Override
    public void setPersistence(MEPersistence persistence) {
        this.persistence = persistence;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
