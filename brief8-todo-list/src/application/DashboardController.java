package application;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import model.Category;
import model.Task;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

import dao.CategoryDao;
import dao.TaskDao;
import helper.ActionButtonTableCell;
import helper.ActionButtonTableCell;
import helper.ChoiceBoxCell;

public class DashboardController  implements Initializable   {
	
	private Main m = new Main();
	private static TaskDao taskDao =  new TaskDao();
	private static CategoryDao categoryDao =  new CategoryDao();

	private Task task;
	
    @FXML private Button logout;
    @FXML private Text displayName;
    @FXML private Button addTaskBtn;
    @FXML private Button cancelTaskBtn;
    @FXML private Button editTaskBtn;
    @FXML private Button deleteTaskBtn;
    @FXML private Button refreshTaskBtn;
    @FXML private Button searchTaskBtn;
    @FXML private TextField searchTaskField;	   
    @FXML private ChoiceBox<String> sStatus;
    @FXML private ChoiceBox<String> sCategory;
    
	@FXML private TextField idField;
	@FXML private TextField nameField;
	@FXML private TextField descField;
	@FXML private DatePicker tobeFinishedAtField;
	@FXML private TextField createdAtField;
	@FXML private TextField finishedAtField;
	@FXML private ChoiceBox<String> categoryField;
	@FXML private ChoiceBox<String> statusField;

	@FXML private TableView<Task> tasksTable;
	@FXML private TableView<Task> notYetTable;
	@FXML private TableView<Task> inProgressTable;
	@FXML private TableView<Task> doneTable;
	
	@FXML private TableColumn<Task, Integer> idC;
	@FXML private TableColumn<Task, String> statusC;
	@FXML private TableColumn<Task, String> nameC;
	@FXML private TableColumn<Task, String> descriptionC;
	@FXML private TableColumn<Task, String> createdAtC;
	@FXML private TableColumn<Task, String> tobeFinishedAtC;
	@FXML private TableColumn<Task, String> finishedAtC;
	@FXML private TableColumn<Task, String> categoryC;
	
	@FXML private TableColumn<Task, String> notYetC;
	@FXML private TableColumn<Task, String> inProgressC;
	@FXML private TableColumn<Task, String> doneC;

	public static ObservableList<Task> tasksList = FXCollections.observableArrayList( );
	public static ObservableList<Task> notYetList = FXCollections.observableArrayList( );
	public static ObservableList<Task> inProgressList = FXCollections.observableArrayList( );
	public static ObservableList<Task> doneList = FXCollections.observableArrayList( );

    private  String[] taskStatuses =  {"all statuses", "not-yet", "in-progress", "done"};
    private List<String> taskCategories = new ArrayList<String>();
    
    public void userLogOut(ActionEvent event) throws IOException {
		tasksList.clear();
		notYetList.clear();
		inProgressList.clear();
		doneList.clear();
        m.changeScene("../view/Signin.fxml");
    }
     
    public void transferMessage(String message) {
    	displayName.setText(message);
    }

	public void addCatgeoriesToChoiceBox() {	
				
		    taskCategories.add("all categories");

            Set<Category> listOfCategories = categoryDao.getAll();
             
            for(Category category : listOfCategories){
   		     taskCategories.add(category.getName());

            }
    }

	public void addTask(ActionEvent event) throws IOException {
		
		String tobeFinishedAtdate = tobeFinishedAtField.getValue()+"";
	   System.out.println(tobeFinishedAtdate);
	    Task task = new Task(nameField.getText(), descField.getText(), statusField.getValue(), tobeFinishedAtdate, finishedAtField.getText(), 2);
	    
	    
    
	    Task taskInserted;
	    Boolean taskUpdtaed = false;
//	    if(1==1) {
		    taskInserted = taskDao.insert(task);
	
//	    }else {
//	    	 int taskId = Integer.parseInt(idField.getText());
//		     taskUpdtaed = taskDao.update(taskId, task);
//	    }
	    
		if( taskInserted != null ||  taskUpdtaed) {
			System.out.println(1+"-"+statusField.getValue()+"...."+(taskInserted));

	    	  tasksList.add(taskInserted);
	    	switch (statusField.getValue().trim()) {
			case "not-yet":
				System.out.println(1+"-"+statusField.getValue());
				notYetList.add(taskInserted);
				break;
			case "in-progress":
				System.out.println(2+"-"+statusField.getValue());
				inProgressList.add(taskInserted);
				break;
			case "done":
				System.out.println(3+"-"+statusField.getValue());
				doneList.add(taskInserted);
				break;
			}

	       }
		
    }
	
