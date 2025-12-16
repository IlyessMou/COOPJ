package first.prosit11F;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManagement pm = new ProductManagement();
        
        List<Product> products = Arrays.asList(
            new Product(3, "Laptop", 1200.50),
            new Product(1, "Souris", 25.99),
            new Product(2, "Keyboard", 75.00),
            new Product(5, "Screen", 350.00),
            new Product(4, "Webcam", 89.99)
        );

        System.out.println("1. Afficher tous les produits");
        pm.displayProducts(products, p -> System.out.println(p));

        System.out.println("2. Produits avec prix > 50€");
        pm.displayProductsByFilter(products, p -> p.getPrix() > 50, p -> System.out.println(p));

        System.out.println("3. Liste des noms de produits");
        String names = pm.returnProductsNames(products, Product::getNom);
        System.out.println(names);

        System.out.println("4. Créer un nouveau produit");
        Product newProduct = pm.createProduct(() -> new Product(6, "Imprimante", 199.99));
        System.out.println("Produit créé: " + newProduct);

        System.out.println("5. Trier les produits par ID");
        List<Product> sorted = pm.sortProductsById(products, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
        sorted.forEach(System.out::println);

        System.out.println("6. Utiliser Stream - Produits < 100€");
        pm.convertToStream(products).filter(p -> p.getPrix() < 100).forEach(p -> System.out.println("Produit abordable: " + p.getNom() + "=" + p.getPrix() + "€"));

        System.out.println("7. Utiliser Stream - Prix moyen");
        double avgPrice = pm.convertToStream(products).mapToDouble(Product::getPrix).average().orElse(0.0);
        System.out.println("Prix moyen: " + avgPrice + "€");
    }
}