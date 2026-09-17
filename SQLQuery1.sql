CREATE TABLE Sistemas (
Sis_ID VARCHAR(10) PRIMARY KEY, 
Sis_Nome VARCHAR (100) NOT NULL, 
Sis_Empresa VARCHAR (100) NOT NULL,
Sis_Responsavel VARCHAR (100) NOT NULL
);


INSERT INTO Sistemas (Sis_ID,Sis_Nome,Sis_Empresa,Sis_Responsavel)VALUES
('001', 'Sistema X', 'Empresa001','jose.silva'),
('002', 'Sistema Y', 'Empresa002','jose.silva');

CREATE TABLE Funcionarios(
Fun_ID VARCHAR (10) PRIMARY KEY,
Fun_Nome_Completo VARCHAR (150) NOT NULL,
Fun_Status VARCHAR (20) NOT NULL,
Fun_Cargo VARCHAR (100) NOT NULL
);

INSERT INTO Funcionarios (Fun_ID, Fun_Nome_Completo, Fun_Status, Fun_Cargo) VALUES
('001','Jose da Silva','Ativo','Analista'),
('0002','Joao da Silva', 'Inativo', 'Coordernador');

SELECT * FROM Funcionarios, Sistemas;
