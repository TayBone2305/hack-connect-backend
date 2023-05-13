CREATE TABLE persons
(
    person_id       SERIAL PRIMARY KEY,
    username        VARCHAR(100),
    first_name      VARCHAR(100),
    last_name       VARCHAR(100),
    email           VARCHAR(100),
    password        VARCHAR(255),
    profile_picture VARCHAR(255)
);

CREATE TABLE skills
(
    skill_id SERIAL PRIMARY KEY,
    name     VARCHAR(100)
);


CREATE TABLE persons_skills
(
    person_id       INT REFERENCES persons (person_id),
    skill_id        INT REFERENCES skills (skill_id),
primary key (person_id, skill_id)
);

CREATE TABLE languages
(
    language_id SERIAL PRIMARY KEY,
    name        VARCHAR(100)
);

CREATE TABLE persons_languages
(
    person_language_id SERIAL PRIMARY KEY,
    person_id          INT REFERENCES persons (person_id),
    language_id        INT REFERENCES languages (language_id)
);

CREATE TABLE teams
(
    team_id     SERIAL PRIMARY KEY,
    name        VARCHAR(100),
    description TEXT,
    picture     VARCHAR(255)
);

CREATE TABLE rooms
(
    room_id SERIAL PRIMARY KEY,
    name    VARCHAR(100),
    team_id INT REFERENCES teams (team_id)
);

CREATE TABLE messages
(
    message_id SERIAL PRIMARY KEY,
    content    VARCHAR(255),
    sender_id  INT REFERENCES persons (person_id),
    room_id    INT REFERENCES rooms (room_id),
    created_at TIMESTAMP
);