import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static class VendingMachine {
        static ArrayList<String> produits = new ArrayList<>(Arrays.asList("Eau", "Soda", "Chips", "Chocolat"));
        static ArrayList<Double> prix = new ArrayList<>(Arrays.asList(5.0, 8.0, 12.0, 15.0));
        static ArrayList<Integer> stock = new ArrayList<>(Arrays.asList(10, 5, 7, 3));
        static int countAchat = 0;
    }

    static void updateStock(int produitNum, double montant) {
        double prixProduit = VendingMachine.prix.get(produitNum);
        int StockActuel = VendingMachine.stock.get(produitNum);
        if (StockActuel > 0) {
            if (montant < prixProduit) {
                System.out.println("The amount is unsifficient, the prix is " + prixProduit + " MAD");
            } else {
                double restMoney = montant - prixProduit;
                VendingMachine.stock.set(produitNum, StockActuel - 1);
                System.out.println("you have Bought : " + VendingMachine.produits.get(produitNum));
                System.out.println("Monnaie rendue :" + restMoney + " MAD");
                System.out.println("Quantity Stock :" + VendingMachine.stock.get(produitNum));
                VendingMachine.countAchat++;
                System.out.println("Total Achats :" + VendingMachine.countAchat);
            }
        } else {
            System.out.println("Stock epuise pour " + VendingMachine.produits.get(produitNum));
        }
    }

    public static void AcheterPrduit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entre product number :");
        int choixproduit = sc.nextInt() - 1;
        if (choixproduit >= 0 && choixproduit < VendingMachine.produits.size()) {
            System.out.println("Entrez le montant insere :");
            double montant = sc.nextDouble();
            updateStock(choixproduit, montant);
        } else {
            System.out.println("Produit invalid !");
        }
    }

    public static void adminMode() {
        Scanner sc = new Scanner(System.in);
        try{
        System.out.print("Password: ");
        String pass = sc.nextLine();
        if (!pass.equals("123")) return;
        System.out.print("Name: ");
        String n = sc.nextLine();
        System.out.print("Price: ");
        double p = sc.nextDouble();
        System.out.print("Stock: ");
        int s = sc.nextInt();
        VendingMachine.produits.add(n);
        VendingMachine.prix.add(p);
        VendingMachine.stock.add(s);
        System.out.println("Added!");
        }catch(Exception e)
        {
            System.out.println("Errore : " + e);
        }
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n========== DISTRIBUTEUR AUTOMATIQUE =====");
            System.out.println("Produits disponibles :");
            for (int i = 0; i < VendingMachine.produits.size(); i++) {
                System.out.println((i + 1) + ". " + VendingMachine.produits.get(i) + " - " + VendingMachine.prix.get(i) + " MAD" + " (Stock : " + VendingMachine.stock.get(i) + ")");
            }
            System.out.println("5. Admin mode");
            System.out.println("0. Quitter");
            System.out.print("\nChoisissez un produit (0 pour quitter) : ");
            int choix = scanner.nextInt();

            if (choix == 0) {
                System.out.println("Merci ! À bientôt ");
                continuer = false;
            } else if (choix == 5) {
                adminMode();
            } else if (choix > 0 && choix <= VendingMachine.produits.size()) {
                System.out.println("Vous avez sélectionné : " + VendingMachine.produits.get(choix - 1));
                
                AcheterPrduit();
            } else {
                System.out.println("Choix invalide !");
            }
        }
        scanner.close();
    }
}
