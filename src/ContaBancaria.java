public class ContaBancaria {
    private double saldo;
    private double limiteChequeEspecial;
    private double valorUsadoChequeEspecial;
    private boolean taxaPendente;
    private double taxa;

    public ContaBancaria() {
        this.saldo = 0;
        this.limiteChequeEspecial = 0;
        this.valorUsadoChequeEspecial = 0;
        this.taxaPendente = false;
        this.taxa = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public double getSaldoTotal() {
        return saldo + limiteChequeEspecial;
    }

    public double getValorUsadoChequeEspecial() {
        return valorUsadoChequeEspecial;
    }

    public double depositar(double valor) {
        if (valor <= 0) {
            return 0;
        }
        this.saldo += valor;

        if (this.limiteChequeEspecial == 0) {
            System.out.println("Primeiro depósito detectado. Definindo limite do Cheque Especial.");
            if (valor <= 500) {
                this.limiteChequeEspecial = 50;
            } else {
                this.limiteChequeEspecial = valor * 0.5;
            }
        }

        if (this.taxaPendente && this.saldo > 0) {
            return aplicarTaxaChequeEspecial();
        }
        return 0;
    }

    public boolean sacar(double valor) {
        if (valor < 0) {
            return false;
        }

        if (valor <= (this.saldo + this.limiteChequeEspecial)) {
            this.saldo -= valor;

            if (this.saldo < 0) {
                this.valorUsadoChequeEspecial = -this.saldo;
                taxaPendente = true;

            } else {
                this.valorUsadoChequeEspecial = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean pagarBoleto(double valor) {
        return sacar(valor);
    }

    public boolean usandoChequeEspecial() {
        return this.valorUsadoChequeEspecial > 0;
    }

    public double calcularTaxaPendente() {
        if (this.taxaPendente) {
            return this.valorUsadoChequeEspecial * 0.2;
        }
        return 0.0; // Se não há taxa pendente, a taxa futura é zero.
    }

    private double aplicarTaxaChequeEspecial() {
        taxa = valorUsadoChequeEspecial * 0.2;
        saldo -= taxa;
        taxaPendente = false;
        valorUsadoChequeEspecial = 0;
        return taxa;
    }
}

