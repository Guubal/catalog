# Sistema de Catálogo de Filmes (IMDB-like)

Um sistema de catálogo de filmes desenvolvido em Java que implementa conceitos de Programação Orientada a Objetos.

## 🎬 Funcionalidades

- ✅ Cadastro de atores
- ✅ Cadastro de diretores  
- ✅ Cadastro de filmes
- ✅ Associação de atores e diretores aos filmes
- ✅ Pesquisa de filmes por nome (case-insensitive)
- ✅ Listagem de filmes, atores e diretores
- ✅ Estatísticas do catálogo

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas com separação clara de responsabilidades:

```
src/
├── model/          # Entidades do domínio
│   ├── Pessoa.java     # Classe abstrata base
│   ├── Ator.java       # Herda de Pessoa
│   ├── Diretor.java    # Herda de Pessoa
│   └── Filme.java      # Entidade filme
├── service/        # Lógica de negócio
│   └── CatalogoFilmes.java
└── Main.java       # Interface do usuário
```

## 🎯 Conceitos de POO Implementados

### Encapsulamento
- Atributos privados com getters/setters
- Validações nos métodos de acesso

### Herança
- `Ator` e `Diretor` herdam de `Pessoa`
- Reutilização de código e estrutura hierárquica

### Polimorfismo
- Método `getDescricao()` implementado diferentemente em cada subclasse

### Classes Abstratas
- `Pessoa` como classe base abstrata

## 🚀 Como Executar

### Pré-requisitos
- Java 8 ou superior
- Terminal/Prompt de comando

### Compilação e Execução

1. **Navegue até o diretório do projeto:**
   ```bash
   cd /caminho/para/o/projeto
   ```

2. **Compile o projeto:**
   ```bash
   javac -d . src/model/*.java src/service/*.java src/Main.java
   ```

3. **Execute o programa:**
   ```bash
   java Main
   ```

## 📋 Como Usar

1. **Menu Principal:** O sistema apresenta um menu interativo com todas as opções
2. **Cadastros:** Cadastre atores, diretores e filmes seguindo as instruções
3. **Associações:** Vincule atores aos filmes através da opção específica
4. **Pesquisas:** Use a busca por nome para encontrar filmes
5. **Listagens:** Visualize todos os dados cadastrados

### Exemplo de Uso

```
=== SISTEMA DE CATÁLOGO DE FILMES ===
Bem-vindo ao sistema similar ao IMDB!

MENU PRINCIPAL
1. Cadastrar Ator
2. Cadastrar Diretor
3. Cadastrar Filme
4. Associar Ator a Filme
5. Pesquisar Filmes
...
```

## 📊 Dados de Exemplo

O sistema carrega automaticamente alguns dados para demonstração:
- **Filmes:** Titanic, A Origem
- **Atores:** Leonardo DiCaprio, Kate Winslet, Robert Downey Jr.
- **Diretores:** James Cameron, Christopher Nolan

## 🔍 Funcionalidades Detalhadas

### Pesquisa de Filmes
- Busca **case-insensitive** (não diferencia maiúsculas/minúsculas)
- Busca por **substring** (encontra parte do nome)
- Exemplo: "tita" encontra "Titanic"

### Validações
- Formato de data: dd/MM/yyyy
- Valores numéricos para orçamento
- Prevenção de duplicatas
- Verificação de dados obrigatórios

## 📁 Estrutura das Classes

### Pessoa (Abstrata)
```java
- nome: String
- dataNascimento: Date  
- nacionalidade: String
+ getDescricao(): String (abstrato)
```

### Filme
```java
- nome: String
- dataLancamento: Date
- orcamento: double
- descricao: String
- diretor: Diretor
- atores: List<Ator>
```

### CatalogoFilmes
```java
- filmes: List<Filme>
- atores: List<Ator>
- diretores: List<Diretor>
+ pesquisarFilmes(String): List<Filme>
```

## 🛠️ Tecnologias Utilizadas

- **Java** - Linguagem de programação
- **Collections Framework** - ArrayList para gerenciamento de listas
- **Date/SimpleDateFormat** - Manipulação de datas
- **Scanner** - Entrada de dados do usuário

## 📖 Documentação

Para documentação detalhada, consulte: [`docs/doc.md`](docs/doc.md)

## 🎓 Conceitos

Este projeto demonstra a aplicação prática de:
- Programação Orientada a Objetos
- Padrões de design (encapsulamento, herança)
- Estruturas de dados (listas)
- Tratamento de exceções
- Interface de usuário em console

---