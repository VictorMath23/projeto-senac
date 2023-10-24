
INSERT INTO area (area) VALUES 
('Manufatura'),
('Processos'),
('Sistemas'),
('Produto'),
('Automação'),
('Qualidade'),
('Materiais');

SELECT * FROM firsts.area;

INSERT INTO beneficio (beneficio) VALUES 
('5S'),
('Ganho de produção'),
('Redução de SCRAP'),
('Automatização');

SELECT * FROM firsts.beneficio;

INSERT INTO gestor (nome,email,matricula,area,comite) VALUES 
('Juari de Oliveira','joliveira','701020','1','Y'),
('Rodrigo Ramon','rramon','702030','3','Y'),
('Fausto Corazza','fcorazza','703040','4','N'),
('Julio Tebalde','jtebalde','704050','2','N'),
('Giovanni Santana','gsantana','705060','5','Y'),
('Antonio Bordon','abordon','706070','6','N'),
('Julio Santos','jsantos','708090','7','Y');

SELECT * FROM firsts.gestor;

INSERT INTO `firsts`.`ideia` (`dono`, `proposta`, `area_id`, `beneficio_id`, `gestor_id`, `data_ideia`, `status`) VALUES ('Junior Alexandre', 'implementar uma tela com dashboard de falhas na manufatura', '1', '4', '1', '2023-03-14 00:00:00', 'Analise');
INSERT INTO `firsts`.`ideia` (`dono`, `proposta`, `area_id`, `beneficio_id`, `gestor_id`, `data_ideia`, `status`) VALUES ('Fernanda Souza', 'Fazer tags vermelhas para identificar falhas no processo de teste', '2', '1', '3', '2023-03-14 00:00:00', 'Analise');
INSERT INTO `firsts`.`ideia` (`dono`, `proposta`, `area_id`, `beneficio_id`, `gestor_id`, `data_ideia`, `status`) VALUES ('Francisco Jhonatas', 'Criar um novo sistema para inserir ideias identificadas no processo', '3', '4', '2', '2023-03-14 00:00:00', 'Analise');

SELECT * FROM ideia;

SELECT ideia.id,ideia.dono,ideia.proposta,area.area,beneficio.beneficio,gestor.nome,DATE_FORMAT(ideia.data_ideia, '%y-%m-%d %H:%i:%s') as DATETIME,ideia.status FROM ideia
INNER JOIN area ON area_id = area.id 
INNER JOIN beneficio ON Beneficio_id = beneficio.id
INNER JOIN gestor ON gestor_id = gestor.id;