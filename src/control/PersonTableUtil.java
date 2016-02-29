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
import model.Person;

/**
 *
 * @author Администратор
 */
public class PersonTableUtil {
        //returns an observable list of persons
    public static ObservableList<Person> getPersonList(){
        Person p1 = new Person("Brian", "Johnson",LocalDate.of(2012,10,11));
        Person p2 = new Person("Mick", "Jagger",LocalDate.of(2011,9,10));
        Person p3 = new Person("Angus", "Young",LocalDate.of(2010,8,9));
        Person p4 = new Person("Lemmy", "Kilmister",LocalDate.of(2009,7,8));
        Person p5 = new Person("Alice", "Cooper",LocalDate.of(2008,6,7));
        Person p6 = new Person("Dusty", "Hill",LocalDate.of(2007,5,6));
        Person p7 = new Person("Dee", "Snider",LocalDate.of(2006,4,5));
        return FXCollections.<Person>observableArrayList(p1,p2,p3,p4,p5,p6,p7);
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
}
