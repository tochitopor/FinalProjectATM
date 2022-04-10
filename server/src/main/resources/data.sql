
DROP TABLE IF EXISTS Scores;
DROP TABLE IF EXISTS Clients;

CREATE TABLE Clients (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  pin INT NOT NULL
);

CREATE TABLE Scores (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  balance int DEFAULT 0,
  client_id  INT NOT NULL,
    foreign key (client_id) references Clients(id)
);

INSERT INTO Clients (pin) VALUES
  (1234),
  (5678);

INSERT INTO Scores (balance,client_id) VALUES
  (1000,1),
  (2000,1),
  (4000,2);