	public void editTask(ActionEvent event) throws IOException {


//	    Task task = new Task(name, name.toLowerCase()+".jpg", desc.replace("\n", ""), price, unit, city, category_id);
//	    boolean taskUpdated = taskDao.update(174, task);
//	       if( taskUpdated) {
//	    	 
////	    	  tasksList..add(taskUpdated);
//	    	  return true;
//	       }
	      // return false;
   }
	
	public void deleteTask(ActionEvent event) {
		 task = tasksTable.getSelectionModel().getSelectedItem();
		 
		 if(taskDao.delete(task.getId())) {
	    	   tasksList.remove(tasksList.indexOf(task));
	    	   tasksTable.getSelectionModel().clearSelection();
	    	   System.out.println("deleted Succefull!");
		}
	       
   }
	
	public void refreshTask(ActionEvent event) {
		tasksList.clear();
		notYetList.clear();
		inProgressList.clear();
		doneList.clear();
		tasksList.addAll(taskDao.getAll()); 
		notYetList.addAll(taskDao.getAllByStatus("not-yet"));
		inProgressList.addAll(taskDao.getAllByStatus("in-progress"));
		doneList.addAll(taskDao.getAllByStatus("done"));
		
  }
	
	public void searchTask(ActionEvent event) {
		tasksList.clear();
		tasksList.addAll(taskDao.search(searchTaskField.getText()));  
  }
	
    public void getTasksByStatus(ActionEvent event) {
       if (sStatus.getValue() == "all statuses")
        	 this.refreshTask(event);
       else
    	tasksList.clear();
    	tasksList.addAll(taskDao.getAllByStatus(sStatus.getValue()));
    }
    
    public void getTasksByCategory(ActionEvent event) {
        if (sCategory.getValue() == "all categories")
         	 this.refreshTask(event);
        else
     	tasksList.clear();
     	tasksList.addAll(taskDao.getAllByCategory(sCategory.getValue()));
     }

    
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	    BooleanBinding isAnyRowSelected = tasksTable.getSelectionModel().selectedItemProperty().isNull();
		editTaskBtn.disableProperty().bind(isAnyRowSelected);
		deleteTaskBtn.disableProperty().bind(isAnyRowSelected);
		
		tasksTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (oldSelection != null) {		

				addTaskBtn.setText("Add");

		    	idField.textProperty().unbindBidirectional(oldSelection.getId());
		    	nameField.textProperty().unbindBidirectional(oldSelection.nameProperty());
		    	descField.textProperty().unbindBidirectional(oldSelection.descriptionProperty());
//		    	
//		        DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
//		        Date result =  df.parse(target); 
		        
//		    	tobeFinishedAtField.valueProperty().unbindBidirectional(oldSelection.tobefinished_atProperty());
		    	createdAtField.textProperty().unbindBidirectional(oldSelection.created_atProperty());
		    	finishedAtField.textProperty().unbindBidirectional(oldSelection.finished_atProperty());
		    	categoryField.valueProperty().unbindBidirectional(oldSelection.categoryProperty());
		    	statusField.valueProperty().unbindBidirectional(oldSelection.statusProperty());

		    }
		    if (newSelection != null) {
		    	tasksTable.getSelectionModel().clearSelection();

				addTaskBtn.setText("Update");

		        idField.setText(newSelection.getId()+"");
		    	nameField.textProperty().bindBidirectional(newSelection.nameProperty());
		    	descField.textProperty().bindBidirectional(newSelection.descriptionProperty());
//                tobeFinishedAtField.valueProperty().bindBidirectional(newSelection.tobefinished_atProperty());
		    	createdAtField.textProperty().bindBidirectional(newSelection.created_atProperty());
		    	finishedAtField.textProperty().bindBidirectional(newSelection.finished_atProperty());
		    	categoryField.valueProperty().bindBidirectional(newSelection.categoryProperty());
		    	statusField.valueProperty().bindBidirectional(newSelection.statusProperty());
		    	

		    }

		});
	

		statusField.getItems().addAll(taskStatuses);	
		statusField.getItems().remove(0);	
		statusField.setValue("not-yet"); 
		categoryField.getItems().addAll(taskCategories);	
