package test;

import java.util.Scanner;

import dao.CategoryDao;
import dao.ProductDao;
import dao.UserDao;
import model.Category;
import model.Task;
import model.User;

public class Test {

	public static void main(String[] args) {
		
        System.out.format("+-----------------+-----------------+%n");
        System.out.format("|          ProductsManager          |%n");
        System.out.format("|          SoussTalents101          |%n");
        System.out.format("|   NajibRachid &  LatifaAmouguay   |%n");
        System.out.format("|         Alpha Version 0.0.1       |%n");
        System.out.format("+-----------------+-----------------+%n");
        
        UserDao userDao =  new UserDao();
        ProductDao productDao =  new ProductDao();
        CategoryDao categoryDao =  new CategoryDao();

        
        
//////////////////login  if admin  and approved;
        
        
      System.out.println(userDao.signIn("nawal@anmoon.ma", "password"));

        /************* USERS *************/
        
        System.out.println(userDao.getAll().size());
        System.out.println(userDao.getAll());
                
//	    User user = new User("latifa@anmoon.ma","qwerty123", "latifa", "amougauay", false);
//
//		if(userDao.insert(user)) {
//			System.out.println("User Created SuccessFuly!");
//		}
//		
//	    User userUpdate = new User("latifa@anmoon.ma","qwerty123", "latifa", "amougauay", true);
//	    System.out.println(userDao.update(4, userUpdate));    
//	    System.out.println(userDao.getOne(4));
//	    
//	    System.out.println(userDao.delete(4));
	    
        /************* CATEGORIES *************/
        
//      System.out.println(categoryDao.getAll().size());
//      System.out.println(categoryDao.getAll());
      
//	    Category category = new Category("fruits", "fruits.png");
//
//		if(categoryDao.insert(category)) {
//			System.out.println("Category Created SuccessFuly!");
//		}
//		
//	    Category categoryUpdate = new Category("fruits", "fruits.jpg");
//	    System.out.println(categoryDao.update(4, categoryUpdate));
//	    System.out.println(categoryDao.getOne(4));
//	    
//	    System.out.println(categoryDao.delete(4));
	    
	    
        /************* PRODUCTS *************/
//        System.out.println(productDao.getAll().size());
//        System.out.println(productDao.getAll());
//     System.out.println(productDao.getAllByCategory(2));
//	    Product product = new Product("Orange1","orange.jpg", " a fruit of various citrus species in the family Rutaceae; it primarily refers to Citrus × sinensis, which is also called sweet orange,", 3, "kilogram", "Houara", 3);
//
//		if(productDao.insert(product)) {
//			System.out.println("Product Created SuccessFuly!");
//		}
//		
//	    Product productUpdate = new Product("Orange","orange.jpg", " a fruit of various citrus species in the family Rutaceae; it primarily refers to Citrus × sinensis, which is also called sweet orange,", 3, "kilogram", "Houara", 5);
//	    System.out.println(productDao.update(5, productUpdate));
//	    System.out.println(productDao.getOne(5));
//	    
//	    System.out.println(productDao.delete(5));

	    
//////////////////else your not allowed
	    

	}

}


