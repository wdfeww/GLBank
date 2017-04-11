CREATE database GLBank;

USE GLBank;
/*use sql11164806;*/

CREATE TABLE Employees (
    idemp INTEGER AUTO_INCREMENT,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    email VARCHAR(30) NOT NULL,
    position CHAR(1) NOT NULL DEFAULT 'C',
    PRIMARY KEY (idemp)
);
INSERT INTO Employees VALUES(idemp,"Jozef","Haluska","jozef.h@gmail.com","C");
INSERT INTO Employees VALUES(idemp,"Martin","Gall","martin.g@gmail.com","C");
INSERT INTO Employees VALUES(idemp,"Peter","Moricz","peter.m@gmail.com","C");



CREATE TABLE LoginEmployee (
    id INTEGER AUTO_INCREMENT,
    idemp INTEGER,
    login VARCHAR(15) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idemp)
        REFERENCES Employees (idemp)
        ON DELETE CASCADE ON UPDATE RESTRICT
);
INSERT INTO LoginEmployee VALUES(id,1, "user1","secret");
INSERT INTO LoginEmployee VALUES(id,2, "user2","secret");
INSERT INTO LoginEmployee VALUES(id,3, "user3","secret");



                          
CREATE TABLE HistoryLoginEmployee (
    id INTEGER AUTO_INCREMENT,
    idemp INTEGER,
    logindate DATETIME,
    PRIMARY KEY (id),
    FOREIGN KEY (idemp)
        REFERENCES Employees (idemp)
        ON DELETE CASCADE ON UPDATE RESTRICT
);

CREATE TABLE Clients (
    idc INTEGER AUTO_INCREMENT,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    disable CHAR(1) DEFAULT 'F',
    PRIMARY KEY (idc)
);
INSERT INTO Clients VALUES(idc,"Jozef","Golonka",'F');
INSERT INTO Clients VALUES(idc,"Maria","Terezia",'F');
INSERT INTO Clients VALUES(idc,"Monika","Benova",'F');
INSERT INTO Clients VALUES(idc,"Filip","Gajdos",'F');
INSERT INTO Clients VALUES(idc,"Dusan","Sten",'F');
INSERT INTO Clients VALUES(idc,"Jan","Gas",'F');
INSERT INTO Clients VALUES(idc,"Mirosalv","Hubovic",'F');
INSERT INTO Clients VALUES(idc,"Marketa","Navratilova",'F');




CREATE TABLE ClientDetails (
    idcd INTEGER AUTO_INCREMENT,
    idc INTEGER NOT NULL,
    street VARCHAR(30) NOT NULL,
    housenumber INTEGER NOT NULL,
    postcode CHAR(5) NOT NULL,
    City VARCHAR(30) NOT NULL,
    dob DATE NOT NULL,
    email VARCHAR(30) NOT NULL,
    PRIMARY KEY (idcd),
     FOREIGN KEY (idc)
     REFERENCES Clients (idc)
     ON DELETE CASCADE ON UPDATE RESTRICT
);
INSERT INTO ClientDetails VALUES(idcd,1,"Alexyho",5,"98513","Presov",'1993-01-13',"Golonka@gmail.com");
INSERT INTO ClientDetails VALUES(idcd,2,"Bellova",8,"92545","Kosice",'1987-02-24',"Terezia@gmail.com");
INSERT INTO ClientDetails VALUES(idcd,3,"Bottova",32,"93004","Banska Bystrica",'1988-04-15',"Benova@gmail.com");
INSERT INTO ClientDetails VALUES(idcd,4,"Cintorinska",5,"23112","Zvolen",'1983-12-21',"Gajdos@gmail.com");
INSERT INTO ClientDetails VALUES(idcd,5,"Dlziny",63,"31241","Trnava",'1969-07-28',"Sten@gmail.com");
INSERT INTO ClientDetails VALUES(idcd,6,"Hony",142,"53232","Bratislava",'1971-05-11',"Gas@gmail.com");
INSERT INTO ClientDetails VALUES(idcd,7,"Hriadky",6,"52355","Kosice",'1969-02-11',"Hubovic@gmail.com");
INSERT INTO ClientDetails VALUES(idcd,8,"Chalupkova",3,"23245","Komarno",'1989-01-12',"Navratilova@gmail.com");



