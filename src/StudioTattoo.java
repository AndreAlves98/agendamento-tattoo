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

            System.out.println("#################################################");
            System.out.println("#                INK MASTER STUDIO              #");
            System.out.println("#           SISTEMA DE GESTÃO DE AGENDA         #");
            System.out.println("#################################################");
            System.out.printf("* TOTAL AGENDADO: %-17d *\n", agenda.size());
            System.out.println("*===============================================*");
            System.out.println("* MENU PRINCIPAL:                               *");
            System.out.println("*-----------------------------------------------*");
            System.out.println("* [1]  (+) NOVO AGENDAMENTO                     *");
            System.out.println("* [2]  (=) IMPRIMIR COMPROVANTE (Por ID)        *");
            System.out.println("* [3]  (?) CONSULTAR AGENDA GERAL               *");
            System.out.println("* [4]  (*) EDITAR AGENDAMENTO                   *");
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


        System.out.print("WhatsApp de contato (apenas números): ");
        String whats;

        while (true) {
            String entrada = input.nextLine();

            // Validação: Verifica se contém APENAS números de 0 a 9 e não está vazio
            if (entrada.matches("[0-9]+") && !entrada.isEmpty()) {
                whats = entrada;
                break;
            } else {
                System.out.println("⚠️ Valor inválido! Por favor, digite apenas números.");
                System.out.print("Tente novamente: ");
            }
        }


        System.out.print("Idade do Cliente (Máx 45): ");
        String idade = "";

        while (true) {
            if (input.hasNextInt()) {
                int valorIdade = input.nextInt();
                input.nextLine(); // Limpa o buffer

                // --- NOVA VALIDAÇÃO AQUI ---
                // Verifica se é maior que 0 E menor ou igual a 45
                if (valorIdade > 17 && valorIdade <= 45) {
                    idade = String.valueOf(valorIdade);
                    break; // SÓ AQUI o loop quebra
                } else {
                    System.out.println("⚠️ A idade permitida é até 45 anos!");
                    System.out.print("Idade do Cliente: ");
                }

            } else {
                input.nextLine();
                System.out.println("⚠️ Idade inválida! Digite apenas números.");
                System.out.print("Idade do Cliente: ");
            }
        }


        String data = "";
        while (true) {
            System.out.print("Data da Sessão (ex: 25/12/2026): ");
            String dataInput = input.nextLine();

            if (dataInput.matches("\\d{2}/\\d{2}/\\d{4}")) {
                data = dataInput;
                break;
            } else {
                System.out.println("Formato Inválido! Use o formato (ex: 25/12/2026)");
            }

        }


        String hora = "";
        while (true) {
            System.out.print("Hora da Sessão (ex: 14:00): ");
            String entrada = input.nextLine();

            if (entrada.matches("\\d{2}:\\d{2}")) {
                hora = entrada;
                break;
            } else {
                System.out.println("Formato Inválido! Use o formato 00:00");
            }
        }

        System.out.print("Local do corpo (ex: Braço, Costas): ");
        String local = input.nextLine();

        String desc = "";
        double centimetros = 0;

        System.out.println("\n--------------------------------");
        System.out.println("TIPO DE TRABALHO:");
        System.out.println("[1] Arte Personalizada (Cliente descreve)");
        System.out.println("[2] Flash Tattoo (Catálogo do estúdio)");
        System.out.print("Escolha: ");


        int tipoTrabalho = 0;
        if (input.hasNextInt()) {
            tipoTrabalho = input.nextInt();
            input.nextLine();
        } else {
            input.nextLine();
        }

        if (tipoTrabalho == 2) {
            // --- MENU DE FLASH TATTOO ---
            System.out.println("\n>>> CATÁLOGO FLASH <<<");
            System.out.println("[1] Adaga Old School (12cm)");
            System.out.println("[2] Borboleta Minimalista (5cm)");
            System.out.println("[3] Crânio com Rosa (15cm)");
            System.out.println("[4] Frase: Carpe Diem (8cm)");
            System.out.print("Escolha o Flash: ");

            int escolhaFlash = input.nextInt();
            input.nextLine();

            switch (escolhaFlash) {
                case 1 -> {
                    desc = "(FLASH) Adaga Old School";
                    centimetros = 12.0;
                }
                case 2 -> {
                    desc = "(FLASH) Borboleta Minimalista";
                    centimetros = 5.0;
                }
                case 3 -> {
                    desc = "(FLASH) Crânio com Rosa";
                    centimetros = 15.0;
                }
                case 4 -> {
                    desc = "(FLASH) Escrita: Carpe Diem";
                    centimetros = 8.0;
                }
                default -> {
                    System.out.println("Opção inválida! Será registrado como 'Flash Genérico'.");
                    desc = "(FLASH) Genérico - Verificar na hora";
                    centimetros = 5.0;
                }
            }
            System.out.println(">>> Flash selecionado: " + desc);

        } else {
            // --- FLUXO NORMAL (PERSONALIZADO) ---
            System.out.print("Descrição da Arte: ");
            desc = input.nextLine();

            System.out.print("Quantos Centímetros? : ");
            while (true) {
                if (input.hasNextDouble() || input.hasNextInt()) { // Aceita int ou double
                    centimetros = input.nextDouble();
                    input.nextLine();
                    break;
                } else {
                    input.nextLine();
                    System.out.println("⚠️ Valor inválido! Digite um número (ex: 10,5 ou 15)");
                }
            }
        }






        // --- 4. CRIAÇÃO DO OBJETO (Igual ao anterior) ---
        Agendamento novaTattoo = new Agendamento(cliente, whats, idade, data , hora, local, desc, centimetros);
        agenda.add(novaTattoo);

        System.out.print("Agendando");
        try {
            for (int i = 0; i < 3; i++) {
                System.out.print(".");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Erro no timer");
        }

        System.out.println("\n\nAgendamento realizado com Sucesso! 🤘");

        int idNovo = agenda.size() - 1;
        novaTattoo.exibirComprovante(idNovo);

        System.out.println("Pressione ENTER para voltar ao menu...");
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
            System.out.println("[2] Mudar Horário");
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
                    System.out.println("Hora Atual: " + a.getHora());
                    System.out.print("Novo Horário: ");
                    String novaHora = input.nextLine();
                    a.setHora(novaHora);
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