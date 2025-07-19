import java.util.Scanner;

public class Main {

    private static void exibirResumo(ContaBancaria conta) {
        System.out.printf("Saldo atual: %.2f (saldo) + %.2f (limite cheque especial) = %.2f (saldo total)\n",
                conta.getSaldo(), conta.getLimiteChequeEspecial(), conta.getSaldoTotal());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha entre uma das opções abaixo:");
        System.out.println("1 - consultar saldo");
        System.out.println("2 - consultar cheque especial");
        System.out.println("3 - depositar dinheiro");
        System.out.println("4 - sacar dinheiro");
        System.out.println("5 - pagar boleto");
        System.out.println("6 - verificar se a conta está usando cheque especial\n");

        int chosenOption;
        double valorDeposito;

        var conta = new ContaBancaria();


        while (true) {


            chosenOption = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (chosenOption) {
                case 0:
                    System.out.println("Saindo...");
                    return;
                case 1:
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    exibirResumo(conta);
                    break;
                case 2:
                    System.out.println("Cheque especial: " + conta.getLimiteChequeEspecial());
                    break;
                case 3:
                    System.out.println("Valor do depósito: ");
                    valorDeposito = scanner.nextDouble();
                    scanner.nextLine();
                    double taxaCobrada = conta.depositar(valorDeposito);

                    System.out.println("Depósito realizado com sucesso!");

                    if (taxaCobrada > 0) {
                        System.out.printf("Atenção: foi cobrada uma taxa de %.2f pelo uso do cheque especial.\n", taxaCobrada);
                    }

                    exibirResumo(conta);
                    break;

                case 4:
                    System.out.println("Valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();
                    if (conta.sacar(valorSaque)) {
                        exibirResumo(conta);
                        if (conta.usandoChequeEspecial()) {
                            System.out.printf("Atenção: será cobrada uma taxa de R$ %.2f no próximo depósito.\n", conta.calcularTaxaPendente());
                        }
                    } else {
                        System.out.println("Saldo insuficiente para realizar o saque.");
                    }
                    break;

                case 5:
                    System.out.println("Valor do boleto: ");
                    double valorBoleto = scanner.nextDouble();
                    scanner.nextLine();
                    if (conta.pagarBoleto(valorBoleto)) {
                        exibirResumo(conta);
                        if (conta.usandoChequeEspecial()) {
                            System.out.printf("Atenção: será cobrada uma taxa de R$ %.2f no próximo depósito.\n", conta.calcularTaxaPendente());
                        }
                    } else {
                        System.out.println("Saldo insuficiente para pagar o boleto.");
                    }
                    break;
                case 6:
                    if (conta.usandoChequeEspecial()) {
                        System.out.printf("Você está usando %.2f do cheque especial.\n", conta.getValorUsadoChequeEspecial());
                    } else {
                        System.out.println("Você não está usando o cheque especial.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção entre 0 e 6.");
                    break;
            }

            }
    }
}