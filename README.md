# Progetto per il corso di Software Cognitive Radio dell'anno 2017

Nel file ci sono 3 sequenze da 1 milione di campioni ciascuna, composti da parte reale e parte immaginaria separati da un tab. Queste 3 sequenze rappresentano segnali complessi che sono stati ascoltati dal nostro terminale. 
In qualcuna, una o tutte è presente un segnale primario. Sono sequenza ricevute quindi presentano eventualmente segnale del primary user e ovviamente corrotto dal rumore catturato lungo la propagazione sul canale. Infatti ciascuna di queste 3 sequenze è osservata a un SNR (Rapporto segnale/rumore) diverso. In particolare ognuna è osservata a 4 SNR diversi (-13db, -8db, -3db, 2db).

Il progetto consiste nel capire se ciò che abbiamo ricevuto sia segnale utile più rumore o solo rumore (ipotesi H1)
