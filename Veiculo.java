public class Veiculo {
    private String marca;
    private String modelo;
    private String placa;
    private int ano;

    public Veiculo(){
    }
    public Veiculo(String marca, String modelo, String placa, int ano){
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Veiculo{");
        sb.append("marca=").append(marca);
        sb.append(", modelo=").append(modelo);
        sb.append(", placa=").append(placa);
        sb.append(", ano=").append(ano);
        sb.append('}');
        return sb.toString();
    }
}
