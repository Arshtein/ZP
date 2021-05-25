package zp;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.sql.ResultSet;

public class StaffTableModel extends AbstractTableModel
{

    private int colnum = 6;
    private int rownum;
    
    private String colNames[] =
    {
        "Табельный номер" , "Фамилия" , "Имя", "Отчество", "Отдел", "Должность"
    };
    
    private ArrayList<String[]> ResultSets;
    
    public StaffTableModel(ResultSet rs)
    {
        ResultSets = new ArrayList<>();
        try
        {
            while(rs.next())
            {
            String[] row = 
            {
                rs.getString("TabN"), rs.getString("F"),
                rs.getString("I"), rs.getString("O"),
                rs.getString("Otdel"), rs.getString("Position")
            };
            ResultSets.add(row);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in UsersTableModel");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        String[] row = ResultSets.get(rowIndex);
        return row[columnIndex];        
    }
    
    @Override
    public int getRowCount() 
    {
        return ResultSets.size();
    }

    @Override
    public int getColumnCount() 
    {
        return colnum;
    }
    
    @Override
    public String getColumnName(int param)
    {
        return colNames[param];
    }
}
