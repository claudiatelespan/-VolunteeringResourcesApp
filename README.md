3 clase, Persoana, Feedback si Eveniment
Persoana: id, nume, varsta, facultate;
Feedback: id_persoana, id_eveniment, rating, comentariu, nume_eveniment, nume_persoana
Eveniment: id_eveniment, nume, asociatie, data, locatie, descriere, *lista_persoane

MainActivity: lista cu oportunitati de voluntariat, cu asociatie, data eveniment, descriere, locatie

SignUpActivity: formular de inscriere la o oportunitate, prin buton de inscriere si care o sa ceara detalii despre tine si un spinner din care alege evenimentul

FeedbackActivity: lista cu feedback-uri pentru oportunitatile de voluntariat, cu o posibila filtrare pe evenimente

AddFeedbackActivity: formular unde completezi feedback-ul pt evenimente cu text, rating, evenimentul in cauza, cine l-a dat

ResourcesActivity: o secțiune dedicată materialelor utile pentru voluntari, precum ghiduri de voluntariat, link-uri către articole, etc

Funcționalitate unică: Implementare dark theme printr-un buton cu care faci toggle intre teme

Sarcini:
Raluca - SignUpActivity + cls Persoana
Ruxi - AddFeedbackActivity + Feedback
Claudia - FeedbackActivity
Dani - MainActivity + Eveniment
Diana - ResourcesActivity + dark theme 
