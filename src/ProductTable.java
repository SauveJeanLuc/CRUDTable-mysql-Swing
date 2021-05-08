import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import java.awt.*;

public class ProductTable extends JFrame
{
    public ProductTable()
    {
        //headers for the table
        String[] columns = new String[] {
                "Product Name", "Product Description", "Points", "Price", "Quantity", "Action"
        };

        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
                {"Donut", "for Eating", 40.0, 100, 243, false},
                {"Donut", "for Eating", 40.0, 100, 243, false},
                {"Donut", "for Eating", 40.0, 100, 243, false},
                {"Donut", "for Eating", 40.0, 100, 243, false},
                {"Donut", "for Eating", 40.0, 100, 243, false},
                {"Donut", "for Eating", 40.0, 100, 243, false},
                {"Donut", "for Eating", 40.0, 100, 243, false}
        };
        //create table with data
        JTable table = new JTable(data, columns);
        table.setBackground(Color.green);

        //add the table to the frame
        this.add(new JScrollPane(table));

        this.setTitle("Products");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductTable();
            }
        });
    }
}