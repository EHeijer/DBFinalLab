package view.table;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import model.Teacher;

public class TeacherTableModel extends AbstractTableModel {
    private List<Teacher> teachers = new ArrayList<>();
    private String[] teachersColumnNames = {"ID", "Name", "Birth date"};

    public Object getValueAt(int rowIndex, int columnIndex) {
        Teacher teacher  = teachers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return teacher.getId();
            case 1:
                return teacher.getName();
            case 2:
                return teacher.getBirthDate();
            default:
                return null;
        }
    }

    public int getRowCount() {
        return teachers.size();
    }

    public int getColumnCount() {
        return teachersColumnNames.length;
    }

    public String getColumnName(int column) {
        return teachersColumnNames[column];
    }

    public void setData(List<Teacher> list) {
        teachers = list;
        fireTableDataChanged();
    }
}
