package com.ccit.servlet;

import java.util.LinkedList;
import java.util.List;

public class TableDataRow {
    private LinkedList<TableDataCell> cells;
    private TableData table;

    public void addCell(TableDataCell cell){
        cells.add(cell);
    }

    public void addCell(String value){
        TableDataCell cell = new TableDataCell(this);
        cell.setValue(value);
        addCell(cell);
    }

    public void addCell(int value){
        TableDataCell cell = new TableDataCell(this);
        cell.setValue(value);
        addCell(cell);
    }

    public void addCell(double value){
        TableDataCell cell = new TableDataCell(this);
        cell.setValue(value);
        addCell(cell);
    }

    public TableDataCell getCellAt(int index){
        return cells.get(index);
    }

    public List<TableDataCell> getCells() {
        return cells;
    }

    public TableData getTable() {
        return table;
    }

    public TableDataRow(TableData table){
        cells = new LinkedList<TableDataCell>();
        this.table = table;
    }
    public void clear(){
        for (TableDataCell tableDataCell : cells) {
            tableDataCell.clear();
        }
        cells.clear();
        table = null;
    }
}

