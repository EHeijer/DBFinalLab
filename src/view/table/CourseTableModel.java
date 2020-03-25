package view.table;

import model.Course;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CourseTableModel extends AbstractTableModel {
    private List<Course> courses = new ArrayList<>();
    private String[] columnNames = {"Id", "Name", "Start date", "End date"};

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Course course = courses.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return course.getId();
            case 1:
                return course.getName();
            case 2:
                return course.getStartDate();
            case 3:
                return course.getEndDate();
            default:
                return null;
        }
    }

    @Override
    public int getRowCount() {
        return courses.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setData(List<Course> list) {
        courses = list;
        fireTableDataChanged();
    }
}
