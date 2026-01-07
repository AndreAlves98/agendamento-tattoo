package agendamento;

public class Agendamento {
    private String cliente;
    private String idade;
    private String whatsapp;
    private String dataSessao;
    private String localCorpo;
    private String descricaoArte;
    private String centimetros;

    // Construtor ÚNICO e COMPLETO
    public Agendamento (String cliente, String whatsapp, String idade, String dataSessao, String localCorpo, String descricaoArte, String centimetros) {
        this.cliente = cliente;
        this.whatsapp = whatsapp;
        this.idade = idade;
        this.dataSessao = dataSessao;
        this.localCorpo = localCorpo;
        this.descricaoArte = descricaoArte;
        this.centimetros = centimetros;
    }

//    public Agendamento(String cliente, String whats, String idade, String data, String local, String centimetros) {
//    }

    // Getters
    public String getCliente() { return cliente; }
    public String getWhatsapp() { return whatsapp; }
    public String getIdade() { return idade; }
    public String getDataSessao() { return dataSessao; }
    public String getDescricaoArte() { return descricaoArte; }
    public String getCentimetros() { return centimetros; }
    public String getLocalCorpo() { return localCorpo; } // Faltava esse getter no seu código original

    // Setters
    public void setDescricaoArte(String descricaoArte) { this.descricaoArte = descricaoArte; }
    public void setDataSessao(String dataSessao) {this.dataSessao = dataSessao; }
    public void setCentimetros(String centimetros) {this.centimetros = centimetros; }

    // Exibir
    public void exibirComprovante(int id) {
        System.out.println("\n-------------------------------------------");
        System.out.printf("ID: %d | CLIENTE: %s\n", id, this.cliente);
        System.out.println("IDADE: " + this.idade + " Anos");
        System.out.println("DATA: " + this.dataSessao);
        System.out.println("ARTE: " + this.descricaoArte);
        System.out.println("LOCAL: " + this.localCorpo);
        System.out.println("CENTÍMETROS: " + this.centimetros);
        System.out.println("-------------------------------------------");
    }
}