CREATE TABLE LoginClient (
    idlc INTEGER AUTO_INCREMENT,
    idc INTEGER NOT NULL,
    login VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
	blocked CHAR(1) DEFAULT 'F',
    PRIMARY KEY (idlc),
     FOREIGN KEY (idc)
     REFERENCES Clients (idc)
     ON DELETE CASCADE ON UPDATE RESTRICT
);
INSERT INTO LoginClient VALUES(idlc,1,"Jozef","Golonka",'F');
INSERT INTO LoginClient VALUES(idlc,2,"Maria","Terezia",'F');
INSERT INTO LoginClient VALUES(idlc,3,"Monika","Benova",'F');
INSERT INTO LoginClient VALUES(idlc,4,"Filip","Gajdos",'F');
INSERT INTO LoginClient VALUES(idlc,5,"Dusan","Sten",'F');
INSERT INTO LoginClient VALUES(idlc,6,"Jan","Gas",'F');
INSERT INTO LoginClient VALUES(idlc,7,"Mirosalv","Hubovic",'F');
INSERT INTO LoginClient VALUES(idlc,8,"Marketa","Navratilova",'F');





CREATE TABLE  Accounts (
	idacc BIGINT UNIQUE,
    idc INTEGER NOT NULL,
    balance FLOAT(10,2) NOT NULL,
    PRIMARY KEY (idacc),
    FOREIGN KEY (idc)
     REFERENCES Clients (idc)
     ON DELETE CASCADE ON UPDATE RESTRICT
);
INSERT INTO Accounts VALUES(7201102161,1,3123.23);
INSERT INTO Accounts VALUES(2215970867,1,333321.23);
INSERT INTO Accounts VALUES(3804855395,1,75433.23);
INSERT INTO Accounts VALUES(1612136537,2,131231.54);



CREATE TABLE BankTransactions (
	idbt  INTEGER UNIQUE AUTO_INCREMENT,
    amount FLOAT(10,2) NOT NULL,
	transdatetime DATETIME NOT NULL,
    description VARCHAR(140),
    idemp INTEGER DEFAULT 0,
    srcacc BIGINT NOT NULL,
    destacc BIGINT NOT NULL,
    srcbank INT NOT NULL,
    destbank INT NOT NULL,    
    PRIMARY KEY (idbt),
    FOREIGN KEY (idemp)
     REFERENCES  Employees(idemp)
     );
     
 CREATE TABLE CashTransactions (
	idct  INTEGER UNIQUE AUTO_INCREMENT,
    idemp INTEGER NOT NULL,
    amount FLOAT(10,2) NOT NULL,
    idacc BIGINT NOT NULL,
	transdatetime DATETIME NOT NULL,
    PRIMARY KEY (idct),
    FOREIGN KEY (idemp)
     REFERENCES  Employees(idemp)
     ON DELETE RESTRICT ON UPDATE RESTRICT
     );  
     
     CREATE TABLE Cards(
		idcard INTEGER UNIQUE AUTO_INCREMENT,
        cardnumber BIGINT NOT NULL,
        idacc BIGINT NOT NULL,
        blocked BOOLEAN NOT NULL DEFAULT FALSE,
        pin INTEGER NOT NULL,
        PRIMARY KEY (idcard),
        FOREIGN KEY (idacc)
		REFERENCES  Accounts(idacc)
       ON DELETE CASCADE  ON UPDATE RESTRICT
     );
     
	CREATE TABLE ATMWithdrawals (
		idatmw  INTEGER UNIQUE AUTO_INCREMENT,
        amount FLOAT(10,2) NOT NULL,
        idatm INT NOT NULL,
        atmdatetime DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
		idcard INTEGER NOT NULL,
        PRIMARY KEY (idatmw),
        FOREIGN KEY (idcard)
        REFERENCES  Cards(idcard)
        ON DELETE CASCADE ON UPDATE RESTRICT
     );
     
     
     
     CREATE VIEW TransactionHistory
     AS SELECT transdatetime, idacc, amount, 'Cash transaction' AS des
               FROM cashtransactions
	 UNION ALL
	 SELECT transdatetime, srcacc as idacc, amount, CONCAT('Bank transaction: ',IFNULL(description,'')) AS des
               FROM banktransactions
	 UNION ALL
	 SELECT transdatetime, destacc as idacc, (-1)*amount, CONCAT('Bank transaction: ',IFNULL(description,'')) AS des
               FROM banktransactions
	 ORDER BY transdatetime desc;
               
               
               
               
               
               
               
               