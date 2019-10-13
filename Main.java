package application;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
class transac_not_allowed extends Exception
{
	public String toString()
	{
		return "Transaction not allowed";
	}
}
public class Main extends Application {
    public Statement statement;
    int i = 0;
    public Button buttonv = new Button("Display details"); 
    public Button buttonc = new Button("Clear");
    public GridPane gridPane = new GridPane();
    public GridPane r = new GridPane();
    public Text text0 = new Text("Account ID");
    public Text text00 = new Text("Password");
    public TextField text0i = new TextField();
    public PasswordField text00p = new PasswordField();
    public Text msg = new Text("");
    public Text text1 = new Text("Account ID");       
    public Text text2 = new Text("Amount");
    public Text text3 = new Text("Balance");
    public Text vu = new Text("");
    public Text vp = new Text("");
    public TextField id = new TextField();
    public TextField first = new TextField();
    public TextField middle = new TextField();
    public Text passw = new Text("Password");
    public PasswordField passwt = new PasswordField();
    public Text sf = new Text();
    public TextField id3 = new TextField();
    public TextField name = new TextField();
    public TextField dob = new TextField();
    public TextField address = new TextField();
    public TextField phone = new TextField();
    public TextField aadhar = new TextField();
    public TextField email = new TextField();
    public Text val = new Text(" Enter The Details...");
    Button bl = new Button("Close Account");
    Button bv = new Button("Deposit");
    Button be = new Button("Withdraw");
    Button bu = new Button("View balance");
    Button ba = new Button("Go Back");
    Button button1 = new Button("Insert Values");
    Button bmai = new Button("Clear");
    
