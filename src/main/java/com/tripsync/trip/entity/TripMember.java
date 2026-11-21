package com.tripsync.trip.entity;

import java.time.LocalDateTime;

import com.tripsync.common.entity.BaseEntity;
import com.tripsync.user.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="trip_members",uniqueConstraints = {@UniqueConstraint(name="uk_trip_members_trip_user",columnNames = {"trip_id","user_id"})})
public class TripMember extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="trip_id",nullable = false)
	private Trip trip;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="user_id",nullable = false)
	private User user;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false,length=20)
	private TripMemberRole role=TripMemberRole.VIEWER;
	@Column(nullable = false,name="joined_at")
	private LocalDateTime joinedAt;
	

}
