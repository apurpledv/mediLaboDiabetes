db = db.getSiblingDB('db_notes');
db.createCollection("notes");
db.notes.insertMany([
  {
    "_id": new ObjectId(),
    "patientId": "1",
    "patientLastName": "TestNone",
    "noteContent": "Le patient déclare qu'il 'se sent très bien' \r\nPoids égal ou inférieur au poids recommandé",
    "_class": "com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note"
  },
  {
    "_id": new ObjectId(),
    "patientId": "2",
    "patientLastName": "TestBorderline",
    "noteContent": "Le patient déclare qu'il ressent beaucoup de stress au travail \r\nIl se plaint également que son audition est anormale dernièrement",
    "_class": "com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note"
  },
  {
    "_id": new ObjectId(),
    "patientId": "2",
    "patientLastName": "TestBorderline",
    "noteContent": "Le patient déclare avoir fait une réaction aux médicaments au cours des 3 derniers mois\r\nIl remarque également que son audition continue d'être anormale",
    "_class": "com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note"
  },
  {
    "_id": new ObjectId(),
    "patientId": "3",
    "patientLastName": "TestInDanger",
    "noteContent": "Le patient déclare qu'il fume depuis peu",
    "_class": "com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note"
  },
  {
    "_id": new ObjectId(),
    "patientId": "3",
    "patientLastName": "TestInDanger",
    "noteContent": "Le patient déclare qu'il est fumeur et qu'il a cessé de fumer l'année dernière \r\nIl se plaint également de crises d’apnée respiratoire anormales\r\nTests de laboratoire indiquant un taux de cholestérol LDL élevé",
    "_class": "com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note"
  },
  {
    "_id": new ObjectId(),
    "patientId": "4",
    "patientLastName": "TestEarlyOnset",
    "noteContent": "Le patient déclare qu'il lui est devenu difficile de monter les escaliers \r\nIl se plaint également d’être essoufflé \r\nTests de laboratoire indiquant que les anticorps sont élevés \r\nRéaction aux médicaments",
    "_class": "com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note"
  },
  {
    "_id": new ObjectId(),
    "patientId": "4",
    "patientLastName": "TestEarlyOnset",
    "noteContent": "Le patient déclare qu'il a mal au dos lorsqu'il reste assis pendant longtemps",
    "_class": "com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note"
  },
  {
    "_id": new ObjectId(),
    "patientId": "4",
    "patientLastName": "TestEarlyOnset",
    "noteContent": "Le patient déclare avoir commencé à fumer depuis peu \r\nHémoglobine A1C supérieure au niveau recommandé",
    "_class": "com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note"
  },
  {
    "_id": new ObjectId(),
    "patientId": "4",
    "patientLastName": "TestEarlyOnset",
    "noteContent": "Taille, Poids, Cholestérol, Vertige et Réaction",
    "_class": "com.openclassrooms.mediLaboDiabetes_ms_notes.model.Note"
  }
]);