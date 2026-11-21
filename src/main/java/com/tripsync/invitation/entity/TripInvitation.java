package com.tripsync.invitation.entity;

import java.time.LocalDateTime;

import com.tripsync.trip.entity.Trip;
import com.tripsync.trip.entity.TripMemberRole;
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
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="trip_invitations")
public class TripInvitation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="trip_id",nullable = false)
	private Trip trip;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="invited_by_id",nullable = false)
	private User invitedBy;
	
	@Column(name="invited_email",nullable = false,length = 150)
	@Email
	private String invitedEmail;
	
	@Column(name = "token_hash", length = 62, unique = true)
	private String tokenHash;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false,length = 20)
	private TripMemberRole proposedRole=TripMemberRole.VIEWER;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false,length = 20)
	private InvitationStatus status=InvitationStatus.PENDING;
	
	@Column(name="expired_at",nullable = false)
	private LocalDateTime expiredAt;
}
