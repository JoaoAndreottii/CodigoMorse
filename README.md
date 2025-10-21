# Sistema de Árvore Binária para Código Morse

## Índice
1. [Visão Geral](#visão-geral)
2. [Estrutura do Projeto](#estrutura-do-projeto)
3. [Conceitos Fundamentais](#conceitos-fundamentais)
4. [Documentação das Classes](#documentação-das-classes)
5. [Como Funciona](#como-funciona)
6. [Guia de Uso](#guia-de-uso)
7. [Exemplos Práticos](#exemplos-práticos)
8. [Complexidade Computacional](#complexidade-computacional)

---

## Visão Geral

Este projeto implementa um sistema completo de codificação e decodificação de Código Morse utilizando uma Árvore Binária como estrutura de dados principal. O sistema permite converter texto para código Morse e vice-versa, além de oferecer operações de inserção, busca e remoção de caracteres.

### Características Principais
- Estrutura de dados: Árvore Binária
- Suporta letras A-Z e números 0-9
- Codificação de texto para Morse
- Decodificação de Morse para texto
- Interface interativa via menu
- Testes automáticos integrados

---

## Estrutura do Projeto

```
morse-tree/
│
├── Nodo.java                    # Classe do nó da árvore
├── ArvoreBinariaMorse.java      # Implementação da árvore
└── Main.java                    # Interface e testes
```

### Arquivos

| Arquivo | Linhas | Descrição |
|---------|--------|-----------|
| `Nodo.java` | 35 | Define a estrutura básica de um nó da árvore |
| `ArvoreBinariaMorse.java` | 220 | Implementa toda a lógica da árvore Morse |
| `Main.java` | 110 | Interface de usuário e testes |

---

## Conceitos Fundamentais

### O que é Código Morse

O Código Morse é um sistema de comunicação que representa letras e números através de sequências de sinais curtos (pontos `.`) e longos (traços `-`).

**Exemplos:**
- **A** = `.-`
- **S** = `...`
- **O** = `---`
- **SOS** = `... --- ...`

### Por que usar Árvore Binária

A árvore binária é ideal para representar Código Morse porque:

1. **Navegação Natural**: Cada ponto `.` leva à esquerda, cada traço `-` leva à direita
2. **Busca Eficiente**: O(h) onde h é a altura da árvore (máximo 5 para Morse)
3. **Estrutura Hierárquica**: Códigos mais curtos ficam mais próximos da raiz

### Estrutura da Árvore Morse

```
                    [raiz]
                   /      \
                  .        -
                /  \      /  \
               E    T    I    N
              / \  / \  / \  / \
             S  U F   ... A  ... W
```

**Regra de navegação:**
- `.` (ponto) vai para o filho esquerdo
- `-` (traço) vai para o filho direito

---

## Documentação das Classes

### Classe Nodo

Representa um nó individual da árvore binária.

#### Atributos
```java
private char caractere;    // Caractere armazenado ('A', 'B', etc.)
private Nodo esquerdo;     // Referência ao filho esquerdo
private Nodo direito;      // Referência ao filho direito
```

#### Construtor
```java
public Nodo(char caractere)
```
- **Parâmetro**: `caractere` - o caractere a ser armazenado
- **Funcionalidade**: Inicializa um nó com o caractere fornecido e filhos nulos

#### Métodos

| Método | Retorno | Descrição |
|--------|---------|-----------|
| `getCaractere()` | `char` | Retorna o caractere armazenado |
| `setCaractere(char)` | `void` | Define um novo caractere |
| `getEsquerdo()` | `Nodo` | Retorna o filho esquerdo |
| `setEsquerdo(Nodo)` | `void` | Define o filho esquerdo |
| `getDireito()` | `Nodo` | Retorna o filho direito |
| `setDireito(Nodo)` | `void` | Define o filho direito |

---

### Classe ArvoreBinariaMorse

Implementa a árvore binária completa para operações com Código Morse.

#### Atributos
```java
private Nodo raiz;    // Nó raiz da árvore
```

#### Métodos Principais

##### inicializar()
```java
public void inicializar()
```
- **Funcionalidade**: Cria a árvore completa com todas as letras (A-Z) e números (0-9)
- **Chamadas**: Faz 36 chamadas ao método `inserir()`
- **Ordem**: Primeiro letras, depois números

##### inserir(String codigoMorse, char caractere)
```java
public void inserir(String codigoMorse, char caractere)
```
- **Parâmetros**:
  - `codigoMorse`: sequência de pontos e traços (ex: `"..."`)
  - `caractere`: letra ou número a inserir (ex: `'S'`)
- **Algoritmo**:
  1. Começa na raiz
  2. Para cada símbolo no código:
     - `.` vai para a esquerda (cria nó se não existir)
     - `-` vai para a direita (cria nó se não existir)
  3. Ao final, armazena o caractere no nó atual

**Exemplo visual:**
```
Inserir 'S' com código "..."
raiz → esquerdo → esquerdo → esquerdo = S
```

##### buscar(String codigoMorse)
```java
public char buscar(String codigoMorse)
```
- **Parâmetro**: `codigoMorse` - código a buscar
- **Retorno**: caractere encontrado ou `'\0'` se não existir
- **Algoritmo**: Navega pela árvore seguindo o código Morse

**Exemplo:**
```java
arvore.buscar("...") → 'S'
arvore.buscar("---") → 'O'
```

##### buscarCodigo(char caractere)
```java
public String buscarCodigo(char caractere)
```
- **Parâmetro**: `caractere` - letra ou número
- **Retorno**: código Morse correspondente ou string vazia
- **Algoritmo**: Percorre a árvore recursivamente até encontrar o caractere

**Exemplo:**
```java
arvore.buscarCodigo('S') → "..."
arvore.buscarCodigo('O') → "---"
```

##### remover(String codigoMorse)
```java
public void remover(String codigoMorse)
```
- **Parâmetro**: `codigoMorse` - código do caractere a remover
- **Comportamento**:
  - Se o nó é folha (sem filhos): remove o nó
  - Se o nó tem filhos: apenas limpa o caractere (mantém estrutura)

##### exibir()
```java
public void exibir()
```
- **Funcionalidade**: Exibe toda a estrutura da árvore de forma hierárquica
- **Formato**: Indentação mostra o nível na árvore

**Saída exemplo:**
```
Estrutura da Arvore Morse:
=========================
  [.] = E
    [..] = I
      [...] = S
      [..-] = U
    [.-] = A
      [.-.] = R
```

##### decodificarMensagem(String mensagemMorse)
```java
public String decodificarMensagem(String mensagemMorse)
```
- **Parâmetro**: `mensagemMorse` - texto em Morse (letras separadas por espaço)
- **Retorno**: texto decodificado
- **Algoritmo**:
  1. Divide a mensagem por espaços
  2. Para cada código, busca o caractere correspondente
  3. Concatena os resultados

**Exemplo:**
```java
arvore.decodificarMensagem("... --- ...") → "SOS"
```

##### codificarMensagem(String mensagem)
```java
public String codificarMensagem(String mensagem)
```
- **Parâmetro**: `mensagem` - texto em letras/números
- **Retorno**: código Morse (letras separadas por espaço)
- **Algoritmo**:
  1. Converte minúsculas para maiúsculas
  2. Para cada caractere, busca o código Morse
  3. Adiciona espaços entre códigos

**Exemplo:**
```java
arvore.codificarMensagem("HELLO") → ".... . .-.. .-.. ---"
```

---

### Classe Main

Fornece interface interativa e testes automáticos.

#### Menu Principal

```
========================================
    ARVORE BINARIA - CODIGO MORSE
========================================
1. Inserir novo caractere
2. Buscar caractere por codigo Morse
3. Buscar codigo Morse de um caractere
4. Remover caractere
5. Exibir arvore completa
6. Codificar/Decodificar mensagem
7. Sair
========================================
```

#### Opções Detalhadas

##### Opção 1: Inserir novo caractere
- Solicita código Morse (ex: `...`)
- Solicita o caractere (ex: `S`)
- Insere na árvore

##### Opção 2: Buscar por código
- Solicita código Morse
- Retorna o caractere correspondente

##### Opção 3: Buscar código de caractere
- Solicita um caractere
- Retorna o código Morse
- Converte automaticamente minúsculas

##### Opção 4: Remover caractere
- Solicita código Morse
- Remove o caractere da árvore

##### Opção 5: Exibir árvore
- Mostra toda a estrutura da árvore
- Formato hierárquico indentado

##### Opção 6: Codificar/Decodificar
Submenu com 2 opções:
1. **Codificar texto para Morse**
   - Entrada: `HELLO`
   - Saída: `.... . .-.. .-.. ---`

2. **Decodificar Morse para texto**
   - Entrada: `... --- ...`
   - Saída: `SOS`

##### Opção 7: Sair
- Fecha o menu
- Executa testes automáticos

#### Testes Automáticos

Após sair do menu, são executados 4 testes:

```java
Teste 1: buscar("...") → 'S'
Teste 2: buscar("---") → 'O'
Teste 3: decodificarMensagem("... --- ...") → "SOS"
Teste 4: codificarMensagem("HELLO") → ".... . .-.. .-.. ---"
```

---

## Como Funciona

### Processo de Inserção

1. **Entrada**: código `"..."` e caractere `'S'`
2. **Navegação**:
   ```
   raiz
   └─> '.' (esquerdo)
       └─> '.' (esquerdo)
           └─> '.' (esquerdo) → armazena 'S'
   ```
3. **Resultado**: caractere inserido no nó correto

### Processo de Busca

1. **Entrada**: código `"..."`
2. **Navegação**: mesmo caminho da inserção
3. **Retorno**: caractere encontrado no nó final

### Processo de Codificação

1. **Entrada**: texto `"SOS"`
2. **Processamento**:
   - `S` busca recursiva retorna `"..."`
   - `O` busca recursiva retorna `"---"`
   - `S` busca recursiva retorna `"..."`
3. **Saída**: `"... --- ..."`

### Processo de Decodificação

1. **Entrada**: morse `"... --- ..."`
2. **Divisão**: `["...", "---", "..."]`
3. **Busca**:
   - `"..."` navega árvore retorna `'S'`
   - `"---"` navega árvore retorna `'O'`
   - `"..."` navega árvore retorna `'S'`
4. **Saída**: `"SOS"`

---

## Guia de Uso

### Compilação

```bash
javac Nodo.java
javac ArvoreBinariaMorse.java
javac Main.java
```

### Execução

```bash
java Main
```

### Uso Programático

```java
// Criar e inicializar árvore
ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
arvore.inicializar();

// Codificar mensagem
String morse = arvore.codificarMensagem("HELLO WORLD");
System.out.println(morse);
// Saída: .... . .-.. .-.. ---  .-- --- .-. .-.. -..

// Decodificar mensagem
String texto = arvore.decodificarMensagem("... --- ...");
System.out.println(texto);
// Saída: SOS

// Buscar código de caractere
String codigoA = arvore.buscarCodigo('A');
System.out.println(codigoA);
// Saída: .-

// Buscar caractere por código
char letra = arvore.buscar(".-");
System.out.println(letra);
// Saída: A
```

---

## Exemplos Práticos

### Exemplo 1: Mensagem de Socorro
```java
ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
arvore.inicializar();

// Codificar SOS
String sos = arvore.codificarMensagem("SOS");
System.out.println("Código Morse: " + sos);
// Saída: ... --- ...

// Decodificar de volta
String texto = arvore.decodificarMensagem(sos);
System.out.println("Texto: " + texto);
// Saída: SOS
```

### Exemplo 2: Nome Próprio
```java
String nome = "MARIA";
String morse = arvore.codificarMensagem(nome);
System.out.println(morse);
// Saída: -- .- .-. .. .-

String decodificado = arvore.decodificarMensagem(morse);
System.out.println(decodificado);
// Saída: MARIA
```

### Exemplo 3: Números
```java
String numero = "123";
String morse = arvore.codificarMensagem(numero);
System.out.println(morse);
// Saída: .---- ..--- ...--

String decodificado = arvore.decodificarMensagem(morse);
System.out.println(decodificado);
// Saída: 123
```

### Exemplo 4: Inserir Caractere Customizado
```java
// Adicionar um novo símbolo (exemplo: '@' com código personalizado)
arvore.inserir(".-.-.", '@');

// Buscar o novo símbolo
char simbolo = arvore.buscar(".-.-.");
System.out.println(simbolo);
// Saída: @
```

### Exemplo 5: Verificar Código de Todas as Letras
```java
String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
for (int i = 0; i < alfabeto.length(); i++) {
    char letra = alfabeto.charAt(i);
    String codigo = arvore.buscarCodigo(letra);
    System.out.println(letra + " = " + codigo);
}
```

**Saída:**
```
A = .-
B = -...
C = -.-.
D = -..
E = .
F = ..-.
G = --.
H = ....
I = ..
J = .---
K = -.-
L = .-..
M = --
N = -.
O = ---
P = .--.
Q = --.-
R = .-.
S = ...
T = -
U = ..-
V = ...-
W = .--
X = -..-
Y = -.--
Z = --..
```

---

## Complexidade Computacional

### Análise de Tempo

| Operação | Complexidade | Explicação |
|----------|--------------|------------|
| `inserir()` | **O(k)** | k = tamanho do código (máximo 5) |
| `buscar()` | **O(k)** | k = tamanho do código |
| `buscarCodigo()` | **O(n)** | n = total de nós na árvore |
| `remover()` | **O(k)** | k = tamanho do código |
| `exibir()` | **O(n)** | Percorre todos os nós |
| `codificarMensagem()` | **O(m × n)** | m = tamanho mensagem, n = nós |
| `decodificarMensagem()` | **O(m × k)** | m = quantidade de códigos, k = tamanho do código |

### Análise de Espaço

- **Árvore completa**: 36 nós (26 letras + 10 números)
- **Altura máxima**: 5 (número "0" = `"-----"`)
- **Espaço total**: **O(n)** onde n = 36

### Otimizações Implementadas

1. **Navegação direta**: não usa recursão para inserir/buscar
2. **Criação sob demanda**: nós criados apenas quando necessário
3. **Conversão inline**: minúsculas convertidas sem estruturas extras
4. **Concatenação eficiente**: usa operador `+` para strings curtas

---

## Conceitos de Estrutura de Dados

### Árvore Binária
- **Definição**: Cada nó tem no máximo 2 filhos
- **Aplicação**: Navegação por decisões binárias (ponto/traço)

### Travessia de Árvore
- **Pré-ordem**: raiz, esquerda, direita
- **Em-ordem**: esquerda, raiz, direita
- **Pós-ordem**: esquerda, direita, raiz
- **Usado no projeto**: Pré-ordem no método `exibirRecursivo()`

### Recursão
- **Uso**: Busca de código (`buscarCodigoRecursivo`)
- **Vantagem**: Código mais limpo para percorrer árvore
- **Desvantagem**: Usa pilha de chamadas

---

## Possíveis Melhorias

### Funcionalidades Adicionais
1. Suporte a pontuação (`.`, `,`, `?`, `!`)
2. Suporte a espaços entre palavras
3. Validação de entrada (códigos inválidos)
4. Exportar/importar árvore de arquivo
5. Interface gráfica (GUI)
6. Reprodução de áudio (bipes)

### Otimizações de Código
1. Usar `StringBuilder` ao invés de concatenação `+`
2. Implementar cache para códigos frequentes
3. Adicionar validação de códigos Morse
4. Implementar serialização da árvore

---

## Referências

- **Código Morse Internacional**: ITU-R M.1677-1
- **Estruturas de Dados**: Árvores Binárias
- **Padrão de Projeto**: Composite Pattern

---

## Detalhes Técnicos

### Versão Java
- Compatível com **Java 8+**
- Não usa recursos modernos (mantém compatibilidade)

### Dependências
- Nenhuma dependência externa
- Usa apenas bibliotecas padrão (`java.util.Scanner`)

### Codificação
- **Charset**: UTF-8
- **Line ending**: LF (Unix) ou CRLF (Windows)

---

## Notas de Implementação

### Decisões de Design

1. **Caractere nulo (`'\0'`)**: Usado para nós intermediários sem letra
2. **String vazia**: Retornada quando caractere não encontrado
3. **Conversão automática**: Minúsculas convertidas para maiúsculas
4. **Espaços duplos**: Representam espaço entre palavras em Morse

### Limitações Conhecidas

1. Não suporta caracteres especiais (@, #, $, etc.)
2. Não distingue maiúsculas de minúsculas (tudo vira maiúscula)
3. Espaços múltiplos em Morse podem causar problemas
4. Não valida se o código Morse é válido antes de buscar

---

## Casos de Uso

### Educacional
- Aprender sobre árvores binárias
- Entender algoritmos de busca
- Praticar recursão

### Prático
- Codificador/decodificador Morse
- Ferramenta de comunicação alternativa
- Base para projetos de rádio amador

### Profissional
- Exemplo de estrutura de dados em entrevistas
- Demonstração de clean code
- Portfólio de programação

---

## Licença

Este código é fornecido como material educacional e pode ser usado livremente para fins de aprendizado.

---

## Contribuições

Para melhorias ou correções:
1. Identifique o problema ou melhoria
2. Implemente a solução
3. Teste com os casos de teste existentes
4. Adicione novos testes se necessário

---

**Desenvolvido para aprendizado de Estruturas de Dados**