package zp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class pHTableModel extends AbstractTableModel
{
    
    private int colnum = 3;
    private int rownum;
    
    private String colNames[] =
    {
        "Табельный номер" , "Период" , "Размер"
    };
    
    private ArrayList<String[]> ResultSets;
    
    public pHTableModel(ResultSet rs)
    {
        ResultSets = new ArrayList<>();
        try
        {
            while(rs.next())
            {
            String[] row = 
            {
                rs.getString("TabN"), rs.getString("Period"),
                rs.getString("Razmer")
            };
            ResultSets.add(row);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in TableModel: " + e);
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
