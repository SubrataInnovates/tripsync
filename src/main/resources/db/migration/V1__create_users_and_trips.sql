
-- ============================================
-- TripSync Database Migration V1
-- Create Users and Trips Tables
-- ============================================

-- 1. USERS TABLE
CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'USER',
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),

    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT uk_users_email UNIQUE (email)
) ENGINE=InnoDB;


-- 2. TRIPS TABLE
CREATE TABLE trips (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    budget DECIMAL(12,2),
    status VARCHAR(20) NOT NULL DEFAULT 'PLANNED',
    owner_id BIGINT NOT NULL,
    created_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    updated_at DATETIME(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),

    CONSTRAINT pk_trips PRIMARY KEY (id),

    CONSTRAINT fk_trips_owner
        FOREIGN KEY (owner_id)
        REFERENCES users(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT chk_trips_dates
        CHECK (end_date >= start_date),

    CONSTRAINT chk_trips_budget
        CHECK (budget IS NULL OR budget >= 0)
) ENGINE=InnoDB;


-- 3. INDEXES
CREATE INDEX idx_trips_owner_id
ON trips(owner_id);

CREATE INDEX idx_trips_destination
ON trips(destination);

CREATE INDEX idx_trips_status
ON trips(status);

CREATE INDEX idx_trips_start_date
ON trips(start_date);
