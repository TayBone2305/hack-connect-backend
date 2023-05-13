CREATE TABLE persons (
  person_id SERIAL PRIMARY KEY,
  username VARCHAR(100),
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  email VARCHAR(100),
  password VARCHAR(255),
  profile_picture VARCHAR(255)
);

CREATE TABLE skills (
  skill_id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE persons_skills (
  person_skill_id SERIAL PRIMARY KEY,
  person_id INT REFERENCES person(person_id),
  skill_id INT REFERENCES skill(skill_id)
);

CREATE TABLE languages (
  language_id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE persons_languages (
  person_language_id SERIAL PRIMARY KEY,
  person_id INT REFERENCES person(person_id),
  language_id INT REFERENCES language(language_id)
);

CREATE TABLE teams (
  team_id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  description TEXT,
  picture VARCHAR(255)
);

CREATE TABLE rooms (
  room_id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  team_id INT REFERENCES team(team_id)
);

CREATE TABLE messages (
  message_id SERIAL PRIMARY KEY,
  content VARCHAR(255),
  sender_id INT REFERENCES person(person_id),
  room_id INT REFERENCES room(room_id),
  created_at TIMESTAMP
);