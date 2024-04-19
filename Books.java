package com.mypack.bookssb1;
//Ramana....
import jakarta.persistence.Column;  
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;  
import jakarta.persistence.Table;  
//mark class as an Entity   
@Entity  
//defining class name as Table name  
@Table(name = "books_record") 
public class Books  //pojo
{  
//Defining book id as primary key  
@Id//primary key  
@GeneratedValue(strategy=GenerationType.AUTO)
@Column  
private int bookid;  
@Column  
private String bookname;  
@Column  
private String author;  
@Column  
private int price;  
public int getBookid()   
{  
return bookid;  
}  
public void setBookid(int bookid)   
{  
this.bookid = bookid;  
}  
public String getBookname()  
{  
return bookname;  
}  
public void setBookname(String bookname)   
{  
this.bookname = bookname;  
}  
public String getAuthor()   
{  
return author;  
}  
public void setAuthor(String author)   
{  
this.author = author;  
}  
public int getPrice()   
{  
return price;  
}  
public void setPrice(int price)   
{  
this.price = price;  
}  
}  
