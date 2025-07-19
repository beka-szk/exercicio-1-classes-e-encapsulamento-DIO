# ☕ Simulador de Conta Bancária em Java

![Linguagem](https://img.shields.io/badge/Linguagem-Java-blue.svg)
![Status](https://img.shields.io/badge/Status-Concluído-green.svg)

## 📄 Sobre o Projeto

Este é um projeto de console interativo, desenvolvido em Java, que simula as operações básicas de uma conta bancária. O objetivo principal foi aplicar e solidificar conceitos fundamentais de **Programação Orientada a Objetos (POO)**, como encapsulamento, abstração e separação de responsabilidades.

O sistema permite que o usuário gerencie uma conta virtual, realizando transações comuns e lidando com regras de negócio como o uso de cheque especial e a cobrança de taxas.

Este projeto foi desenvolvido como parte dos desafios práticos do **Bootcamp de Java e IA da DIO em parceria com a NTT DATA**.

---

## ✨ Funcionalidades

* **Consultar Saldo:** Exibe o saldo atual, o limite do cheque especial e o saldo total disponível.
* **Depósito:** Adiciona fundos à conta. O limite do cheque especial é definido com base no valor do **primeiro depósito** e permanece fixo posteriormente.
* **Saque:** Retira fundos da conta, utilizando o cheque especial automaticamente se o saldo for insuficiente.
* **Pagamento de Boleto:** Reutiliza a lógica de saque para simular o pagamento de contas.
* **Gestão de Cheque Especial:**
    * Permite verificar o valor exato que está sendo utilizado do limite.
    * Sistema de "taxa pendente" que é ativado quando o cheque especial é utilizado.
    * A taxa (20% sobre o valor utilizado) é cobrada automaticamente no próximo depósito que deixar o saldo positivo.
* **Menu Interativo:** Um menu em loop com tratamento de opções inválidas para uma experiência de usuário contínua.

---

## 🛠️ Tecnologias e Conceitos Praticados

Este projeto foi uma oportunidade para praticar os seguintes conceitos:

* **Linguagem:** Java (utilizando recursos do JDK 17+)
* **Programação Orientada a Objetos (POO):**
    * **Classes e Objetos:** Estruturação do código em `Main` (interação) e `ContaBancaria` (modelo de negócio).
    * **Encapsulamento:** Uso de campos `private` e métodos `public` (getters) para proteger e controlar o acesso aos dados.
    * **Abstração:** Foco na lógica de negócio dentro da classe `ContaBancaria`, escondendo a complexidade da implementação.
* **Estruturas de Controle:** Loops (`while`) e Estruturas de Decisão (`switch-case`) para controlar o fluxo do programa.
* **Entrada e Saída de Dados:** Uso da classe `Scanner` para interação com o usuário via terminal.
* **Boas Práticas de Código:**
    * Separação de responsabilidades (Modelo / Visão).
    * Criação de métodos auxiliares (`private static`) para evitar repetição de código (DRY - Don't Repeat Yourself).
    * Refatoração de código para maior clareza e segurança (ex: `if-else if` para `switch`).

---

## 🚀 Como Executar o Projeto

**Pré-requisitos:**
* Ter o **JDK (Java Development Kit) 17 ou superior** instalado.

**Passos:**
1.  Clone o repositório:
    ```bash
    git clone [https://github.com/beka-szk/exercicio-1-classes-e-encapsulamento-DIO.git](https://github.com/beka-szk/exercicio-1-classes-e-encapsulamento-DIO.git)
    ```
2.  Abra o projeto na sua IDE de preferência (IntelliJ, Eclipse, VS Code).
3.  Localize e execute o método `main` no arquivo `Main.java`.
4.  Siga as instruções exibidas no console para interagir com a conta bancária.

---

## ✒️ Autora

Feito com ❤️ por **Beka S.**

[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/beka-szk/)
