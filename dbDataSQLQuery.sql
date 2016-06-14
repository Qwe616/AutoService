INSERT INTO AutoService.dbo.Auto (Name, Mark, Model) VALUES ('Автомобиль 2', 'Audi', 'A8');
INSERT INTO AutoService.dbo.Auto (Name, Mark, Model) VALUES ('Автомобиль 3', 'Lada', 'Vesta');
INSERT INTO AutoService.dbo.Auto (Name, Mark, Model) VALUES ('Автомобиль 4', 'Honda', 'Acord');
INSERT INTO AutoService.dbo.Auto (Name, Mark, Model) VALUES ('Автомобиль 5', 'Lada', 'Priora');


INSERT INTO AutoService.dbo.Details (Name) VALUES ('Кузов');
INSERT INTO AutoService.dbo.Details (Name) VALUES ('Салон');
INSERT INTO AutoService.dbo.Details (Name) VALUES ('Диски');
INSERT INTO AutoService.dbo.Details (Name) VALUES ('Двигатель');
INSERT INTO AutoService.dbo.Details (Name) VALUES ('Шины');

INSERT INTO AutoService.dbo.Properties (Name) VALUES ('Цвет');
INSERT INTO AutoService.dbo.Properties (Name) VALUES ('Материал');
INSERT INTO AutoService.dbo.Properties (Name) VALUES ('Вес(кг)');
INSERT INTO AutoService.dbo.Properties (Name) VALUES ('Производитель');
INSERT INTO AutoService.dbo.Properties (Name) VALUES ('Вместительность(человек)');
INSERT INTO AutoService.dbo.Properties (Name) VALUES ('Размер');
INSERT INTO AutoService.dbo.Properties (Name) VALUES ('Ширина');
INSERT INTO AutoService.dbo.Properties (Name) VALUES ('Мощность(л.с)');
INSERT INTO AutoService.dbo.Properties (Name) VALUES ('Удельный расход топлива');
INSERT INTO AutoService.dbo.Properties (Name) VALUES ('Крутящий момент');
INSERT INTO AutoService.dbo.Properties (Name) VALUES ('Тип');
INSERT INTO AutoService.dbo.Properties (Name) VALUES ('Вылет диска');
INSERT INTO AutoService.dbo.Properties (Name) VALUES ('Сверловка');

INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 1, 3, '1024');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 1, 4, 'Германия');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 2, 1, 'Черный');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 2, 3, '5');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 3, 1, 'Серебро');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 3, 2, 'Сталь');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 3, 3, '11кг');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 3, 4, 'Германия');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 3, 7, '22x6');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 3, 12, '43');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 3, 13, '34f6');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 9, 1, 'Черные');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 9, 2, 'Резина');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 9, 3, '9');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (2, 9, 4, 'Германия');
INSERT INTO AutoService.dbo.AutoDetailsProperties (Auto_id, Details_id, Properties_id, [Values]) VALUES (4203, 1, 2, 'Металл');
