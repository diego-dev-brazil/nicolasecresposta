public class Sistema {
    private String id;
    private String nome;
    private String empresa;
    private String responsavel;

    public Sistema(String id, String nome, String empresa, String responsavel) {
        this.id = id;
        this.nome = nome;
        this.empresa = empresa;
        this.responsavel = responsavel;
    }

    public String getId() { 
        return id; 
    }
    public String getNome() { 
        return nome; 
    }
    public String getEmpresa() {
        return empresa; 
    }
    public String getResponsavel() { 
        return responsavel;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Nome: %s | Empresa: %s | Responsável: %s",
                id, nome, empresa, responsavel);
    }
}
