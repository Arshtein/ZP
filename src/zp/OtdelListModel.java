package zp;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.sql.ResultSet;

public class OtdelListModel extends AbstractTableModel
{
    private int colnum = 3;
    private int rownum;
    
    private String colNames[] =
    {
        "Код профессии" , "Отдел" , "Должность"
    };
    
    private ArrayList<String[]> ResultSets;
    
    public OtdelListModel(ResultSet rs)
    {
        ResultSets = new ArrayList<>();
        try
        {
            while(rs.next())
            {
            String[] row = 
            {
                rs.getString("ID"), rs.getString("Otdel"),
                rs.getString("Position")
            };
            ResultSets.add(row);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in TableModel" + e);
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
