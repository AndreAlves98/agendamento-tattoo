import agendamento.Agendamento; // Importando a classe que você criou
import java.util.ArrayList;
import java.util.Scanner;

public class StudioTattoo {
    private Scanner input = new Scanner(System.in);
    private ArrayList<Agendamento> agenda = new ArrayList<>();

    public static void main(String[] args) {
        StudioTattoo studio = new StudioTattoo();
        studio.exibirMenu();
    }

    public void exibirMenu() {
        int opcao = 0;

        do {
            for(int i = 0; i < 3; i++) System.out.println();

            System.out.println("##################################################");
            System.out.println("#                INK MASTER STUDIO               #");
            System.out.println("#           SISTEMA DE GESTÃO DE AGENDA          #");
            System.out.println("##################################################");
            System.out.printf("* TOTAL AGENDADO: %-17d *\n", agenda.size());
            System.out.println("*===============================================*");
            System.out.println("* MENU PRINCIPAL:                               *");
            System.out.println("*-----------------------------------------------*");
            System.out.println("* [1]  (+) NOVO AGENDAMENTO                     *");
            System.out.println("* [2]  (=) IMPRIMIR COMPROVANTE (Por ID)        *");
            System.out.println("* [3]  (?) CONSULTAR AGENDA GERAL               *");
            System.out.println("* [4]  (*) EDITAR AGENDAMENTO (Data/Valor/Arte) *");
            System.out.println("* [5]  (X) SAIR DO SISTEMA                      *");
            System.out.println("*===============================================*");
            System.out.print("  *>>> Digite o número da opção: ");

            // Proteção contra entrada de letras
            if(input.hasNextInt()) {
                opcao = input.nextInt();
                input.nextLine(); // Limpa o buffer do teclado
            } else {
                input.nextLine();
                opcao = 0;
            }

            switch (opcao){
                case 1 -> novoAgendamento();
                case 2 -> imprimirComprovante();
                case 3 -> consultarAgenda();
                case 4 -> editarAgendamento();
                case 5 -> System.out.println("Fechando o estúdio... Até amanhã!");
                default -> System.out.println(">>> Opção inválida! Tente Novamente.");
            }

        } while(opcao != 5);
        input.close();
    }

    public void novoAgendamento() {
        System.out.println("\n--- NOVO AGENDAMENTO ---");

        System.out.print("Nome do Cliente: ");
        String cliente = input.nextLine();

        System.out.print("WhatsApp de contato: ");
        String whats = input.nextLine();

        System.out.print("Idade do Cliente: ");
        String idade = input.nextLine();

        System.out.print("Data da Sessão (ex: 25/12/2025): ");
        String data = input.nextLine();

        System.out.print("Local do corpo (ex: Braço, Costas): ");
        String local = input.nextLine();

        System.out.print("Descrição da Arte: ");
        String desc = input.nextLine();

        System.out.print("Quantos Centímetros? : ");
        String centimetros;

       if(input.hasNextDouble()) {
           double valor = input.nextDouble();
           centimetros = String.valueOf(valor); // Converte para String para salvar no objeto
           input.nextLine();
        } else {
           input.nextLine(); // Limpa o texto errado que o usuário digitou
           System.out.println("⚠️ Valor inválido! Digite um número");
           centimetros = "0";
        }

        // Criando o objeto
        Agendamento novaTattoo = new Agendamento(cliente, whats, idade, data, local, desc, centimetros);
        agenda.add(novaTattoo);

        System.out.println("\nAgendamento realizado com Sucesso! 🤘");
        System.out.println(">>> CÓDIGO DO AGENDAMENTO (ID): " + (agenda.size() - 1));
        System.out.println("Pressione ENTER para continuar...");
        input.nextLine();
    }

    public void imprimirComprovante() {
        if (agenda.isEmpty()) {
            System.out.println("\n>>> A agenda está vazia!");
            return;
        }

        System.out.print("\nDigite o ID do agendamento para imprimir: ");
        if(input.hasNextInt()){
            int id = input.nextInt();
            input.nextLine();

            if (id >= 0 && id < agenda.size()) {
                // Chama o método que já existe na classe Agendamento
                agenda.get(id).exibirComprovante(id);
            } else {
                System.out.println(">>> Erro: ID não encontrado!");
            }
        } else {
            input.nextLine();
            System.out.println(">>> Digite um número válido.");
        }
        System.out.println("\nPressione ENTER para voltar...");
        input.nextLine();
    }

    public void consultarAgenda() {
        System.out.println("\n--- AGENDA COMPLETA ---");
        if(agenda.isEmpty()) {
            System.out.println("Nenhum cliente agendado.");
        } else {
            for (int i = 0; i < agenda.size(); i++){
                Agendamento a = agenda.get(i);
                // Formatação bonita na lista
                System.out.printf("ID [%d] - | Cliente: %s | Data: %s | Arte: %s - %s CM\n",
                        i,
                        a.getCliente() ,
                        a.getDataSessao(),
                        a.getDescricaoArte(),
                        a.getCentimetros());
            }
        }
        System.out.println("\nPressione ENTER para voltar...");
        input.nextLine();
    }

    public void editarAgendamento() {
        System.out.print("\nQual ID deseja alterar? ");
        if(!input.hasNextInt()) {
            input.nextLine();
            System.out.println("ID Inválido.");
            return;
        }
        int id = input.nextInt();
        input.nextLine();

        if (id >= 0 && id < agenda.size()) {
            Agendamento a = agenda.get(id);

            System.out.println("--- EDITANDO: " + a.getCliente() + " ---");
            System.out.println("[1] Mudar Data");
            System.out.println("[2] Mudar Descrição da Arte");
//            System.out.println("[3] Ajustar Valor");
            System.out.print("Escolha uma opção: ");

            int tipoEdicao = input.nextInt();
            input.nextLine(); // Limpa buffer

            switch(tipoEdicao) {
                case 1 -> {
                    System.out.println("Data Atual: " + a.getDataSessao());
                    System.out.print("Nova Data: ");
                    String novaData = input.nextLine();
                    a.setDataSessao(novaData); // Usando o Setter que criamos
                }
                case 2 -> {
                    System.out.println("Arte Atual: " + a.getDescricaoArte());
                    System.out.print("Nova Descrição: ");
                    String novaDesc = input.nextLine();
                    a.setDescricaoArte(novaDesc);
                }
                default -> System.out.println("Opção inválida.");
            }
            System.out.println(">>> Atualizado com Sucesso!");
        } else {
            System.out.println(">>> ID inválido.");
        }
        System.out.println("Pressione ENTER para continuar...");
        input.nextLine();
    }
}