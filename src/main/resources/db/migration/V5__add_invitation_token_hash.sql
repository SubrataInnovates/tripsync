ALTER TABLE trip_invitations
    ADD COLUMN token_hash VARCHAR(62) NULL;

CREATE UNIQUE INDEX uk_trip_invitations_token_hash
    ON trip_invitations(token_hash);