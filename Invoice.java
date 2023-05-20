// Example about Single Responsiblity.
class Invoice {

    public double calculateTotal() {
        return 1000;
    }

    public static void main(String[] args) {
        System.out.print("Hello world");
    }
}

interface InvoicePrinter {
    public void printInvoice(Invoice invoice);
}

interface InvoiceRepository {
    public void storeInvoice(Invoice invoice);
}
