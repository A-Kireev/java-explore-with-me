CREATE TABLE IF NOT EXISTS categories (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  name varchar NOT NULL CHECK (name <> '')
);

CREATE TABLE IF NOT EXISTS users (
  id int8 GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  name varchar,
  email varchar,
  CONSTRAINT uq_email UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS events (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  initiator_id int8 REFERENCES users (id),
  annotation varchar NOT NULL,
  category_id int8 REFERENCES categories (id),
  description text,
  event_date timestamp NOT NULL,
  created_on timestamp NOT NULL,
  published_on timestamp,
  lat float NOT NULL,
  lon float NOT NULL,
  paid boolean,
  participant_limit int4,
  request_moderation boolean,
  title varchar NOT NULL,
  state varchar NOT NULL
);

CREATE TABLE IF NOT EXISTS requests (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  event_id int8 REFERENCES events (id),
  requester_id int8 REFERENCES users (id),
  status varchar NOT NULL,
  created_on timestamp NOT NULL
);
