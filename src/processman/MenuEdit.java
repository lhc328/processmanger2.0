/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processman;



import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;



/**
 *
 * @author kOX
 */
public class MenuEdit {
    public static int style = 1;
    public MenuBar addMenu(){
        MenuBar menuBar = new MenuBar();
        Menu menuEdit = new Menu("Edit");
        MenuItem rrm = new MenuItem("时间片调度");
        rrm.setOnAction((e)->{
            style=1;
        });
        MenuItem pfm = new MenuItem("优先数优先");
        pfm.setOnAction((e)->{
            style=2;
        });
        MenuItem spnm = new MenuItem("最短进程优先");
        spnm.setOnAction((e)->{
            style=3;
        });
        MenuItem srtm = new MenuItem("最短剩余时间优先");
        srtm.setOnAction((e)->{
            style=4;
        });
        menuEdit.getItems().addAll(rrm, pfm, spnm, srtm);

        Menu menuHelp = new Menu("Help");

        MenuItem about = new MenuItem("about");

        MenuItem instruction = new MenuItem("说明书");

        menuHelp.getItems().addAll(about, instruction);

        menuBar.getMenus().addAll(menuEdit, menuHelp);
        return menuBar;
    }
    
}
