package javafx;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TXT extends Application {
    private String[] bt = {"文件(F)","编辑(E)","格式(O)","查看(V)","帮助(H)"};
    private HBox hBox = new HBox(15);
    private TextArea taNote = new TextArea();
    private String[][] inbt = {{"新建(N)     Ctrl+N","打开(O)...  Ctrl+O","保存(S)      Ctrl+S","页面设置(U)...       ","打印(O)...   Ctrl+P","退出(X)                "},
    		{"撤销(U)     Ctrl+Z","剪切(T)     Ctrl+X","复制(C)     Ctrl+C","粘贴(P)     Ctrl+V","删除(L)           Del","查找(F)...    Ctrl+F",
    	"查找下一个(N) F3","替换(R)...  Ctrl+H","转到(G)...  Ctrl+G","全选(A)     Ctrl+A","时间/日期(D)    F5"},
    		{"   自动换行(W)    ","     字体(F)...        "},{"    状态栏(H)     "},{"   查看帮助(H)     ","   关于记事本(A)  "}};
    
    BorderPane pane = new BorderPane();
    FlowPane fPane = new FlowPane();
    Pane paneOfFont = new Pane();
    
    int iF,iE,iO,iV,iH = 1;
    
    public TXT(){
	    hBox.setPadding(new Insets(0,0,0,0));
	    for(int i = 0;i<bt.length;i++) {
	    	hBox.getChildren().add(new Button(bt[i]));
	    }
	    hBox.setStyle("-fx-border-color:white");
		
        taNote.setPrefColumnCount(20);
	    taNote.setPrefRowCount(20);
        taNote.setWrapText(false);/*文本区域内不自动换行*/
        taNote.setEditable(true);
        taNote.setStyle("-fx-text-fill:blue");
        taNote.setFont(Font.font("Times",20));
       
        
        pane.setTop(hBox);
        pane.setCenter(taNote);
        
        pane.setMaxWidth(200);
        pane.setMaxHeight(200);
          
        pane.getChildren().add(fPane);
        
        action(hBox);//执行按钮动作
    }
    
    
    public void setPlay(Button b) {
    	String s = "";
    	s+= b.getText();
   //     int iF,iE,iO,iV,iH = 1;
    	switch(s) {
    	case "文件(F)":
    		b.setOnAction(e -> {
    		    fPane.getChildren().clear();//执行其他动作时，不显示fPane面板
    			showPane(0);
        		inFpane();
        		iF++;
    		});
    	              break;
    	case "编辑(E)":b.setOnAction(e->{
    		fPane.getChildren().clear();
    		showPane(1);
    		inFpane();});
    		          break;
    	case "格式(O)":b.setOnAction(e->{
    		fPane.getChildren().clear();
    		showPane(2);
    		inFpane();});
    	              break;
    	case "查看(V)":b.setOnAction(e->{
    		fPane.getChildren().clear();
    		showPane(3);
    		inFpane();});
    	              break;
    	case "帮助(H)":b.setOnAction(e->{
    		fPane.getChildren().clear();
    		showPane(4);
    		inFpane();});
    	              break;
    	}
    }
    
    public void showPane(int index) {
    	fPane.setOrientation(Orientation.HORIZONTAL);
    	fPane.setVgap(0);
    	for(int i = 0;i<inbt.length;i++) {
    		if(i == index) {
    			for(int j = 0;j<inbt[index].length;j++) {//如果选择了自动换行按钮则显示   √  自动换行(W)   
    				if((inbt[index][j]).equals("   自动换行(W)    ") && taNote.isWrapText()) {
    					fPane.getChildren().add(new Button("√  自动换行(W)   "));
    		    	}
    				else {
    					fPane.getChildren().add(new Button(inbt[index][j]));
    				}
    			}
    			break;
    		}
    	}
    	
    	fPane.setStyle("-fx-background-color:lightgray");
    	fPane.setLayoutX(71*index);
    	fPane.setLayoutY(25);
  
    }
    
    public void action(HBox hb) {
    	for(int i = 0;i<hb.getChildren().size();i++) {
         //对基本类型值进行转换，hb.getChildren().get(i)得到Node类型
    		Button b = (Button)(hb.getChildren().get(i));
    		setPlay(b);
    	}
    }
    
    public void inFpane() {
    	for(int i = 0;i<fPane.getChildren().size();i++) {
    		Button b = (Button)(fPane.getChildren().get(i));
    		setInFpane(b);
    	}
    }
    
    public void setInFpane(Button b) {
    	String s = "";//最好把要执行的动作都放在b.setOnAction上，因为循环遍历时会执行其他动作，引起不必要错误
    	s+=b.getText();
    	s = s.trim();
    	switch(s) {
    	case "自动换行(W)":
    	    b.setOnAction(e->{
    		//    b.setText("√   自动换行(W)  ");
    		    taNote.setWrapText(true);
    		    fPane.getChildren().clear();
    	    });
    	                break;
    	case "√  自动换行(W)":
    		b.setOnAction(e->{
    	    //	b.setText("    自动换行(W)  ");
    	        taNote.setWrapText(false);
    	    	fPane.getChildren().clear();
    		});
    		            break;
    	case "字体(F)...":b.setOnAction(e->{
    		                showScene();
    		                fPane.getChildren().clear();
    	});             break;
    	case "查看帮助(H)":b.setOnAction(e->{
    		            
    		            fPane.getChildren().clear();
    	}); 
    		            break;
    	case "时间/日期(D)    F5":b.setOnAction(e->{
    		            Date date = new Date();
    		            taNote.positionCaret(2);
    		         // taNote.setText(date.toString()+taNote.getText());
    		            taNote.appendText(date.toString());
    		            fPane.getChildren().clear();
    	}); 
    		            break;
    	}
    		
    }
    
    public void showScene() {
    	Pane paneOfFont = new Pane();
		BorderPane paneOfText = new BorderPane();
	  
		VBox vbF = new VBox(0);
		VBox vbY = new VBox(0);
		VBox vbS = new VBox(0);
		HBox hbButton = new HBox(20);
		
		String[] font = {"楷体","隶书","宋体","微软雅黑","新宋体","幼圆"};
		String[] stringY = {"常规","倾斜","粗体","粗偏斜体"};
		String[] size = {"一号","二号","三号","四号","五号","六号"};
		
		TextField tfF = new TextField();
		TextField tfY = new TextField();
		TextField tfS = new TextField();
		Label lbF = new Label("字体(F):",tfF);
		Label lbY = new Label("字形(Y):",tfY);
		Label lbS = new Label("大小(S):",tfS);
		lbF.setContentDisplay(ContentDisplay.BOTTOM);
		lbY.setContentDisplay(ContentDisplay.BOTTOM);
		lbS.setContentDisplay(ContentDisplay.BOTTOM);
	
		TextField text1 = new TextField("你好赵妍");
		text1.setAlignment(Pos.CENTER);
		text1.setEditable(false);
		text1.setStyle("-fx-background-color:transparent;-fx-border-color:lightgray;");
	
		
		Label example = new Label("示例");
		ComboBox<String> cbo = new ComboBox<>();
		cbo.getItems().addAll("中文","西欧语言","日语","希腊语");
		cbo.setStyle("-fx-background-color:white");
		Label jiaoben = new Label("脚本(R):",cbo);
		jiaoben.setContentDisplay(ContentDisplay.BOTTOM);
		paneOfText.setTop(example);
		paneOfText.setCenter(text1);
		paneOfText.setBottom(jiaoben);
		
	/*	BorderPane.setAlignment(example, Pos.TOP_LEFT);
		BorderPane.setAlignment(text1, Pos.CENTER_LEFT);
		BorderPane.setAlignment(jiaoben, Pos.BOTTOM_LEFT);
	*/	
		
		ListView<String> lvF = new ListView<>(FXCollections.observableArrayList(font));
		ListView<String> lvY = new ListView<>(FXCollections.observableArrayList(stringY));
		ListView<String> lvS = new ListView<>(FXCollections.observableArrayList(size));
       
		Button btR = new Button("确定");
		Button btC = new Button("取消");
	
		vbF.getChildren().addAll(lbF,lvF);
		vbY.getChildren().addAll(lbY,lvY);
		vbS.getChildren().addAll(lbS,lvS);
		hbButton.getChildren().addAll(btR,btC);
		
		tfF.setPrefWidth(200);//设置节点宽度
		lvF.setPrefWidth(200);
		tfY.setPrefWidth(150);
		lvY.setPrefWidth(150);
		tfS.setPrefWidth(60);
		lvS.setPrefWidth(60);
		cbo.setPrefWidth(220);
	  //text1.setPrefWidth(220);
		text1.setMaxWidth(230);
		text1.setPrefHeight(150);
		
		vbF.setPrefSize(200, 180);//设置面板长宽
		vbY.setPrefSize(150, 180);
		vbS.setPrefSize(60, 150);
		paneOfText.setPrefSize(230, 150);
		hbButton.setPrefSize(100, 50);
		
		vbF.setLayoutX(10);//设置面板位置
		vbF.setLayoutY(20);
		vbY.setLayoutX(220);
		vbY.setLayoutY(20);
		vbS.setLayoutX(380);
		vbS.setLayoutY(20);
		paneOfText.setLayoutX(220);
		paneOfText.setLayoutY(220);
		hbButton.setLayoutX(340);
		hbButton.setLayoutY(430);
		
		paneOfFont.getChildren().addAll(vbF,vbY,vbS,paneOfText,hbButton);
    
	    lvF.getSelectionModel().selectedItemProperty().addListener(
	    		ov->{
	    			String s = "";
	    			for(Integer i:lvF.getSelectionModel().getSelectedIndices()) {
	    				s+=lvF.getSelectionModel().getSelectedItem();
	    				switch(s) {
	    				case "楷体":text1.setFont(Font.font("KaiTi"));
	                        break;
	    				case "隶书":text1.setFont(Font.font("Dialog"));
	    					break;
	    				case "宋体":text1.setFont(Font.font("SongTi"));
	    					break;
	    				}
	    			}
	    			tfF.setText(s);
	    		});
	    
	    lvY.getSelectionModel().selectedItemProperty().addListener(
	    		ov->{
	    			String s = "";
	    			for(Integer i:lvY.getSelectionModel().getSelectedIndices()) {
	    				s+=lvY.getSelectionModel().getSelectedItem();
	    				switch(s) {
	    				case "常规":text1.setFont(Font.font(text1.getFont().getName(),FontPosture.REGULAR,text1.getFont().getSize()));
	    					break;
	    				case "倾斜":text1.setFont(Font.font(text1.getFont().getName(), FontPosture.ITALIC, text1.getFont().getSize()));
	    					break;
	    				case "粗体":text1.setFont(Font.font(text1.getFont().getName(), FontWeight.BOLD, text1.getFont().getSize()));
	    					break;
	    				case "粗偏斜体":text1.setFont(Font.font(text1.getFont().getName(), FontWeight.BOLD, FontPosture.ITALIC,text1.getFont().getSize()));
	    					break;
	    				}
	    			}
	    			tfY.setText(s);
	    		});
	    
	    lvS.getSelectionModel().selectedItemProperty().addListener(
	    		ov->{
	    			String s = "";
	    			for(Integer i:lvS.getSelectionModel().getSelectedIndices()) {
	    				s+=lvS.getSelectionModel().getSelectedItem();
	    				switch(s) {
	    				case "一号":text1.setFont(Font.font(8));
	    					break;
	    				case "二号":text1.setFont(Font.font(10));
	    					break;
	    				case "三号":text1.setFont(Font.font(12));
	    					break;
	    				case "四号":text1.setFont(Font.font(14));
	    					break;
	    				case "五号":text1.setFont(Font.font(16));
	    					break;
	    				case "六 号":text1.setFont(Font.font(20));
	    					break;
	    				}
	    			}
	    			tfS.setText(s);
	    		});
	    Stage secondStage = new Stage();
	    Scene sceneFont = new Scene(paneOfFont);
	    secondStage.setScene(sceneFont);
	    secondStage.setTitle("字体");        
	    secondStage.show();  
	    
	    btR.setOnAction(e->{
	    	taNote.setFont(text1.getFont());
	    	secondStage.close();
	    });
	    btC.setOnAction(e->{
	    	secondStage.close();
	    });
    }
    
    
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(pane,500,500);
		primaryStage.setTitle("java记事本");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
   
}

