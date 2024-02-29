import java.util.Scanner;

class Currency{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Currency Converter");
        System.out.print("Enter base currency: ");
        String baseCurrency = scanner.nextLine();
        System.out.print("Enter target currency: ");
        String targetCurrency = scanner.nextLine();

     
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate == -1) {
            System.out.println("Unable to fetch exchange rates. Exiting.");
            return;
        }

        
        System.out.print("Enter the amount to convert: ");
        double amountToConvert = scanner.nextDouble();

        
        double convertedAmount = convertCurrency(amountToConvert, exchangeRate);

        
        System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
    }

    
    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        
        if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return 0.85;
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            return 1.18;
        } else {
            return -1; 
        }
    }

    
    private static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}

