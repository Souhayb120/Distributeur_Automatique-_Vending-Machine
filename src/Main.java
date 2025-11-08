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
   
  
    // stock
    static void updateStock(int produitNum , double montant) {
        double prixProduit = VendingMachine.prix.get(produitNum);
        int StockActuel = VendingMachine.stock.get(produitNum);
        try{
             if(StockActuel > 0){
            if(montant < prixProduit){
                System.out.println("The amount is unsifficient, the prix is "+prixProduit +"MAD");
                return;
            }
            else if(montant >= prixProduit){
                double restMoney = montant - prixProduit;
                VendingMachine.stock.set(produitNum ,StockActuel -1);
                System.out.println("you have Bought : " + VendingMachine.produits.get(produitNum));
                System.out.println("Monnaie rendue :"+restMoney +"MAD");
                System.out.println("Quantity Stock :"+VendingMachine.stock.get(StockActuel));
                VendingMachine.countAchat += 1;
                System.out.println("Total Achats :"+ VendingMachine.countAchat);
            }
        }else{
            System.out.println("Stock epuise pour "+ VendingMachine.produits.get(produitNum));
        }
        }
        catch(Exception e){
            System.out.println("Error :"+ e.getMessage());
        }
       
    }
    //Acheter Produit
    public static void  AcheterPrduit(){
        try{
         Scanner sc = new Scanner(System.in);
        System.out.println("Entre product number :");
        int choixproduit = sc.nextInt() -1;
        if(choixproduit >= 0 && choixproduit < VendingMachine.produits.size()){
         System.out.println("Entrez le montant insere :");
        double montant = sc.nextDouble();
        updateStock(choixproduit, montant);
    
 }else{
    System.out.println("Produit invalid !");
 }
        }
        catch(Exception e){
            System.out.println("Error :"+ e.getMessage());
        }
    }

    public static void main(String[] args) {
        AcheterPrduit();
    }
}