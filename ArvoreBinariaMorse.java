public class ArvoreBinariaMorse {
    private Nodo raiz;
    
    public ArvoreBinariaMorse() {
        this.raiz = null;
    }
    
    public void inicializar() {
        raiz = new Nodo('\0');
        
        inserir(".-", 'A');
        inserir("-...", 'B');
        inserir("-.-.", 'C');
        inserir("-..", 'D');
        inserir(".", 'E');
        inserir("..-.", 'F');
        inserir("--.", 'G');
        inserir("....", 'H');
        inserir("..", 'I');
        inserir(".---", 'J');
        inserir("-.-", 'K');
        inserir(".-..", 'L');
        inserir("--", 'M');
        inserir("-.", 'N');
        inserir("---", 'O');
        inserir(".--.", 'P');
        inserir("--.-", 'Q');
        inserir(".-.", 'R');
        inserir("...", 'S');
        inserir("-", 'T');
        inserir("..-", 'U');
        inserir("...-", 'V');
        inserir(".--", 'W');
        inserir("-..-", 'X');
        inserir("-.--", 'Y');
        inserir("--..", 'Z');
        
        inserir("-----", '0');
        inserir(".----", '1');
        inserir("..---", '2');
        inserir("...--", '3');
        inserir("....-", '4');
        inserir(".....", '5');
        inserir("-....", '6');
        inserir("--...", '7');
        inserir("---..", '8');
        inserir("----.", '9');
    }
    
    public void inserir(String codigoMorse, char caractere) {
        if (raiz == null) {
            raiz = new Nodo('\0');
        }
        
        Nodo atual = raiz;
        int tamanho = codigoMorse.length();
        
        for (int i = 0; i < tamanho; i++) {
            char simbolo = codigoMorse.charAt(i);
            
            if (simbolo == '.') {
                if (atual.getEsquerdo() == null) {
                    atual.setEsquerdo(new Nodo('\0'));
                }
                atual = atual.getEsquerdo();
            } else if (simbolo == '-') {
                if (atual.getDireito() == null) {
                    atual.setDireito(new Nodo('\0'));
                }
                atual = atual.getDireito();
            }
        }
        
        atual.setCaractere(caractere);
    }
    
    public char buscar(String codigoMorse) {
        if (raiz == null) {
            return '\0';
        }
        
        Nodo atual = raiz;
        int tamanho = codigoMorse.length();
        
        for (int i = 0; i < tamanho; i++) {
            char simbolo = codigoMorse.charAt(i);
            
            if (simbolo == '.') {
                if (atual.getEsquerdo() == null) {
                    return '\0';
                }
                atual = atual.getEsquerdo();
            } else if (simbolo == '-') {
                if (atual.getDireito() == null) {
                    return '\0';
                }
                atual = atual.getDireito();
            }
        }
        
        return atual.getCaractere();
    }
    
    public String buscarCodigo(char caractere) {
        String resultado = buscarCodigoRecursivo(raiz, caractere, "");
        if (resultado == null) {
            return "";
        }
        return resultado;
    }
    
    private String buscarCodigoRecursivo(Nodo nodo, char caractere, String caminho) {
        if (nodo == null) {
            return null;
        }
        
        if (nodo.getCaractere() == caractere) {
            return caminho;
        }
        
        String esquerda = buscarCodigoRecursivo(nodo.getEsquerdo(), caractere, caminho + ".");
        if (esquerda != null) {
            return esquerda;
        }
        
        String direita = buscarCodigoRecursivo(nodo.getDireito(), caractere, caminho + "-");
        return direita;
    }
    
    public void remover(String codigoMorse) {
        if (raiz == null || codigoMorse.length() == 0) {
            return;
        }
        
        Nodo atual = raiz;
        Nodo pai = null;
        boolean ehEsquerdo = false;
        int tamanho = codigoMorse.length();
        
        for (int i = 0; i < tamanho; i++) {
            char simbolo = codigoMorse.charAt(i);
            pai = atual;
            
            if (simbolo == '.') {
                ehEsquerdo = true;
                atual = atual.getEsquerdo();
            } else if (simbolo == '-') {
                ehEsquerdo = false;
                atual = atual.getDireito();
            }
            
            if (atual == null) {
                return;
            }
        }
        
        if (atual.getEsquerdo() == null && atual.getDireito() == null) {
            if (ehEsquerdo) {
                pai.setEsquerdo(null);
            } else {
                pai.setDireito(null);
            }
        } else {
            atual.setCaractere('\0');
        }
    }
    
    public void exibir() {
        System.out.println("Estrutura da Arvore Morse:");
        System.out.println("=========================");
        exibirRecursivo(raiz, "", 0);
    }
    
    private void exibirRecursivo(Nodo nodo, String caminho, int nivel) {
        if (nodo == null) {
            return;
        }
        
        String espacos = "";
        for (int i = 0; i < nivel; i++) {
            espacos = espacos + "  ";
        }
        
        if (nodo.getCaractere() != '\0') {
            System.out.println(espacos + "[" + caminho + "] = " + nodo.getCaractere());
        }
        
        exibirRecursivo(nodo.getEsquerdo(), caminho + ".", nivel + 1);
        exibirRecursivo(nodo.getDireito(), caminho + "-", nivel + 1);
    }
    
    public String decodificarMensagem(String mensagemMorse) {
        String resultado = "";
        String palavraAtual = "";
        int tamanho = mensagemMorse.length();
        
        for (int i = 0; i < tamanho; i++) {
            char c = mensagemMorse.charAt(i);
            
            if (c == ' ') {
                if (palavraAtual.length() > 0) {
                    char caractere = buscar(palavraAtual);
                    if (caractere != '\0') {
                        resultado = resultado + caractere;
                    }
                    palavraAtual = "";
                }
            } else {
                palavraAtual = palavraAtual + c;
            }
        }
        
        if (palavraAtual.length() > 0) {
            char caractere = buscar(palavraAtual);
            if (caractere != '\0') {
                resultado = resultado + caractere;
            }
        }
        
        return resultado;
    }
    
    public String codificarMensagem(String mensagem) {
        String resultado = "";
        int tamanho = mensagem.length();
        
        for (int i = 0; i < tamanho; i++) {
            char c = mensagem.charAt(i);
            
            if (c >= 'a' && c <= 'z') {
                c = (char)(c - 32);
            }
            
            if (c == ' ') {
                resultado = resultado + "  ";
            } else {
                String codigo = buscarCodigo(c);
                if (codigo.length() > 0) {
                    resultado = resultado + codigo;
                    if (i < tamanho - 1) {
                        resultado = resultado + " ";
                    }
                }
            }
        }
        
        return resultado;
    }
}