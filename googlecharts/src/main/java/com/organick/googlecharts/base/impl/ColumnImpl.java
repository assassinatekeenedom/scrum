/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.organick.googlecharts.base.impl;

import com.organick.googlecharts.base.Column;
/**
 *
 * @author nkeene
 */
public class ColumnImpl implements Column{

    private String columnType;
    private String columnName;

    public ColumnImpl() {
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
        
}
