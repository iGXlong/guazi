CREATE TABLE web_user
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    username    VARCHAR(32),
    PASSWORD    VARCHAR(32) NOT NULL,
    phonenumber VARCHAR(32) UNIQUE,
    flag        INT DEFAULT 0,
    createtime  DATETIME,
    logintime   DATETIME
) CHARACTER SET utf8mb4;

CREATE TABLE web_express
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    enumber   VARCHAR(64) UNIQUE,
    username  VARCHAR(64),
    userphone VARCHAR(64),
    company   VARCHAR(64),
    CODE      VARCHAR(64) UNIQUE,
    intime    DATETIME,
    outtime   DATETIME,
    STATUS    INT,
    sysPhone  VARCHAR(64)
) CHARACTER SET utf8mb4;
