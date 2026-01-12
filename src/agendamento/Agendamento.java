package agendamento;

public class Agendamento {
    // Atributos
    private String cliente;
    private String whatsapp; // Mudei a ordem aqui pra ficar organizado
    private String idade;
    private String dataSessao;
    private String hora;
    private String localCorpo;
    private String descricaoArte;
    private double centimetros;

    // CONSTRUTOR (A ordem aqui é fundamental!)
    public Agendamento(String cliente, String whatsapp, String idade, String dataSessao, String hora, String localCorpo, String descricaoArte, double centimetros) {
        this.cliente = cliente;
        this.whatsapp = whatsapp;
        this.idade = idade;
        this.dataSessao = dataSessao;
        this.hora = hora;  // Garantindo que a hora seja salva!
        this.localCorpo = localCorpo;
        this.descricaoArte = descricaoArte;
        this.centimetros = centimetros;
    }

    // Getters e Setters (Mantidos iguais)
    public String getCliente() { return cliente; }
    public String getDataSessao() { return dataSessao; }
    public String getHora() { return hora; }
    public String getDescricaoArte() { return descricaoArte; }
    public double getCentimetros() { return centimetros; }

    public void setDataSessao(String dataSessao) { this.dataSessao = dataSessao; }
    public void setHora(String hora) { this.hora = hora; }


    // Método de Exibição
    public void exibirComprovante(int id) {
        System.out.println("\n-------------------------------------------");
        System.out.printf("ID: %d | CLIENTE: %s\n", id, this.cliente);
        System.out.println("IDADE: " + this.idade + " Anos");
        System.out.println("DATA: " + this.dataSessao);
        System.out.println("HORAS: " + this.hora); // Agora vai aparecer!
        System.out.println("ARTE: " + this.descricaoArte);
        System.out.println("LOCAL: " + this.localCorpo);
        System.out.println("CENTÍMETROS: " + this.centimetros);
        System.out.println("-------------------------------------------");
    }
}