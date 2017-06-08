package com.ccit.servlet;

import java.util.LinkedList;
import java.util.List;

public class TableData {
    private TableHeaderMetaData header;
    private LinkedList<TableDataRow> rows;
    private int totalRows;

    public TableData(TableHeaderMetaData header){
        this.header = header;
        rows = new LinkedList<TableDataRow>();
    }

    public TableHeaderMetaData getTableHeader(){
        return header;
    }

    public void addRow(TableDataRow row){
        rows.add(row);
    }

    public List<TableDataRow> getRows(){
        return rows;
    }

    public TableDataRow getRowAt(int index){
        return rows.get(index);
    }

    public int getRowCount(){
        return rows.size();
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }
    public void clear() {
        for (TableDataRow tableDataRow : rows) {
            tableDataRow.clear();
        }
        rows.clear();
    }
}

