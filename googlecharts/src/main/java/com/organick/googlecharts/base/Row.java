/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.organick.googlecharts.base;

import java.util.List;

/**
 *
 * @author nkeene
 */
public interface Row {

    public List<String> getColumnValues();

    public void setColumnValues(List<String> columnValues);

}
