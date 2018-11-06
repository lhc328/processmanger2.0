/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processman;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author koy
 */
public class ErrorWin {

    public static void errorShow(String message) {
        Stage stg = new Stage();//创建舞台；
        stg.setTitle("错误信息");
        Group root = new Group();
        Scene scene = new Scene(root,250,100);
        Text error = new Text(50,50,message);
        root.getChildren().add(error);
        stg.setScene(scene); //将场景载入舞台；
        stg.show();
    }
}
