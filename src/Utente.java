public class Utente {
    protected int id;
    protected String nome;
    protected String cognome;
    protected String email;
    protected int eta;

    public Utente(int id, String nome, String cognome, String email, int eta) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.eta = eta;
    }

    public Utente(String nome, String cognome, String email, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.eta = eta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
