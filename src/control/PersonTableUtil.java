/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ConDb;
import model.Person;

/**
 *
 * @author Администратор
 */
public class PersonTableUtil {
    private static ObservableList<Person> list = FXCollections.observableArrayList();
    private static ConDb conn;
        //returns an observable list of persons
    public static ObservableList<Person> getPersonList(){
        try{ 
            conn = new ConDb();
            list = conn.getAllParts();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Data base error");
        }
        return list;
    }
    
    //returns Person id table column
    public static  TableColumn <Person,Integer> getIdColumn(){
        TableColumn <Person,Integer> personIdColumn = new TableColumn<>("Id");
        personIdColumn.setCellValueFactory(new PropertyValueFactory<>("personId"));
        return personIdColumn;
    }
    
    //returns first name column
    public static TableColumn <Person,String> getFirstNameColumn(){
        TableColumn <Person,String> firstNameColumn = new TableColumn<>("First name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        return firstNameColumn;
    }
    
    //returns last name column
    public static TableColumn<Person,String> getLastNameColumn(){
        TableColumn <Person,String> lastNameColumn = new TableColumn<>("Last name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        return lastNameColumn;
    }
    
    //returns bith date column 
    public static TableColumn<Person,LocalDate> getBirthDate(){
        TableColumn<Person,LocalDate> birthDateColumn = new TableColumn<>("Birth date");
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        return birthDateColumn;
    }
    
    public static void main(String [] args){
        ObservableList l = FXCollections.observableArrayList(PersonTableUtil.getPersonList());
        System.out.println(l);
    }

    
}
