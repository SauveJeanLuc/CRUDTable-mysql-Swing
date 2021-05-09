package withDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class DBUpdater {

    String conString = "jdbc:mysql://localhost:3306/yourDatabaseName";
    String username = "yourUserName";
    String password = "yourPassword";

    //INSERT INTO DB
    public Boolean add(String userProductCode, String userName, String userPrice) {
        //SQL STATEMENT
        String sql = "INSERT INTO products(productCode,name,price) VALUES('" + userProductCode + "','" + userName + "','" + userPrice + "')";

        try {
            //GET CONNECTION
            Connection con = DriverManager.getConnection(conString, username, password);

            // PREPARED STMT
            Statement s = con.prepareStatement(sql);

            s.execute(sql);

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //RETRIEVE DATA
    public DefaultTableModel getData() {
        //ADD COLUMNS TO TABLE MODEL
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("ID");
        dm.addColumn("Product Code");
        dm.addColumn("Position");
        dm.addColumn("Price");

        //SQL STATEMENT
        String sql = "SELECT * FROM products";

        try {
            Connection con = DriverManager.getConnection(conString, username, password);

            //PREPARED STMT
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES
                String id = rs.getString(1);
                String name = rs.getString(1);
                String pos = rs.getString(2);
                String team = rs.getString(3);

                dm.addRow(new String[]{id, name, pos, team});
            }

            return dm;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }

    //UPDATE DATA
    public Boolean update(String id, String name, String pos, String team) {
        //SQL STMT
        String sql = "UPDATE products SET Name ='" + name + "',Position='" + pos + "',Team='" + team + "' WHERE ID='" + id + "'";

        try {
            //GET COONECTION
            Connection con = DriverManager.getConnection(conString, username, password);

            //STATEMENT
            Statement s = con.prepareStatement(sql);

            //EXECUTE
            s.execute(sql);

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //DELETE DATA
    public Boolean delete(String id)
    {
        //SQL STMT
        String sql="DELETE FROM products WHERE ID ='"+id+"'";

        try
        {
            //GET COONECTION
            Connection con=DriverManager.getConnection(conString, username, password);

            //STATEMENT
            Statement s=con.prepareStatement(sql);

            //EXECUTE
            s.execute(sql);

            return true;

        }catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

}