    Label button2;
    public Stage s2;
    public Stage s3;
    public Stage s4;
    public Stage primaryStage;
    public void start(Stage primaryStage) {
       DBConnect();
       primaryStage.setTitle("Banking Management System");
       Button b = new Button("Login");
       Button b1 = new Button("Register");
       EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	int id1 = Integer.parseInt(text0i.getText());
            	String p = text00p.getText();
           	 	int amount=0;
         		try {
                    String insertquery = "select * from det where pass = '"+p+"'";
                    ResultSet result = statement.executeQuery(insertquery);
                    if(result.next()){
                    	s2=new Stage();
                    	Scene scene = new Scene(gridPane);
                        s2.setScene(scene);
                        s2.setTitle("Welcome");
                        s2.show();
                        primaryStage.hide();
                      }
                    else
                    {
                    	System.out.println("Invalid ID");
                    	val.setText("Invalid Credentials..!!");
                    }
                    
                } catch (SQLException ex) {
                    msg.setText("Problem to Show Data");
                }
            } 
        };
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                s3=new Stage();
            	GridPane grid = new GridPane();
            	Scene scene = new Scene(grid);
                s3.setScene(scene);
                s3.setTitle("Perform any operations");
                Text text1 = new Text("Account ID");       
                Text text2 = new Text("Name");
                Text text3 = new Text("Enter Minimum Balance ");
                Text text5 = new Text("Address");
                Text text6 = new Text("Phone number");
                Text text8 = new Text("Aadhar");
                Text text9 = new Text("Email");
                button2 = new Label("Values Not Inserted");  
                grid.setMinSize(600, 600); 
                grid.setPadding(new Insets(10, 10, 10, 10)); 
                grid.setVgap(5); 
                grid.setHgap(5);     
                grid.setAlignment(Pos.CENTER); 
                grid.add(text1, 0, 0); 
                grid.add(id3, 1, 0); 
                grid.add(text2, 0, 1);       
                grid.add(name, 1, 1); 
                grid.add(text3, 0, 2); 
                grid.add(dob, 1, 2); 
                grid.add(text5, 0, 4); 
                grid.add(address, 1, 4); 
                grid.add(text6, 0, 5);       
                grid.add(phone, 1, 5);
                grid.add(text8, 0, 7);       
                grid.add(aadhar, 1, 7);
                grid.add(text9, 0, 8); 
                grid.add(email, 1, 8); 
                grid.add(passw, 0, 9);
                grid.add(passwt, 1, 9);
                grid.add(button1, 0, 10); 
                grid.add(button2, 1, 10);
                grid.add(ba, 0, 12);
                button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
                button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
                text1.setStyle("-fx-font: normal bold 20px 'serif' "); 
                text2.setStyle("-fx-font: normal bold 20px 'serif' ");  
                text3.setStyle("-fx-font: normal bold 20px 'serif' ");  
                text5.setStyle("-fx-font: normal bold 20px 'serif' "); 
                text6.setStyle("-fx-font: normal bold 20px 'serif' ");  
                text8.setStyle("-fx-font: normal bold 20px 'serif' ");  
                text9.setStyle("-fx-font: normal bold 20px 'serif' ");  
                passw.setStyle("-fx-font: normal bold 20px 'serif' ");  
                grid.setStyle("-fx-background-color: #99ccff;");
                button1.setOnAction(event0->insert1(statement));
                s3.show();
                primaryStage.hide();
                s2.hide();
                s4.hide();
            } 
        };
        b.setOnAction(event);
        b1.setOnAction(event1);
        r.setMinSize(600, 600);
        r.setVgap(5);
        r.setHgap(5);
        r.setAlignment(Pos.CENTER);
        r.setStyle("-fx-background-color: #99ccff;"); 
        r.add(text0,0,3);
        r.add(text0i,2,3); 
        r.add(text00,0,6);
        r.add(text00p,2,6);
        r.add(b,1,9);
        r.add(b1,2,9);
        
        r.add(bmai,1,13);
        bmai.setOnAction(new EventHandler<ActionEvent>()
        {
        	public void handle(ActionEvent e) {
        		text0i.setText("");
        		text00p.setText("");
        	}
        }
    );
        r.add(val,0,0);
        Scene sc = new Scene(r); 
        primaryStage.setScene(sc); 
        primaryStage.show(); 
        gridPane.setMinSize(600, 600); 
        gridPane.setPadding(new Insets(10, 10, 10, 10)); 
        gridPane.setVgap(5); 
        gridPane.setHgap(5);     
        gridPane.setAlignment(Pos.CENTER); 
        gridPane.add(text1, 0, 0); 
        gridPane.add(id, 1, 0); 
        gridPane.add(text2, 0, 1);       
        gridPane.add(first, 1, 1); 
        gridPane.add(text3, 0, 2); 
        gridPane.add(middle, 1, 2); 
        gridPane.add(bl, 1, 16); 
        gridPane.add(bv, 1, 9);
        gridPane.add(be, 0, 9);
        gridPane.add(bu, 0, 11);
        gridPane.add(ba, 0, 12);
        gridPane.add(buttonc, 1, 14);
        gridPane.add(buttonv, 1,11);
        gridPane.add(sf, 0, 16);
        gridPane.add(msg, 0, 13);
        bl.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
        bv.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
        be.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;"); 
        bu.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        buttonv.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
        text1.setStyle("-fx-font: normal bold 20px 'serif' "); 
        text2.setStyle("-fx-font: normal bold 20px 'serif' ");  
        text3.setStyle("-fx-font: normal bold 20px 'serif' "); 
        gridPane.setStyle("-fx-background-color: #99ccff;"); 
        gridPane.add(vu, 0,5);
        gridPane.add(vp, 1,5);
        bl.setOnAction(e->delete());
        bv.setOnAction(e->deposit());
        be.setOnAction(e->withdraw());
        bu.setOnAction(e->checkbal());
        buttonc.setOnAction(e -> cancel());
        buttonv.setOnAction(e -> view());
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
            	primaryStage.show();
            	s2.hide();
            	s3.hide();
            	s4.hide();
            }
        };
        ba.setOnAction(event2);
    }
       
    
    public static void main(String[] args) {
        launch(args);
    }
    private void cancel() {
		id.clear();
		first.clear();
		middle.clear();
    }
    public void DBConnect(){
        try {
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/fxapp","root","");
            statement = conn.createStatement();
            msg.setText("Database Connected");
        } catch (Exception e) {
            msg.setText("Database Not Connected");
        }
    }
    public void view()
    {
    	  try {
              String insertquery = "select * from det where id = '"+id.getText()+"'";
              ResultSet result = statement.executeQuery(insertquery);
              if(result.next()){
            	  s4=new Stage();
              	  GridPane grid1 = new GridPane();
              	  Scene scene = new Scene(grid1);
                  s4.setScene(scene);
                  s4.setTitle("User details");
                  Text text1 = new Text("Account ID");       
                  Text text2 = new Text("Name");
                  Text text3 = new Text("Minimum Balance ");
                  Text text5 = new Text("Address");
                  Text text6 = new Text("Phone number");
                  Text fir = new Text();
                  Text mid = new Text();
                  Text add = new Text();
                  Text pho = new Text();
                  Text aad = new Text();
                  fir.setText(result.getString("id"));
                  mid.setText(result.getString("name"));
                  add.setText(result.getString("dob"));
                  pho.setText(result.getString("address"));
                  aad.setText(result.getString("phone"));
                  grid1.setMinSize(600, 600); 
                  grid1.setPadding(new Insets(10, 10, 10, 10)); 
                  grid1.setVgap(5); 
                  grid1.setHgap(5);     
                  grid1.setAlignment(Pos.CENTER); 
                  grid1.add(text1, 0, 0); 
                  grid1.add(fir, 1, 0); 
                  grid1.add(text2, 0, 3);       
                  grid1.add(mid, 1, 3); 
                  grid1.add(text3, 0, 5); 
                  grid1.add(add, 1, 5); 
                  grid1.add(text5, 0, 7); 
                  grid1.add(pho, 1, 7); 
                  grid1.add(text6, 0, 9);       
                  grid1.add(aad, 1, 9); 
                  grid1.setStyle("-fx-background-color: #99ccff;");
                  text1.setStyle("-fx-font: normal bold 20px 'serif' ");
                  text2.setStyle("-fx-font: normal bold 20px 'serif' ");  
                  text3.setStyle("-fx-font: normal bold 20px 'serif' ");  
                  text5.setStyle("-fx-font: normal bold 20px 'serif' "); 
                  text6.setStyle("-fx-font: normal bold 20px 'serif' ");  
                  s4.show();
                  primaryStage.hide();
                  s2.hide();
                  s3.hide();
              }
          } catch (SQLException ex) {
              msg.setText("Problem to Show Data");
          }
       }
