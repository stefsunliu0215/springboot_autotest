package com.liu.bean;

/**
 * @ClassName: CellModel
 * @Description: 单元格实体类
 * @Author: 52945
 * @Date: 2020/1/9 10:21
 * @Version: 1.0
 */
public class CellModel {

    private int row;

    private int column;

    private String value;

    public CellModel() {
    }

    public CellModel(int row, int column, String value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
