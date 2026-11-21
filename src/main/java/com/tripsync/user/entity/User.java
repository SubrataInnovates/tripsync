package com.tripsync.user.entity;

import com.tripsync.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users",uniqueConstraints = {@UniqueConstraint(name="uk_users_email",columnNames = "email")})
@Setter
@Getter
public class User extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false,length = 50)
	private String fullName;
	@Column(nullable = false,unique = true)
	@Email
	private String email;
	
	@Column(nullable = false,length = 100,name="password_hash")
	private String passwordHash;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false,length = 20)
	private Role role=Role.USER;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false,length = 20)
	private AccountStatus status=AccountStatus.ACTIVE;

}
