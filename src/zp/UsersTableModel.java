package zp;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.sql.ResultSet;

public class UsersTableModel extends AbstractTableModel
{

    private int colnum = 4;
    private int rownum;
    
    private String colNames[] =
    {
        "ID пользователя" , "Имя пользователя" , "Пароль", "Уровень доступа"
    };
    
    private ArrayList<String[]> ResultSets;
    
    public UsersTableModel(ResultSet rs)
    {
        ResultSets = new ArrayList<>();
        try
        {
            while(rs.next())
            {
            String[] row = 
            {
                rs.getString("UserID"), rs.getString("UserName"),
                rs.getString("UserPass"), rs.getString("UserLevel")  
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
