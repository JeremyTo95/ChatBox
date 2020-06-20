package front.controller;

import back.server.SimpleClient;
import front.model.Constants;

public class LoginController {
    /*
        TODO: Connecter et initialiser les fonctionnalités
            --> Chargement du compte utilisateur depuis la bdd
            --> Initialisation du socket utlisateur
     */

    public static void initSocket(SimpleClient sc) {
        if (sc != null) sc.connect(Constants.IP_SOCKET);
        else System.out.println("Simple Client is null");
    }
}
