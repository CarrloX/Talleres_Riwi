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
            System.out.println("deposito completado");
        } else {
            System.out.println("no te pases");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0) {
            if (cantidad <= balance) {
                balance -= cantidad;
                System.out.println("retiro realizado.");
            } else {
                System.out.println("no te pases");
            }
        } else {
            System.out.println("no te pases.");
        }
    }

    public void mostrarBalance() {
        System.out.println("El balance actual es: $" + balance);
    }

    public double getBalance() {
        return balance;
    }
}
