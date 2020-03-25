package view.table;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentTableModel extends AbstractTableModel {
    private List<Student> students = new ArrayList<>();
    private String[] studentsColumnNames = {"ID", "Name", "Birth date"};

    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return student.getId();
            case 1:
                return student.getName();
            case 2:
                return student.getBirthDate();
            default:
                return null;
        }
    }

    public int getRowCount() {
        return students.size();
    }

    public int getColumnCount() {
        return studentsColumnNames.length;
    }

    public String getColumnName(int column) {
        return studentsColumnNames[column];
    }

    public void setData(List<Student> list) {
        students = list;
        fireTableDataChanged();
    }
}
