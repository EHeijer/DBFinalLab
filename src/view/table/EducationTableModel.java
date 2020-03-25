package view.table;

import model.Education;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class EducationTableModel extends AbstractTableModel {
    private List<Education> educations = new ArrayList<>();
    private String[] columnNames = {"Id", "Name", "Start date", "End date"};

    public Object getValueAt(int rowIndex, int columnIndex) {
        Education education = educations.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return education.getId();
            case 1:
                return education.getName();
            case 2:
                return education.getStartDate();
            case 3:
                return education.getEndDate();
            default:
                return null;
        }
    }

    public int getRowCount() {
        return educations.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setData(List<Education> list) {
        educations = list;
        fireTableDataChanged();
    }
}
