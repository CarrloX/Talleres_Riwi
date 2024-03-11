class CuentaBancaria {
    private String titular;
    private double balance;

    public CuentaBancaria(String titular, double balance) {
        this.titular = titular;
        this.balance = balance;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            balance += cantidad;
            System.out.println("Depósito de $" + cantidad + " realizado.");
        } else {
            System.out.println("No es posible depositar una cantidad negativa.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0) {
            if (cantidad <= balance) {
                balance -= cantidad;
                System.out.println("Retiro de $" + cantidad + " realizado.");
            } else {
                System.out.println("No es posible retirar $" + cantidad + ". Fondos insuficientes.");
            }
        } else {
            System.out.println("No es posible retirar una cantidad negativa.");
        }
    }

    public void mostrarBalance() {
        System.out.println("El balance actual es: $" + balance);
    }

    public double getBalance() {
        return balance;
    }
}
