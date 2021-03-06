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
public class PCBTableView {
    public TableView addTableView(){
        TableView table = new TableView();
    
        
        TableColumn nameCol = new TableColumn("process-name");
        nameCol.setMinWidth(120);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn statusCol = new TableColumn("status");
        statusCol.setMinWidth(60);
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        TableColumn prCol = new TableColumn("priority");
        prCol.setMinWidth(70);
        prCol.setCellValueFactory(new PropertyValueFactory<>("priority"));
        
        TableColumn etimeCol = new TableColumn("time");
        etimeCol.setMinWidth(60);
        etimeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        TableColumn stimeCol = new TableColumn("start-name");
        stimeCol.setMinWidth(80);
        stimeCol.setCellValueFactory(new PropertyValueFactory<>("starttime"));
        
        
        
        table.getColumns().addAll(nameCol, statusCol, prCol,etimeCol, stimeCol);     
        return table;
    }
}
