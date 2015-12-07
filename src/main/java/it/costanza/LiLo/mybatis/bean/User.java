package it.costanza.LiLo.mybatis.bean;

import it.costanza.LiLo.util.Utility;

import java.util.ArrayList;
import java.util.Date;



public class User {
    private Integer idUser;

    private String name;

    private String surname;

    private String email;
    			 
    private Date birthDate;

    private String username;

    private String password;

    private Date insertTimestamp;

    private Date updateTimestamp;

    //Costruttore vuoto
	public User(){}
    
    
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getInsertTimestamp() {
        return insertTimestamp;
    }

    public void setInsertTimestamp(Date insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
    
    
    @Override
    public String toString() {
    	
    	ArrayList<String> chiavi = new ArrayList<String>();
    	ArrayList<String> valori = new ArrayList<String>();
    	
    	chiavi.add("idUser");
    	chiavi.add("name");
    	chiavi.add("surname");
    	chiavi.add("email");
    	chiavi.add("birthDate");
    	chiavi.add("username");
    	chiavi.add("password");
    	chiavi.add("insertTimestamp");
    	chiavi.add("updateTimestamp");
    	
    	valori.add(idUser+"");
    	valori.add(name);
    	valori.add(surname);
    	valori.add(email);
    	valori.add(birthDate+"");
    	valori.add(username);
    	valori.add(password);
    	valori.add(insertTimestamp+"");
    	valori.add(updateTimestamp+"");
    	
    	return Utility.toStringPerBean(chiavi, valori);
    	
    }
}