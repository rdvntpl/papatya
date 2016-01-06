package com.horizon.fps.Model;

public class User {
	private int id;
	private String name;
	private String lastname;
	private String username;
	private String password;
	private String password2;
	private String email;
	private String phone;
	private String adress;
	private int auth;
	
	public User() {
		
	}
	
	public User(int i, String n , String ln, String un, String ps, String em, String ph, String ad, int a) {
		id = i;
		name = n;
		lastname = ln;
		username = un;
		password = ps;
		email = em;
		phone = ph;
		adress = ad;
		auth = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
}
