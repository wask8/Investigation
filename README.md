# Investigation

README FOR INVESTIGATION GAME BY : L M J K


________________________________ Lucas 31/05 _________________________________________
Pouvez vous jeter un oeil au PanelHistoire.java y'a un soucis, le KeyListener n'est pas pris en compte dans la partie SCENARIO, ce qui fait que le texte du scenario ne change pas, et que le nombre de questions restantes reste fixe aussi. Tout fonctionne une fois rentré dedans donc le soucis vient pas du KeyPressed mais AVANT. J'ai fait quelques tests pour voir d'où pouvait venir le soucis, il semblerait que ce soit par rapport à l'accumulation de panel sur la page, il ne sait pas lequel cibler (test effectué sur une fenetre avec juste un panel + 2 JLabel (scenario+questions restantes) et ça marche à merveille). Bref j'ai plus d'idée donc je veux bien que vous m'aidiez ^^ 

_______________________________________________________________________________________

Packaging : 

lmjk.com.[packagenom]o

Packages :
  - Display
  - Game
  -(++)
  
Class :
  - GameMain
  - Button x 6
  - MenuPanel
  - OptionPanel
  - Fenêtre
  - Display Pos
  - Int
  
Penser à nommer les ATTRIBUTS, METHODES, VARIABLES, CLASSES de manières cohérentes et compréhensibles pour tous
Eviter les variables de types : "a" ou " b1" mais plutot "bouttonHistoire", "boutonOption" par exemple
Penser à annoter, commenter le code car très utiles pour les autres ( faire aussi JDoc si besoin ).

Vous pouvez éditer le README en cliquant en haut à droite sur le "crayon"
