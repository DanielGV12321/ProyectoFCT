package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = {"dni","email"}) })
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "nick", nullable = false)
	private String nick;

	@Column(name = "dni", nullable = false)
	private String dni;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "direccion", nullable = false)
	private String direccion;

	@Column(name = "enable", nullable = true)
	private boolean enable;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="users_rolusers",joinColumns=@JoinColumn(name="users_id",referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="rolusers_id",referencedColumnName = "id"))
	private Set<RolUser> rolUser= new HashSet<>();
	
	@OneToMany(mappedBy = "users",cascade= CascadeType.ALL,orphanRemoval = true)
	private Set<Pedidos> pedidos=new HashSet<>();

	public Users() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Set<RolUser> getRolUser() {
		return rolUser;
	}

	public void setRolUser(Set<RolUser> rolUser) {
		this.rolUser = rolUser;
	}

	public Set<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	
	

}
