# Puzzle-3x3

1. Introducció
Aquest projecte consisteix en el desenvolupament d’un joc de trencaclosques de 3x3 peces
amb interfície gràfica mitjançant Java i Swing. L’objectiu és proporcionar un joc on l’usuari
pugui resoldre el trencaclosques fins a reconstruir la imatge original, utilitzant com a entrada
les tecles de direcció (W, A, S, D).
La pràctica tracta coneixements adquirits durant l’assignatura de Programació II, destacant
aspectes com la programació orientada objectes, la manipulació d’imatges, i la gestió
d’esdeveniments en interfícies gràfiques.
2. Disseny i implementació
El programa està estructurat en diverses classes amb responsabilitats clarament definides.
La classe principal (Joc) és la porta d’entrada de l’aplicació, des de la qual es construeix la
interfície gràfica i es connecten la lògica del joc i la gestió de les imatges.
2.1. Estructura general
Per al desenvolupament d’aquest projecte hem aplicat un disseny descendent, partint de
l’objectiu general —crear un joc de puzzle amb imatges— i dividint-lo en components
funcionals més petits. Això ens ha permès repartir millor les tasques entre els dos membres
de l’equip i assegurar una estructura clara i modular del codi.
La solució s’ha estructurat en quatre classes principals:
1. Casilla
És la classe que representa cada peça del puzzle. Conté informació sobre la imatge que hi
ha a cada posició, així com les coordenades correctes i actuals. També gestiona si la
casella és buida (per permetre el moviment).
Mètodes destacats:
getImatge() i setImatge(...): Get i set
esBuida(): indica si és la casella buida
2
2. Imatge
Aquesta classe gestiona la càrrega i fragmentació de la imatge. Agafa una imatge global i la
divideix en tantes parts com calgui per formar el puzzle. (A n’aquest cas en un array de 9
components)
Mètodes destacats:
carregaImatges(): llegeix les imatges des del disc
getTros(i): retorna la porció de la imatge que correspon a una casella concreta
3. Puzzle
Conté la lògica del joc: crea les caselles, les barreja aleatòriament i comprova si el puzzle
està resolt.
Mètodes destacats:
inicialitzar(): ordena les peces
escapçar(): desordena les peces
moure( Char ): mou la casella buida cap a una direcció
estaResolt(): comprova si totes les peces són a lloc
4. Joc
És la classe principal que munta la interfície gràfica. Aquí es crea la finestra, es mostren les
caselles i es gestionen els esdeveniments de les tecles.
Mètodes destacats:
inicialitzaMenu(): crea i mostra el menu i redimensiona les imatges cuan es redimensiona la
finestra
inicialitzarTauler(): crea el tauler amb un redimensionament incluit
refrescarTauler(): redibuixa la finestra després de cada moviment
2.2. Interacció i control
Entrada per teclat: S’intercepten les tecles W, A, S, D per moure la peça buida en les quatre
direccions.
Comprovació de resolució: Cada vegada que l’usuari realitza un moviment, es comprova
automàticament si totes les peces estan en la seva posició correcta. Fins que està resolt i
s’utilitza JOptionPane per mostrar un missatge quan el joc s’ha resolt correctament.
3
2.3. Disseny visual
El trencaclosques es compon de 8 imatges (ImageIcon) disposades en un panell de 3x3.
Es reserva una posició com a “casella buida” que permet el moviment de les altres peces.
Les imatges són escalades automàticament per adaptar-se a la mida del component gràfic.
Hi ha una linea negra que separa cada imatge.
3. Detalls tècnics
Entorn de desenvolupament: NetBeans IDE.
Llibreries utilitzades: javax.swing, java.awt, java.awt.event, javax.imageio.
Control de flux: Patró observador per actualitzar el tauler gràfic després de cada acció.
4. Conclusions i anàlisi crítica
El desenvolupament d’aquest trencaclosques ha permès aplicar de manera pràctica
diversos conceptes fonamentals de la programació orientada a objectes i de la programació
gràfica amb Java.
Aspectes assolits
Disseny modular correcte amb responsabilitats ben definides per classe.
Ús eficient de Swing per crear una interfície funcional i visualment clara.
Implementació correcta de la lògica de joc i detecció de condició de victòria.
Dificultats i reptes
En el principi el que més complicat ens va parèixer, va ser aplicar la comprovació després
de cada moviment, i refrescar el tauler.
La càrrega i escalat de les imatges hem hagut de fer diversos ajustos per mantenir bé les
imatges sense desbordar el panell.
També ha estat clau gestionar correctament la lògica de moviment, assegurant que no es
produeixin desbordaments fora dels límits del tauler.
Aprenentatges clau
La importància de separar en classes el funcionament del joc
L’ús pràctic dels esdeveniments de teclat (KeyListener) i la seva integració amb el model del
joc.
4
Com gestionar recursos gràfics en aplicacions Java.
Aquest projecte ha suposat un bon ajut per consolidar habilitats essencials en el
desenvolupament d'aplicacions gràfiques i la gestió d’interaccions d’usuari en entorns
orientats a objectes.
