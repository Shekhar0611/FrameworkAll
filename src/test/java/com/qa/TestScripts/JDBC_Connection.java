package com.qa.TestScripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JDBC_Connection {
	
	@Test
	public void jdbc() throws SQLException {

	String host="localhost";

	String port= "3306";

	Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/jdbcdemo", "root", "Shekhar@8796");

	Statement s=con.createStatement();

	ResultSet rs=s.executeQuery("select * from jdbc where username ='rewardscard'");

	while(rs.next())

	{

	WebDriver driver= new ChromeDriver();

	driver.get("https://login.salesforce.com");

	driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));
 
	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));
	}	 
	}
	}