public void insert1(Statement statement){
        try{
            String insertquery1 = "INSERT INTO `det`(`id`, `name`, `dob`, `address`, `phone`, `pass`)  VALUES ('"+id3.getText()+"', '"+name.getText()+"' , '"+dob.getText()+"' ,  '"+address.getText()+"', '"+phone.getText()+"', '"+passwt.getText()+"')";
            statement.executeUpdate(insertquery1);
            button2.setText("Inserted");
        } catch(Exception e){
            button2.setText("Not Inserted");
        }
    }
public void deposit(){
    	int id1 = Integer.parseInt(id.getText());
 		int depo = Integer.parseInt(first.getText());
 		int amount;
 		try {
            String insertquery = "select * from det where id = '"+Integer.toString(id1)+"'";
            ResultSet result = statement.executeQuery(insertquery);
            if(result.next()){
            	amount = result.getInt("dob");
                amount = amount + depo;
                String sql = "update `det` set `dob`='"+Integer.toString(amount)+"' WHERE `id`= '"+id1+"'";
                statement.executeUpdate(sql);
                middle.setText(Integer.toString(amount));
                sf.setText("Deposited");
              }
            else
            {
            	sf.setText("Invalid ID");
            }
        } catch (SQLException ex) {
            msg.setText("Problem to Show Data");
        }
     }
 public void withdraw(){
    	int id1 = Integer.parseInt(id.getText());
  		int with = Integer.parseInt(first.getText());
  		int amount;
  		try {
             String insertquery = "select * from det where id = '"+Integer.toString(id1)+"'";
             ResultSet result = statement.executeQuery(insertquery);
             if(result.next()){
             	amount = result.getInt("dob");
             	if(amount>with && amount>1000)
             	{
                 amount = amount - with;
                 String sql = "update `det` set `dob`='"+Integer.toString(amount)+"' WHERE `id`= '"+id1+"'";
                 statement.executeUpdate(sql);
                 middle.setText(Integer.toString(amount));
                 try
                 {
                	 if(amount<1000)
                	 throw new transac_not_allowed();
                	 else
                		 sf.setText("Withdrawn");
                 }
                 catch(transac_not_allowed e)
                 {
                	 System.out.println(e);
                 }
             	}
             	else
             		{	sf.setText("Cannot withdraw");
             		System.out.println("Please enter a valid amount");
             		}
             }
             else
             {
             	sf.setText("Invalid ID");
             }
             
         } catch (SQLException ex) {
             msg.setText("Problem to Show Data");
         }
   }
public void checkbal(){
    	 int id1 = Integer.parseInt(id.getText());
    	 int amount=0;
  		try {
             String insertquery = "select * from det where id = '"+Integer.toString(id1)+"'";
             ResultSet result = statement.executeQuery(insertquery);
             if(result.next()){
             	amount = result.getInt("dob");
                middle.setText(Integer.toString(amount));
               }
             else
             {
             	sf.setText("Invalid ID");
             }
             
         } catch (SQLException ex) {
             msg.setText("Problem to Show Data");
         }
     }
public void delete(){
    	int sg = Integer.parseInt(id.getText());
         try {
        	String insertquery = "DELETE FROM `det` WHERE id = '"+sg+"'";
            if(statement.executeUpdate(insertquery)==1)
            {	
            msg.setText("Account Closed!!");
            sf.setText("");
            }
            else
            	msg.setText("Invalid Account ID");
        	 
        } catch (SQLException ex) {
            msg.setText(ex.getMessage());
        }
     }
}
