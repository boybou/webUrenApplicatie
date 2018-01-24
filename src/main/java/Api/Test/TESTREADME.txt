Voordat er getest kan worden moet de bestaande "webeduurendatabase" gedropt worden

#1: DROP DATABASE webeduurendatabase;

Daarna moet deze database opnieuw aangemaakt worden en moet er een test script in worden geladen

#2: CREATE DATABASE webeduurendatabase;

#3: run TestSqlScript in de webeduurendatabase

Als alle testen voltooid zijn moet opnieuw de "webeduurendatabase" gedropt worden,
en moet er nu het normale SqlScript ingeladen worden

#4: DROP DATABASE webeduurendatabase;

#5: CREATE DATABASE webeduurendatabase;

#6: run SqlScript in webeduurendatabase

