
package com.tripsync.invitation.repository;
 

import com.tripsync.invitation.entity.InvitationStatus;
import com.tripsync.invitation.entity.TripInvitation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TripInvitationRepository extends JpaRepository<TripInvitation,Long> {
    List<TripInvitation> findByInvitedEmailIgnoreCase(String invitedEmail);
    List<TripInvitation> findByTripId(Long tripId);
    Optional<TripInvitation> findByIdAndInvitedEmailIgnoreCase(Long id, String invitedEmail);
    Optional<TripInvitation>findByTokenHash(String tokenHash);
    boolean existsByTrip_IdAndInvitedEmailIgnoreCaseAndStatus(Long tripId,
                                                              String invitedEmail, InvitationStatus status);
}