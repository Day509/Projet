package test;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCellColor {
    class ColoredCell {
        int row;
        int column;
        Color color;

        ColoredCell(int row, int column, Color color) {
            this.row = row;
            this.column = column;
            this.color = color;
        }

        private final Vector<ColoredCell> coloredCells = new Vector<>();

        public void setCellColor(JTable table, int row, int column, Color color) {
            coloredCells.add(new ColoredCell(row, column, color));

            table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int rowIndex, int columnIndex) {
                    Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                            rowIndex, columnIndex);

                    for (ColoredCell cell : coloredCells) {
                        if (cell.row == rowIndex && cell.column == columnIndex) {
                            cellComponent.setBackground(cell.color);
                            return cellComponent;
                        }
                    }

                    cellComponent.setBackground(table.getBackground());
                    return cellComponent;
                }
            });

            table.repaint();
        }
    }
}