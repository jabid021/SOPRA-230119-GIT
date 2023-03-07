-- Nettoyages
DELETE FROM espece;
ALTER TABLE espece ALTER COLUMN id RESTART WITH 1;

DELETE FROM reservation;
ALTER TABLE reservation ALTER COLUMN id RESTART WITH 1;

DELETE FROM activite;
ALTER TABLE activite ALTER COLUMN id RESTART WITH 1;

DELETE FROM biome;
ALTER TABLE biome ALTER COLUMN id RESTART WITH 1;

DELETE FROM compte;
ALTER TABLE compte ALTER COLUMN id RESTART WITH 1;


-- Données par défaut

INSERT INTO biome (nom, superficie, zone, version) VALUES
('Savane', 20, 'FORET', 0),
('Plaine', 20, 'VOLIERE', 0),
('Marin', 23, 'FORET', 1);


INSERT INTO activite (guide, prix, duree, vehicule, biome, type_activite) VALUES
(1, '100.50', 7, 'VOITURE', 1, 'Scientifique'),
(1, '25.00', 4, NULL, 2, 'Tourisme'),
(1, '25.00', 4, NULL, 2, 'Tourisme');


INSERT INTO compte (login, password, nom, prenom, anciennete, numero, voie, ville, cp, pays, type_compte) VALUES
('admin', 'not24get', 'Du Chataignier', 'Olivier', NULL, NULL, NULL, NULL, NULL, NULL, 'admin'),
('bg66', 'bg66', 'Rayonnant', 'Charles', NULL, '1 bis', 'rue de la Boustifaille', 'Grobuffet', '23000', 'France', 'client'),
('ranger', 'ranger', 'Pipenbois', 'Patrick', 11, NULL, NULL, NULL, NULL, NULL, 'ranger');


INSERT INTO espece (nom, effectif, indice_protection, dangerosite, biome, type_espece) VALUES
('Megalastrum canacae', 53, 0, NULL, 1, 'Vegetal'),
('Ochotona princeps', 17, 40, 99, 2, 'Animal'),
('Megalastrum canacae2', 53, 0, NULL, 1, 'Vegetal'),
('Ochotona princeps', 17, 40, 99, 1, 'Animal');


INSERT INTO reservation (effectif, prix, jour, heure, client, activite, ranger) VALUES
(2, '100.50', '2023-01-01', '15:00:00', 2, 1, NULL),
(4, '100.00', '2023-02-11', '15:00:00', 2, 2, 3),
(1, '100.50', '2023-02-11', '18:00:00', 2, 1, NULL);