INSERT INTO THEATRE (ID, NAME,PERDE,DURATION,GENRE,DESCRIPTION) VALUES (1,'Diary of a Madman', 1, 100,'Drama','Diary of a Madman is a farcical short story by Nikolai Gogol. Along with The Overcoat and The Nose, Diary of a Madman is considered to be one of GogolWs greatest short stories.');
INSERT INTO THEATRE (ID, NAME,PERDE,DURATION,GENRE,DESCRIPTION) VALUES (2, 'Zengin Mutfagi', 2, 130,'Epik',
'not genuine, correct, or comprehensible Latin anymore. While lorem ipsum''s still resembles classical Latin, it actually has no meaning whatsoever. As Cicero''s text doesn''t contain the letters K, W, or Z, alien to latin, these, and others are often inserted randomly to mimic the typographic appearence of European languages, as are digraphs not to be found in the original.
');
INSERT INTO THEATRE (ID, NAME,PERDE,DURATION,GENRE,DESCRIPTION) VALUES (3, '12 Ofkeli Adam', 2, 110, 'Polisiye',
'not genuine, correct, or comprehensible Latin anymore. While lorem ipsum''s still resembles classical Latin, it actually has no meaning whatsoever. As Cicero''s text doesn''t contain the letters K, W, or Z, alien to latin, these, and others are often inserted randomly to mimic the typographic appearence of European languages, as are digraphs not to be found in the original.
');

ALTER TABLE THEATRE ALTER COLUMN DESCRIPTION TYPE VARCHAR(1000);

SELECT * FROM OPERATION;
SELECT * FROM THEATRE;

SELECT COUNT(*) FROM OPERATION;

SELECT OPERATION_TYPE, COUNT(*) FROM OPERATION WHERE CLASS_LABEL='MALICIOUS' GROUP BY OPERATION_TYPE;

SELECT OPERATION_BASE, COUNT(*) FROM OPERATION WHERE CLASS_LABEL='MALICIOUS' GROUP BY OPERATION_BASE;

SELECT OPERATION_TYPE, COUNT(*) FROM OPERATION WHERE CLASS_LABEL='REGULAR' GROUP BY OPERATION_TYPE;
