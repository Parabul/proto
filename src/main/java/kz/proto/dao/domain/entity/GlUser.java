package kz.proto.dao.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class GlUser {
	
	@Id
	@SequenceGenerator(name="GL_USER_ID_GENERATOR", sequenceName="GL_USER_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GL_USER_ID_GENERATOR")
	private Integer id;

	@Column(unique = true)
	private String email;

	@JsonIgnore
	private String password;

	@ElementCollection
	private List<String> roles;

	private boolean enabled;

	@Column(name = "account_non_expired")
	private boolean accountNonExpired;

	@Column(name = "credentials_non_expired")
	private boolean credentialsNonExpired;

	@Column(name = "account_mon_locked")
	private boolean accountNonLocked;

	private Integer cashierId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Integer getCashierId() {
		return cashierId;
	}

	public void setCashierId(Integer cashierId) {
		this.cashierId = cashierId;
	}

}
