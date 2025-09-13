import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static List<Veiculo> veiculos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Controle de Cadastro de Veículos.");
        String menu = """
                Escolha uma das opções abaixo:
                1 - Cadastro de Veículo
                2 - Listar Veículos
                3 - Excluir Veículo
                4 - Pesquisar um Veiculo 
                0 - Sair
                """;
        int opcao;
        do {
            System.out.println(menu);
            opcao = Input.scanInt("Escolha uma opção: ", scan);
            switch (opcao) {
                case 1:
                    cadastraVeiculo();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 2:
                    listaVeiculos();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 3:
                    removeVeiculo();
                    System.out.println("Presione Enter para continuar");
                    scan.nextLine();
                    break;
                case 4:
                    pesquisarVeiculo();
                    scan.nextLine();
                    break;
                case 0:
                    System.out.println("Volte Sempre!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    static void cadastraVeiculo() {
        System.out.println("==== Cadastrando novo veículo ====");
        String marca = Input.scanString("Digite a marca: ", scan);
        String modelo = Input.scanString("Digite o modelo: ", scan);
        String placa = Input.scanString("Digite a placa: ", scan);
        int ano = Input.scanInt("Digite o ano: ", scan);

        Veiculo veiculo = new Veiculo(marca, modelo, placa, ano);
        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    static void listaVeiculos() {
        System.out.println("==== Veículos cadastrados ====");
        int i = 1;
        for (Veiculo veiculo : veiculos) {
            System.out.println("Veículo " + i++ + ": " + veiculo);
        }
    }

    static void removeVeiculo() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }

        String placa = Input.scanString("Digite a placa do veículo a remover: ", scan);
        boolean removido = false;

        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                veiculos.remove(veiculo);
                System.out.println("Veículo com placa " + placa + " removido com sucesso!");
                removido = true;
                break;
            }
        }

        if (!removido) {
            System.out.println("Nenhum veículo encontrado com a placa informada.");
        }
    }

    static void pesquisarVeiculo() {
        System.out.println("""
                1 - Pesquisar por PLACA
                2 - Pesquisar por MODELO
                """);

        int escolhaPesquisa = Input.scanInt("Escolha uma opção: ", scan);
        boolean encontrado = false;

        switch (escolhaPesquisa) {
            case 1 -> {
                String placa = Input.scanString("Digite a placa: ", scan);
                for (Veiculo veiculo : veiculos) {
                    if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                        System.out.println("=== Veículo encontrado ===");
                        System.out.println("Marca: " + veiculo.getMarca());
                        System.out.println("Modelo: " + veiculo.getModelo());
                        System.out.println("Ano: " + veiculo.getAno());
                        System.out.println("Placa: " + veiculo.getPlaca());
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Veículo não encontrado!");
                }
            }
            case 2 -> {
                String modelo = Input.scanString("Digite o modelo: ", scan);
                for (Veiculo veiculo : veiculos) {
                    if (veiculo.getModelo().equalsIgnoreCase(modelo)) {
                        System.out.println("=== Veículo encontrado ===");
                        System.out.println("Marca: " + veiculo.getMarca());
                        System.out.println("Modelo: " + veiculo.getModelo());
                        System.out.println("Ano: " + veiculo.getAno());
                        System.out.println("Placa: " + veiculo.getPlaca());
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Nenhum veículo com esse modelo foi encontrado.");
                }
            }
            default -> System.out.println("Opção inválida!");
        }
    }
}