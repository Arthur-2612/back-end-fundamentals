# 📁 Projeto Prático: Gerenciador de Arquivos em Memória

Simulador de sistema de arquivos virtual em memória RAM, modelado para consolidar os conceitos de encapsulamento, pacotes Java (`packages`), manipulação de strings e interface gráfica nativa com `JOptionPane`.

---

## 🎯 Conceitos Chave Aplicados

1. **Separação por Pacotes (`package models`):** Isolamento da regra de negócio da entidade `File` em um pacote dedicado.
2. **Encapsulamento Estrito:** Atributos `name`, `content` e `size` privados, garantindo que o tamanho seja recalculado automaticamente a cada mutação de texto (`updateSize()`).
3. **Validação Defensiva:** O método `rename()` higieniza a entrada (`trim()`) e rejeita strings vazias ou nulas.
4. **Integração Gráfica Simples (`JOptionPane`):** Apresentação das informações ao usuário em janela popup nativa do sistema operacional.

---

## 🚀 Como Executar

A partir da pasta raiz do projeto (`projetos-praticos/gerenciador-arquivos/`):

```bash
# Compilar o pacote models e o App
javac models/File.java App.java

# Executar a aplicação
java App
```

---

## 📊 Estrutura de Arquivos

| Arquivo | Descrição |
|---|---|
| `models/File.java` | Classe de domínio com encapsulamento e cálculo dinâmico de bits |
| `App.java` | Classe principal executável com testes e diálogo `JOptionPane` |
| `Arquivo.java` | Versão inicial legada para estudo comparativo de evolução de código |
| `README.md` | Documentação explicativa do projeto |
