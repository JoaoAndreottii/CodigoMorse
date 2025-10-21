import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.inicializar();
        
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        while (opcao != 7) {
            System.out.println("\n========================================");
            System.out.println("    ARVORE BINARIA - CODIGO MORSE");
            System.out.println("========================================");
            System.out.println("1. Inserir novo caractere");
            System.out.println("2. Buscar caractere por codigo Morse");
            System.out.println("3. Buscar codigo Morse de um caractere");
            System.out.println("4. Remover caractere");
            System.out.println("5. Exibir arvore completa");
            System.out.println("6. Codificar/Decodificar mensagem");
            System.out.println("7. Sair");
            System.out.println("========================================");
            System.out.print("Escolha uma opcao: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            if (opcao == 1) {
                System.out.print("Digite o codigo Morse (ex: ...): ");
                String codigo = scanner.nextLine();
                System.out.print("Digite o caractere: ");
                String input = scanner.nextLine();
                
                if (input.length() > 0) {
                    char caractere = input.charAt(0);
                    arvore.inserir(codigo, caractere);
                    System.out.println("Caractere inserido com sucesso!");
                }
                
            } else if (opcao == 2) {
                System.out.print("Digite o codigo Morse (ex: ...): ");
                String codigo = scanner.nextLine();
                char resultado = arvore.buscar(codigo);
                
                if (resultado != '\0') {
                    System.out.println("Caractere encontrado: " + resultado);
                } else {
                    System.out.println("Nenhum caractere encontrado para este codigo.");
                }
                
            } else if (opcao == 3) {
                System.out.print("Digite o caractere: ");
                String input = scanner.nextLine();
                
                if (input.length() > 0) {
                    char caractere = input.charAt(0);
                    
                    if (caractere >= 'a' && caractere <= 'z') {
                        caractere = (char)(caractere - 32);
                    }
                    
                    String codigo = arvore.buscarCodigo(caractere);
                    if (codigo.length() > 0) {
                        System.out.println("Codigo Morse: " + codigo);
                    } else {
                        System.out.println("Caractere nao encontrado na arvore.");
                    }
                }
                
            } else if (opcao == 4) {
                System.out.print("Digite o codigo Morse do caractere a remover: ");
                String codigo = scanner.nextLine();
                arvore.remover(codigo);
                System.out.println("Caractere removido (se existia).");
                
            } else if (opcao == 5) {
                arvore.exibir();
                
            } else if (opcao == 6) {
                System.out.println("1. Codificar texto para Morse");
                System.out.println("2. Decodificar Morse para texto");
                System.out.print("Escolha: ");
                int subOpcao = scanner.nextInt();
                scanner.nextLine();
                
                if (subOpcao == 1) {
                    System.out.print("Digite o texto: ");
                    String texto = scanner.nextLine();
                    String morse = arvore.codificarMensagem(texto);
                    System.out.println("Codigo Morse: " + morse);
                    
                } else if (subOpcao == 2) {
                    System.out.println("Digite o codigo Morse (separe letras com espaco):");
                    System.out.print("Exemplo: ... --- ... para SOS: ");
                    String morse = scanner.nextLine();
                    String texto = arvore.decodificarMensagem(morse);
                    System.out.println("Texto decodificado: " + texto);
                }
                
            } else if (opcao == 7) {
                System.out.println("Encerrando programa...");
                
            } else {
                System.out.println("Opcao invalida!");
            }
        }
        
        scanner.close();
        
        System.out.println("\n=== TESTES AUTOMATICOS ===");
        
        System.out.println("\nTeste 1 - Buscar S:");
        char s = arvore.buscar("...");
        System.out.println("Resultado: " + s);
        
        System.out.println("\nTeste 2 - Buscar O:");
        char o = arvore.buscar("---");
        System.out.println("Resultado: " + o);
        
        System.out.println("\nTeste 3 - Decodificar SOS:");
        String sos = arvore.decodificarMensagem("... --- ...");
        System.out.println("Resultado: " + sos);
        
        System.out.println("\nTeste 4 - Codificar HELLO:");
        String hello = arvore.codificarMensagem("HELLO");
        System.out.println("Resultado: " + hello);
        
        System.out.println("\n=== FIM DOS TESTES ===");
    }
}