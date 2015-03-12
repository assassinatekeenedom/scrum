/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.organick.googlecharts.base.impl;

import com.organick.googlecharts.base.Row;
import java.util.List;

/**
 *
 * @author nkeene
 */
public class RowImpl implements Row {

    private List<String> columnValues;

    public RowImpl() {
    }

    public List<String> getColumnValues() {
        return columnValues;
    }

    public void setColumnValues(List<String> columnValues) {
        this.columnValues = columnValues;
    }
}
