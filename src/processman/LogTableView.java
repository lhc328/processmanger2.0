/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processman;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author kOX
 */
public class LogTableView {

    public TableView addTableView() {
        TableView table = new  TableView();
        
//        TableColumn timeCol = new TableColumn("run-time");
//        timeCol.setMinWidth(50);
//        timeCol.setCellValueFactory(new PropertyValueFactory<>("runtime"));
        
        TableColumn nameCol = new TableColumn("process-name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
//        TableColumn statusCol = new TableColumn("status");
//        statusCol.setMinWidth(80);
//        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        TableColumn prCol = new TableColumn("priority");
        prCol.setMinWidth(55);
        prCol.setCellValueFactory(new PropertyValueFactory<>("priority"));
        
        TableColumn startCol = new TableColumn("s-time");
        startCol.setMinWidth(90);
        startCol.setCellValueFactory(new PropertyValueFactory<>("starttime"));
        
        TableColumn endCol = new TableColumn("r-time");
        endCol.setMinWidth(80);
        endCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        
        //table.getColumns().addAll(timeCol, nameCol, statusCol, prCol, startCol, endCol);
        table.getColumns().addAll(nameCol, prCol, startCol, endCol);
        return table;
    }
    
}