//		categoryField.getItems().remove(0);	
//		categoryField.setValue(taskCategories.get(0)); 
		
		addCatgeoriesToChoiceBox();
		sStatus.getItems().addAll(taskStatuses);	
		sStatus.setValue("all statuses"); 
		sCategory.getItems().addAll(taskCategories);	
		sCategory.setValue("all categories"); 

		sStatus.setOnAction(this::getTasksByStatus);
		sCategory.setOnAction(this::getTasksByCategory);
	

//          sCategory.getItems().addAll(categoryDao.getAll())
			idC.setCellValueFactory(new PropertyValueFactory<Task, Integer>("id"));
			statusC.setCellFactory(column -> new ChoiceBoxCell(taskStatuses));
			statusC.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
			nameC.setCellValueFactory(new PropertyValueFactory<Task, String>("name"));
			descriptionC.setCellValueFactory(new PropertyValueFactory<Task, String>("description"));
		    createdAtC.setCellValueFactory(new PropertyValueFactory<Task, String>("created_at"));
			tobeFinishedAtC.setCellValueFactory(new PropertyValueFactory<Task, String>("tobefinished_at"));
			finishedAtC.setCellValueFactory(new PropertyValueFactory<Task, String>("finished_at"));
			categoryC.setCellValueFactory(new PropertyValueFactory<Task, String>("category"));
			
			
			notYetC.setCellValueFactory(new PropertyValueFactory<Task, String>("name"));
			inProgressC.setCellValueFactory(new PropertyValueFactory<Task, String>("name"));
			doneC.setCellValueFactory(new PropertyValueFactory<Task, String>("name"));
			
	        TableColumn actionCol1 = new TableColumn("");
	        TableColumn actionCol2 = new TableColumn("");
	        TableColumn actionCol3 = new TableColumn("");
	        TableColumn actionCol4 = new TableColumn("");

	        notYetTable.getColumns().addAll(actionCol1);
	        inProgressTable.getColumns().addAll(actionCol2);
	        inProgressTable.getColumns().addAll(actionCol3);
	        doneTable.getColumns().addAll(actionCol4);

	    	
	        actionCol1.setCellFactory(ActionButtonTableCell.<Task>forTableColumn("￫", (Task p) -> {
	            System.out.print(taskDao.setStatus(p.getId(), "in-progress"));
	            notYetList.remove(p);
	            inProgressList.add(p);
			    return p;
			}));  
	        
	        actionCol2.setCellFactory(ActionButtonTableCell.<Task>forTableColumn("￩", (Task p) -> {
	        	System.out.println(p.getId());
	            System.out.print(taskDao.setStatus(p.getId(), "not-yet"));
	            inProgressList.remove(p);
	            notYetList.add(p);
			    return p;
			}));
	        
	        actionCol3.setCellFactory(ActionButtonTableCell.<Task>forTableColumn("￫", (Task p) -> {
	        	System.out.println(p.getId());
	            System.out.print(taskDao.setStatus(p.getId(), "done"));
	            inProgressList.remove(p);
	            doneList.add(p);
			    return p;
			}));
	    	
	        actionCol4.setCellFactory(ActionButtonTableCell.<Task>forTableColumn("￩", (Task p) -> {
	        	System.out.println(p.getId());
	            System.out.print(taskDao.setStatus(p.getId(), "in-progress"));
	            doneList.remove(p);
	            inProgressList.add(p);
			    return p;
			}));

			tasksList.addAll(taskDao.getAll());
			notYetList.addAll(taskDao.getAllByStatus("not-yet"));
			inProgressList.addAll(taskDao.getAllByStatus("in-progress"));
			doneList.addAll(taskDao.getAllByStatus("done"));
	        
			tasksTable.setItems(tasksList);
			notYetTable.setItems(notYetList);
			inProgressTable.setItems(inProgressList);
			doneTable.setItems(doneList);
			
			tasksTable.setEditable(true);
	}

}