package application;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dao.ProductDao;

public class DashboardController  implements Initializable   {
	
	private Main m = new Main();
	static Stage dialog = new Stage();
	private static ProductDao productDao =  new ProductDao();
	private Product product;
	
    @FXML private Button logout;
    @FXML private Text displayName;
    @FXML private Button addProductBtn;
    @FXML private Button editProductBtn;
    @FXML private Button deleteProductBtn;
    @FXML private Button refreshProductBtn;
    @FXML private Button searchProductBtn;
    @FXML private TextField searchProductField;	   

	@FXML private TableView<Product> productsTable;
	@FXML private TableColumn<Product, Integer> idC;
	@FXML private TableColumn<Product, String> nameC;
	@FXML private TableColumn<Product, String> imgC;
	@FXML private TableColumn<Product, String> descriptionC;
	@FXML private TableColumn<Product, Float> priceC;
	@FXML private TableColumn<Product, String> unitC;
	@FXML private TableColumn<Product, String> cityC;
	@FXML private TableColumn<Product, String> categoryC;

	
	public static ObservableList<Product> productsList = FXCollections.observableArrayList( );

	  
	public void addProduct(ActionEvent event) throws IOException {
		
		ShowProductForm();
		
    }
	
	
    public boolean  insertProduct(String name, String desc, float price, String unit, String city, int category_id) {
    	
	    Product product = new Product(name, name.toLowerCase()+".jpg", desc.replace("\n", ""), price, unit, city, category_id);
	    Product productInserted = productDao.insert(product);
	       if( productInserted != null) {
	    	  productsList.add(productInserted);
	    	  return true;
	       }
	       return false;
    }

	public void editProduct(ActionEvent event) throws IOException {
		
		
		
//		  Stage stage; 
		    Parent root;
//		    if(event.getSource()==btn1){
		        //get reference to the button's stage         
//		        stage=(Stage) btn1.getScene().getWindow();
		        //load up OTHER FXML document

		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(getClass().getResource("../view/ProductForm.fxml"));
		        root = loader.load();
		        ProductFormController productFormController = loader.getController();
				Product product = productsTable.getSelectionModel().getSelectedItem();

		        productFormController.setProduct(product);

//		    }
//		    else{
//		        stage=(Stage) btn1.getScene().getWindow();
//		        root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//		    }
		    //create a new scene with root and set the stage
		    Scene scene = new Scene(root);
		    dialog.setScene(scene);
		    dialog.show();



   }
	
    public boolean  updateProduct(String name, String desc, float price, String unit, String city, int category_id) {
    	
	    Product product = new Product(name, name.toLowerCase()+".jpg", desc.replace("\n", ""), price, unit, city, category_id);
	    boolean productUpdated = productDao.update(174, product);
	       if( productUpdated) {
	    	 
//	    	  productsList..add(productUpdated);
	    	  return true;
	       }
	       return false;
    }
	
	public void deleteProduct(ActionEvent event) {
		 product = productsTable.getSelectionModel().getSelectedItem();
		 
		 if(productDao.delete(product.getId())) {
	    	   productsList.remove(productsList.indexOf(product));
	    	   productsTable.getSelectionModel().clearSelection();
	    	   System.out.println("deleted Succefull!");
		}
	       
   }
	
	public void refreshProduct(ActionEvent event) {
		productsList.clear();
		productsList.addAll(productDao.getAll()); 
  }
	
	public void searchProduct(ActionEvent event) {
		productsList.clear();
		productsList.addAll(productDao.search(searchProductField.getText()));
	       
  }
	


    public void userLogOut(ActionEvent event) throws IOException {
        m.changeScene("../view/Signin.fxml");
    }
     
    public void transferMessage(String message) {
    	displayName.setText(message);
    }
    
    
    public void ShowProductForm() throws IOException {
		dialog.getIcons().add(new Image("resources/ahanou-icon.png"));
		dialog.setTitle("AhanouOnline Add Product");
		dialog.setResizable(false);
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../view/ProductForm.fxml"));
		Scene scene = new Scene(root,430,360);
		scene.getStylesheets().add(getClass().getResource("../view/application.css").toExternalForm());
		dialog.setScene(scene);		
		
		dialog.initOwner(Main.stg.getOwner());
		dialog.initModality(Modality.APPLICATION_MODAL); 
		dialog.show();
		
    }

    
    public void closeProductForm() {
        dialog.close();
    }
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
//		 Product producter = productsTable.getSelectionModel().getSelectedItem();
		 
//		StringProperty nameProperty =  new SimpleStringProperty(producter.getName());

			
		 
//		 StringProperty descProperty =  new StringProperty((producter.getDescription());

//		 searchProductField.textProperty().bindBidirectional(descProperty));

//		SimpleStringProperty tedesc = new SimpleStringProperty(products);
		
		
//		tedesc.bindBidirectional(searchProductField.textProperty());

		BooleanBinding isAnyRowSelected = productsTable.getSelectionModel().selectedItemProperty().isNull();

		editProductBtn.disableProperty().bind(isAnyRowSelected);
	    deleteProductBtn.disableProperty().bind(isAnyRowSelected);

		productsList.addAll(productDao.getAll());
		idC.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
//		nameC.  .setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

		nameC.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
		imgC.setCellValueFactory(new PropertyValueFactory<Product, String>("img"));
		descriptionC.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));
		priceC.setCellValueFactory(new PropertyValueFactory<Product, Float>("price"));
		unitC.setCellValueFactory(new PropertyValueFactory<Product, String>("unit"));
		cityC.setCellValueFactory(new PropertyValueFactory<Product, String>("city"));
		categoryC.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
		productsTable.setItems(productsList);

	}
	

	




}